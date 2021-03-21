import Model.Monomial;
import Model.Polynomial;
import Operations.PolynomialOperations;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static Operations.PolynomialOperations.*;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class TestFile {
    @Test

    public void testAddition(){
        Polynomial result = new Polynomial();
        result.addMonomial(new Monomial(10, 2));
        result.addMonomial(new Monomial(10, 3));

        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(7, 3));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(10, 2));
        p2.addMonomial(new Monomial(3, 1));

        assertNotSame(result, addPolynoms(p1, p2));
    }

    @Test
    public void testSubstraction(){
        Polynomial p_expected = new Polynomial();
        p_expected.addMonomial(new Monomial(12, 3));
        p_expected.addMonomial(new Monomial(-2, 2));
        p_expected.addMonomial(new Monomial(-2, 1));

        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(7, 3));
        p1.addMonomial(new Monomial(-2, 2));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(2, 1));
        p2.addMonomial(new Monomial(-5, 3));

        assertNotSame(p_expected, substractPolynoms(p1, p2));
    }

    @Test
    public void testMultiply(){
        Polynomial result = new Polynomial();
        result.addMonomial(new Monomial(4, 6));
        result.addMonomial(new Monomial(6, 3));

        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(2, 2));
        p1.addMonomial(new Monomial(5, 1));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(2, 4));
        p2.addMonomial(new Monomial(3, 1));

        assertNotSame(result, multiplyPolynoms(p1, p2));
    }

    @Test
    public void testDerivate(){
        Polynomial result = new Polynomial();
        result.addMonomial(new Monomial(3, 1));
        result.addMonomial(new Monomial(50, 10));

        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(1, 2));
        p1.addMonomial(new Monomial(5, 10));


        assertNotSame(result, derivativePolynom(p1));
    }

    @Test
    public void testIntegrate(){
        Polynomial result = new Polynomial();
        result.addMonomial(new Monomial(3.56, 1));
        result.addMonomial(new Monomial(-5, 10));

        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(1, 2));
        p1.addMonomial(new Monomial(5, 10));


        assertNotSame(result, integratePolynom(p1));
    }

    @Test
    public void testDivide(){
        Polynomial result = new Polynomial();
        result.addMonomial(new Monomial(4, 6));
        result.addMonomial(new Monomial(6, 3));

        Polynomial p1 = new Polynomial();
        p1.addMonomial(new Monomial(2, 2));
        p1.addMonomial(new Monomial(5, 1));

        Polynomial p2 = new Polynomial();
        p2.addMonomial(new Monomial(2, 4));
        p2.addMonomial(new Monomial(3, 1));

        assertNotSame(result, dividePolynoms(p1, p2));
    }
}
