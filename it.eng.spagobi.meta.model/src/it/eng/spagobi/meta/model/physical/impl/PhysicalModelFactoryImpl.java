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
package it.eng.spagobi.meta.model.physical.impl;

import it.eng.spagobi.meta.model.physical.*;
import it.eng.spagobi.meta.model.physical.PhysicalColumn;
import it.eng.spagobi.meta.model.physical.PhysicalForeignKey;
import it.eng.spagobi.meta.model.physical.PhysicalModel;
import it.eng.spagobi.meta.model.physical.PhysicalModelFactory;
import it.eng.spagobi.meta.model.physical.PhysicalModelPackage;
import it.eng.spagobi.meta.model.physical.PhysicalPrimaryKey;
import it.eng.spagobi.meta.model.physical.PhysicalTable;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PhysicalModelFactoryImpl extends EFactoryImpl implements PhysicalModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PhysicalModelFactory init() {
		try {
			PhysicalModelFactory thePhysicalModelFactory = (PhysicalModelFactory)EPackage.Registry.INSTANCE.getEFactory("http:///it/eng/spagobi/meta/model/physical.ecore"); 
			if (thePhysicalModelFactory != null) {
				return thePhysicalModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PhysicalModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case PhysicalModelPackage.PHYSICAL_MODEL: return createPhysicalModel();
			case PhysicalModelPackage.PHYSICAL_TABLE: return createPhysicalTable();
			case PhysicalModelPackage.PHYSICAL_COLUMN: return createPhysicalColumn();
			case PhysicalModelPackage.PHYSICAL_PRIMARY_KEY: return createPhysicalPrimaryKey();
			case PhysicalModelPackage.PHYSICAL_FOREIGN_KEY: return createPhysicalForeignKey();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalColumn createPhysicalColumn() {
		PhysicalColumnImpl physicalColumn = new PhysicalColumnImpl();
		return physicalColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalForeignKey createPhysicalForeignKey() {
		PhysicalForeignKeyImpl physicalForeignKey = new PhysicalForeignKeyImpl();
		return physicalForeignKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalModel createPhysicalModel() {
		PhysicalModelImpl physicalModel = new PhysicalModelImpl();
		return physicalModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalPrimaryKey createPhysicalPrimaryKey() {
		PhysicalPrimaryKeyImpl physicalPrimaryKey = new PhysicalPrimaryKeyImpl();
		return physicalPrimaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalTable createPhysicalTable() {
		PhysicalTableImpl physicalTable = new PhysicalTableImpl();
		return physicalTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalModelPackage getPhysicalModelPackage() {
		return (PhysicalModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PhysicalModelPackage getPackage() {
		return PhysicalModelPackage.eINSTANCE;
	}

} //PhysicalModelFactoryImpl
