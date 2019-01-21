package fecha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 203p21
 */
public class Mes {
    private int diasMes;
    private String nombre;

    public Mes(int diasMes, String nombre) {
        this.diasMes = diasMes;
        this.nombre = nombre;
    }

    public int getDiasMes() {
        return diasMes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDiasMes(int diasMes) {
        this.diasMes = diasMes;
    }
    
    
}
