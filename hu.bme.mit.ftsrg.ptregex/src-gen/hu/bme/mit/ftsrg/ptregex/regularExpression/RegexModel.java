/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regex Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel#getAlphabet <em>Alphabet</em>}</li>
 *   <li>{@link hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getRegexModel()
 * @model
 * @generated
 */
public interface RegexModel extends EObject
{
  /**
   * Returns the value of the '<em><b>Alphabet</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alphabet</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alphabet</em>' containment reference.
   * @see #setAlphabet(Alphabet)
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getRegexModel_Alphabet()
   * @model containment="true"
   * @generated
   */
  Alphabet getAlphabet();

  /**
   * Sets the value of the '{@link hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel#getAlphabet <em>Alphabet</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alphabet</em>' containment reference.
   * @see #getAlphabet()
   * @generated
   */
  void setAlphabet(Alphabet value);

  /**
   * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
   * The list contents are of type {@link hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declarations</em>' containment reference list.
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#getRegexModel_Declarations()
   * @model containment="true"
   * @generated
   */
  EList<ExpressionDeclaration> getDeclarations();

} // RegexModel
