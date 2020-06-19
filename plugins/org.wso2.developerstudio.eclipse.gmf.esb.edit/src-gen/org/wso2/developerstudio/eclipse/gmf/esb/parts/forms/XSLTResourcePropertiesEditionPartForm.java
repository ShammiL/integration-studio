/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.wso2.developerstudio.eclipse.gmf.esb.NamespacedProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.RegistryKeyProperty;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.XSLTResourcePropertiesEditionPart;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class XSLTResourcePropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, XSLTResourcePropertiesEditionPart {

    protected Text location;
    // Start of user code for resourceRegistryKey widgets declarations

    // End of user code

    /**
     * For {@link ISection} use only.
     */
    public XSLTResourcePropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public XSLTResourcePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
        super(editionComponent);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
     * 
     */
    public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
        ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
        Form form = scrolledForm.getForm();
        view = form.getBody();
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        view.setLayout(layout);
        createControls(widgetFactory, view);
        return scrolledForm;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
     *      createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
     * 
     */
    public void createControls(final FormToolkit widgetFactory, Composite view) {
        CompositionSequence xSLTResourceStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = xSLTResourceStep.addStep(EsbViewsRepository.XSLTResource.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.XSLTResource.Properties.location);
        propertiesStep.addStep(EsbViewsRepository.XSLTResource.Properties.resourceRegistryKey);

        composer = new PartComposer(xSLTResourceStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.XSLTResource.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.XSLTResource.Properties.location) {
                    return createLocationText(widgetFactory, parent);
                }
                // Start of user code for resourceRegistryKey addToPart creation

                // End of user code
                return parent;
            }
        };
        composer.compose(view);
    }

    /**
     * 
     */
    protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
        Section propertiesSection = widgetFactory.createSection(parent,
                Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
        propertiesSection.setText(EsbMessages.XSLTResourcePropertiesEditionPart_PropertiesGroupLabel);
        GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
        propertiesSectionData.horizontalSpan = 3;
        propertiesSection.setLayoutData(propertiesSectionData);
        Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
        GridLayout propertiesGroupLayout = new GridLayout();
        propertiesGroupLayout.numColumns = 3;
        propertiesGroup.setLayout(propertiesGroupLayout);
        propertiesSection.setClient(propertiesGroup);
        return propertiesGroup;
    }

    protected Composite createLocationText(FormToolkit widgetFactory, Composite parent) {
        createDescription(parent, EsbViewsRepository.XSLTResource.Properties.location,
                EsbMessages.XSLTResourcePropertiesEditionPart_LocationLabel);
        location = widgetFactory.createText(parent, ""); //$NON-NLS-1$
        location.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
        widgetFactory.paintBordersFor(parent);
        GridData locationData = new GridData(GridData.FILL_HORIZONTAL);
        location.setLayoutData(locationData);
        location.addFocusListener(new FocusAdapter() {
            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void focusLost(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(
                            new PropertiesEditionEvent(XSLTResourcePropertiesEditionPartForm.this,
                                    EsbViewsRepository.XSLTResource.Properties.location, PropertiesEditionEvent.COMMIT,
                                    PropertiesEditionEvent.SET, null, location.getText()));
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTResourcePropertiesEditionPartForm.this,
                            EsbViewsRepository.XSLTResource.Properties.location, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_LOST, null, location.getText()));
                }
            }

            /**
             * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
             */
            @Override
            public void focusGained(FocusEvent e) {
                if (propertiesEditionComponent != null) {
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            XSLTResourcePropertiesEditionPartForm.this, null, PropertiesEditionEvent.FOCUS_CHANGED,
                            PropertiesEditionEvent.FOCUS_GAINED, null, null));
                }
            }
        });
        location.addKeyListener(new KeyAdapter() {
            /**
             * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
             * 
             */
            @Override
            @SuppressWarnings("synthetic-access")
            public void keyPressed(KeyEvent e) {
                if (e.character == SWT.CR) {
                    if (propertiesEditionComponent != null)
                        propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                                XSLTResourcePropertiesEditionPartForm.this,
                                EsbViewsRepository.XSLTResource.Properties.location, PropertiesEditionEvent.COMMIT,
                                PropertiesEditionEvent.SET, null, location.getText()));
                }
            }
        });
        EditingUtils.setID(location, EsbViewsRepository.XSLTResource.Properties.location);
        EditingUtils.setEEFtype(location, "eef::Text"); //$NON-NLS-1$
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(
                EsbViewsRepository.XSLTResource.Properties.location, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createLocationText

        // End of user code
        return parent;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public void firePropertiesChanged(IPropertiesEditionEvent event) {
        // Start of user code for tab synchronization

        // End of user code
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XSLTResourcePropertiesEditionPart#getLocation()
     * 
     */
    public String getLocation() {
        return location.getText();
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.XSLTResourcePropertiesEditionPart#setLocation(String
     *      newValue)
     * 
     */
    public void setLocation(String newValue) {
        if (newValue != null) {
            location.setText(newValue);
        } else {
            location.setText(""); //$NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.XSLTResource.Properties.location);
        if (eefElementEditorReadOnlyState && location.isEnabled()) {
            location.setEnabled(false);
            location.setToolTipText(EsbMessages.XSLTResource_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !location.isEnabled()) {
            location.setEnabled(true);
        }

    }

    // Start of user code for resourceRegistryKey specific getters and setters implementation
    @Override
    public RegistryKeyProperty getResourceRegistryKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setResourceRegistryKey(RegistryKeyProperty regKey) {
        // TODO Auto-generated method stub

    }

    // End of user code

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return EsbMessages.XSLTResource_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
