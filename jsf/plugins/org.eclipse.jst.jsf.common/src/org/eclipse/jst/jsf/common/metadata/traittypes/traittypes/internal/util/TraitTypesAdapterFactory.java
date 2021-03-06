/**
 * <copyright>
 * </copyright>
 *
 * $Id: TraitTypesAdapterFactory.java,v 1.7 2010/04/27 17:40:11 gkessler Exp $
 */
package org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.internal.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.BooleanValue;
import org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.ListOfValues;
import org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.SetGenerator;
import org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.StringValue;
import org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.TraitTypesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.TraitTypesPackage
 * @generated
 */
public class TraitTypesAdapterFactory extends AdapterFactoryImpl {
    /**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright (c) 2007 Oracle Corporation"; //$NON-NLS-1$

    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static TraitTypesPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public TraitTypesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TraitTypesPackage.eINSTANCE;
		}
	}

    /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
    public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

    /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected TraitTypesSwitch modelSwitch =
        new TraitTypesSwitch() {
			public Object caseListOfValues(ListOfValues object) {
				return createListOfValuesAdapter();
			}
			public Object caseSetGenerator(SetGenerator object) {
				return createSetGeneratorAdapter();
			}
			public Object caseStringValue(StringValue object) {
				return createStringValueAdapter();
			}
			public Object caseBooleanValue(BooleanValue object) {
				return createBooleanValueAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

    /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
    public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


    /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.ListOfValues <em>List Of Values</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.ListOfValues
	 * @generated
	 */
    public Adapter createListOfValuesAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.SetGenerator <em>Set Generator</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.SetGenerator
	 * @generated
	 */
    public Adapter createSetGeneratorAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.StringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.StringValue
	 * @generated
	 */
	public Adapter createStringValueAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.BooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.jst.jsf.common.metadata.traittypes.traittypes.BooleanValue
	 * @generated
	 */
	public Adapter createBooleanValueAdapter() {
		return null;
	}

				/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
    public Adapter createEObjectAdapter() {
		return null;
	}

} //TraitTypesAdapterFactory
