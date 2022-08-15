/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bepto;

/**
 *
 * @author jaug1
 */
public class Nodo {
    private String id;
    private double TiempoVacio;
    private double promTiempo;

    public Nodo(String id, double TiempoVacio, double promTiempo) {
        this.id = id;
        this.TiempoVacio = TiempoVacio;
        this.promTiempo = promTiempo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTiempoVacio() {
        return TiempoVacio;
    }

    public void setTiempoVacio(double TiempoVacio) {
        this.TiempoVacio = TiempoVacio;
    }

    public double getPromTiempo() {
        return promTiempo;
    }

    public void setPromTiempo(double promTiempo) {
        this.promTiempo = promTiempo;
    }
    
}
