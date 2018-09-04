package com.javafx.calculator;

public interface IRationalNumber <T>{
	
	public void addRational(RationalNumber<Number> rationalToBeAdded);
	public void substractRational(RationalNumber<Number> rationalToBeSubstracted);
	public void multiplyRational(RationalNumber<Number> rationalFactor);
	public void divideRational(RationalNumber<Number> rationalQuocient);
	public void simplifyRational();
	public void rationalInverse();
	public void squaredRational();
	public Number getNumerator();
	public Number getDenominator();
	public String toString();
	
}