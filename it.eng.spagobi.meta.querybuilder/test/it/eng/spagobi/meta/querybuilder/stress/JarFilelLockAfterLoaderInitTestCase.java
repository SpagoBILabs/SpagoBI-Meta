/**
 SpagoBI, the Open Source Business Intelligence suite

 Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this file,
 You can obtain one at http://mozilla.org/MPL/2.0/.
 
**/
package it.eng.spagobi.meta.querybuilder.stress;

import it.eng.qbe.classloader.ClassLoaderManager;
import it.eng.spagobi.commons.exception.SpagoBIPluginException;
import it.eng.spagobi.meta.querybuilder.AbtractQueryBuilderTestCase;
import it.eng.spagobi.meta.querybuilder.TestCaseConstants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Alberto Ghedin (alberto.ghedin@eng.it)
 *
 */
public class JarFilelLockAfterLoaderInitTestCase extends AbtractQueryBuilderTestCase {

	// How many time creation/deletion loop must iterate
	public static final int ITERATION_NUMBER = 10;
	
	public static final File TEST_INPUT_FOLDER = new File(TestCaseConstants.TEST_FOLDER, "models/stress");
	public static final File TEST_OUTPUT_FOLDER = new File(TestCaseConstants.TEST_OUPUT_ROOT_FOLDER, "stress");
	
	// a model with no keys but with relationships
	private static final File TEST_JAR_FILE = new File(TEST_INPUT_FOLDER, "datamart.jar");
	


	protected void setUp() throws Exception {
		modelName = "a";
		super.setUp();
		File jarFile = new File(TEST_OUTPUT_FOLDER, "datamart.jar");
		if(jarFile.exists()) {
			try {
				doDeleteJarFileTest(jarFile);
			} catch(Throwable t) {
				System.err.println("SET-UP: impossible to delete an old version of datamart.jar");
				throw new Exception(t);
			}
			System.err.println("SET-UP: delelted an old version of datamart.jar");
		} else {
			System.err.println("SET-UP: Test output folder is empty");
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testJarFileLock() throws Exception {
		try {
			for(int i = 0; i < ITERATION_NUMBER; i++){
				copyFile(TEST_JAR_FILE, TEST_OUTPUT_FOLDER);
				File jarFile = new File(TEST_OUTPUT_FOLDER, "datamart.jar");
				doClassLoaderInitializationTest( jarFile );	
				doDeleteJarFileTest( jarFile );
				System.err.println("Jar file [" + jarFile.getAbsolutePath() + "] deleted succesfully (iteration " + (i+1) + " of " + ITERATION_NUMBER +")");
			}
		} catch (SpagoBIPluginException e) {
			e.printStackTrace();
			fail("Can't delete the file");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}

	private void doDeleteJarFileTest(File file){
		boolean b = file.delete();
		if(!b) {
			throw new SpagoBIPluginException("Can't delete the file "+ file.getAbsolutePath()+" the file is writtable? "+file.canWrite() +" "+file.canExecute());
		}
	}
	
	private void doClassLoaderInitializationTest(File jarFile) throws Exception {
		//ClassLoaderManager.qbeClassLoader = null;
		ClassLoaderManager.updateCurrentClassLoader(jarFile);	
	}
	
	private void copyFile(File sourceFile, File destinationFolder) {
		try {
			File destinationFile = new File(destinationFolder, sourceFile.getName());
			if(!destinationFolder.exists()) {
				destinationFolder.mkdirs();
			}
		    InputStream in = new FileInputStream(sourceFile);
		    OutputStream out = new FileOutputStream(destinationFile);

		    byte[] buf = new byte[1024];
		    int len;
		    while ((len = in.read(buf)) > 0){
		    	out.write(buf, 0, len);
		    }
		    in.close();
		    out.flush();
		    out.close();
		   
		    /*
		    // release pointers
		    in = null;
		    out = null;
		    
		    // force garbage collection
		    Runtime javaRuntime = Runtime.getRuntime();
		    javaRuntime.gc();
			*/
		    
		    System.err.println("File [" + destinationFile.getAbsolutePath() + "] succesfully created");
		} catch(Throwable t) {
			throw new RuntimeException("Impossible to copy file [" + sourceFile + "] into folder [" + destinationFolder + "]", t);
		}

	}
	
}
