package lab9p1_carlosespinal;

import java.util.ArrayList;

public class Game {

    int[][] InitMatriz = new int[10][10];
    int[][] Matriznew = new int[10][10];
    ArrayList<String> coords = new ArrayList<>();

    int rondas = 0;

    public Game() {
    }

    public int[][] getInitMatriz() {
        return InitMatriz;
    }

    public void setInitMatriz(int[][] InitMatriz) {
        this.InitMatriz = InitMatriz;
    }

    public int[][] getMatriznew() {
        return Matriznew;
    }

    public void setMatriznew(int[][] Matriznew) {
        this.Matriznew = Matriznew;
    }

    public ArrayList<String> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<String> coords) {
        this.coords = coords;
    }

    public int getRondas() {
        return rondas;
    }

    public void setRondas(int rondas) {
        this.rondas = rondas;
    }



    public void print(ArrayList<String> lista) {
        int[][] temp = new int[10][10];
        String outp = "";
        for (int i = 0; i < lista.size(); i++) {
            String[] coord = lista.get(i).split(":");
            temp[Integer.parseInt(coord[0])][Integer.parseInt(coord[1])] = 1;
        }
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 10; k++) {
                outp += "[" + temp[j][k] + "]";
            }
            outp += "\n";
        }
        System.out.println(coords);
        System.out.println(outp);

    }

    public void nextGen() {
        coords.clear();
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (InitMatriz[i][j] == 1 && getnumvecinos(i, j) < 2) {
                    Matriznew[i][j] = 0;
                } else if (InitMatriz[i][j] == 1 && getnumvecinos(i, j) > 3) {
                    Matriznew[i][j] = 0;
                } else if (InitMatriz[i][j] == 0 && getnumvecinos(i, j) == 3) {
                    Matriznew[i][j] = 1;

                } else {
                    Matriznew[i][j] = 1;
                }
                if (Matriznew[i][j] == 1) {
                    coords.add(Integer.toString(i) + ":" + Integer.toString(j));
                }
            }
        }
        InitMatriz = Matriznew;
        Matriznew = new int[10][10];
        
    }

    public int getnumvecinos(int i, int j) {
        int conta = 0;

        for (int k = -1; k <= 1; k++) {
            if (i + k > -1 && i + k < 10 && j - 1 > -1) {
                if (InitMatriz[i + k][j - 1] == 1 ) {
                    conta++;
                }

            } else if (i + k > -1 && i + k < 10 && j + 1 < 10) {
                if (InitMatriz[i + k][j + 1] == 1 ) {
                    conta++;
                }
            } 

        }
        if(InitMatriz[i-1][j] == 1 && i - 1 > -1) {
            conta++;
        }
        if(InitMatriz[i+1][j]==1 && i + 1 < 10) {
            conta++;
        }

        return conta;
    }

    public void play(int rondas) {
        for (int i = 0; i < rondas; i++) {
            print(coords);
            nextGen();
            System.out.println("");
            System.out.println("");
        }

    }

}
