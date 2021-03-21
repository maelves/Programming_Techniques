package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polynomial {
    private List<Monomial> monomialList;

    public Polynomial() {
        this.monomialList = new ArrayList<>();
    }

    public List<Monomial> getMonomialList() {
        return this.monomialList;
    }

    public void addMonomial(Monomial m) {
        this.monomialList.add(m);
    }

    public void removeMonomial(Monomial m) {
        this.monomialList.remove(m);
    }

    public void arrange() {
        Collections.sort(this.monomialList);
    }

    public String toString(){
        String s = "";
        for (Monomial m: this.getMonomialList()) {
            if(this.monomialList.get(monomialList.indexOf(m)).getCoef() > 0.0 && this.monomialList.indexOf(m) != 0){
                s = s + " + " + this.monomialList.get(monomialList.indexOf(m));
            }
            else {
                s = s + " " + this.monomialList.get(monomialList.indexOf(m));
            }
        }
        return s;
    }

    public void removeRedundantlyTerms() {
        List<Monomial> list = this.monomialList;
        for(int i=0;i<list.size()-1;i++)//Scot termenii redundanti din polinom
        {
            for(int j=i+1;j<list.size();j++){
                Monomial m1=list.get(i);
                Monomial m2=list.get(j);
                if(m1.getDeg()==m2.getDeg()){
                    //list.
                    monomialList.add(new Monomial(m1.getCoef() + m2.getCoef(), m1.getDeg()));
                    monomialList.remove(m1);
                    monomialList.remove(m2);

                }
            }
        }

        this.monomialList = list;
    }

    public int getDegree()
    {
        if (this.monomialList.size() > 0) {
            return this.monomialList.get(0).getDeg();
        }

        return 0;
    }

    public Monomial getLeadTerm() {
        //Collections.sort(this.monomialList);
        if (this.monomialList.size() > 0) {
            return this.monomialList.get(0);
        }

        return null;
    }

    public boolean isZero(){
        if (monomialList.size() == 0 || (getDegree() == 0 && monomialList.get(0).getCoef() == 0)) return true;
        return false;
    }

    public void copyPolynomial(Polynomial p1){
        for (Monomial m: p1.getMonomialList()){
            Monomial copyM = new Monomial(m.getCoef(), m.getDeg());
            addMonomial(copyM);
        }
    }


}
