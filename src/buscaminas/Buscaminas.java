
package buscaminas;

import buscaminas.utiles.LectorProperties;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;



public class Buscaminas {
    
    //Motivos
    public static final char MINA = '@';
    public static final char VACIO = '0';
    public static final char EXPLOSION = 'X';
    public static final char PANEL = '#';
    public static final char BANDERA = '>';
    public static final char INTERROGACION = '?';
    
    //Constantes del nivel del juego
    public final int PRINCIPIANTE = 200;
    public final int INTERMEDIO = 400;
    public final int AVANZADO = 600;
    
    //Variables
    private int tamFila;
    private int tamCol;
    //Dificultad == número de minas
    private int dificultad;
    
    //Variables para el tiempo  
    public long tiempoInicial;
    public long tiempoFinal;
    public int cont = 0;
    public boolean tiempoOn = false;
    
    //Se crea el objeto LectorPropiedades que automáticamente carga los valores properties
    LectorProperties propiedades = new LectorProperties();
    
    //Posición de las minas
    public ArrayList<Point> listaPosMinas = new ArrayList();
    
    //Disposición de los motivos en el tablero al principio del juego
    char[][] tablero;
    
    //Disposición del tablero que se descubre durante el juego
    char[][] tableroTapado;
    
    //Constructor del juego
    public Buscaminas(int tamFila, int tamCol, int dificultad){
        this.tamFila = tamFila;
        this.tamCol = tamCol;
        this.dificultad = dificultad;
        //Se crea el tablero
        tablero = new char[tamFila][tamCol];
        //Se crea el mismo tablero para ser tableroTapado
        tableroTapado = new char[tamFila][tamCol];
        
        //Poner espacios en tablero y paneles en el tablero tapado
        for(int f=0; f<tamFila; f++){
            for(int c=0; c<tamCol; c++){
                tablero[f][c]=VACIO;
                tableroTapado[f][c] = PANEL;
            }
        }
        
        //Introducir las minas
        Random random = new Random();
        for(int i=0;i<dificultad;i++){
            int posFila;
            int posCol;
            do{
                posFila = random.nextInt(tamFila);
                posCol = random.nextInt(tamCol);  
            }while(tablero[posFila][posCol] == MINA);
            //Se deberian guardar las posiciones
            listaPosMinas.add(new Point(posCol,posFila));
            tablero[posFila][posCol] = MINA; 
        }
        //Colocar la numeración de las pistas
        setPistas();
    }
    
    //Colocar pistas
    public void setPistas() {
        Point posicion = null;
        for (int i = 0; i < listaPosMinas.size(); i++) {
            posicion = listaPosMinas.get(i);
            try {
                if (tablero[posicion.y - 1][posicion.x - 1] != MINA) {
                    tablero[posicion.y - 1][posicion.x - 1] += (char) 1;
                }
            } catch (Exception e) {
            }
            try {
                if (tablero[posicion.y][posicion.x - 1] != MINA) {
                    tablero[posicion.y][posicion.x - 1] += (char) 1;
                }
            } catch (Exception e) {
            }
            try {
                if (tablero[posicion.y + 1][posicion.x - 1] != MINA) {
                    tablero[posicion.y + 1][posicion.x - 1] += (char) 1;
                }
            } catch (Exception e) {
            }
            try {
                if (tablero[posicion.y - 1][posicion.x] != MINA) {
                    tablero[posicion.y - 1][posicion.x] += (char) 1;
                }
            } catch (Exception e) {
            }
            try {
                if (tablero[posicion.y + 1][posicion.x] != MINA) {
                    tablero[posicion.y + 1][posicion.x] += (char) 1;
                }
            } catch (Exception e) {
            }
            try {
                if (tablero[posicion.y - 1][posicion.x + 1] != MINA) {
                    tablero[posicion.y - 1][posicion.x + 1] += (char) 1;
                }
            } catch (Exception e) {
            }
            try {
                if (tablero[posicion.y][posicion.x + 1] != MINA) {
                    tablero[posicion.y][posicion.x + 1] += (char) 1;
                }
            } catch (Exception e) {
            }
            try {
                if (tablero[posicion.y + 1][posicion.x + 1] != MINA) {
                    tablero[posicion.y + 1][posicion.x + 1] += (char) 1;
                }
            } catch (Exception e) {
            }
        }

    }

    public int getTamFila() {
        return tamFila;
    }

    public int getTamCol() {
        return tamCol;
    }

