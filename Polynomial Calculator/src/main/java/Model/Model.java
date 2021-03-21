package Model;

public class Model {
    private Polynomial p1, p2;
    private Polynomial result;
    private Polynomial remain;

    public Model(){
        p1 = new Polynomial();
        p2 = new Polynomial();
        result = new Polynomial();
        remain = new Polynomial();
    }

    public Polynomial getP1() {
        return p1;
    }

    public void setP1(Polynomial p1) {
        this.p1 = p1;
    }

    public Polynomial getP2() {
        return p2;
    }

    public void setP2(Polynomial p2) {
        this.p2 = p2;
    }

    public Polynomial getResult() {
        return result;
    }

    public Polynomial getRemain() {
        return remain;
    }

    public void setResult(Polynomial result) {
        this.result = result;
    }

    public void setRemain(Polynomial remain) {
        this.remain = remain;
    }

    public void reset(){
        p1 = new Polynomial();
        p2 = new Polynomial();
        result = new Polynomial();
    }
}

