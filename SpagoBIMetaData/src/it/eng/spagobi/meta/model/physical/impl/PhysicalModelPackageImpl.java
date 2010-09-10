/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package it.eng.spagobi.meta.model.physical.impl;

import it.eng.spagobi.meta.model.physical.PhysicalColumn;
import it.eng.spagobi.meta.model.physical.PhysicalForeignKey;
import it.eng.spagobi.meta.model.physical.PhysicalModel;
import it.eng.spagobi.meta.model.physical.PhysicalModelFactory;
import it.eng.spagobi.meta.model.physical.PhysicalModelPackage;
import it.eng.spagobi.meta.model.physical.PhysicalPrimaryKey;
import it.eng.spagobi.meta.model.physical.PhysicalTable;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PhysicalModelPackageImpl extends EPackageImpl implements PhysicalModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalColumnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalForeignKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalPrimaryKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass physicalTableEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see it.eng.spagobi.meta.model.physical.PhysicalModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PhysicalModelPackageImpl() {
		super(eNS_URI, PhysicalModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PhysicalModelPackage init() {
		if (isInited) return (PhysicalModelPackage)EPackage.Registry.INSTANCE.getEPackage(PhysicalModelPackage.eNS_URI);

		// Obtain or create and register package
		PhysicalModelPackageImpl thePhysicalModelPackage = (PhysicalModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof PhysicalModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new PhysicalModelPackageImpl());

		isInited = true;

		// Create package meta-data objects
		thePhysicalModelPackage.createPackageContents();

		// Initialize created meta-data
		thePhysicalModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePhysicalModelPackage.freeze();

		return thePhysicalModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalColumn() {
		return physicalColumnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_Name() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_Comment() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_DataType() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_TypeName() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_Size() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_OctectLength() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_DecimalDigits() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_Radix() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_DefaultValue() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_Nullable() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalColumn_Position() {
		return (EAttribute)physicalColumnEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalColumn_Table() {
		return (EReference)physicalColumnEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalForeignKey() {
		return physicalForeignKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalForeignKey_SourceName() {
		return (EAttribute)physicalForeignKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalForeignKey_SourceTable() {
		return (EReference)physicalForeignKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalForeignKey_SourceColumns() {
		return (EReference)physicalForeignKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalForeignKey_DestinationName() {
		return (EAttribute)physicalForeignKeyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalForeignKey_DestinationTable() {
		return (EReference)physicalForeignKeyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalForeignKey_DestinationColumns() {
		return (EReference)physicalForeignKeyEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalForeignKey_Model() {
		return (EReference)physicalForeignKeyEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalModel() {
		return physicalModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalModel_Name() {
		return (EAttribute)physicalModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalModel_DatabaseName() {
		return (EAttribute)physicalModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalModel_DatabaseVersion() {
		return (EAttribute)physicalModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalModel_Catalog() {
		return (EAttribute)physicalModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalModel_Schema() {
		return (EAttribute)physicalModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalModel_Tables() {
		return (EReference)physicalModelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalModel_PrimaryKeys() {
		return (EReference)physicalModelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalModel_ForeignKeys() {
		return (EReference)physicalModelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalPrimaryKey() {
		return physicalPrimaryKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalPrimaryKey_Name() {
		return (EAttribute)physicalPrimaryKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalPrimaryKey_Model() {
		return (EReference)physicalPrimaryKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalPrimaryKey_Table() {
		return (EReference)physicalPrimaryKeyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalPrimaryKey_Columns() {
		return (EReference)physicalPrimaryKeyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPhysicalTable() {
		return physicalTableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalTable_Name() {
		return (EAttribute)physicalTableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalTable_Comment() {
		return (EAttribute)physicalTableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPhysicalTable_Type() {
		return (EAttribute)physicalTableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalTable_Model() {
		return (EReference)physicalTableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalTable_Columns() {
		return (EReference)physicalTableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalTable_PrimaryKey() {
		return (EReference)physicalTableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalTable_ForeignKeys() {
		return (EReference)physicalTableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPhysicalTable_ReverseForeignKeys() {
		return (EReference)physicalTableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhysicalModelFactory getPhysicalModelFactory() {
		return (PhysicalModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		physicalColumnEClass = createEClass(PHYSICAL_COLUMN);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__NAME);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__COMMENT);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__DATA_TYPE);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__TYPE_NAME);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__SIZE);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__OCTECT_LENGTH);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__DECIMAL_DIGITS);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__RADIX);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__DEFAULT_VALUE);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__NULLABLE);
		createEAttribute(physicalColumnEClass, PHYSICAL_COLUMN__POSITION);
		createEReference(physicalColumnEClass, PHYSICAL_COLUMN__TABLE);

		physicalForeignKeyEClass = createEClass(PHYSICAL_FOREIGN_KEY);
		createEAttribute(physicalForeignKeyEClass, PHYSICAL_FOREIGN_KEY__SOURCE_NAME);
		createEReference(physicalForeignKeyEClass, PHYSICAL_FOREIGN_KEY__SOURCE_TABLE);
		createEReference(physicalForeignKeyEClass, PHYSICAL_FOREIGN_KEY__SOURCE_COLUMNS);
		createEAttribute(physicalForeignKeyEClass, PHYSICAL_FOREIGN_KEY__DESTINATION_NAME);
		createEReference(physicalForeignKeyEClass, PHYSICAL_FOREIGN_KEY__DESTINATION_TABLE);
		createEReference(physicalForeignKeyEClass, PHYSICAL_FOREIGN_KEY__DESTINATION_COLUMNS);
		createEReference(physicalForeignKeyEClass, PHYSICAL_FOREIGN_KEY__MODEL);

		physicalModelEClass = createEClass(PHYSICAL_MODEL);
		createEAttribute(physicalModelEClass, PHYSICAL_MODEL__NAME);
		createEAttribute(physicalModelEClass, PHYSICAL_MODEL__DATABASE_NAME);
		createEAttribute(physicalModelEClass, PHYSICAL_MODEL__DATABASE_VERSION);
		createEAttribute(physicalModelEClass, PHYSICAL_MODEL__CATALOG);
		createEAttribute(physicalModelEClass, PHYSICAL_MODEL__SCHEMA);
		createEReference(physicalModelEClass, PHYSICAL_MODEL__TABLES);
		createEReference(physicalModelEClass, PHYSICAL_MODEL__PRIMARY_KEYS);
		createEReference(physicalModelEClass, PHYSICAL_MODEL__FOREIGN_KEYS);

		physicalPrimaryKeyEClass = createEClass(PHYSICAL_PRIMARY_KEY);
		createEAttribute(physicalPrimaryKeyEClass, PHYSICAL_PRIMARY_KEY__NAME);
		createEReference(physicalPrimaryKeyEClass, PHYSICAL_PRIMARY_KEY__MODEL);
		createEReference(physicalPrimaryKeyEClass, PHYSICAL_PRIMARY_KEY__TABLE);
		createEReference(physicalPrimaryKeyEClass, PHYSICAL_PRIMARY_KEY__COLUMNS);

		physicalTableEClass = createEClass(PHYSICAL_TABLE);
		createEAttribute(physicalTableEClass, PHYSICAL_TABLE__NAME);
		createEAttribute(physicalTableEClass, PHYSICAL_TABLE__COMMENT);
		createEAttribute(physicalTableEClass, PHYSICAL_TABLE__TYPE);
		createEReference(physicalTableEClass, PHYSICAL_TABLE__MODEL);
		createEReference(physicalTableEClass, PHYSICAL_TABLE__COLUMNS);
		createEReference(physicalTableEClass, PHYSICAL_TABLE__PRIMARY_KEY);
		createEReference(physicalTableEClass, PHYSICAL_TABLE__FOREIGN_KEYS);
		createEReference(physicalTableEClass, PHYSICAL_TABLE__REVERSE_FOREIGN_KEYS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(physicalColumnEClass, PhysicalColumn.class, "PhysicalColumn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhysicalColumn_Name(), ecorePackage.getEString(), "name", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_DataType(), ecorePackage.getEShort(), "dataType", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_TypeName(), ecorePackage.getEString(), "typeName", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_Size(), ecorePackage.getEInt(), "size", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_OctectLength(), ecorePackage.getEInt(), "octectLength", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_DecimalDigits(), ecorePackage.getEInt(), "decimalDigits", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_Radix(), ecorePackage.getEInt(), "radix", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_DefaultValue(), ecorePackage.getEString(), "defaultValue", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_Nullable(), ecorePackage.getEBoolean(), "nullable", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalColumn_Position(), ecorePackage.getEInt(), "position", null, 0, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalColumn_Table(), this.getPhysicalTable(), this.getPhysicalTable_Columns(), "table", null, 1, 1, PhysicalColumn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalForeignKeyEClass, PhysicalForeignKey.class, "PhysicalForeignKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhysicalForeignKey_SourceName(), ecorePackage.getEString(), "sourceName", null, 0, 1, PhysicalForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalForeignKey_SourceTable(), this.getPhysicalTable(), this.getPhysicalTable_ForeignKeys(), "sourceTable", null, 1, 1, PhysicalForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalForeignKey_SourceColumns(), this.getPhysicalColumn(), null, "sourceColumns", null, 1, -1, PhysicalForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalForeignKey_DestinationName(), ecorePackage.getEString(), "destinationName", null, 0, 1, PhysicalForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalForeignKey_DestinationTable(), this.getPhysicalTable(), this.getPhysicalTable_ReverseForeignKeys(), "destinationTable", null, 1, 1, PhysicalForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalForeignKey_DestinationColumns(), this.getPhysicalColumn(), null, "destinationColumns", null, 1, -1, PhysicalForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalForeignKey_Model(), this.getPhysicalModel(), this.getPhysicalModel_ForeignKeys(), "model", null, 0, 1, PhysicalForeignKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalModelEClass, PhysicalModel.class, "PhysicalModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhysicalModel_Name(), ecorePackage.getEString(), "name", null, 0, 1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalModel_DatabaseName(), ecorePackage.getEString(), "databaseName", null, 0, 1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalModel_DatabaseVersion(), ecorePackage.getEString(), "databaseVersion", null, 0, 1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalModel_Catalog(), ecorePackage.getEString(), "catalog", null, 0, 1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalModel_Schema(), ecorePackage.getEString(), "schema", null, 0, 1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalModel_Tables(), this.getPhysicalTable(), this.getPhysicalTable_Model(), "tables", null, 0, -1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalModel_PrimaryKeys(), this.getPhysicalPrimaryKey(), this.getPhysicalPrimaryKey_Model(), "primaryKeys", null, 0, -1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalModel_ForeignKeys(), this.getPhysicalForeignKey(), this.getPhysicalForeignKey_Model(), "foreignKeys", null, 0, -1, PhysicalModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalPrimaryKeyEClass, PhysicalPrimaryKey.class, "PhysicalPrimaryKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhysicalPrimaryKey_Name(), ecorePackage.getEString(), "name", null, 0, 1, PhysicalPrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalPrimaryKey_Model(), this.getPhysicalModel(), this.getPhysicalModel_PrimaryKeys(), "model", null, 1, 1, PhysicalPrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalPrimaryKey_Table(), this.getPhysicalTable(), this.getPhysicalTable_PrimaryKey(), "table", null, 0, 1, PhysicalPrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalPrimaryKey_Columns(), this.getPhysicalColumn(), null, "columns", null, 1, -1, PhysicalPrimaryKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(physicalTableEClass, PhysicalTable.class, "PhysicalTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPhysicalTable_Name(), ecorePackage.getEString(), "name", null, 0, 1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalTable_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPhysicalTable_Type(), ecorePackage.getEString(), "type", null, 0, 1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalTable_Model(), this.getPhysicalModel(), this.getPhysicalModel_Tables(), "model", null, 1, 1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalTable_Columns(), this.getPhysicalColumn(), this.getPhysicalColumn_Table(), "columns", null, 0, -1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalTable_PrimaryKey(), this.getPhysicalPrimaryKey(), this.getPhysicalPrimaryKey_Table(), "primaryKey", null, 0, 1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalTable_ForeignKeys(), this.getPhysicalForeignKey(), this.getPhysicalForeignKey_SourceTable(), "foreignKeys", null, 0, -1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPhysicalTable_ReverseForeignKeys(), this.getPhysicalForeignKey(), this.getPhysicalForeignKey_DestinationTable(), "reverseForeignKeys", null, 0, -1, PhysicalTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PhysicalModelPackageImpl