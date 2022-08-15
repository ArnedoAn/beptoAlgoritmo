/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bepto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Andres
 */
public class Bepto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String linea="";
        String delimitante=";";
        try{
            String filePath="C:\\Users\\jaug1\\Downloads\\2S_FSJ.b2pFloorMapReport.txt";
            FileReader fileReader = new FileReader(filePath);
            BufferedReader reader= new BufferedReader(fileReader);
            String[] campo;
            
            while((linea=reader.readLine())!=null){
                if(linea.contains(delimitante)){
                    campo=linea.split(delimitante);
                    for(String data: campo){
                    System.out.print(data+" ");
                }
                    System.out.println("");
                }
                
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
