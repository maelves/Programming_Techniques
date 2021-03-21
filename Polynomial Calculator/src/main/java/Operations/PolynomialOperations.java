package Operations;

import Model.Monomial;
import Model.Polynomial;
import java.util.ArrayList;
import java.util.List;

public class PolynomialOperations {

    public PolynomialOperations() {
    }

    public static Polynomial addPolynoms(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();

        for (Monomial m: p1.getMonomialList()) {
            result.addMonomial(new Monomial(m.getCoef(), m.getDeg()));
        }

        for (Monomial m2: p2.getMonomialList()){
            boolean found = false;
            for (Monomial m: result.getMonomialList()){
                if (m2.getDeg() == m.getDeg()){
                    m.setCoef(m.getCoef() + m2.getCoef());
                    //m.addMonomials(m2);
                    found = true;
                }
            }
            if (!found) {
                result.addMonomial(new Monomial(m2.getCoef(), m2.getDeg()));
            }
        }

        result.arrange();
        return result;
    }

    public static Polynomial substractPolynoms(Polynomial p1, Polynomial p2){
        Polynomial result = new Polynomial();

        for (Monomial m: p1.getMonomialList()) {
            result.addMonomial(new Monomial(m.getCoef(), m.getDeg()));
        }

        for (Monomial m2: p2.getMonomialList()){
            boolean found = false;
            for (Monomial m: result.getMonomialList()){
                if (m.getDeg() == m2.getDeg()){
                    m.setCoef(m.getCoef() - m2.getCoef());
                    found = true;
                }
            }
            if (!found) {
                result.addMonomial(new Monomial(-m2.getCoef(), m2.getDeg()));
            }
        }

        result.arrange();
        return result;

    }

    public static Polynomial multiplyPolynoms(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();

        for (Monomial m1 : p1.getMonomialList()){
            for (Monomial m2 : p2.getMonomialList()) {
                boolean found = false;
                for (Monomial m : result.getMonomialList())
                    if (m1.getDeg() == (m1.getDeg() + m2.getDeg())) {
                        m.setCoef(m.getCoef() + m1.getCoef() * m2.getCoef());
                        found = true;
                    }
                if (!found)
                    result.addMonomial(new Monomial(m1.getCoef() * m2.getCoef(), m1.getDeg() + m2.getDeg()));
            }
        }
        result.arrange();
        return result;
    }

    public static Polynomial derivativePolynom(Polynomial p){
        Polynomial result = new Polynomial();

        for (Monomial m: p.getMonomialList()){
            if (m.getDeg() != 0){
                result.addMonomial(new Monomial(m.getCoef() * m.getDeg(), m.getDeg() - 1));
            }
        }
        return result;
    }

    public static Polynomial integratePolynom(Polynomial p){
        Polynomial result = new Polynomial();

        for (Monomial m: p.getMonomialList()){
            result.addMonomial(new Monomial(m.getCoef() / (m.getDeg() + 1), m.getDeg() + 1));
        }
        return result;
    }

    public static Polynomial[] dividePolynoms(Polynomial p1, Polynomial p2) {
        Polynomial result[] = new Polynomial[2];
        if(p2.getMonomialList().size()==0){//Daca p2 este 0
            result[0]=p1;
            result[1]=null;
            return result;
        }

        if(p1.getMonomialList().size()==0){//Daca p1 este nul
            result[0]=null;
            result[1]=p2;
            return result;
        }

        p1.arrange();//Aranjez coeficientii lui p1 dupa grad
        p2.arrange();//Aranjez coeficientii lui p2 dupa grad
        p1.removeRedundantlyTerms();//Scot termenii redundanti din p1
        p2.removeRedundantlyTerms();//Scot termenii redundanti din p1
        result[0] = new Polynomial();
        result[1] = new Polynomial();
        //System.out.println(result[1].getDegree() + " hjhjhjh");

        while (p1.getDegree() >= p2.getDegree()) {
            Monomial m1 = p1.getLeadTerm();
            if(m1.getCoef()==0.0){//Daca coeficientul termenului din fata e 0, atunci il scot din lista si continui iteratia
                p1.getMonomialList().remove(m1);
                continue;
            }
            Monomial m2 = p2.getLeadTerm();
            Monomial r = m1.divideMonomials(m2);

            Polynomial buff = new Polynomial();

            for (Monomial m : p2.getMonomialList()) {
                buff.addMonomial(r.multiplyMonomials(m));
            }

            p1 = PolynomialOperations.substractPolynoms(p1, buff);

            result[0].addMonomial(r);

            if (p1.getDegree() == p2.getDegree() && p1.getDegree() == 0) {
                break;
            }
        }

        result[1] = p1;
        result[0].arrange();
        result[1].arrange();
        return result;
    }

}
