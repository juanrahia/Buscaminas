/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.utiles;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan
 */
public class LectorProperties {
    //Variable para el archivo de propiedades
    final private String file = "properties.properties";    
    //Variables para las propiedades;
    public String nombrePrincipiante;
    public String nombreIntermedio;
    public String nombreAvanzado;
    public long tiempoPrincipiante;
    public long tiempoIntermedio;
    public long tiempoAvanzado;
    public String idioma;
    //Objeto properties
    Properties properties = new Properties();
    //Constructor
    public LectorProperties(){
        try {
            properties.load(new FileReader(file));
        } catch (IOException ex) {
            Logger.getLogger(LectorProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Getter y setter
    public String getNombrePrincipiante() {
        nombrePrincipiante = properties.getProperty("nombre_principiante");
        return nombrePrincipiante;
    }

    public void setNombrePrincipiante(String nombrePrincipiante) {
        this.nombrePrincipiante = nombrePrincipiante;
        properties.setProperty("nombre_principiante", nombrePrincipiante);
    }

    public String getNombreIntermedio() {
        nombreIntermedio = properties.getProperty("nombre_intermedio");
        return nombreIntermedio;
    }

    public void setNombreIntermedio(String nombreIntermedio) {
        this.nombreIntermedio = nombreIntermedio;
        properties.setProperty("nombre_intermedio", nombreIntermedio);
    }

    public String getNombreAvanzado() {
        nombreAvanzado = properties.getProperty("nombre_avanzado");
        return nombreAvanzado;
    }

    public void setNombreAvanzado(String nombreAvanzado) {
        this.nombreAvanzado = nombreAvanzado;
        properties.setProperty("nombre_avanzado", nombreAvanzado);
    }

    public long getTiempoPrincipiante() {
        tiempoPrincipiante = Long.valueOf(properties.getProperty("tiempo_principiante"));
        return tiempoPrincipiante;
    }

    public void setTiempoPrincipiante(long tiempoPrincipiante) {
        this.tiempoPrincipiante = tiempoPrincipiante;
        properties.setProperty("tiempo_principiante", String.valueOf(tiempoPrincipiante));
    }

    public long getTiempoIntermedio() {
        tiempoIntermedio = Long.valueOf(properties.getProperty("tiempo_intermedio"));
        return tiempoIntermedio;
    }

    public void setTiempoIntermedio(long tiempoIntermedio) {
        this.tiempoIntermedio = tiempoIntermedio;
        properties.setProperty("tiempo_intermedio", String.valueOf(tiempoIntermedio));
    }

    public long getTiempoAvanzado() {
        tiempoAvanzado = Long.valueOf(properties.getProperty("tiempo_avanzado"));
        return tiempoAvanzado;
    }

    public void setTiempoAvanzado(long tiempoAvanzado) {
        this.tiempoAvanzado = tiempoAvanzado;
        properties.setProperty("tiempo_avanzado", String.valueOf(tiempoAvanzado));
    }

    public String getIdioma() {
        this.idioma = properties.getProperty("idioma");
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
        properties.setProperty("idioma", idioma);
    }
    
    
    //Guardar el archivo propiedades
    public void storeProperties(){
        try {
            properties.store(new BufferedWriter(new FileWriter(file)), Calendar.getInstance().getTime().toString());
        } catch (IOException ex) {
            Logger.getLogger(LectorProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
