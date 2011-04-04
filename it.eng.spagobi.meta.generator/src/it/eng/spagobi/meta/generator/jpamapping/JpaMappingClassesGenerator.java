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
package it.eng.spagobi.meta.generator.jpamapping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.eng.spagobi.meta.compiler.DataMartGenerator;
import it.eng.spagobi.meta.generator.GenerationException;
import it.eng.spagobi.meta.generator.jpamapping.wrappers.JpaProperties;
import it.eng.spagobi.meta.model.ModelObject;
import it.eng.spagobi.meta.model.business.BusinessModel;

/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class JpaMappingClassesGenerator extends JpaMappingCodeGenerator {
	
	//List<File> libs;
	
	private File libDir;
	
	private String[] libraryLink = {
		"org.eclipse.persistence.core_2.1.1.v20100817-r8050.jar",
	  	"javax.persistence_2.0.1.v201006031150.jar"
	};
	
	private static Logger logger = LoggerFactory.getLogger(JpaMappingClassesGenerator.class);
	
	JpaMappingClassesGenerator() {
		//libs = new ArrayList<File>();
	}
	
	public void setLibDir(File libDir) {
		this.libDir = libDir;
	}

	public void setLibraryLink(String[] libraryLink) {
		this.libraryLink = libraryLink;
	}

	@Override
	public void generate(ModelObject o, String outputDir)  {
		logger.trace("IN");
		
		try {
			BusinessModel model;
			
			super.generate(o, outputDir);
			
			model = (BusinessModel)o;
			
			//Get Package Name
			String packageName = model.getProperties().get(JpaProperties.MODEL_PACKAGE).getValue();
				
			//Call Java Compiler
			DataMartGenerator datamartGenerator = new DataMartGenerator(
					baseOutputDir,
					packageName.replace(".", "/")
			);
			datamartGenerator.setLibDir(new File("plugins"));
			
			
			datamartGenerator = new DataMartGenerator(
					baseOutputDir, 
					packageName.replace(".", "/")
			);
			
			datamartGenerator.setLibDir(libDir);
			datamartGenerator.setLibraryLink(libraryLink);
			
			
			
			boolean compiled = datamartGenerator.compile();
			
			if(!compiled) {
				throw new GenerationException("Impossible to compile mapping code");
			}
			
		} catch(Throwable t) {
			logger.error("An error occur while generating JPA jar", t);
			throw new GenerationException("An error occur while generating JPA jar", t);
		} finally {		
			logger.trace("OUT");
		}
	}
}
