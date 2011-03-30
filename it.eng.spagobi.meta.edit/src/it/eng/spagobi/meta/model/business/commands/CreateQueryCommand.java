/**

SpagoBI - The Business Intelligence Free Platform

Copyright (C) 2005-2010 Engineering Ingegneria Informatica S.p.A.

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA

**/
package it.eng.spagobi.meta.model.business.commands;


import it.eng.spagobi.meta.compiler.DataMartGenerator;
import it.eng.spagobi.meta.generator.jpamapping.JpaMappingGenerator;
import it.eng.spagobi.meta.initializer.properties.BusinessModelDefaultPropertiesInitializer;
import it.eng.spagobi.meta.model.business.BusinessModel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @authors cortella, gioia
 *
 */
public class CreateQueryCommand extends AbstractSpagoBIModelCommand {

	File queryFile;
	
	private static Logger logger = LoggerFactory.getLogger(CreateQueryCommand.class);
	
	public CreateQueryCommand(EditingDomain domain, CommandParameter parameter) {
		super( "model.business.commands.createquery.label"
			 , "model.business.commands.createquery.description"
			 , "model.business.commands.createquery"
			 , domain, parameter);
	}
	
	public CreateQueryCommand(EditingDomain domain) {
		this(domain, null);
	}
	
	@Override
	public void execute() {		
		prepareMapping();
		initQueryFileContents();
		openQueryEditor();		
	}
	
	protected void prepareMapping() {
		BusinessModel businessModel;
		businessModel = (BusinessModel)parameter.getOwner();
		String directory = (String)parameter.getValue();

		//Call JPA Mapping generator
		JpaMappingGenerator generator = new JpaMappingGenerator();
		try {
			generator.generate(businessModel, directory);
		} catch (Exception e) {
			logger.error("An error occurred while executing command [{}]:", EditBusinessColumnsCommand.class.getName(), e);
			showInformation("Error in JPAMappingGenerator","Cannot create JPA Mapping classes");
		}
		
		//Get Package Name
		String packageName = businessModel.getProperties().get(BusinessModelDefaultPropertiesInitializer.MODEL_PACKAGE).getValue();
			
		//Call Java Compiler
		DataMartGenerator datamartGenerator = new DataMartGenerator(
				directory,
				directory+"/build/",
				null,
				directory+"/dist/",
				packageName.replace(".", "/")
				);		
		
		boolean result = datamartGenerator.compile();
		if (result){
			// compile OK
			showInformation("Successfull Compilation ","JPA Source Code correctly compiled");
			
			//Generate Jar from compiled code
			datamartGenerator.jar();
			this.executed = true;
			logger.debug("Command [{}] executed succesfully", EditBusinessColumnsCommand.class.getName());
		}else{
			// compile error
			showInformation("Failed Compilation","Error: JPA Source Code NOT correctly compiled");
			this.executed = false; 
			logger.debug("Command [{}] not executed succesfully", EditBusinessColumnsCommand.class.getName());
		}
		
		
	}
	
	protected void initQueryFileContents() {
		String directory;
		BusinessModel businessModel;
		Writer out;
		
		directory = (String)parameter.getValue();		
		queryFile = new File(directory,"query.metaquery");
		
		if(!queryFile.exists()){
			out = null;
			try {
				queryFile.createNewFile();
				FileWriter fstream = new FileWriter(queryFile);
				out = new BufferedWriter(fstream);
				businessModel = (BusinessModel)parameter.getOwner();
				//out.write("// Target business model: " + businessModel.getName());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if(out != null) {
					try {
						out.flush();
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}
	
	protected void openQueryEditor() {
		if (queryFile.exists() && queryFile.isFile()) {
		    IFileStore fileStore = EFS.getLocalFileSystem().getStore(queryFile.toURI());
		    IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		 
		    try {
		        IDE.openEditorOnFileStore( page, fileStore );
		    } catch ( PartInitException e ) {
		        e.printStackTrace();
		    }
		}
	}
	
	//This command can't be undone
	@Override
	public boolean canUndo() {
		return false;
	}
	
	/**
	 * Show an information dialog box.
	 */
	public void showInformation(final String title, final String message) {
	  Display.getDefault().asyncExec(new Runnable() {
	    @Override
	    public void run() {
	      MessageDialog.openInformation(null, title, message);
	    }
	  });
	}	
}
