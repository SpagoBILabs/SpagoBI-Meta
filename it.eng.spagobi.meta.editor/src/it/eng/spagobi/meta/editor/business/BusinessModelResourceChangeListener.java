/**
 SpagoBI, the Open Source Business Intelligence suite

 Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this file,
 You can obtain one at http://mozilla.org/MPL/2.0/.
 
**/
package it.eng.spagobi.meta.editor.business;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class BusinessModelResourceChangeListener implements IResourceChangeListener {
	
	AdapterFactoryEditingDomain editingDomain;
	BusinessModelEditor editor;
	
	private static Logger logger = LoggerFactory.getLogger(BusinessModelResourceChangeListener.class);
	
	/**
	 * Resources that have been removed since last activation.
	 */
	protected Collection<Resource> removedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been changed since last activation.
	 */
	protected Collection<Resource> changedResources = new ArrayList<Resource>();

	/**
	 * Resources that have been saved.
	 */
	protected Collection<Resource> savedResources = new ArrayList<Resource>();
	
	public Collection<Resource> getSavedResources() {
		return savedResources;
	}

	public BusinessModelResourceChangeListener(AdapterFactoryEditingDomain editingDomain, BusinessModelEditor editor) {
		this.editingDomain = editingDomain;
		this.editor = editor;
	}
	
	public boolean isDirty() {
		return ((BasicCommandStack)editingDomain.getCommandStack()).isSaveNeeded();
	}
	
	public void resourceChanged(IResourceChangeEvent event) {
		IResourceDelta delta;;
		
		logger.trace("IN");
		
		try {
			
			delta = event.getDelta();

			final ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
			delta.accept(visitor);

			logger.debug("The delta generated by the change contains [{}] removed resource", visitor.getRemovedResources().size());
			
			for (Resource resource : visitor.getRemovedResources()) {
				logger.debug("Resource [{}] has been removed", resource.getURI());
			}
			
			if (!visitor.getRemovedResources().isEmpty()) {
				editor.getSite().getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 removedResources.addAll(visitor.getRemovedResources());
							 
							 if (!isDirty()) {
								 logger.warn("There are some removed resources but the editor state is not dirty. The editor will be closed");
								 editor.getSite().getPage().closeEditor(editor, false);
							 }
						 }
					 });
			}

			
			logger.debug("The delta generated by the change contains [{}] changed resource", visitor.getChangedResources().size());
			for (Resource resource : visitor.getRemovedResources()) {
				logger.debug("Resource [{}] has been changed", resource.getURI());
			}
			
			if (!visitor.getChangedResources().isEmpty()) {
				editor.getSite().getShell().getDisplay().asyncExec
					(new Runnable() {
						 public void run() {
							 changedResources.addAll(visitor.getChangedResources());
							 
							 if (editor.getSite().getPage().getActiveEditor() == editor) {
								 handleActivate();
							 }
						 }
					 });
			}
		} catch (CoreException exception) {
			logger.error("An error occurred while handling resource changed event", exception);
		} finally {
			logger.trace("OUT");
		}
		
		
	}
	
	/**
	 * Handles activation of the editor or it's associated views.
	 */
	protected void handleActivate() {
		
		logger.trace("IN");
		
		try {
		
			// Recompute the read only state.
			if (editingDomain.getResourceToReadOnlyMap() != null) {
			  editingDomain.getResourceToReadOnlyMap().clear();
			  // Refresh any actions that may become enabled or disabled.
			  //editor.setSelection(editor.getSelection());
			  logger.debug("Read only state recomputed succesfully");
			}
			
			logger.debug("Since last activation [{}] resource has been removed", removedResources.size());
			logger.debug("Since last activation [{}] resource has been changed", changedResources.size());
			logger.debug("Since last activation [{}] resource has been saved", savedResources.size());
	
			if (!removedResources.isEmpty()) {
				
				// shows a dialog that asks if conflicting changes should be discarded...
//				if (editor.handleDirtyConflict()) { // ...if YES
//					editor.getSite().getPage().closeEditor(editor, false);
//				} else { // ...if NO
//					removedResources.clear();
//					changedResources.clear();
//					savedResources.clear();
//				}
				editor.getSite().getPage().closeEditor(editor, false);
			
			} else if (!changedResources.isEmpty()) {
				changedResources.removeAll(savedResources);
				
				handleChangedResources();
				
				changedResources.clear();
				savedResources.clear();
			}
		
		} finally {
			logger.trace("OUT");
		}
	}
	
	/**
	 * Handles what to do with changed resources on activation
	 */
	protected void handleChangedResources() {
		
		logger.trace("IN");
		
//		if (!changedResources.isEmpty() && (!isDirty() || editor.handleDirtyConflict())) {
//			if (isDirty()) {
//				changedResources.addAll(editingDomain.getResourceSet().getResources());
//			}
//			editingDomain.getCommandStack().flush();
//
//			//editor.setUpdateProblemIndication(false);
//			for (Resource resource : changedResources) {
//				reloadResource(resource);
//				logger.debug("Resource [{}] has been reloaded succesfully", resource.getURI());
//			}
//
//			if (AdapterFactoryEditingDomain.isStale(editor.getEditorSelection())) {
//				editor.setSelection(StructuredSelection.EMPTY);
//			}

			//editor.setUpdateProblemIndication(true);
			//editor.updateProblemIndication();
	//	}
		
		logger.trace("OUT");
	}
	
	protected void reloadResource(Resource resource) {
		if (resource.isLoaded()) {
			resource.unload();
			try {
				resource.load(Collections.EMPTY_MAP);
			} catch (IOException exception) {
//				if (!editor.getResourceToDiagnosticMap().containsKey(resource)) {
//					editor.getResourceToDiagnosticMap().put(resource, editor.analyzeResourceProblems(resource, exception));
//				}
			}
		}
	}
	
	
	class ResourceDeltaVisitor implements IResourceDeltaVisitor {
		protected ResourceSet resourceSet = editingDomain.getResourceSet();
		protected Collection<Resource> changedResources = new ArrayList<Resource>();
		protected Collection<Resource> removedResources = new ArrayList<Resource>();

		public boolean visit(IResourceDelta delta) {
			if (delta.getResource().getType() == IResource.FILE) {
				if (delta.getKind() == IResourceDelta.REMOVED ||
				    delta.getKind() == IResourceDelta.CHANGED && delta.getFlags() != IResourceDelta.MARKERS) {
					Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(delta.getFullPath().toString(), true), false);
					if (resource != null) {
						if (delta.getKind() == IResourceDelta.REMOVED) {
							removedResources.add(resource);
						}
						else if (!savedResources.remove(resource)) {
							changedResources.add(resource);
						}
					}
				}
			}

			return true;
		}

		public Collection<Resource> getChangedResources() {
			return changedResources;
		}

		public Collection<Resource> getRemovedResources() {
			return removedResources;
		}
	}
  
}

