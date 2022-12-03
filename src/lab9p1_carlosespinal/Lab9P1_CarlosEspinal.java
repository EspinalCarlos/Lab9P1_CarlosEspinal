
package lab9p1_carlosespinal;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab9P1_CarlosEspinal {
    static Scanner read = new Scanner(System.in);
    static Random rand = new Random();
    static Game g = new Game();
    
    public static int menu() {
        int opcion = 0;
        System.out.println("  Menu de Opciones  \n\n");
        System.out.println("Opcion 1: The Game of Life");
        System.out.println("Opcion 2: SALIDA\n\n");
        System.out.println("Ingrese la opcion con la que desea trabajar: ");
        opcion = read.nextInt();
        
        return opcion;
        
    }
    
    public static int[][] fillMatriz(int[][] Tablero, int[][]TableroNew, ArrayList<String> list) {
        for(int i = 0; i < Tablero.length; i++) {
            for (int j = 0; j < Tablero[i].length;j++) {
                if (i == 0|| j == 0|| i == Tablero.length - 1|| j == Tablero.length - 1) {
                    Tablero[i][j] = 0;
                }
                else {
                    Tablero[i][j] += rand.nextInt(2);
                    if (Tablero[i][j] == 1) {
                        list.add(Integer.toString(i)+":"+Integer.toString(j));
                    } 
                    
                }
                
            }
        }
        g.setCoords(list);
        return Tablero;
    }
    
    public static String imprimir(int[][] numeros) {
        String cadena = "";
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
                cadena += "["+numeros[i][j]+"]";
            }
            cadena += "\n";
        }
        return cadena;
    } 

    public static void main(String[] args) {
        int opcion = menu();
        
            switch (opcion) {
                case 1:
                    
                    System.out.println("Ingrese el numero de rondas: ");
                    int rond = read.nextInt();
                    
                    int[][] tab = new int[10][10];
                    int[][] tabnew = new int[10][10];
                    ArrayList<String> list = new ArrayList<>(); 
                    
                    tab = fillMatriz(tab,tabnew, list);
                    g.setInitMatriz(tab);
                    g.setMatriznew(tabnew);
                    g.setRondas(rond);
                    
                    g.play(rond);
                    
                    
                    break;
            }
        
    }
    
}
