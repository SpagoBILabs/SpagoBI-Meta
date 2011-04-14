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
package it.eng.spagobi.meta.querybuilder.edit;

import it.eng.qbe.query.WhereField;
import it.eng.qbe.query.WhereField.Operand;
import it.eng.qbe.statement.AbstractStatement;
import it.eng.spagobi.meta.querybuilder.ui.QueryBuilder;

import java.util.StringTokenizer;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;


/**
 * @author Alberto Ghedin (alberto.ghedin@eng.it)
 *
 */
public class FilterRightOperandColumnEditingSupport extends EditingSupport {
	private final TableViewer viewer;
	private QueryBuilder queryBuilder;
	/**
	 * @param viewer
	 */
	public FilterRightOperandColumnEditingSupport(TableViewer viewer, QueryBuilder queryBuilder) {
		super(viewer);
		this.viewer = viewer;
		this.queryBuilder = queryBuilder;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new TextCellEditor(viewer.getTable());
	}


	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		WhereField whereField = ((WhereField) element);
		if(whereField!=null && whereField.getRightOperand()!=null && whereField.getRightOperand().description!=null){
			return whereField.getRightOperand().description;
		}
		return "";
	}

	@Override
	protected void setValue(Object element, Object value) {	
		String stringValue = (String)value;
		String[] values = getValues(stringValue);
		Operand rightOperand = new Operand(values,stringValue, AbstractStatement.OPERAND_TYPE_STATIC, values, values);
		((WhereField) element).setRightOperand(rightOperand);
		viewer.refresh();
		
		queryBuilder.setDirtyEditor();
	}
	
	private String[] getValues(String values){
		StringTokenizer stk = new StringTokenizer(values,",");
		int tockensNumber = stk.countTokens();
		String[] valuesArray = new String[tockensNumber];
		int i=0;
		while(stk.hasMoreTokens()){
			valuesArray[i]=stk.nextToken();
			i++;
		}
		return valuesArray;
		
	}

}