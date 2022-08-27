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
import java.util.Iterator;

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

            Rutas rutaTemp;
            Arco arcoTemp;
            int band = 0;

            while ((linea = reader.readLine()) != null) {

                rutaTemp = new Rutas();

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

                    //System.out.println(linea);
                    rutasList.add(new Node<>(rutaTemp));
                    break;
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
