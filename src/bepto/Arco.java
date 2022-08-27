/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bepto;

/**
 * @author jaug1
 */
public class Arco {
    private String id; // Identificador
    private double EAT;
    private double max;
    private double emta; // %EvacueesMovingThroughArc
    private double BSI;
    private double TTP; // TotalTimePeriod
    private String[] TPM; // TimePeriodMoving

    public Arco(String id, double EAT, double max, double emta, double BSI, double TTP, String[] TPM) {
        this.id = id;
        this.EAT = EAT;
        this.max = max;
        this.emta = emta;
        this.BSI = BSI;
        this.TTP = TTP;
        this.TPM = TPM;
    }

    public Arco() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getEAT() {
        return EAT;
    }

    public void setEAT(double EAT) {
        this.EAT = EAT;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getEmta() {
        return emta;
    }

    public void setEmta(double emta) {
        this.emta = emta;
    }

    public double getBSI() {
        return BSI;
    }

    public void setBSI(double BSI) {
        this.BSI = BSI;
    }

    public double getTTP() {
        return TTP;
    }

    public void setTTP(double TTP) {
        this.TTP = TTP;
    }

    public String[] getTPM() {
        return TPM;
    }

    public void setTPM(String[] TPM) {
        this.TPM = TPM;
    }

    @Override
    public String toString() {
        return "Arco{" + "id=" + id + ", EAT=" + EAT + ", max=" + max + ", emta=" + emta + ", BSI=" + BSI + ", TTP=" + TTP + ", TPM=" + TPM + '}';
    }


}
