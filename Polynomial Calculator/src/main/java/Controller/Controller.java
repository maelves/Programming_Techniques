package Controller;

import Model.Model;
import Model.Monomial;
import Model.Polynomial;
import Operations.PolynomialOperations;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private View ui;
    private Model model;

    public Controller(View ui, Model model) {
        this.model = model;
        this.ui = ui;

        ui.addListenerAddBtn(new AddPolyListener());
        ui.addListenerSubstractBtn(new SubPolyListener());
        ui.addListenerMultiplyBtn(new MultiplyPolyListener());
        ui.addListenerDeriveBtn(new DerivatePolyListener());
        ui.addListenerIntegrateBtn(new IntegratePolyListener());
        ui.addListenerDivideBtn(new DividePolyListener());

    }

    public static Polynomial strToPolynomial(String str) {
        Pattern p = Pattern.compile("(-?\\b\\d+)[xX]\\^(-?\\d+\\b)");
        Matcher m = p.matcher(str);
        Polynomial polynomial = new Polynomial();
        while (m.find()) {
            Monomial m1 = new Monomial();
            m1.setCoef((double) Integer.parseInt(m.group(1)));
            m1.setDeg(Integer.parseInt(m.group(2)));
            polynomial.addMonomial(m1);
            //System.out.println(m1);
        }
        return polynomial;
    }

    class AddPolyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = ui.getPolinomial1().getText();
                userInput2 = ui.getPolinomial2().getText();
                //System.out.println(userInput1);
                //System.out.println(userInput2);
                model.setResult(PolynomialOperations.addPolynoms(strToPolynomial(userInput1), strToPolynomial(userInput2)));
                ui.getResult().setText(model.getResult().toString());

            } catch (NumberFormatException wrongInput) {
                ui.setResult("WRONG INPUT");
            }
        }

    }

    class SubPolyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = ui.getPolinomial1().getText();
                userInput2 = ui.getPolinomial2().getText();
                model.setResult(PolynomialOperations.substractPolynoms(strToPolynomial(userInput1), strToPolynomial(userInput2)));
                ui.getResult().setText(model.getResult().toString());

            } catch (NumberFormatException wrongInput) {
                ui.setResult("WRONG INPUT");
            }
        }
    }

    class MultiplyPolyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = ui.getPolinomial1().getText();
                userInput2 = ui.getPolinomial2().getText();
                model.setResult(PolynomialOperations.multiplyPolynoms(strToPolynomial(userInput1), strToPolynomial(userInput2)));
                ui.getResult().setText(model.getResult().toString());

            } catch (NumberFormatException wrongInput) {
                ui.setResult("WRONG INPUT");
            }
        }
    }

    class DerivatePolyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            try {
                userInput1 = ui.getPolinomial1().getText();
                model.setResult(PolynomialOperations.derivativePolynom(strToPolynomial(userInput1)));
                ui.getResult().setText(model.getResult().toString());
            } catch (NumberFormatException wrongInput) {
                ui.setResult("WRONG INPUT");
            }
        }
    }

    class IntegratePolyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1 = "";
            try {
                userInput1 = ui.getPolinomial1().getText();
                model.setResult(PolynomialOperations.integratePolynom(strToPolynomial(userInput1)));
                ui.getResult().setText(model.getResult().toString());
            } catch (NumberFormatException wrongInput) {
                ui.setResult("WRONG INPUT");
            }
        }
    }

    class DividePolyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput2 = "", userInput1 = "";
            try {
                userInput1 = ui.getPolinomial1().getText();
                userInput2 = ui.getPolinomial2().getText();
                Polynomial res[] = PolynomialOperations.dividePolynoms(strToPolynomial(userInput1), strToPolynomial(userInput2));
                model.setResult(res[0]);
                model.setRemain(res[1]);
                ui.getResult().setText(model.getResult().toString());
                ui.getRemain().setText(model.getRemain().toString());

            } catch (NumberFormatException wrongInput) {
                ui.setResult("WRONG INPUT");
            }
        }
    }

}

