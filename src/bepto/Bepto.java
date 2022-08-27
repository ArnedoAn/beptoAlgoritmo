/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bepto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import List.*;

/**
 * @author Andres
 */
public class Bepto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Rutas[] rutasArray;
        Path path = Paths.get("src/File/2S_FSJ.b2pFloorMapReport.txt");
        String linea = "";
        List<Rutas> rutasList = new List<Rutas>();
        String line = "****************************************************************";

        try {

            String filePath = path.toString();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);

            String[] campo;

            Rutas rutaTemp = new Rutas();
            Arco arcoTemp;
            Nodo nodoTemp;
            int band = 0;

            while ((linea = reader.readLine()) != null) {

                if (linea.toLowerCase().contains("route")) { //Guardar Id de la ruta

                    campo = linea.split(" ");

                    rutaTemp.setId(Integer.parseInt(campo[4]));

                } else if (linea.toLowerCase().contains("iroom2supersource")) { //Guardar arcos

                    linea = linea.replace("IRoom2SuperSource", "");
                    linea = linea.replace("*  Arcs ", "");
                    linea = linea.replace("  ", " ");

                    campo = linea.split(" ");

                    for (String data : campo) {
                        arcoTemp = new Arco();
                        arcoTemp.setId(data);
                        rutaTemp.addArco(arcoTemp);
                    }

                } else if (linea.contains("Unused Arcs")) { //Guardar arcos no usados

                    linea = linea.replace("*  Unused Arcs ", "");
                    linea = linea.replace("[", "");
                    linea = linea.replace("]", "");
                    linea = linea.replace(",", "");

                    campo = linea.split(" ");
                    for (String data : campo) {
                        arcoTemp = new Arco();
                        arcoTemp.setId(data);
                        rutaTemp.addArcoNoUse(arcoTemp);
                    }

                } else if (linea.contains("Estimated evacuation time")) { // Guardar tiempo de evacuacion estimado

                    linea = linea.replace("*  Estimated evacuation time ", "");
                    linea = linea.replace(" units of time", "");
                    linea = linea.replace(" ", "");

                    rutaTemp.setEVT(Float.parseFloat(linea));

                } else if (linea.contains("Evacuees not expossed")) { // Guardar evacuados no expuestos (?)

                    linea = linea.replace("*  Evacuees not expossed", "");
                    linea = linea.replace(" ", "");

                    rutaTemp.setENE(Integer.parseInt(linea));

                } else if (linea.contains("Solution found in")) { // Guardar tiempo de solucion

                    linea = linea.replace("*  Solution found in :", "");
                    linea = linea.replace("total CPU sec", "");
                    linea = linea.replace(" ", "");

                    rutaTemp.setTiempoSolution(Float.parseFloat(linea));

                } else if (linea.contains("PNS File")) { // Guardar PNS File
                    linea = reader.readLine();
                    linea = linea.replace("*  Input File : =", "");
                    linea = linea.replace("           Output File :=", "");

                    campo = linea.split(" ");

                    String[] temp = new String[2];
                    temp[0] = campo[1] + "KB";
                    temp[1] = campo[4] + "KB";

                    rutaTemp.setPNS(temp);

                } else if (linea.contains("Total Size of the Network")) { // Guardar Total Size of the Network

                    linea = reader.readLine();
                    linea = linea.replace("*  Material(s) : = ", "");
                    linea = linea.replace("           Operating Unit(s) := ", "");

                    campo = linea.split(" ");

                    int[] temp = new int[2];
                    temp[0] = Integer.parseInt(campo[0]);
                    temp[1] = Integer.parseInt(campo[1]);

                    rutaTemp.setTSN(temp);

                } else if (linea.contains("Inessential Material(s) & Operating Unit(s)")) { // Guardar Inessential Material(s) & Operating Unit(s)

                    linea = reader.readLine();
                    linea = linea.replace("*  Material(s) : = ", "");
                    linea = linea.replace("           Operating Unit(s) := ", "");
                    campo = linea.split(" ");

                    int[] temp = new int[2];
                    temp[0] = Integer.parseInt(campo[0]);
                    temp[1] = Integer.parseInt(campo[1]);

                    rutaTemp.setIMOU(temp);

                } else if (linea.contains("Maximal Structure ") && !linea.contains("% Reduction")) { // Guardar Maximal Structure

                    linea = reader.readLine();
                    linea = linea.replace("*  Material(s) : = ", "");
                    linea = linea.replace("           Operating Unit(s) := ", "");
                    campo = linea.split(" ");

                    int[] temp = new int[2];
                    temp[0] = Integer.parseInt(campo[0]);
                    temp[1] = Integer.parseInt(campo[1]);

                    rutaTemp.setMS(temp);

                } else if (linea.contains("Maximal Structure % Reduction ")) { // Guardar Maximal Structure % Reduction

                    linea = reader.readLine();
                    linea = linea.replace("*  Material(s) : = ", "");
                    linea = linea.replace("         Operating Unit(s) :=", "");
                    linea = linea.replace("%", "");
                    linea = linea.replace(",", ".");

                    campo = linea.split(" ");

                    double[] temp = new double[2];
                    temp[0] = Double.parseDouble(campo[0]);
                    temp[1] = Double.parseDouble(campo[1]);

                    rutaTemp.setMSR(temp);
                } else if (linea.contains(";")) { // Guardar movimientos de arcos

                    if (linea.contains("Arc")) {
                        linea = reader.readLine();
                    }

                    campo = linea.split(";");

                    arcoTemp = new Arco();

                    arcoTemp.setEAT(Double.parseDouble(campo[1]));
                    arcoTemp.setMax(Double.parseDouble(campo[2]));
                    arcoTemp.setEmta(Double.parseDouble(campo[3]));
                    arcoTemp.setBSI(Double.parseDouble(campo[4]));
                    arcoTemp.setTTP(Double.parseDouble(campo[5]));

                    int n = campo.length - 6;
                    String[] TPM = new String[n];
                    for (int i = 0; i < n; i++) {
                        TPM[i] = campo[6 + i];
                    }

                    arcoTemp.setTPM(TPM);

                } else if (linea.contains("Arc Utilization")) { // Guardar Arc Utilization

                    linea = linea.replace("Arc Utilization ", "");
                    rutaTemp.setUA(Double.parseDouble(linea));

                } else if (linea.contains("Average Time Periods for Evacuees to Evacuate Building")) { // Guardar Average Time Periods for Evacuees to Evacuate Building

                    linea = linea.replace("Average Time Periods for Evacuees to Evacuate Building ", "");
                    rutaTemp.setATPEEB(Double.parseDouble(linea));

                } else if (linea.contains("AverageEvacueesperTimePeriod")) { // Guardar AverageEvacueesperTimePeriod

                    linea = linea.replace("AverageEvacueesperTimePeriod ", "");
                    rutaTemp.setAET(Double.parseDouble(linea));

                } else if (linea.contains("Cummulative")) { // Guardar Cummulatives

                    linea = linea.replace("Cummulative ", "");
                    linea = linea.replace("%", "");

                    campo = linea.split(" ");

                    rutaTemp.addCummulative(campo);

                } else if (linea.contains("Node Clearence Time")) { // Guardar nodos

                    nodoTemp = new Nodo();
                    linea = linea.replace("Node Clearence Time ", "");
                    campo = linea.split(" ");
                    nodoTemp.setId(campo[0]);
                    nodoTemp.setPromTiempo(Double.parseDouble(campo[1]));

                    linea = reader.readLine();

                    linea = linea.replace("Average Evacuess Waiting per Time Period ", "");
                    campo = linea.split(" ");
                    nodoTemp.setTiempoVacio(Double.parseDouble(campo[1]));

                    rutaTemp.addNodo(nodoTemp);

                } else if (linea.contains(line)) { // Guardar Ruta con todos los atributos asigandos {No guarda la ultima ruta}
                    if (band == 0) {
                        band++;
                    } else {
                        rutasList.addEnd(new Node<>(rutaTemp));
                        rutaTemp = new Rutas();
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int cont = 0;
        rutasArray = rutasList.toArrayRutas();
        for (Rutas one : rutasArray) {
            System.out.println("Id de la ruta --> " + one.getId());
            cont++;
        }
        System.out.println(cont);

    }

}
