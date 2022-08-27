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
        String delimitante = ";";
        List<Rutas> rutasList = new List<Rutas>();
        String line = "****************************************************************";

        try {

            String filePath = path.toString();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);

            String[] campo;

            Rutas rutaTemp = new Rutas();
            Arco arcoTemp;
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
                    break;
                } else if (linea.contains(";")){

                    /*if(linea.contains("Arc")){
                        linea = reader.readLine();
                    }

                    campo = linea.split(";");*/



                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        rutasArray = rutasList.toArrayRutas();
        for (Rutas one : rutasArray) {
            System.out.println("Id de la ruta --> " + one.getId());

            for (Arco two : one.getArco()) {
                System.out.println(two.getId());
            }

        }


    }

}
