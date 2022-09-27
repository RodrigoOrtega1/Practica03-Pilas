/**
 * Implementa la Actividad 5 de la Practica03
 * @author Rodrigo Ortega 318036104
 * @version 1.0 26-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Actividad5 {

    Stack<String> solution = new Stack<>(); //Donde se almacenan las soluciones

    /**
     * Checa si [row,col] es un indice valido para el laberinto o si es un camino o pared
     * @param maze el laberinto
     * @param row coordenada en las filas
     * @param col coordenada en las columnas
     * @return true si si es un indice valido
     */
    public boolean isValid(int maze[][], int row, int col){ // Si [row,col] esta fuera del laberinto y es "pared" regresa false 
        return (row >= 0 && col >= 0 && row < maze.length && col < maze.length && maze[row][col] == 0);
    }
 
    /**
     * Resuelve recursivamente un laberinto
     * @param maze el laberinto a resolver
     * @param row la fila inicial
     * @param col la columna inicial
     * @return true si es una casilla solucion, false si no lo es
     */
    public boolean solveMAux(int maze[][], int row, int col){
        if (row == maze.length - 1 && col == maze.length - 1 && maze[row][col] == 0){ //Cuando [r,c] llege a [n-1,n-1] encontramos una parte de la solucion
            solution.push("[" + row + "," + col +  "]");
            return true;
        }
        if (isValid(maze, row, col) == true){// checa que [row,col] sean validos
            solution.push("[" + row + "," + col +  "]"); // Marcamos [row,col] como una parte de la solucion
            if (solveMAux(maze, (row + 1), col)){ // Nos movemos en la fila a la derecha
                return true;
            } else if (solveMAux(maze, row, (col + 1))){ // Si movernos por las filas no es valido, nos movemos por las columnas hacia abajo
                return true;
            }
            solution.pop(); //Si ningun movimiento anterior es valido, retrocedemos
            return false;
        }
        return false;
    }

    /**
     * Manda a llamar la funcion que resuelve el laberinto usando backtracking
     * @param maze el laberito a resolver
     */
    public void solveM(int maze[][]){
        if (solveMAux(maze, 0, 0) == false) {
            System.out.print("No hay solucion");
        } 
        solution.show();
    }
}