    public int getDificultad() {
        return dificultad;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public char[][] getTableroTapado() {
        return tableroTapado;
    }
    
    //Descubrir valor de cada casilla
    public void clicCasilla(int x, int y){
        char motivo = tablero[y][x];
        switch (motivo){
                case MINA:
                    for(int i=0; i<listaPosMinas.size(); i++){
                        tableroTapado[listaPosMinas.get(i).y][listaPosMinas.get(i).x]=MINA;
                     }
                    break;
                case VACIO:
                    this.destaparEspacios(x, y);
                    break;
                default:
                    tableroTapado[y][x] = tablero[y][x];
       }                
    }
    
    //Destapar espacios
    public void destaparEspacios(int x, int y){
        //Si se ha seleccionado un espacio se destapa el espacio
        tableroTapado[y][x] = tablero[y][x];
        //Se realiza un bucle para buscar los espacios vacios colindantes
        for(int f=-1; f<2; f++){
            for(int c=-1;c<2;c++){
                try{
                char mot = tablero[y + f][x + c];
                if(mot == this.VACIO && tableroTapado[y+f][x+c] == this.PANEL){
                    tableroTapado[y+f][x+c] = mot; 
                    destaparEspacios(x+c,y+f);
                }else{
                    if(tableroTapado[y+f][x+c] != BANDERA && tableroTapado[y+f][x+c] != INTERROGACION){
                        tableroTapado[y+f][x+c] = mot;
                    }   
                }
            }
            catch(Exception e){}
            }
        }
    }
    
    //Colocar banderas
    public void colocarBandera(int x, int y){
        if(tableroTapado[y][x] != tablero[y][x]){
            char motivo = tableroTapado[y][x];
            switch(motivo){
                case PANEL:
                    tableroTapado[y][x] = BANDERA;
                    break;
                case BANDERA:
                    tableroTapado[y][x] = INTERROGACION;
                    break;
                case INTERROGACION:
                    tableroTapado[y][x] = PANEL;
                    break;
            }
        }
    
    }
    
    //Método que comprueba si se ha destapado alguna mina
    public boolean isFin(){
        for(int c=0; c<tableroTapado.length; c++){
            for(int f=0; f<tableroTapado.length; f++){
                if(tableroTapado[c][f] == MINA){
                    return true;
                }
                }
            }
        return false;
    }
    
    //Juego Ganado
    public boolean isVencedor(){
        int numBanderas = 0;
        int numPaneles = 0;
        for(int c=0; c<tableroTapado.length; c++ ){
            for(int f=0; f<tableroTapado.length;f++){
                char motivo = tableroTapado[c][f];
                if(motivo == BANDERA){
                    numBanderas++;
                }else{
                    if(motivo==PANEL){
                        numPaneles++;
                    }
                }            
            }
        }
        if(numBanderas == this.dificultad && numPaneles==0){
            return true;
        }else{
            return false;
        }
    }
    //Devolver numero banderas colocadas
    public int numBanderas(){
        int numBanderas = 0;
        for(int c=0; c<tableroTapado.length; c++ ){
            for(int f=0; f<tableroTapado.length;f++){
                char motivo = tableroTapado[c][f];
                if(motivo == BANDERA){
                    numBanderas++;
                }
            }
        }
        return numBanderas;
    }
    
    //Establecer dificultad:
//    public void setDificultad(int seleccion){
//        switch(seleccion){
//            case 0:
//                dificultad = 10;
//            break;
//            case 1:
//                dificultad = 40;
//            break;
//            case 2:
//                dificultad = 100;
//            break;
//        }
//    
//    }
    
    //Controlar tiempo
    public void ComenzarTiempo(){
    Calendar calendar = Calendar.getInstance();    
    tiempoInicial = calendar.getTimeInMillis();
    }
    
    public void TerminarTiempo(){
    Calendar calendar = Calendar.getInstance();    
    tiempoFinal = calendar.getTimeInMillis();
    }
    
    public long getTiempo(){
        long tiempoTotal = tiempoFinal - tiempoInicial;
        return tiempoTotal;
    }
    
    public void setTiempoOn(boolean empezar){
        this.tiempoOn = empezar;
    }
    
    public boolean isTiempoOn(){
        if(this.tiempoOn){
            return true;
        }else{
            return false;
        }
    }
    
    //Comprobar si se ha producido record
    public boolean isRecord(){
        switch (getDificultad()){
            case 10:
                if(propiedades.getTiempoPrincipiante()>= this.getTiempo()){
                    return true;
                }else{
                    return false;
                }
            case 40:
                if(propiedades.getTiempoIntermedio()>= this.getTiempo()){
                    return true;
                }else{
                    return false;
                }
            case 100:
                if(propiedades.getTiempoAvanzado()>= this.getTiempo()){
                    return true;
                }else{
                    return false;
                }
            default:
                return false;
        
        }
    }
    //Establecer record en properties
    public void setRecord(String nombre, long tiempo){
        if(isRecord()){
            switch(getDificultad()){
                case 10:
                    propiedades.setNombrePrincipiante(nombre);
                    propiedades.setTiempoPrincipiante(tiempo);
                    propiedades.storeProperties();
                    break;
                case 40:
                    propiedades.setNombreIntermedio(nombre);
                    propiedades.setTiempoIntermedio(tiempo);
                    propiedades.storeProperties();
                    break;
                case 100:
                    propiedades.setNombreAvanzado(nombre);
                    propiedades.setTiempoAvanzado(tiempo);
                    propiedades.storeProperties();
                    break;
            }
        }
    
    
    }
    //Mensaje de records
    public String redordToString(){
        String mensaje = "";
        mensaje += propiedades.getNombrePrincipiante()+": "+(propiedades.getTiempoPrincipiante()/1000)+"s\n";
        mensaje += propiedades.getNombreIntermedio()+": "+(propiedades.getTiempoIntermedio()/1000)+"s\n";
        mensaje += propiedades.getNombreAvanzado()+": "+(propiedades.getTiempoAvanzado()/1000)+"s";
        return mensaje;
    
    }
    
}
