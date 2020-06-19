/**
 * Generated with Acceleo
 */
package org.wso2.developerstudio.eclipse.gmf.esb.components;

// Start of user code for imports
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;

import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;

import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;

import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;

import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;

import org.wso2.developerstudio.eclipse.gmf.esb.AutoscaleInMediator;
import org.wso2.developerstudio.eclipse.gmf.esb.EsbPackage;

import org.wso2.developerstudio.eclipse.gmf.esb.parts.AutoscaleInMediatorPropertiesEditionPart;
import org.wso2.developerstudio.eclipse.gmf.esb.parts.EsbViewsRepository;

// End of user code

/**
 * 
 * 
 */
public class AutoscaleInMediatorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

    public static String BASE_PART = "Base"; //$NON-NLS-1$

    /**
     * Default constructor
     * 
     */
    public AutoscaleInMediatorPropertiesEditionComponent(PropertiesEditingContext editingContext,
            EObject autoscaleInMediator, String editing_mode) {
        super(editingContext, autoscaleInMediator, editing_mode);
        parts = new String[] { BASE_PART };
        repositoryKey = EsbViewsRepository.class;
        partKey = EsbViewsRepository.AutoscaleInMediator.class;
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int,
     *      org.eclipse.emf.ecore.EObject,
     *      org.eclipse.emf.ecore.resource.ResourceSet)
     * 
     */
    public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
        setInitializing(true);
        if (editingPart != null && key == partKey) {
            editingPart.setContext(elt, allResource);

            final AutoscaleInMediator autoscaleInMediator = (AutoscaleInMediator) elt;
            final AutoscaleInMediatorPropertiesEditionPart basePart = (AutoscaleInMediatorPropertiesEditionPart) editingPart;
            // init values
            if (isAccessible(EsbViewsRepository.AutoscaleInMediator.Properties.description))
                basePart.setDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING,
                        autoscaleInMediator.getDescription()));

            if (isAccessible(EsbViewsRepository.AutoscaleInMediator.Properties.commentsList))
                basePart.setCommentsList(autoscaleInMediator.getCommentsList());

            if (isAccessible(EsbViewsRepository.AutoscaleInMediator.Properties.reverse)) {
                basePart.setReverse(autoscaleInMediator.isReverse());
            }
            // init filters

            // init values for referenced views

            // init filters for referenced views

        }
        setInitializing(false);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
     */
    public EStructuralFeature associatedFeature(Object editorKey) {
        if (editorKey == EsbViewsRepository.AutoscaleInMediator.Properties.description) {
            return EsbPackage.eINSTANCE.getEsbElement_Description();
        }
        if (editorKey == EsbViewsRepository.AutoscaleInMediator.Properties.commentsList) {
            return EsbPackage.eINSTANCE.getEsbElement_CommentsList();
        }
        if (editorKey == EsbViewsRepository.AutoscaleInMediator.Properties.reverse) {
            return EsbPackage.eINSTANCE.getMediator_Reverse();
        }
        return super.associatedFeature(editorKey);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public void updateSemanticModel(final IPropertiesEditionEvent event) {
        AutoscaleInMediator autoscaleInMediator = (AutoscaleInMediator) semanticObject;
        if (EsbViewsRepository.AutoscaleInMediator.Properties.description == event.getAffectedEditor()) {
            autoscaleInMediator.setDescription((java.lang.String) EEFConverterUtil
                    .createFromString(EcorePackage.Literals.ESTRING, (String) event.getNewValue()));
        }
        if (EsbViewsRepository.AutoscaleInMediator.Properties.commentsList == event.getAffectedEditor()) {
            if (event.getKind() == PropertiesEditionEvent.SET) {
                autoscaleInMediator.getCommentsList().clear();
                autoscaleInMediator.getCommentsList().addAll(((EList) event.getNewValue()));
            }
        }
        if (EsbViewsRepository.AutoscaleInMediator.Properties.reverse == event.getAffectedEditor()) {
            autoscaleInMediator.setReverse((Boolean) event.getNewValue());
        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
     */
    public void updatePart(Notification msg) {
        super.updatePart(msg);
        if (editingPart.isVisible()) {
            AutoscaleInMediatorPropertiesEditionPart basePart = (AutoscaleInMediatorPropertiesEditionPart) editingPart;
            if (EsbPackage.eINSTANCE.getEsbElement_Description().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.AutoscaleInMediator.Properties.description)) {
                if (msg.getNewValue() != null) {
                    basePart.setDescription(
                            EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
                } else {
                    basePart.setDescription("");
                }
            }
            if (EsbPackage.eINSTANCE.getEsbElement_CommentsList().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.AutoscaleInMediator.Properties.commentsList)) {
                if (msg.getNewValue() instanceof EList<?>) {
                    basePart.setCommentsList((EList<?>) msg.getNewValue());
                } else if (msg.getNewValue() == null) {
                    basePart.setCommentsList(new BasicEList<Object>());
                } else {
                    BasicEList<Object> newValueAsList = new BasicEList<Object>();
                    newValueAsList.add(msg.getNewValue());
                    basePart.setCommentsList(newValueAsList);
                }
            }

            if (EsbPackage.eINSTANCE.getMediator_Reverse().equals(msg.getFeature())
                    && msg.getNotifier().equals(semanticObject) && basePart != null
                    && isAccessible(EsbViewsRepository.AutoscaleInMediator.Properties.reverse))
                basePart.setReverse((Boolean) msg.getNewValue());

        }
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
     */
    @Override
    protected NotificationFilter[] getNotificationFilters() {
        NotificationFilter filter = new EStructuralFeatureNotificationFilter(
                EsbPackage.eINSTANCE.getEsbElement_Description(), EsbPackage.eINSTANCE.getEsbElement_CommentsList(),
                EsbPackage.eINSTANCE.getMediator_Reverse());
        return new NotificationFilter[] { filter, };
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
     * 
     */
    public Diagnostic validateValue(IPropertiesEditionEvent event) {
        Diagnostic ret = Diagnostic.OK_INSTANCE;
        if (event.getNewValue() != null) {
            try {
                if (EsbViewsRepository.AutoscaleInMediator.Properties.description == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(),
                                (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getEsbElement_Description().getEAttributeType(), newValue);
                }
                if (EsbViewsRepository.AutoscaleInMediator.Properties.commentsList == event.getAffectedEditor()) {
                    BasicDiagnostic chain = new BasicDiagnostic();
                    for (Iterator iterator = ((List) event.getNewValue()).iterator(); iterator.hasNext();) {
                        chain.add(Diagnostician.INSTANCE.validate(
                                EsbPackage.eINSTANCE.getEsbElement_CommentsList().getEAttributeType(),
                                iterator.next()));
                    }
                    ret = chain;
                }
                if (EsbViewsRepository.AutoscaleInMediator.Properties.reverse == event.getAffectedEditor()) {
                    Object newValue = event.getNewValue();
                    if (newValue instanceof String) {
                        newValue = EEFConverterUtil.createFromString(
                                EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), (String) newValue);
                    }
                    ret = Diagnostician.INSTANCE
                            .validate(EsbPackage.eINSTANCE.getMediator_Reverse().getEAttributeType(), newValue);
                }
            } catch (IllegalArgumentException iae) {
                ret = BasicDiagnostic.toDiagnostic(iae);
            } catch (WrappedException we) {
                ret = BasicDiagnostic.toDiagnostic(we);
            }
        }
        return ret;
    }

}
