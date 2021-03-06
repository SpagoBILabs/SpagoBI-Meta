/**
 SpagoBI, the Open Source Business Intelligence suite

 Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this file,
 You can obtain one at http://mozilla.org/MPL/2.0/.
 
**/
package it.eng.spagobi.meta.mapper.cwm;

import it.eng.spagobi.meta.mapper.cwm.emf.CWMEMFImpl;
import it.eng.spagobi.meta.mapper.cwm.jmi.SpagoBICWMJMIImpl;


/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class CWMFactory {
	public static ICWM createModel(String modelName, CWMImplType implementationType) {
		ICWM cwm = null;
		
		if(implementationType == CWMImplType.JMI) {
			cwm = new SpagoBICWMJMIImpl(modelName);
		} else {
			cwm = new CWMEMFImpl(modelName);
		}
		
		return cwm;
	}
}
