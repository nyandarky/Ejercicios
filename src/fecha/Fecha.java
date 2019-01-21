/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author 203p21
 */
public class Fecha {
    
    private int dia;
    private int mes;
    private int anno;
    Mes[] meses;
    
    public Fecha() {
        meses = new Mes[]{new Mes(31, "enero"),
            new Mes(28, "febrero"),
            new Mes(31, "marzo"),
            new Mes(30, "abril"),
            new Mes(31, "mayo"),
            new Mes(30, "junio"),
            new Mes(31, "julio"),
            new Mes(31, "agosto"),
            new Mes(30, "septiembre"),
            new Mes(31, "octubre"),
            new Mes(30, "noviembre"),
            new Mes(31, "diciembre")};
        
    }
    
    public Fecha(int dia, int mes, int anno) {
        this.dia = dia;
        this.mes = mes;
        this.anno = anno;
        meses = new Mes[]{new Mes(31, "enero"),
            new Mes(28, "febrero"),
            new Mes(31, "marzo"),
            new Mes(30, "abril"),
            new Mes(31, "mayo"),
            new Mes(30, "junio"),
            new Mes(31, "julio"),
            new Mes(31, "agosto"),
            new Mes(30, "septiembre"),
            new Mes(31, "octubre"),
            new Mes(30, "noviembre"),
            new Mes(31, "diciembre")};
    }
    
    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getAnno() {
        return anno;
    }
    
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    public String fechaCompleta() {
        return dia + "/" + mes + "/" + anno;
        
    }
    
    public String fechaCompletaLetra() {
        return dia + "/" + meses[mes - 1].getNombre() + "/" + anno;
        
    }
    
    public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            meses[1].setDiasMes(29);
        } else {
            meses[1].setDiasMes(28);
        }
    }
    
    public boolean comprobar(String dato) {
        boolean correcto = false;
        String[] resultado = dato.split("/");
        if (resultado.length == 3) {
            try {
                dia = Integer.parseInt(resultado[0]);
                mes = Integer.parseInt(resultado[1]);
                anno = Integer.parseInt(resultado[2]);
                if (anno > 1000 && anno < 3000) {
                    if (mes > 0 && mes < 13) {
                        bisiesto();
                        if (dia >= 1 && dia <= meses[mes - 1].getDiasMes()) {
                            correcto = true;
                        }
                    }
                }
            } catch (NumberFormatException es) {
            }
        }
        return correcto;
    }
    
    public int calculoOrden() {
        int orden = 0;
        bisiesto();
        for (int m = 1; m < mes; m++) {
            orden = orden + meses[m - 1].getDiasMes();
        }
        orden = orden + dia;
        return orden;
    }
    
    public Fecha calcularVencimiento(int diasVencimiento) {
        Fecha fven = new Fecha(dia, mes, anno);
        //  fven.setDia(fven.getDia()+diasVencimiento);
        fven.dia = fven.dia + diasVencimiento;
        while ( fven.getDia()> meses[fven.getMes() - 1].getDiasMes()) {
            fven.setDia(fven.getDia() - meses[fven.getMes() - 1].getDiasMes());
            fven.setMes(fven.getMes() + 1);
            if (fven.getMes() > 12) {
                bisiesto();
                fven.setAnno(fven.getAnno() + 1);
                fven.setMes(1);
            }
            
        }
        return fven;
    }
    
}
