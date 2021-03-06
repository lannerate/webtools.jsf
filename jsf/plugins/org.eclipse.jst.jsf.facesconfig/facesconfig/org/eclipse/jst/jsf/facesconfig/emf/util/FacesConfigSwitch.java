/***************************************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM Corporation - initial API and implementation
 *   Oracle Corporation - revision
 **************************************************************************************************/
package org.eclipse.jst.jsf.facesconfig.emf.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jst.jsf.facesconfig.emf.*;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.jst.jsf.facesconfig.emf.FacesConfigPackage
 * @generated
 */
public class FacesConfigSwitch {
    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 IBM Corporation and others"; //$NON-NLS-1$

    /**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static FacesConfigPackage modelPackage;

    /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FacesConfigSwitch() {
		if (modelPackage == null) {
			modelPackage = FacesConfigPackage.eINSTANCE;
		}
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
     * @param theEObject 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
     * @param theEClass 
     * @param theEObject 
     * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		List eSuperTypes = theEClass.getESuperTypes();
		return
			eSuperTypes.isEmpty() ?
				defaultCase(theEObject) :
				doSwitch((EClass)eSuperTypes.get(0), theEObject);
	}

    /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
     * @param classifierID 
     * @param theEObject 
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case FacesConfigPackage.ABSOLUTE_ORDERING_TYPE: {
				AbsoluteOrderingType absoluteOrderingType = (AbsoluteOrderingType)theEObject;
				Object result = caseAbsoluteOrderingType(absoluteOrderingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ACTION_LISTENER_TYPE: {
				ActionListenerType actionListenerType = (ActionListenerType)theEObject;
				Object result = caseActionListenerType(actionListenerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.APPLICATION_FACTORY_TYPE: {
				ApplicationFactoryType applicationFactoryType = (ApplicationFactoryType)theEObject;
				Object result = caseApplicationFactoryType(applicationFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.APPLICATION_TYPE: {
				ApplicationType applicationType = (ApplicationType)theEObject;
				Object result = caseApplicationType(applicationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.APPLICATION_EXTENSION_TYPE: {
				ApplicationExtensionType applicationExtensionType = (ApplicationExtensionType)theEObject;
				Object result = caseApplicationExtensionType(applicationExtensionType);
				if (result == null) result = caseExtensionType(applicationExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ATTRIBUTE_CLASS_TYPE: {
				AttributeClassType attributeClassType = (AttributeClassType)theEObject;
				Object result = caseAttributeClassType(attributeClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ATTRIBUTE_EXTENSION_TYPE: {
				AttributeExtensionType attributeExtensionType = (AttributeExtensionType)theEObject;
				Object result = caseAttributeExtensionType(attributeExtensionType);
				if (result == null) result = caseExtensionType(attributeExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ATTRIBUTE_NAME_TYPE: {
				AttributeNameType attributeNameType = (AttributeNameType)theEObject;
				Object result = caseAttributeNameType(attributeNameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ATTRIBUTE_TYPE: {
				AttributeType attributeType = (AttributeType)theEObject;
				Object result = caseAttributeType(attributeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.BEHAVIOR_CLASS_TYPE: {
				BehaviorClassType behaviorClassType = (BehaviorClassType)theEObject;
				Object result = caseBehaviorClassType(behaviorClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.BEHAVIOR_ID_TYPE: {
				BehaviorIdType behaviorIdType = (BehaviorIdType)theEObject;
				Object result = caseBehaviorIdType(behaviorIdType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.BEHAVIOR_TYPE: {
				BehaviorType behaviorType = (BehaviorType)theEObject;
				Object result = caseBehaviorType(behaviorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.BEHAVIOR_EXTENSION_TYPE: {
				BehaviorExtensionType behaviorExtensionType = (BehaviorExtensionType)theEObject;
				Object result = caseBehaviorExtensionType(behaviorExtensionType);
				if (result == null) result = caseExtensionType(behaviorExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CLIENT_BEHAVIOR_RENDERER_CLASS_TYPE: {
				ClientBehaviorRendererClassType clientBehaviorRendererClassType = (ClientBehaviorRendererClassType)theEObject;
				Object result = caseClientBehaviorRendererClassType(clientBehaviorRendererClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CLIENT_BEHAVIOR_RENDERER_TYPE: {
				ClientBehaviorRendererType clientBehaviorRendererType = (ClientBehaviorRendererType)theEObject;
				Object result = caseClientBehaviorRendererType(clientBehaviorRendererType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CLIENT_BEHAVIOR_RENDERER_TYPE_TYPE: {
				ClientBehaviorRendererTypeType clientBehaviorRendererTypeType = (ClientBehaviorRendererTypeType)theEObject;
				Object result = caseClientBehaviorRendererTypeType(clientBehaviorRendererTypeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.COMPONENT_CLASS_TYPE: {
				ComponentClassType componentClassType = (ComponentClassType)theEObject;
				Object result = caseComponentClassType(componentClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.COMPONENT_EXTENSION_TYPE: {
				ComponentExtensionType componentExtensionType = (ComponentExtensionType)theEObject;
				Object result = caseComponentExtensionType(componentExtensionType);
				if (result == null) result = caseExtensionType(componentExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.COMPONENT_FAMILY_TYPE: {
				ComponentFamilyType componentFamilyType = (ComponentFamilyType)theEObject;
				Object result = caseComponentFamilyType(componentFamilyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.COMPONENT_TYPE: {
				ComponentType componentType = (ComponentType)theEObject;
				Object result = caseComponentType(componentType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.COMPONENT_TYPE_TYPE: {
				ComponentTypeType componentTypeType = (ComponentTypeType)theEObject;
				Object result = caseComponentTypeType(componentTypeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CONVERTER_CLASS_TYPE: {
				ConverterClassType converterClassType = (ConverterClassType)theEObject;
				Object result = caseConverterClassType(converterClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CONVERTER_FOR_CLASS_TYPE: {
				ConverterForClassType converterForClassType = (ConverterForClassType)theEObject;
				Object result = caseConverterForClassType(converterForClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CONVERTER_ID_TYPE: {
				ConverterIdType converterIdType = (ConverterIdType)theEObject;
				Object result = caseConverterIdType(converterIdType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CONVERTER_TYPE: {
				ConverterType converterType = (ConverterType)theEObject;
				Object result = caseConverterType(converterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.CONVERTER_EXTENSION_TYPE: {
				ConverterExtensionType converterExtensionType = (ConverterExtensionType)theEObject;
				Object result = caseConverterExtensionType(converterExtensionType);
				if (result == null) result = caseExtensionType(converterExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DEFAULT_LOCALE_TYPE: {
				DefaultLocaleType defaultLocaleType = (DefaultLocaleType)theEObject;
				Object result = caseDefaultLocaleType(defaultLocaleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DEFAULT_RENDER_KIT_ID_TYPE: {
				DefaultRenderKitIdType defaultRenderKitIdType = (DefaultRenderKitIdType)theEObject;
				Object result = caseDefaultRenderKitIdType(defaultRenderKitIdType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DEFAULT_VALIDATORS_TYPE: {
				DefaultValidatorsType defaultValidatorsType = (DefaultValidatorsType)theEObject;
				Object result = caseDefaultValidatorsType(defaultValidatorsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DEFAULT_VALUE_TYPE: {
				DefaultValueType defaultValueType = (DefaultValueType)theEObject;
				Object result = caseDefaultValueType(defaultValueType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DESCRIPTION_TYPE: {
				DescriptionType descriptionType = (DescriptionType)theEObject;
				Object result = caseDescriptionType(descriptionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DISPLAY_NAME_TYPE: {
				DisplayNameType displayNameType = (DisplayNameType)theEObject;
				Object result = caseDisplayNameType(displayNameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				Object result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DYNAMIC_ATTRIBUTE: {
				DynamicAttribute dynamicAttribute = (DynamicAttribute)theEObject;
				Object result = caseDynamicAttribute(dynamicAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.DYNAMIC_ELEMENT: {
				DynamicElement dynamicElement = (DynamicElement)theEObject;
				Object result = caseDynamicElement(dynamicElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.EL_RESOLVER_TYPE: {
				ELResolverType elResolverType = (ELResolverType)theEObject;
				Object result = caseELResolverType(elResolverType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.EXCEPTION_HANDLER_FACTORY_TYPE: {
				ExceptionHandlerFactoryType exceptionHandlerFactoryType = (ExceptionHandlerFactoryType)theEObject;
				Object result = caseExceptionHandlerFactoryType(exceptionHandlerFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.EXTENSION_TYPE: {
				ExtensionType extensionType = (ExtensionType)theEObject;
				Object result = caseExtensionType(extensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.EXTERNAL_CONTEXT_FACTORY_TYPE: {
				ExternalContextFactoryType externalContextFactoryType = (ExternalContextFactoryType)theEObject;
				Object result = caseExternalContextFactoryType(externalContextFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACES_CONFIG_TYPE: {
				FacesConfigType facesConfigType = (FacesConfigType)theEObject;
				Object result = caseFacesConfigType(facesConfigType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACES_CONFIG_EXTENSION_TYPE: {
				FacesConfigExtensionType facesConfigExtensionType = (FacesConfigExtensionType)theEObject;
				Object result = caseFacesConfigExtensionType(facesConfigExtensionType);
				if (result == null) result = caseExtensionType(facesConfigExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACES_CONTEXT_FACTORY_TYPE: {
				FacesContextFactoryType facesContextFactoryType = (FacesContextFactoryType)theEObject;
				Object result = caseFacesContextFactoryType(facesContextFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACET_EXTENSION_TYPE: {
				FacetExtensionType facetExtensionType = (FacetExtensionType)theEObject;
				Object result = caseFacetExtensionType(facetExtensionType);
				if (result == null) result = caseExtensionType(facetExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACET_NAME_TYPE: {
				FacetNameType facetNameType = (FacetNameType)theEObject;
				Object result = caseFacetNameType(facetNameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACET_TYPE: {
				FacetType facetType = (FacetType)theEObject;
				Object result = caseFacetType(facetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACTORY_TYPE: {
				FactoryType factoryType = (FactoryType)theEObject;
				Object result = caseFactoryType(factoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FACTORY_EXTENSION_TYPE: {
				FactoryExtensionType factoryExtensionType = (FactoryExtensionType)theEObject;
				Object result = caseFactoryExtensionType(factoryExtensionType);
				if (result == null) result = caseExtensionType(factoryExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FROM_ACTION_TYPE: {
				FromActionType fromActionType = (FromActionType)theEObject;
				Object result = caseFromActionType(fromActionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FROM_OUTCOME_TYPE: {
				FromOutcomeType fromOutcomeType = (FromOutcomeType)theEObject;
				Object result = caseFromOutcomeType(fromOutcomeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.FROM_VIEW_ID_TYPE: {
				FromViewIdType fromViewIdType = (FromViewIdType)theEObject;
				Object result = caseFromViewIdType(fromViewIdType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ICON_TYPE: {
				IconType iconType = (IconType)theEObject;
				Object result = caseIconType(iconType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.IF_TYPE: {
				IfType ifType = (IfType)theEObject;
				Object result = caseIfType(ifType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.KEY_CLASS_TYPE: {
				KeyClassType keyClassType = (KeyClassType)theEObject;
				Object result = caseKeyClassType(keyClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.KEY_TYPE: {
				KeyType keyType = (KeyType)theEObject;
				Object result = caseKeyType(keyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.LARGE_ICON_TYPE: {
				LargeIconType largeIconType = (LargeIconType)theEObject;
				Object result = caseLargeIconType(largeIconType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.LIFECYCLE_FACTORY_TYPE: {
				LifecycleFactoryType lifecycleFactoryType = (LifecycleFactoryType)theEObject;
				Object result = caseLifecycleFactoryType(lifecycleFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.LIFECYCLE_TYPE: {
				LifecycleType lifecycleType = (LifecycleType)theEObject;
				Object result = caseLifecycleType(lifecycleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.LIFECYCLE_EXTENSION_TYPE: {
				LifecycleExtensionType lifecycleExtensionType = (LifecycleExtensionType)theEObject;
				Object result = caseLifecycleExtensionType(lifecycleExtensionType);
				if (result == null) result = caseExtensionType(lifecycleExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.LIST_ENTRIES_TYPE: {
				ListEntriesType listEntriesType = (ListEntriesType)theEObject;
				Object result = caseListEntriesType(listEntriesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.LOCALE_CONFIG_TYPE: {
				LocaleConfigType localeConfigType = (LocaleConfigType)theEObject;
				Object result = caseLocaleConfigType(localeConfigType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MANAGED_BEAN_CLASS_TYPE: {
				ManagedBeanClassType managedBeanClassType = (ManagedBeanClassType)theEObject;
				Object result = caseManagedBeanClassType(managedBeanClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MANAGED_BEAN_NAME_TYPE: {
				ManagedBeanNameType managedBeanNameType = (ManagedBeanNameType)theEObject;
				Object result = caseManagedBeanNameType(managedBeanNameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MANAGED_BEAN_SCOPE_TYPE: {
				ManagedBeanScopeType managedBeanScopeType = (ManagedBeanScopeType)theEObject;
				Object result = caseManagedBeanScopeType(managedBeanScopeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MANAGED_BEAN_TYPE: {
				ManagedBeanType managedBeanType = (ManagedBeanType)theEObject;
				Object result = caseManagedBeanType(managedBeanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MANAGED_BEAN_EXTENSION_TYPE: {
				ManagedBeanExtensionType managedBeanExtensionType = (ManagedBeanExtensionType)theEObject;
				Object result = caseManagedBeanExtensionType(managedBeanExtensionType);
				if (result == null) result = caseExtensionType(managedBeanExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MANAGED_PROPERTY_TYPE: {
				ManagedPropertyType managedPropertyType = (ManagedPropertyType)theEObject;
				Object result = caseManagedPropertyType(managedPropertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MAP_ENTRIES_TYPE: {
				MapEntriesType mapEntriesType = (MapEntriesType)theEObject;
				Object result = caseMapEntriesType(mapEntriesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MAP_ENTRY_TYPE: {
				MapEntryType mapEntryType = (MapEntryType)theEObject;
				Object result = caseMapEntryType(mapEntryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.MESSAGE_BUNDLE_TYPE: {
				MessageBundleType messageBundleType = (MessageBundleType)theEObject;
				Object result = caseMessageBundleType(messageBundleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.NAME_TYPE: {
				NameType nameType = (NameType)theEObject;
				Object result = caseNameType(nameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.NAVIGATION_CASE_TYPE: {
				NavigationCaseType navigationCaseType = (NavigationCaseType)theEObject;
				Object result = caseNavigationCaseType(navigationCaseType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.NAVIGATION_HANDLER_TYPE: {
				NavigationHandlerType navigationHandlerType = (NavigationHandlerType)theEObject;
				Object result = caseNavigationHandlerType(navigationHandlerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.NAVIGATION_RULE_TYPE: {
				NavigationRuleType navigationRuleType = (NavigationRuleType)theEObject;
				Object result = caseNavigationRuleType(navigationRuleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.NAVIGATION_RULE_EXTENSION_TYPE: {
				NavigationRuleExtensionType navigationRuleExtensionType = (NavigationRuleExtensionType)theEObject;
				Object result = caseNavigationRuleExtensionType(navigationRuleExtensionType);
				if (result == null) result = caseExtensionType(navigationRuleExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.NULL_VALUE_TYPE: {
				NullValueType nullValueType = (NullValueType)theEObject;
				Object result = caseNullValueType(nullValueType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ORDERING_TYPE: {
				OrderingType orderingType = (OrderingType)theEObject;
				Object result = caseOrderingType(orderingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ORDERING_ORDERING_TYPE: {
				OrderingOrderingType orderingOrderingType = (OrderingOrderingType)theEObject;
				Object result = caseOrderingOrderingType(orderingOrderingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.ORDERING_OTHERS_TYPE: {
				OrderingOthersType orderingOthersType = (OrderingOthersType)theEObject;
				Object result = caseOrderingOthersType(orderingOthersType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.PARTIAL_VIEW_CONTEXT_FACTORY_TYPE: {
				PartialViewContextFactoryType partialViewContextFactoryType = (PartialViewContextFactoryType)theEObject;
				Object result = casePartialViewContextFactoryType(partialViewContextFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.PHASE_LISTENER_TYPE: {
				PhaseListenerType phaseListenerType = (PhaseListenerType)theEObject;
				Object result = casePhaseListenerType(phaseListenerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.PROPERTY_CLASS_TYPE: {
				PropertyClassType propertyClassType = (PropertyClassType)theEObject;
				Object result = casePropertyClassType(propertyClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.PROPERTY_EXTENSION_TYPE: {
				PropertyExtensionType propertyExtensionType = (PropertyExtensionType)theEObject;
				Object result = casePropertyExtensionType(propertyExtensionType);
				if (result == null) result = caseExtensionType(propertyExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.PROPERTY_NAME_TYPE: {
				PropertyNameType propertyNameType = (PropertyNameType)theEObject;
				Object result = casePropertyNameType(propertyNameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.PROPERTY_RESOLVER_TYPE: {
				PropertyResolverType propertyResolverType = (PropertyResolverType)theEObject;
				Object result = casePropertyResolverType(propertyResolverType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.PROPERTY_TYPE: {
				PropertyType propertyType = (PropertyType)theEObject;
				Object result = casePropertyType(propertyType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.REDIRECT_TYPE: {
				RedirectType redirectType = (RedirectType)theEObject;
				Object result = caseRedirectType(redirectType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.REDIRECT_VIEW_PARAM_TYPE: {
				RedirectViewParamType redirectViewParamType = (RedirectViewParamType)theEObject;
				Object result = caseRedirectViewParamType(redirectViewParamType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.REFERENCED_BEAN_CLASS_TYPE: {
				ReferencedBeanClassType referencedBeanClassType = (ReferencedBeanClassType)theEObject;
				Object result = caseReferencedBeanClassType(referencedBeanClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.REFERENCED_BEAN_NAME_TYPE: {
				ReferencedBeanNameType referencedBeanNameType = (ReferencedBeanNameType)theEObject;
				Object result = caseReferencedBeanNameType(referencedBeanNameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.REFERENCED_BEAN_TYPE: {
				ReferencedBeanType referencedBeanType = (ReferencedBeanType)theEObject;
				Object result = caseReferencedBeanType(referencedBeanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDERER_CLASS_TYPE: {
				RendererClassType rendererClassType = (RendererClassType)theEObject;
				Object result = caseRendererClassType(rendererClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDERER_EXTENSION_TYPE: {
				RendererExtensionType rendererExtensionType = (RendererExtensionType)theEObject;
				Object result = caseRendererExtensionType(rendererExtensionType);
				if (result == null) result = caseExtensionType(rendererExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDERER_TYPE: {
				RendererType rendererType = (RendererType)theEObject;
				Object result = caseRendererType(rendererType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDERER_TYPE_TYPE: {
				RendererTypeType rendererTypeType = (RendererTypeType)theEObject;
				Object result = caseRendererTypeType(rendererTypeType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDER_KIT_CLASS_TYPE: {
				RenderKitClassType renderKitClassType = (RenderKitClassType)theEObject;
				Object result = caseRenderKitClassType(renderKitClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDER_KIT_FACTORY_TYPE: {
				RenderKitFactoryType renderKitFactoryType = (RenderKitFactoryType)theEObject;
				Object result = caseRenderKitFactoryType(renderKitFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDER_KIT_ID_TYPE: {
				RenderKitIdType renderKitIdType = (RenderKitIdType)theEObject;
				Object result = caseRenderKitIdType(renderKitIdType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDER_KIT_TYPE: {
				RenderKitType renderKitType = (RenderKitType)theEObject;
				Object result = caseRenderKitType(renderKitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RENDER_KIT_EXTENSION_TYPE: {
				RenderKitExtensionType renderKitExtensionType = (RenderKitExtensionType)theEObject;
				Object result = caseRenderKitExtensionType(renderKitExtensionType);
				if (result == null) result = caseExtensionType(renderKitExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RESOURCE_HANDLER_TYPE: {
				ResourceHandlerType resourceHandlerType = (ResourceHandlerType)theEObject;
				Object result = caseResourceHandlerType(resourceHandlerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.SMALL_ICON_TYPE: {
				SmallIconType smallIconType = (SmallIconType)theEObject;
				Object result = caseSmallIconType(smallIconType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.SOURCE_CLASS_TYPE: {
				SourceClassType sourceClassType = (SourceClassType)theEObject;
				Object result = caseSourceClassType(sourceClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.STATE_MANAGER_TYPE: {
				StateManagerType stateManagerType = (StateManagerType)theEObject;
				Object result = caseStateManagerType(stateManagerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.SUGGESTED_VALUE_TYPE: {
				SuggestedValueType suggestedValueType = (SuggestedValueType)theEObject;
				Object result = caseSuggestedValueType(suggestedValueType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.SUPPORTED_LOCALE_TYPE: {
				SupportedLocaleType supportedLocaleType = (SupportedLocaleType)theEObject;
				Object result = caseSupportedLocaleType(supportedLocaleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.SYSTEM_EVENT_CLASS_TYPE: {
				SystemEventClassType systemEventClassType = (SystemEventClassType)theEObject;
				Object result = caseSystemEventClassType(systemEventClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.SYSTEM_EVENT_LISTENER_CLASS_TYPE: {
				SystemEventListenerClassType systemEventListenerClassType = (SystemEventListenerClassType)theEObject;
				Object result = caseSystemEventListenerClassType(systemEventListenerClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.SYSTEM_EVENT_LISTENER_TYPE: {
				SystemEventListenerType systemEventListenerType = (SystemEventListenerType)theEObject;
				Object result = caseSystemEventListenerType(systemEventListenerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.TAG_HANDLER_DELEGATE_FACTORY_TYPE: {
				TagHandlerDelegateFactoryType tagHandlerDelegateFactoryType = (TagHandlerDelegateFactoryType)theEObject;
				Object result = caseTagHandlerDelegateFactoryType(tagHandlerDelegateFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.TO_VIEW_ID_TYPE: {
				ToViewIdType toViewIdType = (ToViewIdType)theEObject;
				Object result = caseToViewIdType(toViewIdType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VALIDATOR_CLASS_TYPE: {
				ValidatorClassType validatorClassType = (ValidatorClassType)theEObject;
				Object result = caseValidatorClassType(validatorClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VALIDATOR_ID_TYPE: {
				ValidatorIdType validatorIdType = (ValidatorIdType)theEObject;
				Object result = caseValidatorIdType(validatorIdType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VALIDATOR_TYPE: {
				ValidatorType validatorType = (ValidatorType)theEObject;
				Object result = caseValidatorType(validatorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VALIDATOR_EXTENSION_TYPE: {
				ValidatorExtensionType validatorExtensionType = (ValidatorExtensionType)theEObject;
				Object result = caseValidatorExtensionType(validatorExtensionType);
				if (result == null) result = caseExtensionType(validatorExtensionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VALUE_CLASS_TYPE: {
				ValueClassType valueClassType = (ValueClassType)theEObject;
				Object result = caseValueClassType(valueClassType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VALUE_TYPE: {
				ValueType valueType = (ValueType)theEObject;
				Object result = caseValueType(valueType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VARIABLE_RESOLVER_TYPE: {
				VariableResolverType variableResolverType = (VariableResolverType)theEObject;
				Object result = caseVariableResolverType(variableResolverType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VIEW_HANDLER_TYPE: {
				ViewHandlerType viewHandlerType = (ViewHandlerType)theEObject;
				Object result = caseViewHandlerType(viewHandlerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.RESOURCE_BUNDLE_TYPE: {
				ResourceBundleType resourceBundleType = (ResourceBundleType)theEObject;
				Object result = caseResourceBundleType(resourceBundleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.BASE_NAME_TYPE: {
				BaseNameType baseNameType = (BaseNameType)theEObject;
				Object result = caseBaseNameType(baseNameType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VAR_TYPE: {
				VarType varType = (VarType)theEObject;
				Object result = caseVarType(varType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VIEW_DECLARATION_LANGUAGE_FACTORY_TYPE: {
				ViewDeclarationLanguageFactoryType viewDeclarationLanguageFactoryType = (ViewDeclarationLanguageFactoryType)theEObject;
				Object result = caseViewDeclarationLanguageFactoryType(viewDeclarationLanguageFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case FacesConfigPackage.VISIT_CONTEXT_FACTORY_TYPE: {
				VisitContextFactoryType visitContextFactoryType = (VisitContextFactoryType)theEObject;
				Object result = caseVisitContextFactoryType(visitContextFactoryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Absolute Ordering Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Absolute Ordering Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAbsoluteOrderingType(AbsoluteOrderingType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Listener Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Listener Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseActionListenerType(ActionListenerType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Application Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseApplicationFactoryType(ApplicationFactoryType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Application Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseApplicationType(ApplicationType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeClassType(AttributeClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Extension Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeExtensionType(AttributeExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Name Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeNameType(AttributeNameType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAttributeType(AttributeType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBehaviorClassType(BehaviorClassType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Id Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Id Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBehaviorIdType(BehaviorIdType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBehaviorType(BehaviorType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Extension Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBehaviorExtensionType(BehaviorExtensionType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Client Behavior Renderer Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Client Behavior Renderer Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClientBehaviorRendererClassType(ClientBehaviorRendererClassType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Client Behavior Renderer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Client Behavior Renderer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClientBehaviorRendererType(ClientBehaviorRendererType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Client Behavior Renderer Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Client Behavior Renderer Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClientBehaviorRendererTypeType(ClientBehaviorRendererTypeType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentClassType(ComponentClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Component Extension Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentExtensionType(ComponentExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Component Family Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Family Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentFamilyType(ComponentFamilyType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentType(ComponentType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Component Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseComponentTypeType(ComponentTypeType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Converter Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Converter Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConverterClassType(ConverterClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Converter For Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Converter For Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConverterForClassType(ConverterForClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Converter Id Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Converter Id Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConverterIdType(ConverterIdType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Converter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Converter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConverterType(ConverterType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Default Locale Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Locale Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefaultLocaleType(DefaultLocaleType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Default Render Kit Id Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Render Kit Id Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefaultRenderKitIdType(DefaultRenderKitIdType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Default Validators Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Validators Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefaultValidatorsType(DefaultValidatorsType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDefaultValueType(DefaultValueType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Description Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDescriptionType(DescriptionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Display Name Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Display Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDisplayNameType(DisplayNameType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDocumentRoot(DocumentRoot object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Attribute</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseDynamicAttribute(DynamicAttribute object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Element</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseDynamicElement(DynamicElement object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>EL Resolver Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EL Resolver Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseELResolverType(ELResolverType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Exception Handler Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exception Handler Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExceptionHandlerFactoryType(ExceptionHandlerFactoryType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFacesConfigType(FacesConfigType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Faces Context Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Faces Context Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFacesContextFactoryType(FacesContextFactoryType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Extension Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFacetExtensionType(FacetExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Name Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFacetNameType(FacetNameType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Facet Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Facet Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFacetType(FacetType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFactoryType(FactoryType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>From Action Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Action Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFromActionType(FromActionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>From Outcome Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From Outcome Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFromOutcomeType(FromOutcomeType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>From View Id Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>From View Id Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFromViewIdType(FromViewIdType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Icon Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icon Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIconType(IconType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>If Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIfType(IfType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Key Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseKeyClassType(KeyClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Key Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Key Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseKeyType(KeyType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Large Icon Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Large Icon Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLargeIconType(LargeIconType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Lifecycle Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lifecycle Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLifecycleFactoryType(LifecycleFactoryType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Lifecycle Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lifecycle Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLifecycleType(LifecycleType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>List Entries Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Entries Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseListEntriesType(ListEntriesType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Locale Config Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Locale Config Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLocaleConfigType(LocaleConfigType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Bean Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Bean Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManagedBeanClassType(ManagedBeanClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Bean Name Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Bean Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManagedBeanNameType(ManagedBeanNameType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Bean Scope Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Bean Scope Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManagedBeanScopeType(ManagedBeanScopeType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Bean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Bean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManagedBeanType(ManagedBeanType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseManagedPropertyType(ManagedPropertyType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Map Entries Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Entries Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMapEntriesType(MapEntriesType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Map Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Entry Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMapEntryType(MapEntryType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Message Bundle Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message Bundle Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMessageBundleType(MessageBundleType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Name Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNameType(NameType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Case Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Case Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNavigationCaseType(NavigationCaseType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Handler Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Handler Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNavigationHandlerType(NavigationHandlerType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Rule Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Rule Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNavigationRuleType(NavigationRuleType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Null Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Null Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseNullValueType(NullValueType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Ordering Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordering Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrderingType(OrderingType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordering Ordering Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordering Ordering Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrderingOrderingType(OrderingOrderingType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordering Others Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordering Others Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOrderingOthersType(OrderingOthersType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Partial View Context Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Partial View Context Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePartialViewContextFactoryType(PartialViewContextFactoryType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Phase Listener Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Phase Listener Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePhaseListenerType(PhaseListenerType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyClassType(PropertyClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Extension Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyExtensionType(PropertyExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Name Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyNameType(PropertyNameType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Resolver Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Resolver Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyResolverType(PropertyResolverType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyType(PropertyType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Redirect Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redirect Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRedirectType(RedirectType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Redirect View Param Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redirect View Param Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRedirectViewParamType(RedirectViewParamType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Referenced Bean Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referenced Bean Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReferencedBeanClassType(ReferencedBeanClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Referenced Bean Name Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referenced Bean Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReferencedBeanNameType(ReferencedBeanNameType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Referenced Bean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Referenced Bean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseReferencedBeanType(ReferencedBeanType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Renderer Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Renderer Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRendererClassType(RendererClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Renderer Extension Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Renderer Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRendererExtensionType(RendererExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Renderer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Renderer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRendererType(RendererType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Renderer Type Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Renderer Type Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRendererTypeType(RendererTypeType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Render Kit Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Kit Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRenderKitClassType(RenderKitClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Render Kit Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Kit Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRenderKitFactoryType(RenderKitFactoryType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Render Kit Id Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Kit Id Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRenderKitIdType(RenderKitIdType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Render Kit Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Kit Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseRenderKitType(RenderKitType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Small Icon Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Small Icon Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSmallIconType(SmallIconType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Source Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSourceClassType(SourceClassType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>State Manager Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Manager Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStateManagerType(StateManagerType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Suggested Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Suggested Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSuggestedValueType(SuggestedValueType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Supported Locale Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Supported Locale Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSupportedLocaleType(SupportedLocaleType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>System Event Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Event Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSystemEventClassType(SystemEventClassType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>System Event Listener Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Event Listener Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSystemEventListenerClassType(SystemEventListenerClassType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>System Event Listener Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Event Listener Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseSystemEventListenerType(SystemEventListenerType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Tag Handler Delegate Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tag Handler Delegate Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTagHandlerDelegateFactoryType(TagHandlerDelegateFactoryType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>To View Id Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>To View Id Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseToViewIdType(ToViewIdType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Validator Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validator Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseValidatorClassType(ValidatorClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Validator Id Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validator Id Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseValidatorIdType(ValidatorIdType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Validator Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validator Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseValidatorType(ValidatorType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Value Class Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Class Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseValueClassType(ValueClassType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseValueType(ValueType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Resolver Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Resolver Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableResolverType(VariableResolverType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>View Handler Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Handler Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseViewHandlerType(ViewHandlerType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Bundle Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Bundle Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseResourceBundleType(ResourceBundleType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Base Name Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Name Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseBaseNameType(BaseNameType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Var Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseVarType(VarType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>View Declaration Language Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>View Declaration Language Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseViewDeclarationLanguageFactoryType(ViewDeclarationLanguageFactoryType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Visit Context Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visit Context Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVisitContextFactoryType(VisitContextFactoryType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Render Kit Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Kit Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseRenderKitExtensionType(RenderKitExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Handler Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Handler Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseResourceHandlerType(ResourceHandlerType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Rule Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Rule Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseNavigationRuleExtensionType(NavigationRuleExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Validator Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validator Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseValidatorExtensionType(ValidatorExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseFacesConfigExtensionType(FacesConfigExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Factory Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Factory Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseFactoryExtensionType(FactoryExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Lifecycle Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lifecycle Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseLifecycleExtensionType(LifecycleExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Managed Bean Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Managed Bean Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseManagedBeanExtensionType(ManagedBeanExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Converter Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Converter Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseConverterExtensionType(ConverterExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseExtensionType(ExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>External Context Factory Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Context Factory Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseExternalContextFactoryType(ExternalContextFactoryType object) {
		return null;
	}

				/**
	 * Returns the result of interpreting the object as an instance of '<em>Application Extension Type</em>'.
	 * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Application Extension Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
    public Object caseApplicationExtensionType(ApplicationExtensionType object) {
		return null;
	}

    /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //FacesConfigSwitch
