/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bepto;

/**
 *
 * @author jaug1
 */
public class Rutas {
    private int id;
    private Arco[] arcos;
    private String[] arcosNoUse;
    private double tiempoSolution;
    private String[] PNS;
    private int[] TSN;
    private int[] IMOU;
    private int[] MS;
    private double[] MSR;
    private double UA; // utilizacion de arcos
    private double ATPEEB;
    private double AET;
    private Nodo[] nodos;
    //variable cumulative

    public Rutas(int id, Arco[] arcos, String[] arcosNoUse, double tiempoSolution, String[] PNS, int[] TSN, int[] IMOU, int[] MS, double[] MSR, double UA, double ATPEEB, double AET, Nodo[] nodos) {
        this.id = id;
        this.arcos = arcos;
        this.arcosNoUse = arcosNoUse;
        this.tiempoSolution = tiempoSolution;
        this.PNS = PNS;
        this.TSN = TSN;
        this.IMOU = IMOU;
        this.MS = MS;
        this.MSR = MSR;
        this.UA = UA;
        this.ATPEEB = ATPEEB;
        this.AET = AET;
        this.nodos = nodos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Arco[] getArcos() {
        return arcos;
    }

    public void setArcos(Arco[] arcos) {
        this.arcos = arcos;
    }

    public String[] getArcosNoUse() {
        return arcosNoUse;
    }

    public void setArcosNoUse(String[] arcosNoUse) {
        this.arcosNoUse = arcosNoUse;
    }

    public double getTiempoSolution() {
        return tiempoSolution;
    }

    public void setTiempoSolution(double tiempoSolution) {
        this.tiempoSolution = tiempoSolution;
    }

    public String[] getPNS() {
        return PNS;
    }

    public void setPNS(String[] PNS) {
        this.PNS = PNS;
    }

    public int[] getTSN() {
        return TSN;
    }

    public void setTSN(int[] TSN) {
        this.TSN = TSN;
    }

    public int[] getIMOU() {
        return IMOU;
    }

    public void setIMOU(int[] IMOU) {
        this.IMOU = IMOU;
    }

    public int[] getMS() {
        return MS;
    }

    public void setMS(int[] MS) {
        this.MS = MS;
    }

    public double[] getMSR() {
        return MSR;
    }

    public void setMSR(double[] MSR) {
        this.MSR = MSR;
    }

    public double getUA() {
        return UA;
    }

    public void setUA(double UA) {
        this.UA = UA;
    }

    public double getATPEEB() {
        return ATPEEB;
    }

    public void setATPEEB(double ATPEEB) {
        this.ATPEEB = ATPEEB;
    }

    public double getAET() {
        return AET;
    }

    public void setAET(double AET) {
        this.AET = AET;
    }

    public Nodo[] getNodos() {
        return nodos;
    }

    public void setNodos(Nodo[] nodos) {
        this.nodos = nodos;
    }
    
}
