/**
 */
package hu.bme.mit.ftsrg.ptregex.regularExpression.impl;

import hu.bme.mit.ftsrg.ptregex.regularExpression.Alphabet;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Any;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Cardinality;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Choice;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Event;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Expression;
import hu.bme.mit.ftsrg.ptregex.regularExpression.ExpressionDeclaration;
import hu.bme.mit.ftsrg.ptregex.regularExpression.FixIntParameter;
import hu.bme.mit.ftsrg.ptregex.regularExpression.FixParameter;
import hu.bme.mit.ftsrg.ptregex.regularExpression.FixStringParameter;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Functor;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Inverse;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Parameter;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Plus;
import hu.bme.mit.ftsrg.ptregex.regularExpression.RegexModel;
import hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionFactory;
import hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Sequence;
import hu.bme.mit.ftsrg.ptregex.regularExpression.SingletonParameter;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Star;
import hu.bme.mit.ftsrg.ptregex.regularExpression.TimedExpression;
import hu.bme.mit.ftsrg.ptregex.regularExpression.Var;
import hu.bme.mit.ftsrg.ptregex.regularExpression.VarParameter;

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
public class RegularExpressionPackageImpl extends EPackageImpl implements RegularExpressionPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass regexModelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alphabetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass anyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inverseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timedExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixIntParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixStringParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass singletonParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choiceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass starEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass plusEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass cardinalityEClass = null;

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
   * @see hu.bme.mit.ftsrg.ptregex.regularExpression.RegularExpressionPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RegularExpressionPackageImpl()
  {
    super(eNS_URI, RegularExpressionFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link RegularExpressionPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RegularExpressionPackage init()
  {
    if (isInited) return (RegularExpressionPackage)EPackage.Registry.INSTANCE.getEPackage(RegularExpressionPackage.eNS_URI);

    // Obtain or create and register package
    RegularExpressionPackageImpl theRegularExpressionPackage = (RegularExpressionPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RegularExpressionPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RegularExpressionPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theRegularExpressionPackage.createPackageContents();

    // Initialize created meta-data
    theRegularExpressionPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theRegularExpressionPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RegularExpressionPackage.eNS_URI, theRegularExpressionPackage);
    return theRegularExpressionPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRegexModel()
  {
    return regexModelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRegexModel_Alphabet()
  {
    return (EReference)regexModelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRegexModel_Declarations()
  {
    return (EReference)regexModelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlphabet()
  {
    return alphabetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAlphabet_Functors()
  {
    return (EReference)alphabetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctor()
  {
    return functorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctor_Name()
  {
    return (EAttribute)functorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunctor_Arity()
  {
    return (EAttribute)functorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressionDeclaration()
  {
    return expressionDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExpressionDeclaration_Name()
  {
    return (EAttribute)expressionDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionDeclaration_Vars()
  {
    return (EReference)expressionDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressionDeclaration_Body()
  {
    return (EReference)expressionDeclarationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAny()
  {
    return anyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInverse()
  {
    return inverseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInverse_Excludes()
  {
    return (EReference)inverseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimedExpression()
  {
    return timedExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimedExpression_Body()
  {
    return (EReference)timedExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimedExpression_Timeout()
  {
    return (EAttribute)timedExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvent()
  {
    return eventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEvent_Functor()
  {
    return (EReference)eventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEvent_Parameters()
  {
    return (EReference)eventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter()
  {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixParameter()
  {
    return fixParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixIntParameter()
  {
    return fixIntParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFixIntParameter_Body()
  {
    return (EAttribute)fixIntParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixStringParameter()
  {
    return fixStringParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFixStringParameter_Body()
  {
    return (EAttribute)fixStringParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarParameter()
  {
    return varParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVarParameter_Var()
  {
    return (EReference)varParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSingletonParameter()
  {
    return singletonParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVar()
  {
    return varEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVar_Name()
  {
    return (EAttribute)varEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoice()
  {
    return choiceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoice_Elements()
  {
    return (EReference)choiceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSequence()
  {
    return sequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSequence_Elements()
  {
    return (EReference)sequenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStar()
  {
    return starEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStar_Body()
  {
    return (EReference)starEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPlus()
  {
    return plusEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPlus_Body()
  {
    return (EReference)plusEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCardinality()
  {
    return cardinalityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCardinality_Body()
  {
    return (EReference)cardinalityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCardinality_N()
  {
    return (EAttribute)cardinalityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegularExpressionFactory getRegularExpressionFactory()
  {
    return (RegularExpressionFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    regexModelEClass = createEClass(REGEX_MODEL);
    createEReference(regexModelEClass, REGEX_MODEL__ALPHABET);
    createEReference(regexModelEClass, REGEX_MODEL__DECLARATIONS);

    alphabetEClass = createEClass(ALPHABET);
    createEReference(alphabetEClass, ALPHABET__FUNCTORS);

    functorEClass = createEClass(FUNCTOR);
    createEAttribute(functorEClass, FUNCTOR__NAME);
    createEAttribute(functorEClass, FUNCTOR__ARITY);

    expressionDeclarationEClass = createEClass(EXPRESSION_DECLARATION);
    createEAttribute(expressionDeclarationEClass, EXPRESSION_DECLARATION__NAME);
    createEReference(expressionDeclarationEClass, EXPRESSION_DECLARATION__VARS);
    createEReference(expressionDeclarationEClass, EXPRESSION_DECLARATION__BODY);

    expressionEClass = createEClass(EXPRESSION);

    anyEClass = createEClass(ANY);

    inverseEClass = createEClass(INVERSE);
    createEReference(inverseEClass, INVERSE__EXCLUDES);

    timedExpressionEClass = createEClass(TIMED_EXPRESSION);
    createEReference(timedExpressionEClass, TIMED_EXPRESSION__BODY);
    createEAttribute(timedExpressionEClass, TIMED_EXPRESSION__TIMEOUT);

    eventEClass = createEClass(EVENT);
    createEReference(eventEClass, EVENT__FUNCTOR);
    createEReference(eventEClass, EVENT__PARAMETERS);

    parameterEClass = createEClass(PARAMETER);

    fixParameterEClass = createEClass(FIX_PARAMETER);

    fixIntParameterEClass = createEClass(FIX_INT_PARAMETER);
    createEAttribute(fixIntParameterEClass, FIX_INT_PARAMETER__BODY);

    fixStringParameterEClass = createEClass(FIX_STRING_PARAMETER);
    createEAttribute(fixStringParameterEClass, FIX_STRING_PARAMETER__BODY);

    varParameterEClass = createEClass(VAR_PARAMETER);
    createEReference(varParameterEClass, VAR_PARAMETER__VAR);

    singletonParameterEClass = createEClass(SINGLETON_PARAMETER);

    varEClass = createEClass(VAR);
    createEAttribute(varEClass, VAR__NAME);

    choiceEClass = createEClass(CHOICE);
    createEReference(choiceEClass, CHOICE__ELEMENTS);

    sequenceEClass = createEClass(SEQUENCE);
    createEReference(sequenceEClass, SEQUENCE__ELEMENTS);

    starEClass = createEClass(STAR);
    createEReference(starEClass, STAR__BODY);

    plusEClass = createEClass(PLUS);
    createEReference(plusEClass, PLUS__BODY);

    cardinalityEClass = createEClass(CARDINALITY);
    createEReference(cardinalityEClass, CARDINALITY__BODY);
    createEAttribute(cardinalityEClass, CARDINALITY__N);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    anyEClass.getESuperTypes().add(this.getExpression());
    inverseEClass.getESuperTypes().add(this.getExpression());
    timedExpressionEClass.getESuperTypes().add(this.getExpression());
    eventEClass.getESuperTypes().add(this.getExpression());
    fixParameterEClass.getESuperTypes().add(this.getParameter());
    fixIntParameterEClass.getESuperTypes().add(this.getFixParameter());
    fixStringParameterEClass.getESuperTypes().add(this.getFixParameter());
    varParameterEClass.getESuperTypes().add(this.getParameter());
    singletonParameterEClass.getESuperTypes().add(this.getParameter());
    choiceEClass.getESuperTypes().add(this.getExpression());
    sequenceEClass.getESuperTypes().add(this.getExpression());
    starEClass.getESuperTypes().add(this.getExpression());
    plusEClass.getESuperTypes().add(this.getExpression());
    cardinalityEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(regexModelEClass, RegexModel.class, "RegexModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRegexModel_Alphabet(), this.getAlphabet(), null, "alphabet", null, 0, 1, RegexModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRegexModel_Declarations(), this.getExpressionDeclaration(), null, "declarations", null, 0, -1, RegexModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(alphabetEClass, Alphabet.class, "Alphabet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAlphabet_Functors(), this.getFunctor(), null, "functors", null, 0, -1, Alphabet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functorEClass, Functor.class, "Functor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunctor_Name(), ecorePackage.getEString(), "name", null, 0, 1, Functor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunctor_Arity(), ecorePackage.getEInt(), "arity", null, 0, 1, Functor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionDeclarationEClass, ExpressionDeclaration.class, "ExpressionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExpressionDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, ExpressionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpressionDeclaration_Vars(), this.getVar(), null, "vars", null, 0, -1, ExpressionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpressionDeclaration_Body(), this.getExpression(), null, "body", null, 0, 1, ExpressionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(anyEClass, Any.class, "Any", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(inverseEClass, Inverse.class, "Inverse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInverse_Excludes(), this.getEvent(), null, "excludes", null, 0, -1, Inverse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timedExpressionEClass, TimedExpression.class, "TimedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTimedExpression_Body(), this.getExpression(), null, "body", null, 0, 1, TimedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimedExpression_Timeout(), ecorePackage.getEInt(), "timeout", null, 0, 1, TimedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEvent_Functor(), this.getFunctor(), null, "functor", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEvent_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fixParameterEClass, FixParameter.class, "FixParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fixIntParameterEClass, FixIntParameter.class, "FixIntParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFixIntParameter_Body(), ecorePackage.getEInt(), "body", null, 0, 1, FixIntParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fixStringParameterEClass, FixStringParameter.class, "FixStringParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFixStringParameter_Body(), ecorePackage.getEString(), "body", null, 0, 1, FixStringParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varParameterEClass, VarParameter.class, "VarParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVarParameter_Var(), this.getVar(), null, "var", null, 0, 1, VarParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(singletonParameterEClass, SingletonParameter.class, "SingletonParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(varEClass, Var.class, "Var", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVar_Name(), ecorePackage.getEString(), "name", null, 0, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChoice_Elements(), this.getExpression(), null, "elements", null, 0, -1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sequenceEClass, Sequence.class, "Sequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSequence_Elements(), this.getExpression(), null, "elements", null, 0, -1, Sequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(starEClass, Star.class, "Star", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStar_Body(), this.getExpression(), null, "body", null, 0, 1, Star.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(plusEClass, Plus.class, "Plus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPlus_Body(), this.getExpression(), null, "body", null, 0, 1, Plus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(cardinalityEClass, Cardinality.class, "Cardinality", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCardinality_Body(), this.getExpression(), null, "body", null, 0, 1, Cardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCardinality_N(), ecorePackage.getEInt(), "n", null, 0, 1, Cardinality.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //RegularExpressionPackageImpl
