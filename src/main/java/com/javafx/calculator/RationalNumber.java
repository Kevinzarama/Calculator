package com.javafx.calculator;

import java.math.BigInteger;

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
			numerador = add(multiplier(numerador, (T) c.getDenominator()), multiplier(denominador, (T) c.getNumerator()));
			denominador = multiplier(denominador, (T) c.getDenominator());
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
			numerador = substract(multiplier(numerador, (T) rationalToBeSubstracted.getDenominator()), multiplier(denominador, (T) rationalToBeSubstracted.getNumerator()));
			denominador = multiplier(denominador, (T) rationalToBeSubstracted.getDenominator());
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
		String[] num1 = doEquals("" + numerador, "" + rationalFactor.getNumerator());
		String[] num2 = doEquals("" + denominador, "" + rationalFactor.getDenominator());
		numerador = multiply(num1[0], num1[1]);
		denominador = multiply(num2[0], num2[1]);
		simplifyRational();
	}
	public T multiply(String num1, String num2) {
		if(num1.length() < 3) {
			String[] nums1 = num1.split("");
			String[] nums2 = num2.split("");
			return (T) BigInteger.valueOf(Long.parseLong(karatsuba(Integer.parseInt(nums1[0]), Integer.parseInt(nums1[1]), Integer.parseInt(nums2[0]), Integer.parseInt(nums2[1]))));
		} else {
			String p1 = "" + multiply(num1.substring(0, num1.length() / 2), num2.substring(0, num2.length() / 2));
			String p2 = "" + multiply(num1.substring(num1.length() / 2, num1.length()), num2.substring(num2.length() / 2, num2.length()));
			String[] add = doEquals("" + (BigInteger.valueOf(Long.parseLong(num1.substring(0, num1.length() / 2))).add(BigInteger.valueOf(Long.parseLong(num1.substring(num1.length() / 2, num1.length()))))), "" +	(BigInteger.valueOf(Long.parseLong((num2.substring(0, num2.length() / 2)))).add(BigInteger.valueOf(Long.parseLong(num2.substring(num2.length() / 2, num2.length()))))));
			String p3 = "" + multiply(add[0], add[1]);
			String p4 = addZero(""+(BigInteger.valueOf(Long.parseLong(p3))).add(((BigInteger.valueOf(Long.parseLong(p2))).negate()).add((BigInteger.valueOf(Long.parseLong(p1))).negate())), (int) Math.ceil(((double)p2.length())/2));
			String[] aux = doEquals(p1, p2);
			String p5 = "" + (BigInteger.valueOf(Long.parseLong(aux[0] + aux[1])).add(BigInteger.valueOf(Long.parseLong(p4))));
			return (T) BigInteger.valueOf(Long.parseLong(p5));
		}
	}
	
	public String addZero(String number, int zero) {
		for(int i = 0; i < zero; i++) {
			number = number + "0";
		}
		return number;
	}
	
	public String[] doEquals(String num1, String num2) {
		String[] numbers = new String[2];
		if(num1.length() == num2.length()) {
			if(num1.length() % 2 == 0) {
				numbers[0] = num1;
				numbers[1] = num2;
				return numbers;
			} else {
				numbers[0] = "0" + num1;
				numbers[1] = "0" + num2;
				return numbers;
			}
		} else {
			if(num1.length() < num2.length()) {
				if(num2.length() % 2 == 0) {
					return doEquals("0" + num1, num2);
				} else {
					return doEquals(num1, "0" + num2);
				}
			} else {
				if(num1.length() % 2 == 0) {
					return doEquals(num1, "0" + num2);
				} else {
					return doEquals("0" + num1, num2);
				}
			}
		}
	}
	
	public String karatsuba(int a, int b, int c, int d) {
		int p1 = a * c;
		int p2 = b * d;
		int p3 = (a + b) * (c + d);
		int p4 = p3 - p2 - p1;
		int result = (p1 * 100) + p2 + (p4 * 10);
		return "" + result;
	}
//	public T multiply(T number1,T number2) {
//		T number=null;
//		if(number1 instanceof Long) {
//			number=(T)Long.valueOf(number1.longValue()*number2.longValue());
//		}else if(number1 instanceof Integer) {
//			number=(T)Integer.valueOf(number1.intValue()*number2.intValue());
//		}else if(number1 instanceof Short) {
//			number=(T)Short.valueOf((short) (number1.shortValue()*number2.shortValue()));
//		}
//		return number;
//	}
	@Override
	public void divideRational(RationalNumber<Number> rationalQuocient) {
		numerador = multiplier(numerador, (T) rationalQuocient.getDenominator());
		denominador = multiplier(denominador, (T) rationalQuocient.getNumerator());
		simplifyRational();
	}
	public T multiplier(T number1,T number2) {
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
