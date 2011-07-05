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
package it.eng.spagobi.meta.generator.jpamapping.wrappers;

import it.eng.spagobi.meta.generator.jpamapping.wrappers.impl.JpaViewInnerJoinRelatioship;
import it.eng.spagobi.meta.generator.jpamapping.wrappers.impl.JpaViewInnerTable;
import it.eng.spagobi.meta.generator.jpamapping.wrappers.impl.JpaViewOuterRelationship;
import it.eng.spagobi.meta.model.business.BusinessRelationship;
import it.eng.spagobi.meta.model.business.BusinessViewInnerJoinRelationship;

import java.util.List;

public interface IJpaView {
	
	String getPackage();

	public String getName();
	
	public String getDescription();
	
	String getClassName();
	
	String getQualifiedClassName();
	
	String getUniqueName();
	

	List<IJpaTable> getInnerTables();

	List<IJpaColumn> getColumns(JpaViewInnerTable table);

	List<JpaViewInnerJoinRelatioship> getJoinRelationships();
	
	List<JpaViewOuterRelationship> getRelationships();
	
	List<IJpaSubEntity> getSubEntities();

}