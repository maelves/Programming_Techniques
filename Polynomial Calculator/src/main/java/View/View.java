package View;

import Controller.Controller;
import Model.Model;
import Model.Polynomial;

import javax.swing.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    Model model;

    private static Polynomial p1,p2;
    private JLabel p1Label;
    private JLabel p2Label;
    private JLabel resultLabel;
    private JLabel remaintLabel;
    private JTextField polinomial1;
    private JTextField polinomial2;
    private JTextField result;
    private JTextField remain;
    private JButton addBtn = new JButton("Add");
    private JButton subtractBtn = new JButton("Substract");
    private JButton multiplyBtn = new JButton("Multiply");
    private JButton divideBtn = new JButton("Divide");
    private JButton deriveBtn = new JButton("Derive");
    private JButton integrateBtn = new JButton("Integrate");
    private JButton clearBtn = new JButton();

    public View(Model model){
        this.setTitle("Polynomial Operations");
        this.setSize(700, 400);
        this.model = model;

        p1Label = new JLabel("Polynom 1:");
        p1Label.setBounds(10, 9, 120, 30);
        getContentPane().add(p1Label);

        p2Label = new JLabel("Polynom 2:");
        p2Label.setBounds(10, 35, 120, 30);
        getContentPane().add(p2Label);

        resultLabel = new JLabel("RESULT:");
        resultLabel.setBounds(10, 63, 120, 30);
        getContentPane().add(resultLabel);

        remaintLabel = new JLabel("REMAIN:");
        remaintLabel.setBounds(10, 87, 120, 30);
        getContentPane().add(remaintLabel);

        polinomial1 = new JTextField();
        polinomial1.setBounds(88, 8, 170, 30);
        getContentPane().add(polinomial1);

        polinomial2 = new JTextField();
        polinomial2.setBounds(88, 33, 170, 30);
        getContentPane().add(polinomial2);

        result = new JTextField();
        result.setEditable(false);
        result.setBounds(88, 60, 250, 30);
        getContentPane().add(result);

        remain = new JTextField();
        remain.setEditable(false);
        remain.setBounds(88, 87, 250, 30);
        getContentPane().add(remain);

        addBtn.setBounds(450, 7, 75, 20);
        getContentPane().add(addBtn);

        subtractBtn.setBounds(450, 32, 75, 20);
        getContentPane().add(subtractBtn);

        multiplyBtn.setBounds(450, 57, 75, 20);
        getContentPane().add(multiplyBtn);

        divideBtn.setBounds(450, 82, 75, 20);
        getContentPane().add(divideBtn);

        deriveBtn.setBounds(450, 107, 75, 20);
        getContentPane().add(deriveBtn);

        integrateBtn.setBounds(450, 132, 75, 20);
        getContentPane().add(integrateBtn);

        clearBtn.setBounds(450, 132, 75, 20);
        getContentPane().add(clearBtn);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static Polynomial getP1() {
        return p1;
    }

    public static Polynomial getP2() {
        return p2;
    }

    public JLabel getP1Label() {
        return p1Label;
    }

    public JLabel getP2Label() {
        return p2Label;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JTextField getPolinomial1() {
        return polinomial1;
    }

    public JTextField getPolinomial2() {
        return polinomial2;
    }

    public JTextField getResult() {
        return result;
    }

    public static void setP1(Polynomial p1) {
        View.p1 = p1;
    }

    public static void setP2(Polynomial p2) {
        View.p2 = p2;
    }

    public void setP1Label(JLabel p1Label) {
        this.p1Label = p1Label;
    }

    public void setP2Label(JLabel p2Label) {
        this.p2Label = p2Label;
    }

    public void setResultLabel(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public void setPolinomial1(JTextField polinomial1) {
        this.polinomial1 = polinomial1;
    }

    public void setPolinomial2(JTextField polinomial2) {
        this.polinomial2 = polinomial2;
    }

    public void setResult(String rez){
        result.setText(rez);
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getSubtractBtn() {
        return subtractBtn;
    }

    public JButton getMultiplyBtn() {
        return multiplyBtn;
    }

    public JButton getDivideBtn() {
        return divideBtn;
    }

    public JButton getDeriveBtn() {
        return deriveBtn;
    }

    public JButton getIntegrateBtn() {
        return integrateBtn;
    }

    public JButton getClearBtn() {
        return clearBtn;
    }

    public JLabel getRemaintLabel() {
        return remaintLabel;
    }

    public JTextField getRemain() {
        return remain;
    }

    public void addListenerAddBtn(ActionListener e) {
        addBtn.addActionListener(e);
    }

    public void addListenerSubstractBtn(ActionListener e) {
        subtractBtn.addActionListener(e);
    }

    public void addListenerMultiplyBtn(ActionListener e) {
        multiplyBtn.addActionListener(e);
    }

    public void addListenerDivideBtn(ActionListener e) {
        divideBtn.addActionListener(e);
    }

    public void addListenerDeriveBtn(ActionListener e) {
        deriveBtn.addActionListener(e);
    }

    public void addListenerIntegrateBtn(ActionListener e) {
        integrateBtn.addActionListener(e);
    }
}
