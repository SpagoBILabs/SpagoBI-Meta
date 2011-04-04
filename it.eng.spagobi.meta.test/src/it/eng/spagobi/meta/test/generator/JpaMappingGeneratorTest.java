package it.eng.spagobi.meta.test.generator;

import java.io.File;

import it.eng.spagobi.meta.generator.jpamapping.JpaMappingCodeGenerator;
import it.eng.spagobi.meta.initializer.BusinessModelInitializer;
import it.eng.spagobi.meta.initializer.PhysicalModelInitializer;
import it.eng.spagobi.meta.model.Model;
import it.eng.spagobi.meta.model.ModelFactory;
import it.eng.spagobi.meta.model.business.BusinessModel;
import it.eng.spagobi.meta.model.physical.PhysicalModel;
import it.eng.spagobi.meta.test.initializer.TestConnectionFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class JpaMappingGeneratorTest {

	TestConnectionFactory.DatabaseType dbType=TestConnectionFactory.DatabaseType.MYSQL;
	Model rootModel=null;
	PhysicalModel physicalModel=null;
	PhysicalModelInitializer modelInitializer=null;
	BusinessModel businessModel=null;
	BusinessModelInitializer businessModelInitializer=null;
        
	JpaMappingCodeGenerator gen = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// initialize model
		
		rootModel = ModelFactory.eINSTANCE.createModel();
		rootModel.setName("modelDemo");
		
		modelInitializer = new PhysicalModelInitializer();
		modelInitializer.setRootModel(rootModel);		
		physicalModel = modelInitializer.initialize( 
        		"physicalModelDemo", 
        		TestConnectionFactory.createConnection(dbType),
        		"Test Connection",
        		TestConnectionFactory.MYSQL_URL,
        		TestConnectionFactory.MYSQL_USER,
        		TestConnectionFactory.MYSQL_PWD,
        		"DB Name",
        		TestConnectionFactory.getDefaultCatalogue(dbType), 
        		TestConnectionFactory.getDefaultSchema(dbType));
		
        businessModelInitializer = new BusinessModelInitializer();
        businessModel = businessModelInitializer.initialize("businessModelDemo", physicalModel);	
        
        gen = new JpaMappingCodeGenerator();
	}
}
