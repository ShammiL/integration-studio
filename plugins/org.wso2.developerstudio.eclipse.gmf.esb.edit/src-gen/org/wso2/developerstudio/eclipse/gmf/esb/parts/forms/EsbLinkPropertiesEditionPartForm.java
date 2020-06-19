/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.parts.forms;

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.part.impl.SectionPropertiesEditingPart;

import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;

import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;

import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.EObjectFlatComboViewer;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;

import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

import org.wso2.developerstudio.eclipse.gmf.esb.providers.EsbMessages;

// End of user code

/**
 * 
 * 
 */
public class EsbLinkPropertiesEditionPartForm extends SectionPropertiesEditingPart
        implements IFormPropertiesEditionPart, EsbLinkPropertiesEditionPart {

    protected EObjectFlatComboViewer source;
    protected EObjectFlatComboViewer target;

    /**
     * For {@link ISection} use only.
     */
    public EsbLinkPropertiesEditionPartForm() {
        super();
    }

    /**
     * Default constructor
     * 
     * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
     * 
     */
    public EsbLinkPropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
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
        CompositionSequence esbLinkStep = new BindingCompositionSequence(propertiesEditionComponent);
        CompositionStep propertiesStep = esbLinkStep.addStep(EsbViewsRepository.EsbLink.Properties.class);
        propertiesStep.addStep(EsbViewsRepository.EsbLink.Properties.source);
        propertiesStep.addStep(EsbViewsRepository.EsbLink.Properties.target);

        composer = new PartComposer(esbLinkStep) {

            @Override
            public Composite addToPart(Composite parent, Object key) {
                if (key == EsbViewsRepository.EsbLink.Properties.class) {
                    return createPropertiesGroup(widgetFactory, parent);
                }
                if (key == EsbViewsRepository.EsbLink.Properties.source) {
                    return createSourceFlatComboViewer(parent, widgetFactory);
                }
                if (key == EsbViewsRepository.EsbLink.Properties.target) {
                    return createTargetFlatComboViewer(parent, widgetFactory);
                }
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
        propertiesSection.setText(EsbMessages.EsbLinkPropertiesEditionPart_PropertiesGroupLabel);
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

    /**
     * @param parent the parent composite
     * @param widgetFactory factory to use to instanciante widget of the form
     * 
     */
    protected Composite createSourceFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
        createDescription(parent, EsbViewsRepository.EsbLink.Properties.source,
                EsbMessages.EsbLinkPropertiesEditionPart_SourceLabel);
        source = new EObjectFlatComboViewer(parent, !propertiesEditionComponent
                .isRequired(EsbViewsRepository.EsbLink.Properties.source, EsbViewsRepository.FORM_KIND));
        widgetFactory.adapt(source);
        source.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
        GridData sourceData = new GridData(GridData.FILL_HORIZONTAL);
        source.setLayoutData(sourceData);
        source.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EsbLinkPropertiesEditionPartForm.this, EsbViewsRepository.EsbLink.Properties.source,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getSource()));
            }

        });
        source.setID(EsbViewsRepository.EsbLink.Properties.source);
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.EsbLink.Properties.source, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createSourceFlatComboViewer

        // End of user code
        return parent;
    }

    /**
     * @param parent the parent composite
     * @param widgetFactory factory to use to instanciante widget of the form
     * 
     */
    protected Composite createTargetFlatComboViewer(Composite parent, FormToolkit widgetFactory) {
        createDescription(parent, EsbViewsRepository.EsbLink.Properties.target,
                EsbMessages.EsbLinkPropertiesEditionPart_TargetLabel);
        target = new EObjectFlatComboViewer(parent, !propertiesEditionComponent
                .isRequired(EsbViewsRepository.EsbLink.Properties.target, EsbViewsRepository.FORM_KIND));
        widgetFactory.adapt(target);
        target.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
        GridData targetData = new GridData(GridData.FILL_HORIZONTAL);
        target.setLayoutData(targetData);
        target.addSelectionChangedListener(new ISelectionChangedListener() {

            /**
             * {@inheritDoc}
             * 
             * @see org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)
             */
            public void selectionChanged(SelectionChangedEvent event) {
                if (propertiesEditionComponent != null)
                    propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
                            EsbLinkPropertiesEditionPartForm.this, EsbViewsRepository.EsbLink.Properties.target,
                            PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, getTarget()));
            }

        });
        target.setID(EsbViewsRepository.EsbLink.Properties.target);
        FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent
                .getHelpContent(EsbViewsRepository.EsbLink.Properties.target, EsbViewsRepository.FORM_KIND), null); // $NON-NLS-1$
        // Start of user code for createTargetFlatComboViewer

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
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#getSource()
     * 
     */
    public EObject getSource() {
        if (source.getSelection() instanceof StructuredSelection) {
            Object firstElement = ((StructuredSelection) source.getSelection()).getFirstElement();
            if (firstElement instanceof EObject)
                return (EObject) firstElement;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#initSource(EObjectFlatComboSettings)
     */
    public void initSource(EObjectFlatComboSettings settings) {
        source.setInput(settings);
        if (current != null) {
            source.setSelection(new StructuredSelection(settings.getValue()));
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EsbLink.Properties.source);
        if (eefElementEditorReadOnlyState && source.isEnabled()) {
            source.setEnabled(false);
            source.setToolTipText(EsbMessages.EsbLink_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
            source.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#setSource(EObject newValue)
     * 
     */
    public void setSource(EObject newValue) {
        if (newValue != null) {
            source.setSelection(new StructuredSelection(newValue));
        } else {
            source.setSelection(new StructuredSelection()); // $NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EsbLink.Properties.source);
        if (eefElementEditorReadOnlyState && source.isEnabled()) {
            source.setEnabled(false);
            source.setToolTipText(EsbMessages.EsbLink_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !source.isEnabled()) {
            source.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#setSourceButtonMode(ButtonsModeEnum
     *      newValue)
     */
    public void setSourceButtonMode(ButtonsModeEnum newValue) {
        source.setButtonMode(newValue);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#addFilterSource(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToSource(ViewerFilter filter) {
        source.addFilter(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#addBusinessFilterSource(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToSource(ViewerFilter filter) {
        source.addBusinessRuleFilter(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#getTarget()
     * 
     */
    public EObject getTarget() {
        if (target.getSelection() instanceof StructuredSelection) {
            Object firstElement = ((StructuredSelection) target.getSelection()).getFirstElement();
            if (firstElement instanceof EObject)
                return (EObject) firstElement;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#initTarget(EObjectFlatComboSettings)
     */
    public void initTarget(EObjectFlatComboSettings settings) {
        target.setInput(settings);
        if (current != null) {
            target.setSelection(new StructuredSelection(settings.getValue()));
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EsbLink.Properties.target);
        if (eefElementEditorReadOnlyState && target.isEnabled()) {
            target.setEnabled(false);
            target.setToolTipText(EsbMessages.EsbLink_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !target.isEnabled()) {
            target.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#setTarget(EObject newValue)
     * 
     */
    public void setTarget(EObject newValue) {
        if (newValue != null) {
            target.setSelection(new StructuredSelection(newValue));
        } else {
            target.setSelection(new StructuredSelection()); // $NON-NLS-1$
        }
        boolean eefElementEditorReadOnlyState = isReadOnly(EsbViewsRepository.EsbLink.Properties.target);
        if (eefElementEditorReadOnlyState && target.isEnabled()) {
            target.setEnabled(false);
            target.setToolTipText(EsbMessages.EsbLink_ReadOnly);
        } else if (!eefElementEditorReadOnlyState && !target.isEnabled()) {
            target.setEnabled(true);
        }

    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#setTargetButtonMode(ButtonsModeEnum
     *      newValue)
     */
    public void setTargetButtonMode(ButtonsModeEnum newValue) {
        target.setButtonMode(newValue);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#addFilterTarget(ViewerFilter
     *      filter)
     * 
     */
    public void addFilterToTarget(ViewerFilter filter) {
        target.addFilter(filter);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbLinkPropertiesEditionPart#addBusinessFilterTarget(ViewerFilter
     *      filter)
     * 
     */
    public void addBusinessFilterToTarget(ViewerFilter filter) {
        target.addBusinessRuleFilter(filter);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
     * 
     */
    public String getTitle() {
        return EsbMessages.EsbLink_Part_Title;
    }

    // Start of user code additional methods

    // End of user code

}
