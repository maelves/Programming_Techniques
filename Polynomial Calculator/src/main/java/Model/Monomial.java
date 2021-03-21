package Model;

public class Monomial implements Comparable {
    private double coef;
    private int deg;

    public Monomial(double coef, int deg) {
        this.coef = coef;
        this.deg = deg;
    }

    public Monomial() {
        this.coef = 0.0;
        this.deg = 0;
    }

    public double getCoef() {
        return coef;
    }

    public int getDeg() {
        return deg;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return this.coef + "x^" + this.deg;
    }


    @Override
    public int compareTo(Object o) {
        Monomial monomial = (Monomial) o;
        return monomial.deg - this.deg;
    }

    public Monomial addMonomials(Monomial m) {
        if (deg == m.getDeg()) {
            Monomial result = new Monomial(coef + m.getCoef(), deg);
            return result;
        }
        return null;
    }

    public Monomial subMonomials(Monomial m) {
        if (this.deg == m.getDeg()) {
            return new Monomial(this.coef - m.getCoef(), this.deg);
        } else if(this.deg == 0)
            return new Monomial(-1.0 * m.getCoef(), this.deg);
        return null;
    }

    public Monomial multiplyMonomials(Monomial m) {
        return new Monomial(this.coef * m.getCoef(), this.deg + m.getDeg());
    }

    public Monomial divideMonomials(Monomial m) {
        if (this.deg >= m.getDeg()) {
            return new Monomial(this.coef / m.getCoef(), this.deg - m.getDeg());
        }
        return null;
    }

    public Monomial derivateMonomial() {
        if (this.deg >= 1) {
            return new Monomial(this.coef * this.deg, this.deg - 1);
        }
        return null;
    }

    public Monomial integrateMonomial() {
        return new Monomial(this.coef / (this.deg + 1), this.deg + 1);
    }
}

