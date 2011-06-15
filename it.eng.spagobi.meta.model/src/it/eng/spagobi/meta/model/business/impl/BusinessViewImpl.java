/**

SpagoBI - The Business Intelligence Free Platform

Copyright (C) 2005-2011 Engineering Ingegneria Informatica S.p.A.

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
package it.eng.spagobi.meta.model.business.impl;

import it.eng.spagobi.meta.model.ModelPropertyType;
import it.eng.spagobi.meta.model.business.BusinessModelPackage;
import it.eng.spagobi.meta.model.business.BusinessView;
import it.eng.spagobi.meta.model.business.BusinessViewInnerJoinRelationship;
import it.eng.spagobi.meta.model.physical.PhysicalTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link it.eng.spagobi.meta.model.business.impl.BusinessViewImpl#getJoinRelationships <em>Join Relationships</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessViewImpl extends BusinessColumnSetImpl implements BusinessView {
	/**
	 * The cached value of the '{@link #getJoinRelationships() <em>Join Relationships</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList<BusinessViewInnerJoinRelationship> joinRelationships;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessViewImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BusinessModelPackage.Literals.BUSINESS_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusinessViewInnerJoinRelationship> getJoinRelationships() {
		if (joinRelationships == null) {
			joinRelationships = new EObjectResolvingEList<BusinessViewInnerJoinRelationship>(BusinessViewInnerJoinRelationship.class, this, BusinessModelPackage.BUSINESS_VIEW__JOIN_RELATIONSHIPS);
		}
		return joinRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BusinessModelPackage.BUSINESS_VIEW__JOIN_RELATIONSHIPS:
				return getJoinRelationships();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BusinessModelPackage.BUSINESS_VIEW__JOIN_RELATIONSHIPS:
				getJoinRelationships().clear();
				getJoinRelationships().addAll((Collection<? extends BusinessViewInnerJoinRelationship>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BusinessModelPackage.BUSINESS_VIEW__JOIN_RELATIONSHIPS:
				getJoinRelationships().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BusinessModelPackage.BUSINESS_VIEW__JOIN_RELATIONSHIPS:
				return joinRelationships != null && !joinRelationships.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	// =========================================================================
	// Utility methods
	// =========================================================================
	
	@Override
	public EList<ModelPropertyType> getPropertyTypes() {
		return null;
	}
	
	@Override
	public List<PhysicalTable> getPhysicalTables(){
		EList<BusinessViewInnerJoinRelationship> joinRelationships = this.getJoinRelationships();
		Set<PhysicalTable> physicalTableSet = new HashSet<PhysicalTable>();
		List<PhysicalTable> physicalTables;
		for (BusinessViewInnerJoinRelationship relationship: joinRelationships){
			physicalTableSet.add(relationship.getSourceTable());
			physicalTableSet.add(relationship.getDestinationTable());
		}
		physicalTables = new ArrayList<PhysicalTable>(physicalTableSet);
		return physicalTables;
	}
	
	@Override
	public List<PhysicalTable> getPhysicalTablesOccurrences(){
		EList<BusinessViewInnerJoinRelationship> joinRelationships = this.getJoinRelationships();
		List<PhysicalTable> physicalTablesOccurences = new ArrayList<PhysicalTable>();
		for (BusinessViewInnerJoinRelationship relationship: joinRelationships){
			if (!physicalTablesOccurences.contains(relationship.getSourceTable())){
				physicalTablesOccurences.add(relationship.getSourceTable());
			}
			physicalTablesOccurences.add(relationship.getDestinationTable());
		}
		return physicalTablesOccurences;
	}
	
	//if the PhysicalTable has more occurrence, return the BusinessInnerJoinRelationship corresponding at the occurence numer specified
	@Override
	public BusinessViewInnerJoinRelationship getBusinessViewInnerJoinRelationshipAtOccurrenceNumber(PhysicalTable physicalTable, int index){
		int counter=0;
		EList<BusinessViewInnerJoinRelationship> joinRelationships = this.getJoinRelationships();
		for (BusinessViewInnerJoinRelationship relationship: joinRelationships){
			if (relationship.getSourceTable().equals(physicalTable)){
				counter++;
				if (counter == index){
					return relationship;
				}
			}
			if (relationship.getDestinationTable().equals(physicalTable)){
				counter++;	
				if (counter == index){
					return relationship;
				}
			}				
		}
		return null;
		
	}
	

} //BusinessViewImpl
