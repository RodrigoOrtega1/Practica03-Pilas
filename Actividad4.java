import java.util.Arrays;

import Extras.SimpleLinkedList;

/**
 * Implementa la Actividad 4 de la Practica03
 * @author Rodrigo Ortega 318036104
 * @version 1.0 26-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Actividad4 {

    //Donde almacenaremos todas las posibles soluciones
    SimpleLinkedList<String> result = new SimpleLinkedList<>();
    
    /**
     * Genera un arreglo nxn de cadenas
     * @param n el tamano del arreglo
     * @return un arreglo nxn
     */
    public String[][] genBoard(int n){
        String[][] board = new String[n][n];
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = ".";
            }
        }
        return board;
    }

    /**
     * Checa si se puede colocar una reina en una posicion rxc del tablero
     * @param board el tablero
     * @param r filas del tablero
     * @param c columnas del tablero
     * @return true si se puede colocar una reina
     */
    public boolean canPlace(String[][] board, int r, int c){
        for(int i = 0; i < board.length; i++){
            if(board[i][c].equals("Q")){ //checamos columnas
                return false;
            } else if (r - i >= 0 && c - i >= 0 && board[r - i][c - i].equals("Q")) { // checamos diagonales
                 return false;
            } else if(r - i >= 0 && c + i <  board.length && board[r - i][c + i].equals("Q")) { //checamos diagonales   
                return false;
            }
        }
        return true;
    }

    /**
     * Resuelve recursivamente el tablero
     * @param board el tablero a resolver
     * @param r una fila
     */
    public void solve(String[][] board, int r){
        if (r == board.length){
            result.add(result.size(), Arrays.deepToString(board));
            return;
        }
        for(int col = 0; col < board.length; col++){
            if(canPlace(board, r, col)){
                board[r][col] = "Q";
                solve(board, r + 1);
                board[r][col] = ".";
            }
        }
    } 
}
