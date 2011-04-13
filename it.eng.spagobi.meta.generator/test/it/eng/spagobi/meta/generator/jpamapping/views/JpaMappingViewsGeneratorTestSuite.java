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
package it.eng.spagobi.meta.generator.jpamapping.views;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;



/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class JpaMappingViewsGeneratorTestSuite extends TestCase {
	static public Test suite() {
		TestSuite suite = new TestSuite();
		//suite.addTestSuite(JpaMappingNoKeyGeneratorTestCase.class);
		suite.addTestSuite(JpaMappingSimpleKeyGeneratorTestCase.class);
		//suite.addTestSuite(JpaMappingCompKeyGeneratorTestCase.class);
		suite.addTestSuite(JpaMappingRelNoKeyGeneratorTestCase.class);
		suite.addTestSuite(JpaMappingRelSimpleKeyGeneratorTestCase.class);
		//suite.addTestSuite(JpaMappingRelCompKeyGeneratorTestCase.class);
		return suite;
	}
}