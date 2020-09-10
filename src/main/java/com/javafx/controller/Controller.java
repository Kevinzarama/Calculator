package com.javafx.controller;

import javax.swing.JOptionPane;

import com.javafx.calculator.RationalNumber;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {
	
	@FXML
    private Button n7;

    @FXML
    private Button n9;

    @FXML
    private Button n8;

    @FXML
    private Button n4;

    @FXML
    private Button n5;

    @FXML
    private Button n0;

    @FXML
    private Button n3;

    @FXML
    private Button n2;

    @FXML
    private Button n1;

    @FXML
    private Button n6;

    @FXML
    private Button delete;

    @FXML
    private TextArea txtNR1;

    @FXML
    private TextArea txtNR2;

    @FXML
    private Button add;

    @FXML
    private Button sub;

    @FXML
    private Button mul;

    @FXML
    private Button div;

    @FXML
    private Button sim;

    @FXML
    private Button squ;

    @FXML
    private Button rat;

    @FXML
    private Button btNA1;

    @FXML
    private Button btNB1;

    @FXML
    private Button btNB2;

    @FXML
    private Button btNA2;
    
    @FXML
    private Button negative;
    
    @FXML
    private Button c;

    @FXML
    private Button ce;
    
    private boolean selNA1 = false, selNA2 = false, selNB1 = false, selNB2 = false;
    
    private RationalNumber r;
    private RationalNumber s;
    
    @FXML
    void add(ActionEvent event) {
    	long num1 = Long.valueOf(0);
    	long num2 = Long.valueOf(0);
    	long num3 = Long.valueOf(0);
    	long num4 = Long.valueOf(0);
    	try {
	    	num1 = Long.parseLong(btNA1.getText().equals("") ? "1" : btNA1.getText());
	    	num2 = Long.parseLong(btNA2.getText().equals("") ? "1" : btNA2.getText());
	    	num3 = Long.parseLong(btNB1.getText().equals("") ? "1" : btNB1.getText());
	    	num4 = Long.parseLong(btNB2.getText().equals("") ? "1" : btNB2.getText());
    	} catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "enter whole numbers");
    	}
    	r = new RationalNumber<Number>(num1, num2);
    	s = new RationalNumber<Number>(num3, num4);
    	r.addRational(s);
    	txtNR1.setText(r.getNumerator() + "");
    	txtNR2.setText(r.getDenominator() + "");
    }

    @FXML
    void delete(ActionEvent event) {
    	if(selNA1) {
			String contend = btNA1.getText();
			int size = contend.length()-1;
			contend = size < 0 ? contend : contend.substring(0, size);
			btNA1.setText(contend);
		} else if(selNA2) {
			String contend = btNA2.getText();
			int size = contend.length()-1;
			contend = size < 0 ? contend : contend.substring(0, size);
			btNA2.setText(contend);
		} else if(selNB1) {
			String contend = btNB1.getText();
			int size = contend.length()-1;
			contend = size < 0 ? contend : contend.substring(0, size);
			btNB1.setText(contend);
		} else if(selNB2) {
			String contend = btNB2.getText();
			int size = contend.length()-1;
			contend = size < 0 ? contend : contend.substring(0, size);
			btNB2.setText(contend);
		}
    }

    @FXML
    void divi(ActionEvent event) {
    	long num1 = Long.parseLong(btNA1.getText().equals("") ? "1" : btNA1.getText());
    	long num2 = Long.parseLong(btNA2.getText().equals("") ? "1" : btNA2.getText());
    	long num3 = Long.parseLong(btNB1.getText().equals("") ? "1" : btNB1.getText());
    	long num4 = Long.parseLong(btNB2.getText().equals("") ? "1" : btNB2.getText());
    	r = new RationalNumber<Number>(num1, num2);
    	s = new RationalNumber<Number>(num3, num4);
    	r.divideRational(s);
    	txtNR1.setText(r.getNumerator() + "");
    	txtNR2.setText(r.getDenominator() + "");
    }

    @FXML
    void inve(ActionEvent event) {
    	long num1 = Long.valueOf(0);
    	long num2 = Long.valueOf(0);
    	try {
	    	num1 = Long.parseLong(btNA1.getText().equals("") ? "1" : btNA1.getText());
	    	num2 = Long.parseLong(btNA2.getText().equals("") ? "1" : btNA2.getText());
	    } catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "enter whole numbers");
    	}
    	r = new RationalNumber<Number>(num1, num2);
    	r.rationalInverse();
    	txtNR1.setText(r.getNumerator() + "");
    	txtNR2.setText(r.getDenominator() + "");
    }

    @FXML
    void mult(ActionEvent event) {
    	long num1 = Long.valueOf(1);
    	long num2 = Long.valueOf(1);
    	long num3 = Long.valueOf(1);
    	long num4 = Long.valueOf(1);
    	try {
	    	num1 = Long.parseLong(btNA1.getText().equals("") ? "1" : btNA1.getText());
	    	num2 = Long.parseLong(btNA2.getText().equals("") ? "1" : btNA2.getText());
	    	num3 = Long.parseLong(btNB1.getText().equals("") ? "1" : btNB1.getText());
	    	num4 = Long.parseLong(btNB2.getText().equals("") ? "1" : btNB2.getText());
    	} catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "enter whole numbers");
    	}
    	r = new RationalNumber<Number>(num1, num2);
    	s = new RationalNumber<Number>(num3, num4);
    	r.multiplyRational(s);
    	txtNR1.setText(r.getNumerator() + "");
    	txtNR2.setText(r.getDenominator() + "");
    }

    @FXML
    void selected0(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "0");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "0");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "0");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "0");
		}
    	
    }

    @FXML
    void selected1(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "1");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "1");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "1");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "1");
		}
    	
    }

    @FXML
    void selected2(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "2");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "2");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "2");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "2");
		}
    	
    }

    @FXML
    void selected3(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "3");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "3");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "3");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "3");
		}
    	
    }

    @FXML
    void selected4(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "4");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "4");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "4");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "4");
		}
    	
    }

    @FXML
    void selected5(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "5");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "5");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "5");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "5");
		}
    	
    }

    @FXML
    void selected6(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "6");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "6");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "6");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "6");
		}
    	
    }

    @FXML
    void selected7(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "7");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "7");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "7");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "7");
		}
    	
    }

    @FXML
    void selected8(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "8");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "8");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "8");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "8");
		}
    	
    }

    @FXML
    void selected9(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText(contend + "9");
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText(contend + "9");
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText(contend + "9");
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText(contend + "9");
		}
    	
    }

    @FXML
    void selectedNA1(ActionEvent event) {
    	
    	selNA1 = true;
    	selNA2 = false;
    	selNB1 = false;
    	selNB2 = false;
    	
    }

    @FXML
    void selectedNA2(ActionEvent event) {
    	
    	selNA1 = false;
    	selNA2 = true;
    	selNB1 = false;
    	selNB2 = false;
    	
    }

    @FXML
    void selectedNB1(ActionEvent event) {
    	
    	selNA1 = false;
    	selNA2 = false;
    	selNB1 = true;
    	selNB2 = false;
    	
    }

    @FXML
    void selectedNB2(ActionEvent event) {
    	
    	selNA1 = false;
    	selNA2 = false;
    	selNB1 = false;
    	selNB2 = true;
    	
    }

    @FXML
    void simp(ActionEvent event) {
    	long num1 = Long.valueOf(0);
    	long num2 = Long.valueOf(0);
    	try {
	    	num1 = Long.parseLong(btNA1.getText().equals("") ? "1" : btNA1.getText());
	    	num2 = Long.parseLong(btNA2.getText().equals("") ? "1" : btNA2.getText());
	    } catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "enter whole numbers");
    	}
    	r = new RationalNumber<Number>(num1, num2);
    	r.simplifyRational();
    	txtNR1.setText(r.getNumerator() + "");
    	txtNR2.setText(r.getDenominator() + "");
    }

    @FXML
    void squa(ActionEvent event) {
    	long num1 = Long.valueOf(0);
    	long num2 = Long.valueOf(0);
    	try {
	    	num1 = Long.parseLong(btNA1.getText().equals("") ? "1" : btNA1.getText());
	    	num2 = Long.parseLong(btNA2.getText().equals("") ? "1" : btNA2.getText());
	    } catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "enter whole numbers");
    	}
    	r = new RationalNumber<Number>(num1, num2);
    	r.squaredRational();
    	txtNR1.setText(r.getNumerator() + "");
    	txtNR2.setText(r.getDenominator() + "");
    }

    @FXML
    void subs(ActionEvent event) {
    	long num1 = Long.valueOf(0);
    	long num2 = Long.valueOf(0);
    	long num3 = Long.valueOf(0);
    	long num4 = Long.valueOf(0);
    	try {
	    	num1 = Long.parseLong(btNA1.getText().equals("") ? "1" : btNA1.getText());
	    	num2 = Long.parseLong(btNA2.getText().equals("") ? "1" : btNA2.getText());
	    	num3 = Long.parseLong(btNB1.getText().equals("") ? "1" : btNB1.getText());
	    	num4 = Long.parseLong(btNB2.getText().equals("") ? "1" : btNB2.getText());
    	} catch(NumberFormatException e){
    		JOptionPane.showMessageDialog(null, "enter whole numbers");
    	}
    	r = new RationalNumber<Number>(num1, num2);
    	s = new RationalNumber<Number>(num3, num4);
    	r.substractRational(s);
    	txtNR1.setText(r.getNumerator() + "");
    	txtNR2.setText(r.getDenominator() + "");
    }
    
    @FXML
    void negative(ActionEvent event) {
    	
    	if(selNA1) {
			String contend = btNA1.getText();
			btNA1.setText("-" + contend);
		} else if(selNA2) {
			String contend = btNA2.getText();
			btNA2.setText("-" + contend);
		} else if(selNB1) {
			String contend = btNB1.getText();
			btNB1.setText("-" + contend);
		} else if(selNB2) {
			String contend = btNB2.getText();
			btNB2.setText("-" + contend);
		}
    	
    }
    
    @FXML
    void c(ActionEvent event) {
    	
    	btNA1.setText("");
    	btNA2.setText("");
    	btNB1.setText("");
    	btNB2.setText("");
    	txtNR1.setText("");
    	txtNR2.setText("");
    	
    }

    @FXML
    void ce(ActionEvent event) {
    	
    	if(selNA1) {
			btNA1.setText("");
		} else if(selNA2) {
			btNA2.setText("");
		} else if(selNB1) {
			btNB1.setText("");
		} else if(selNB2) {
			btNB2.setText("");
		}
    	
    }
    
}
