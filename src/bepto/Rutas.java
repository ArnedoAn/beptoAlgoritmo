/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bepto;

import List.*;

/**
 * @author jaug1
 */
public class Rutas {
    private int id; // Identificador
    private List<Arco> arcos = new List<Arco>(); // Conjunto de arcos
    private List<Arco> arcosNoUse = new List<Arco>(); // Conjuntos de arcos no usados
    private double EVT; // Estimated evacuation time
    private int ENE; // Evacuees not expossed
    private double tiempoSolution; // Tiempo en que se encontro la solucion
    private String[] PNS; // PNS File
    private int[] TSN; // Total Size of the Network
    private int[] IMOU; // Inessential Material(s) & Operating Unit(s) (0 - Material), (1 - OU)
    private int[] MS; // Maximal Structure (0 - Material), (1 - OU)
    private double[] MSR; // Maximal Structure % Reduction (0 - Material), (1 - OU)
    private double UA; // Utilizacion de arcos
    private double ATPEEB; // Average Time Periods for Evacuees to Evacuate Building
    private double AET; // AverageEvacueesperTimePeriod
    private List<Nodo> Nodos = new List<Nodo>(); // Nodes

    private List<String[]> cummulative = new List<String[]>(); // Cummulative

    private double porcUtilizacionArcos;


    public Rutas() {

    }

    public Rutas(int id, double tiempoSolution, String[] PNS, int[] TSN, int[] IMOU, int[] MS, double[] MSR, double UA, double ATPEEB, double AET, Nodo[] nodos) {
        this.id = id;
        this.tiempoSolution = tiempoSolution;
        this.PNS = PNS;
        this.TSN = TSN;
        this.IMOU = IMOU;
        this.MS = MS;
        this.MSR = MSR;
        this.UA = UA;
        this.ATPEEB = ATPEEB;
        this.AET = AET;
    }

    public void setPorcUtilizacionArcos() {
        int sizeArcos = getArco().length;
        int sizeArcosNoUsados = getArcoNoUse().length;

        double porcentaje;
        porcentaje = (1 - (sizeArcosNoUsados / sizeArcos)) * 100;

        this.porcUtilizacionArcos = porcentaje;

    }

    public int getENE() {
        return ENE;
    }

    public void setENE(int ENE) {
        this.ENE = ENE;
    }

    public void addArcoNoUse(Arco tempoArco) {
        this.arcosNoUse.addEnd(new Node<Arco>(tempoArco));
    }

    public Arco[] getArcoNoUse() {
        return this.arcosNoUse.toArrayArco();
    }

    public void addNodo(Nodo tempNodo) {
        this.Nodos.addEnd(new Node<Nodo>(tempNodo));
    }

    public Nodo[] getNod() {
        return this.Nodos.toArrayNodo();
    }

    public void addArco(Arco tempArco) {
        this.arcos.addEnd(new Node<>(tempArco));
    }

    public Arco[] getArco() {
        return this.arcos.toArrayArco();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setEVT(double EVT) {
        this.EVT = EVT;
    }

    public double getEVT() {
        return this.EVT;
    }
}




