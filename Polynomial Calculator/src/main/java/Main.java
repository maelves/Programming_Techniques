import Controller.Controller;
import Model.Model;
import Model.Monomial;
import Model.Polynomial;
import Operations.PolynomialOperations;
import View.View;

import static Operations.PolynomialOperations.*;

public class Main {
    public static void main(String[] args) {
        Monomial m1 = new Monomial(-1.2, 3);
        Monomial m2 = new Monomial(2, 3);
        Monomial m3 = new Monomial(6.0, 6);
        Monomial m4 = new Monomial(2.0, 3);
        //System.out.println(m1.addMonomials(m2));
        //System.out.println(m2.subMonomials(m1));
        System.out.println(m3.divideMonomials(m2));
        //System.out.println();
        //System.out.println(m2.derivateMonomial());
        //System.out.println(m3.integrateMonomial());

        Polynomial p1 = new Polynomial();
        p1.addMonomial(m2);
        p1.addMonomial(m3);
        Polynomial p2 = new Polynomial();
        p2.addMonomial(m1);
        p2.addMonomial(m4);
        System.out.println("Degree pol1: " + p1.getDegree());
        System.out.println("Degree pol2: " + p2.getDegree());
        Polynomial res = addPolynoms(p1, p2);
        Polynomial res2 = substractPolynoms(p1, p2);
        Polynomial res3 = multiplyPolynoms(p1, p2);
        Polynomial res4 = derivativePolynom(p1);
        Polynomial res5 = derivativePolynom(p2);
        Polynomial res6 = integratePolynom(p1);
        Polynomial res7 = integratePolynom(p2);
        Polynomial[] res8 = new Polynomial[2];
        res8 = PolynomialOperations.dividePolynoms(p1, p2);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(res8[0]);
        System.out.println(res8[1]);
        //System.out.println(res3);
        //System.out.println(res4);
        //System.out.println(res5);
        //System.out.println(res6);
        //System.out.println(res7);

        Model model = new Model();
        View ui = new View(model);
        Controller controller = new Controller(ui, model);

        ui.setVisible(true);

    }
}
