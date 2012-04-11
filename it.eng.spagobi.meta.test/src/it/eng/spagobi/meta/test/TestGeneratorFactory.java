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
package it.eng.spagobi.meta.test;

import it.eng.spagobi.meta.generator.jpamapping.JpaMappingClassesGenerator;
import it.eng.spagobi.meta.generator.jpamapping.JpaMappingCodeGenerator;
import it.eng.spagobi.meta.generator.jpamapping.JpaMappingJarGenerator;

import java.io.File;

/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class TestGeneratorFactory {
	public static JpaMappingCodeGenerator createCodeGeneraor() {
		File generatorProjectRootFolder = new File(TestCostants.workspaceFolder, "it.eng.spagobi.meta.generator");
		File generatorProjectTemplateFolder = new File(generatorProjectRootFolder, "templates");
		JpaMappingCodeGenerator.defaultTemplateFolderPath = generatorProjectTemplateFolder.toString();
		JpaMappingCodeGenerator jpaMappingCodeGenerator = new JpaMappingCodeGenerator();
		return jpaMappingCodeGenerator;	
	}
	
	public static JpaMappingClassesGenerator createClassesGeneraor() {
		File generatorProjectRootFolder = new File(TestCostants.workspaceFolder, "it.eng.spagobi.meta.generator");
		File generatorProjectTemplateFolder = new File(generatorProjectRootFolder, "templates");
		File generatorProjectLibFolder = new File(generatorProjectRootFolder, "libs/eclipselink");
		
		JpaMappingClassesGenerator jpaMappingClassesGenerator;
		JpaMappingClassesGenerator.defaultTemplateFolderPath = generatorProjectTemplateFolder.toString();
		jpaMappingClassesGenerator = new JpaMappingJarGenerator();
		
		jpaMappingClassesGenerator.setLibDir( generatorProjectLibFolder );
		jpaMappingClassesGenerator.setLibs(new String[]{
				"org.eclipse.persistence.core_2.1.2.jar",
				"javax.persistence_2.0.1.jar"
		});	
		return jpaMappingClassesGenerator;
	}
	
	public static JpaMappingJarGenerator createJarGeneraor() {
		JpaMappingJarGenerator jpaMappingJarGenerator;
		JpaMappingJarGenerator.defaultTemplateFolderPath = "D:/Documenti/Sviluppo/workspaces/helios/metadata/it.eng.spagobi.meta.generator/templates";
		jpaMappingJarGenerator = new JpaMappingJarGenerator();
		File projectRootFolder = new File("D:/Documenti/Sviluppo/workspaces/helios/metadata/it.eng.spagobi.meta.generator");
		jpaMappingJarGenerator.setLibDir(new File(projectRootFolder, "libs/eclipselink"));
		jpaMappingJarGenerator.setLibs(new String[]{
				"org.eclipse.persistence.core_2.1.2.jar",
				"javax.persistence_2.0.1.jar"
		});	
		return jpaMappingJarGenerator;
	}
}