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
 *
 * @author Andres
 */
public class Bepto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

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
            int band = 0;
            int band1 = 0;

            while ((linea = reader.readLine()) != null) {
                int a = 0;
                /*if (linea.equals(line)) {
                    if (band == 0) {
                        band++;
                    } else {
                        break;
                    }
                } else if (linea.contains(delimitante)) {
                    if(band1==0){
                        band1=1;
                        continue;
                    }
                    campo = linea.split(delimitante);
                    for (String data : campo) {
                        System.out.print(data + " " + a + " ");
                        a++;
                    }
                    System.out.println("");
                } else if (linea.toLowerCase().contains("route")) {
                    campo = linea.split(" ");
                    ruta.setId(Integer.parseInt(campo[4]));
                }*/

                if(linea.toLowerCase().contains("route")){
                    campo = linea.split(" ");
                    Rutas temp = new Rutas();
                    temp.setId(Integer.parseInt(campo[4]));
                    rutasList.add(new Node<Rutas>(temp));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        rutasList.print();
        System.out.println(rutasList.getSize());
    }

}
