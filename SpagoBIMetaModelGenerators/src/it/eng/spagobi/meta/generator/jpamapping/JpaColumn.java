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

import java.util.List;

import it.eng.spagobi.meta.commons.JDBCTypeMapper;
import it.eng.spagobi.meta.initializer.BusinessModelDefaultPropertiesInitializer;
import it.eng.spagobi.meta.model.ModelProperty;
import it.eng.spagobi.meta.model.business.BusinessColumn;
import it.eng.spagobi.meta.model.business.BusinessRelationship;

/**
 * @author Andrea Gioia (andrea.gioia@eng.it)
 *
 */
public class JpaColumn {
	BusinessColumn businessColumn;
	JpaTable jpaTable;
	
	/*get/set and field scopes*/
	public static final String PUBLIC_SCOPE = "public"; //$NON-NLS-1$
	public static final String PROTECTED_SCOPE = "protected"; //$NON-NLS-1$
	public static final String PRIVATE_SCOPE = "private"; //$NON-NLS-1$
	
	public JpaColumn(BusinessColumn businessColumn) {
		this.businessColumn = businessColumn;
	}
	
	public boolean isIdentifier() {
		return businessColumn.isIdentifier();
	}
	
	/**
	 * Return true if this Column belong to any relationship
	 * @return
	 */
	public boolean isColumnInRelationship() {
		List<BusinessRelationship> relationships;
		relationships = jpaTable.getBusinessTable().getRelationships();
		for(BusinessRelationship relationship : relationships) {
			List<BusinessColumn> columns = null; 
			if(relationship.getSourceTable().equals( jpaTable.getBusinessTable() )) {
				columns =  relationship.getSourceColumns();
			} else {
				columns =  relationship.getDestinationColumns();
			}
			if (columns!=null){
				// scann columns
				for(BusinessColumn column : columns) {
					if(column.equals(businessColumn)) return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns the generated bean property name for the given column.
	 * Does not return null.
	 */
	public String getPropertyName() {
		String name;
		name = StringUtil.tableNameToVarName(businessColumn.getPhysicalColumn().getName());	
		return name;
	}
	

	public String getSimplePropertyType()  {
		String result=null;
		result= getPropertyType().substring( getPropertyType().lastIndexOf('.')+1 );
		return result;
	}
	
	/**
	 * Returns the column type as JAVA Object
	 * Does not return null.
	 */
	public String getPropertyType()  {
		String type;
		
		ModelProperty property = businessColumn.getProperties().get(BusinessModelDefaultPropertiesInitializer.COLUMN_DATATYPE);
		String modelType = property.getValue();
		type = JDBCTypeMapper.getJavaTypeName(modelType);
					
		return type;
	}
	
	public BusinessColumn getBusinessColumn() {
		return businessColumn;
	}
	public void setBusinessColumn(BusinessColumn businessColumn) {
		this.businessColumn = businessColumn;
	}
	public JpaTable getJpaTable() {
		return jpaTable;
	}
	public void setJpaTable(JpaTable jpaTable) {
		this.jpaTable = jpaTable;
	}
	/**
	 * TODO ... da verificare !!  
	 * @return
	 */
	public boolean isDataTypeLOB(){
		ModelProperty property = businessColumn.getProperties().get(BusinessModelDefaultPropertiesInitializer.COLUMN_DATATYPE);
		String modelType = property.getValue();
		if (modelType.equals("BLOB") || modelType.equals("CLOB")) return true;
		else return false;
	}
	
	/**
	 * Return the phisical column name 
	 * @return
	 */
	public String getColumnName(){
		return businessColumn.getPhysicalColumn().getName();
	}
	public String getColumnNameDoubleQuoted(){
		return StringUtil.doubleQuote(businessColumn.getPhysicalColumn().getName());
	}
	
	public boolean needMapTemporalType(){
		if (getPropertyType().equals("java.sql.Date") 
					|| getPropertyType().equals("java.sql.Time")
					|| getPropertyType().equals("java.sql.Timestamp")) return true;
		else return false;
	}
	public String getMapTemporalType(){
		if (getPropertyType().equals("java.sql.Date") ) return "DATE";
		if (getPropertyType().equals("java.sql.Time") ) return "TIME";
		if (getPropertyType().equals("java.sql.Timestamp") ) return "TIMESTAMP";
		else return "";
	}	
	
	/**
	 * Return the name of the metod GETTER
	 * @return
	 */
	public String getPropertyNameGetter() {
		return "get"+StringUtil.initUpper(getPropertyName());
	}
	/**
	 * Return the name of the metod SETTER
	 * @return
	 */
	public String getPropertyNameSetter() {
		return "set"+StringUtil.initUpper(getPropertyName());
	}	
}
