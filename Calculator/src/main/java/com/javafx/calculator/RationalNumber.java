package com.javafx.calculator;
@SuppressWarnings("unchecked")
public class RationalNumber<T extends Number> implements IRationalNumber<IRationalNumber<Number>> {
	private T numerador;
	private T denominador;

	public RationalNumber(T number1, T number2) {
		super();
		this.numerador = number1;
		this.denominador = number2;
	}

	@Override
	public void addRational(RationalNumber<Number> c) {
		if(denominador == c.getDenominator()) {
			numerador = add(numerador, (T) c.getNumerator());
			simplifyRational();
		} else {
			numerador = add(multiply(numerador, (T) c.getDenominator()), multiply(denominador, (T) c.getNumerator()));
			denominador = multiply(denominador, (T) c.getDenominator());
			simplifyRational();
		}
	}
	public T add(T number1, T number2) {
		T number = null;
		if(number1 instanceof Long) {
			number= (T) Long.valueOf(number1.longValue()+number2.longValue());
		}else if(number1 instanceof Integer) {
			number=(T) Integer.valueOf(number1.intValue()+number2.intValue());
		}else if(number1 instanceof Short) {
			number=(T)Short.valueOf((short) (number1.shortValue()+number2.shortValue()));
		}
		return number;
	}
	@Override
	public void substractRational(RationalNumber<Number> rationalToBeSubstracted) {
		if(denominador == rationalToBeSubstracted.getDenominator()) {
			numerador = substract(numerador,  (T) rationalToBeSubstracted.getNumerator());
			simplifyRational();
		} else {
			numerador = substract(multiply(numerador, (T) rationalToBeSubstracted.getDenominator()), multiply(denominador, (T) rationalToBeSubstracted.getNumerator()));
			denominador = multiply(denominador, (T) rationalToBeSubstracted.getDenominator());
			simplifyRational();
		}
	}
	public T substract(T number1, T number2) {
		T number = null;
		if(number1 instanceof Long) {
			number= (T) Long.valueOf(number1.longValue() - number2.longValue());
		}else if(number1 instanceof Integer) {
			number=(T) Integer.valueOf(number1.intValue() - number2.intValue());
		}else if(number1 instanceof Short) {
			number=(T)Short.valueOf((short) (number1.shortValue() - number2.shortValue()));
		}
		return number;
	}
	@Override
	public void multiplyRational(RationalNumber<Number> rationalFactor) {
		numerador = multiply(numerador, (T) rationalFactor.getNumerator());
		denominador = multiply(denominador, (T) rationalFactor.getDenominator());
		simplifyRational();
	}
	public T multiply(T number1,T number2) {
		T number=null;
		if(number1 instanceof Long) {
			number=(T)Long.valueOf(number1.longValue()*number2.longValue());
		}else if(number1 instanceof Integer) {
			number=(T)Integer.valueOf(number1.intValue()*number2.intValue());
		}else if(number1 instanceof Short) {
			number=(T)Short.valueOf((short) (number1.shortValue()*number2.shortValue()));
		}
		return number;
	}
	@Override
	public void divideRational(RationalNumber<Number> rationalQuocient) {
		numerador = multiply(numerador, (T) rationalQuocient.getDenominator());
		denominador = multiply(denominador, (T) rationalQuocient.getNumerator());
		simplifyRational();
	}
	@Override
	public void simplifyRational() {
		simplify(numerador, denominador);
	}
	public void simplify(T nume, T deno) {
		T mcd = mcd(nume, deno);
		numerador = (T) Long.valueOf(numerador.longValue() / mcd.longValue());
		denominador = (T) Long.valueOf(denominador.longValue() / mcd.longValue());
	}
	public T mcd(T nume, T deno) {
		T mcd = (T) Long.valueOf(1);;
		if(nume.longValue() == 0) {
			return mcd;
		} else {
			if(Long.valueOf(nume.longValue()) < 0) {
				nume = (T) Long.valueOf(nume.longValue() * -1);
			}
			if(Long.valueOf(deno.longValue()) < 0) {
				deno = (T) Long.valueOf(deno.longValue() * -1);
			}
			if(deno.longValue() > nume.longValue()) {
				T temp = nume;
				nume = deno;
				deno = temp;
			}
			while(deno.longValue() != 0) {
				mcd = deno;
				deno = (T) Long.valueOf(nume.longValue() % deno.longValue());
				nume = mcd;
			}
			return mcd;
		}
	}

	@Override
	public void rationalInverse() {
		if(!numerador.equals(0)) {
			T temp = numerador;
			numerador = denominador;
			denominador = temp;
			simplifyRational();
		}
	}

	@Override
	public void squaredRational() {
		numerador = square(numerador);
		denominador = square(denominador);
		simplifyRational();
	}
	public T square(T number1) {
		T number=null;
		if(number1 instanceof Long) {
			number=(T)Long.valueOf((long) (number1.longValue() * number1.longValue()));
		}else if(number1 instanceof Integer) {
			number=(T)(Integer.valueOf((int) (number1.intValue() * number1.intValue())));
		}else if(number1 instanceof Short) {
			number=(T)Short.valueOf((short) (number1.shortValue() * number1.shortValue()));
		}
		return number;
	}
	@Override
	public T getNumerator() {
		return numerador;
	}

	@Override
	public T getDenominator() {
		return denominador;
	}
}
