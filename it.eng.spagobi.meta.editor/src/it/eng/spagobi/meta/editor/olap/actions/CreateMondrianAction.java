/**
 SpagoBI, the Open Source Business Intelligence suite

 Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this file,
 You can obtain one at http://mozilla.org/MPL/2.0/.
 
 **/
package it.eng.spagobi.meta.editor.olap.actions;

import it.eng.spagobi.meta.editor.olap.wizards.inline.NewMondrianFileWizard;
import it.eng.spagobi.meta.editor.physical.actions.DeletePhysicalModelObjectAction;
import it.eng.spagobi.meta.editor.physical.dialogs.DeleteElementsWarningDialog;
import it.eng.spagobi.meta.initializer.PhysicalModelInitializer;
import it.eng.spagobi.meta.model.Model;
import it.eng.spagobi.meta.model.ModelObject;
import it.eng.spagobi.meta.model.business.BusinessModel;
import it.eng.spagobi.meta.model.business.commands.ISpagoBIModelCommand;
import it.eng.spagobi.meta.model.olap.OlapModel;
import it.eng.spagobi.meta.model.olap.commands.edit.generate.CreateMondrianCommand;
import it.eng.spagobi.meta.model.phantom.provider.BusinessRootItemProvider;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * @author cortella
 * 
 */
public class CreateMondrianAction extends AbstractSpagoBIModelAction {

	/**
	 * @param commandClass
	 * @param workbenchPart
	 * @param selection
	 */
	public CreateMondrianAction(IWorkbenchPart workbenchPart, ISelection selection) {
		super(CreateMondrianCommand.class, workbenchPart, selection);

	}

	/**
	 * This executes the command.
	 */
	@Override
	public void run() {
		try {
			int returnCode = Window.CANCEL;

			BusinessModel businessModel = (BusinessModel) ((BusinessRootItemProvider) owner).getParentObject();

			// First, check if there are any physical model objects marked as deleted
			PhysicalModelInitializer physicalModelInitializer = new PhysicalModelInitializer();
			List<ModelObject> markedElements = physicalModelInitializer.getElementsMarkedAsDeleted(businessModel.getPhysicalModel());
			if (!markedElements.isEmpty()) {
				DeleteElementsWarningDialog warningDialog = new DeleteElementsWarningDialog(markedElements);
				warningDialog.create();
				warningDialog.setBlockOnOpen(true);
				returnCode = warningDialog.open();
				if (returnCode == Window.OK) {
					// execute a command for mass delete of elements marked as deleted
					DeletePhysicalModelObjectAction deletePhysicalModelObjectAction = new DeletePhysicalModelObjectAction();
					final Command deleteCommand = deletePhysicalModelObjectAction.createCommand(markedElements);
					// this guard is for extra security, but should not be necessary
					if (editingDomain != null && deleteCommand != null) {
						// use up the command

						ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(new Shell());
						progressDialog.setCancelable(false);
						try {
							progressDialog.run(false, false, new IRunnableWithProgress() {
								@Override
								public void run(IProgressMonitor monitor) {
									// Note: this is a non-UI Thread
									monitor.beginTask("Deleting marked elements, please wait...", IProgressMonitor.UNKNOWN);
									// doing task...

									editingDomain.getCommandStack().execute(deleteCommand);

									monitor.done();
								}
							});
						} catch (InvocationTargetException e1) {
							e1.printStackTrace();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
					}

				}
			}

			if (markedElements.isEmpty() || returnCode != Window.CANCEL) {
				Model model = businessModel.getParentModel();
				OlapModel olapModel = model.getOlapModels().get(0);

				NewMondrianFileWizard wizard = new NewMondrianFileWizard(olapModel, editingDomain, (ISpagoBIModelCommand) command);
				wizard.init(PlatformUI.getWorkbench(), new StructuredSelection());
				WizardDialog dialog = new WizardDialog(wizard.getShell(), wizard);
				dialog.create();
				dialog.open();
			}

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
