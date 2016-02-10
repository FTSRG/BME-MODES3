/**
 * generated by Xtext 2.9.1
 */
package hu.bme.mit.inf.parametricTimedRegularExpression.impl;

import hu.bme.mit.inf.parametricTimedRegularExpression.Alphabet;
import hu.bme.mit.inf.parametricTimedRegularExpression.Functor;
import hu.bme.mit.inf.parametricTimedRegularExpression.ParametricTimedRegularExpressionPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alphabet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.inf.parametricTimedRegularExpression.impl.AlphabetImpl#getFunctors <em>Functors</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlphabetImpl extends MinimalEObjectImpl.Container implements Alphabet
{
  /**
   * The cached value of the '{@link #getFunctors() <em>Functors</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFunctors()
   * @generated
   * @ordered
   */
  protected EList<Functor> functors;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlphabetImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ParametricTimedRegularExpressionPackage.Literals.ALPHABET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Functor> getFunctors()
  {
    if (functors == null)
    {
      functors = new EObjectContainmentEList<Functor>(Functor.class, this, ParametricTimedRegularExpressionPackage.ALPHABET__FUNCTORS);
    }
    return functors;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ParametricTimedRegularExpressionPackage.ALPHABET__FUNCTORS:
        return ((InternalEList<?>)getFunctors()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ParametricTimedRegularExpressionPackage.ALPHABET__FUNCTORS:
        return getFunctors();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ParametricTimedRegularExpressionPackage.ALPHABET__FUNCTORS:
        getFunctors().clear();
        getFunctors().addAll((Collection<? extends Functor>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ParametricTimedRegularExpressionPackage.ALPHABET__FUNCTORS:
        getFunctors().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ParametricTimedRegularExpressionPackage.ALPHABET__FUNCTORS:
        return functors != null && !functors.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //AlphabetImpl