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
        try {
            String filePath = path.toString();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader = new BufferedReader(fileReader);
            String[] campo;

            while ((linea = reader.readLine()) != null) {
                int a = 0;
                if (linea.contains(delimitante)) {
                    campo = linea.split(delimitante);
                    for (String data : campo) {
                        System.out.print(data + " ");
                    }
                    System.out.println("");
                } else if (linea.toLowerCase().contains("route")) {
                    campo = linea.split(" ");
                    for (String data : campo) {
                        a++;
                        System.out.println(data + " " + a);
                    }
                    break;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
