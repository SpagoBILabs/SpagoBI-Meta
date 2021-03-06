/**
 SpagoBI, the Open Source Business Intelligence suite

 Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 This Source Code Form is subject to the terms of the Mozilla Public
 License, v. 2.0. If a copy of the MPL was not distributed with this file,
 You can obtain one at http://mozilla.org/MPL/2.0/.
 
 **/
package it.eng.spagobi.meta.editor.multi.wizards;

import it.eng.spagobi.commons.resource.IResourceLocator;
import it.eng.spagobi.meta.editor.SpagoBIMetaEditorPlugin;
import it.eng.spagobi.meta.editor.multi.DSEBridge;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.datatools.connectivity.IConnectionProfile;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * @author cortella
 * 
 */
public class SelectionConnectionPage extends WizardPage {

	private static final IResourceLocator RL = SpagoBIMetaEditorPlugin.getInstance().getResourceLocator();

	private List connectionList;
	private final DSEBridge dseBridge;
	private IConnectionProfile[] profiles;
	private Combo catalogCombo;
	private Combo schemaCombo;
	private Connection jdbcConnection;
	private String selectedConnectionName;
	private PhysicalTableSelectionPage physicalTableSelectionPageRef;

	/**
	 * @param pageName
	 */
	protected SelectionConnectionPage(String pageName) {
		super(pageName);
		setTitle(RL.getString("multi.editor.wizard.selectionconnection.title"));
		setMessage(RL.getString("multi.editor.wizard.selectionconnection.message"));
		ImageDescriptor image = ImageDescriptor.createFromURL((URL) RL.getImage("it.eng.spagobi.meta.editor.business.wizards.inline.selectConnection"));
		if (image != null) {
			setImageDescriptor(image);
		}
		dseBridge = new DSEBridge();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createControl(Composite parent) {
		profiles = dseBridge.getConnectionProfiles();

		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new GridLayout(1, false));

		Group grpConnection = new Group(container, SWT.NONE);
		grpConnection.setText(RL.getString("multi.editor.wizard.selectionconnection.label"));
		grpConnection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		FillLayout fl_grpConnection = new FillLayout(SWT.HORIZONTAL);
		grpConnection.setLayout(fl_grpConnection);

		ListViewer listViewer = new ListViewer(grpConnection, SWT.BORDER | SWT.V_SCROLL);
		connectionList = listViewer.getList();
		connectionList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				// reset combos
				catalogCombo.removeAll();
				catalogCombo.setEnabled(false);
				schemaCombo.removeAll();
				schemaCombo.setEnabled(false);

				selectedConnectionName = connectionList.getSelection()[0];
				// ProgressMonitorDialog to show a progress bar for long
				// operation
				ProgressMonitorDialog dialog = new ProgressMonitorDialog(new Shell());
				dialog.setCancelable(false);

				try {
					dialog.run(true, false, new IRunnableWithProgress() {
						@Override
						public void run(IProgressMonitor monitor) {
							// Note: this is a non-UI Thread
							monitor.beginTask("Checking connection, please wait...", IProgressMonitor.UNKNOWN);
							// doing task...
							jdbcConnection = dseBridge.connect(selectedConnectionName);
							monitor.done();
						}
					});
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				if (jdbcConnection != null) {
					setErrorMessage(null);
					setPageComplete(true);
					populateCatalogCombo(jdbcConnection);
				} else {
					setPageComplete(false);
					ErrorDialog.openError(null, "Connection failed", "Connection to database failed, please check your settings",
							new org.eclipse.core.runtime.Status(IStatus.ERROR, "id", "Connection to database failed"));
					setErrorMessage("Please select a valid connection to continue");
				}
			}
		});
		listViewer.setContentProvider(new ArrayContentProvider());
		listViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((IConnectionProfile) element).getName();
			}
		});
		listViewer.setInput(profiles);
		Group grpCatalogAndSchema = new Group(container, SWT.NONE);
		grpCatalogAndSchema.setText(RL.getString("multi.editor.wizard.selectionconnection.catalogschema.label"));
		grpCatalogAndSchema.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		grpCatalogAndSchema.setLayout(new FillLayout(SWT.HORIZONTAL));

		Composite composite = new Composite(grpCatalogAndSchema, SWT.NONE);
		composite.setLayout(new GridLayout(4, false));

		Label lblCatalog = new Label(composite, SWT.NONE);
		lblCatalog.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblCatalog.setText(RL.getString("multi.editor.wizard.selectionconnection.catalog.label"));

		catalogCombo = new Combo(composite, SWT.READ_ONLY);
		catalogCombo.setEnabled(false);
		catalogCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectionIndex = catalogCombo.getSelectionIndex();
				String selectedCatalog = catalogCombo.getItem(selectionIndex);
				populateSchemaCombo(jdbcConnection, selectedCatalog);
			}
		});
		catalogCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblSchema = new Label(composite, SWT.NONE);
		lblSchema.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSchema.setText(RL.getString("multi.editor.wizard.selectionconnection.schema.label"));

		schemaCombo = new Combo(composite, SWT.READ_ONLY);
		schemaCombo.setEnabled(false);
		schemaCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

	}

	private void populateCatalogCombo(Connection connection) {
		String catalog;
		DatabaseMetaData dbMeta;
		ResultSet rs = null;

		try {
			catalog = connection.getCatalog();
			if (catalog != null)
				catalogCombo.add(catalog);
			else {
				dbMeta = connection.getMetaData();
				rs = dbMeta.getCatalogs();
				while (rs.next()) {
					String catalogName = rs.getString(1);
					if (catalogName != null) {
						catalogCombo.add(catalogName);
					}
				}
			}
			if (catalogCombo.getItemCount() > 0) {
				if (catalogCombo.getItemCount() == 1) {
					// only one catalog found, automatically search schema
					catalogCombo.select(0);
					catalogCombo.setEnabled(true);
					populateSchemaCombo(connection, null);
				} else {
					// set first value as default selection
					catalogCombo.select(0);
					catalogCombo.setEnabled(true);
				}
			} else {
				catalogCombo.setEnabled(false);
				populateSchemaCombo(connection, null);
			}
		} catch (Throwable t) {
			throw new RuntimeException("Impossible to check catalog", t);
		}
	}

	private void populateSchemaCombo(Connection connection, String catalog) {

		ResultSet rs;
		DatabaseMetaData dbMeta;

		try {
			dbMeta = connection.getMetaData();
			if (catalog == null) {
				rs = dbMeta.getSchemas();
			} else {
				rs = dbMeta.getSchemas();
				// rs = dbMeta.getSchemas(catalog,null);
			}
			while (rs.next()) {
				String schemaName = rs.getString(1);
				if (schemaName != null) {
					schemaCombo.add(rs.getString(1));
				}
			}
			if (schemaCombo.getItemCount() > 0) {
				// set first value as default selection
				schemaCombo.select(0);
				schemaCombo.setEnabled(true);
			} else {
				schemaCombo.setEnabled(false);
			}
			// release result set resources
			// rs.close();
			// close connection
			// connection.close();
		} catch (Throwable t) {
			throw new RuntimeException("Impossible to check schema", t);
		}
	}

	public String getConnectionName() {
		if (connectionList.getSelection().length > 0)
			return connectionList.getSelection()[0];
		else
			return null;
	}

	public String getCatalogName() {
		if (catalogCombo.isEnabled()) {
			int selectionIndex = catalogCombo.getSelectionIndex();
			return catalogCombo.getItem(selectionIndex);
		} else
			return null;
	}

	public String getSchemaName() {
		if (schemaCombo.isEnabled()) {
			int selectionIndex = schemaCombo.getSelectionIndex();
			return schemaCombo.getItem(selectionIndex);
		} else
			return null;
	}

	public Connection getConnection() {
		return dseBridge.connect(getConnectionName());
	}

	// must be invoked after getConnection
	public String getConnectionDriver() {
		return dseBridge.getConnectionDriver();
	}

	// must be invoked after getConnection
	public String getConnectionUrl() {
		return dseBridge.getConnectionUrl();
	}

	// must be invoked after getConnection
	public String getConnectionUsername() {
		return dseBridge.getConnectionUsername();
	}

	// must be invoked after getConnection
	public String getConnectionPassword() {
		return dseBridge.getConnectionPassword();
	}

	// must be invoked after getConnection
	public String getConnectionDatabaseName() {
		return dseBridge.getConnectionDatabaseName();
	}

	// Set next page data
	@Override
	public IWizardPage getNextPage() {
		IWizardPage nextPage = super.getNextPage();
		String schemaName = getSchemaName();
		String catalogName = getCatalogName();
		if (getConnectionName() != null && (schemaName != null || catalogName != null)) {
			if (nextPage instanceof PhysicalTableSelectionPage) {
				physicalTableSelectionPageRef.addTableItems(getConnectionName(), getCatalogName(), getSchemaName());
			}
		}
		return nextPage;
	}

	/**
	 * @param physicalTableSelectionPageRef
	 *            the physicalTableSelectionPageRef to set
	 */
	public void setPhysicalTableSelectionPageRef(PhysicalTableSelectionPage physicalTableSelectionPageRef) {
		this.physicalTableSelectionPageRef = physicalTableSelectionPageRef;
	}

	/**
	 * @return the physicalTableSelectionPageRef
	 */
	public PhysicalTableSelectionPage getPhysicalTableSelectionPageRef() {
		return physicalTableSelectionPageRef;
	}
}
