/**
 SpagoBI, the Open Source Business Intelligence suite

 Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this file,
 You can obtain one at http://mozilla.org/MPL/2.0/.
 
**/
package it.eng.spagobi.meta.editor.business.wizards.inline;

import it.eng.spagobi.commons.resource.IResourceLocator;
import it.eng.spagobi.meta.editor.SpagoBIMetaEditorPlugin;
import it.eng.spagobi.meta.model.business.BusinessColumnSet;
import it.eng.spagobi.meta.model.business.BusinessModel;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

/**
 * @author cortella
 *
 */
public class AddBusinessIdentifierWizardPageBusinessTableSelection extends
		WizardPage {

	private String defaultTable;
	private List tableList;
	private String tableSelected;
	private AddBusinessIdentifierWizardPageColumnSelection pageTwoRef;
	private BusinessColumnSet businessColumnSet;
	
	private static final IResourceLocator RL = SpagoBIMetaEditorPlugin.getInstance().getResourceLocator(); 
	
	/**
	 * @param pageName
	 */
	protected AddBusinessIdentifierWizardPageBusinessTableSelection(
			String pageName, String defaultTable, BusinessColumnSet businessColumnSet) {
		super(pageName);
		setTitle(RL.getString("business.editor.wizard.addbusinessidentifier.title"));
		setDescription(RL.getString("business.editor.wizard.addbusinessidentifier.tableselection.description"));
		ImageDescriptor image = ImageDescriptor.createFromURL( (URL)RL.getImage("it.eng.spagobi.meta.editor.business.wizards.inline.createBI") );
		if (image!=null) setImageDescriptor(image);	
	    this.defaultTable = defaultTable;
	    this.businessColumnSet = businessColumnSet;
	}

	@Override
	public void createControl(Composite parent) {
		//Main composite
		Composite composite = new Composite(parent, SWT.NULL);
        //Important: Setting page control
 		setControl(composite);
		
 		GridLayout gl = new GridLayout();
		gl.numColumns = 1;
		gl.makeColumnsEqualWidth = true;
		composite.setLayout(gl);
		
		createTableGroup(composite,SWT.SHADOW_ETCHED_IN);
 		
 		populateTableList();
 		
 		addListener();
 		
 	    checkPageComplete();

	}
	
	private void createTableGroup(Composite composite, int style){
		//Business Table List
		Group tableGroup = new Group(composite, style);
		tableGroup.setText(RL.getString("business.editor.wizard.addbusinessidentifier.tableselection.label"));
		GridLayout glTable = new GridLayout();
		GridData gd = new GridData(GridData.FILL_BOTH);
		glTable.numColumns = 1;
		glTable.makeColumnsEqualWidth = false;
		tableGroup.setLayout(glTable);
		tableGroup.setLayoutData(gd);

		Composite compList = new Composite(tableGroup, SWT.NONE);
		GridLayout glL = new GridLayout();
		GridData gdL = new GridData(GridData.FILL_BOTH);
		glL.numColumns = 1;
		compList.setLayout(glL);
		compList.setLayoutData(gdL);
		
 		tableList = new List(compList, SWT.BORDER|SWT.SINGLE|SWT.V_SCROLL|SWT.H_SCROLL);
 		GridData gdList = new GridData(GridData.FILL_BOTH);
 		gdList.heightHint = 250;
 		tableList.setLayoutData(gdList);
	}
	
	public void addListener(){
		//adding listener to List
 		tableList.addListener(SWT.Selection, new Listener() {		
			@Override
			public void handleEvent(Event event) {
				String[] sel = tableList.getSelection();
				setTableSelected(sel[0]);
				checkPageComplete();
			}
		});		
	}
	
	//populate the list with the Business Tables' names
	private void populateTableList(){
		BusinessModel businessModel = businessColumnSet.getModel();
		int numTables = businessModel.getTables().size();
		String tabName;
		for (int i = 0; i < numTables; i++){
			tabName = businessModel.getTables().get(i).getName();
			tableList.add(tabName);		
		}
	}	

	//check if the right conditions to go forward occurred
	private void checkPageComplete(){
 		if (defaultTable != null){
 			tableList.setSelection(new String[]{defaultTable});
 			tableList.setEnabled(false);
 			setPageComplete(true);
 		}
 		else if(tableSelected != null){
			setPageComplete(true);
			if (pageTwoRef != null)
				pageTwoRef.addTableItems(tableSelected);
		}
		else{			
			setPageComplete(false);
		}		
	}	
	
	/**
	 * @param tableSelected the tableSelected to set
	 */
	public void setTableSelected(String tableSelected) {
		this.tableSelected = tableSelected;
	}

	/**
	 * @return the tableSelected
	 */
	public String getTableSelected() {
		return tableSelected;
	}

	/**
	 * @param pageTwoRef the pageTwoRef to set
	 */
	public void setPageTwoRef(AddBusinessIdentifierWizardPageColumnSelection pageTwoRef) {
		this.pageTwoRef = pageTwoRef;
	}

	/**
	 * @return the pageTwoRef
	 */
	public AddBusinessIdentifierWizardPageColumnSelection getPageTwoRef() {
		return pageTwoRef;
	}
}
