/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage
 * @generated
 */
public interface RegularExpressionFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  RegularExpressionFactory eINSTANCE = hu.bme.mit.ftsrg.ptregex.regularExpression.impl.RegularExpressionFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Regex Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Regex Model</em>'.
   * @generated
   */
  RegexModel createRegexModel();

  /**
   * Returns a new object of class '<em>Alphabet</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Alphabet</em>'.
   * @generated
   */
  Alphabet createAlphabet();

  /**
   * Returns a new object of class '<em>Functor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Functor</em>'.
   * @generated
   */
  Functor createFunctor();

  /**
   * Returns a new object of class '<em>Expression Declaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Declaration</em>'.
   * @generated
   */
  ExpressionDeclaration createExpressionDeclaration();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Any</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Any</em>'.
   * @generated
   */
  Any createAny();

  /**
   * Returns a new object of class '<em>Inverse</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Inverse</em>'.
   * @generated
   */
  Inverse createInverse();

  /**
   * Returns a new object of class '<em>Timed Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Timed Expression</em>'.
   * @generated
   */
  TimedExpression createTimedExpression();

  /**
   * Returns a new object of class '<em>Event</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Event</em>'.
   * @generated
   */
  Event createEvent();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns a new object of class '<em>Fix Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fix Parameter</em>'.
   * @generated
   */
  FixParameter createFixParameter();

  /**
   * Returns a new object of class '<em>Fix Int Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fix Int Parameter</em>'.
   * @generated
   */
  FixIntParameter createFixIntParameter();

  /**
   * Returns a new object of class '<em>Fix String Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fix String Parameter</em>'.
   * @generated
   */
  FixStringParameter createFixStringParameter();

  /**
   * Returns a new object of class '<em>Var Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Parameter</em>'.
   * @generated
   */
  VarParameter createVarParameter();

  /**
   * Returns a new object of class '<em>Singleton Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Singleton Parameter</em>'.
   * @generated
   */
  SingletonParameter createSingletonParameter();

  /**
   * Returns a new object of class '<em>Var</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var</em>'.
   * @generated
   */
  Var createVar();

  /**
   * Returns a new object of class '<em>Choice</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Choice</em>'.
   * @generated
   */
  Choice createChoice();

  /**
   * Returns a new object of class '<em>Sequence</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sequence</em>'.
   * @generated
   */
  Sequence createSequence();

  /**
   * Returns a new object of class '<em>Star</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Star</em>'.
   * @generated
   */
  Star createStar();

  /**
   * Returns a new object of class '<em>Plus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plus</em>'.
   * @generated
   */
  Plus createPlus();

  /**
   * Returns a new object of class '<em>Cardinality</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Cardinality</em>'.
   * @generated
   */
  Cardinality createCardinality();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  RegularExpressionPackage getRegularExpressionPackage();

} //RegularExpressionFactory
