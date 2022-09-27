/**
 * Implementa la Actividad 5 de la Practica03
 * @author Rodrigo Ortega 318036104
 * @version 1.0 26-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Actividad5 {
    /* // Size of the maze
    static int maze.length; */
    Stack<String> solution = new Stack<>();

    /* A utility function to print solution matrix sol[maze.length][maze.length] */
    /* void printSolution(int sol[][])
    {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++)
                System.out.print(
                    " " + sol[i][j] + " ");
            System.out.println();
        }
    } */
 
    /* A utility function to check if x, y is valid index for maze.length*maze.length maze */
    boolean isSafe(int maze[][], int x, int y){
        // if (x, y outside maze) return false
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 0   );
    }
 
    /* This function solves the Maze problem using
    Backtracking. It mainly uses solveMazeUtil()
    to solve the problem. It returns false if no
    path is possible, otherwise return true and
    prints the path in the form of 1s. Please note
    that there may be more than one solutions, this
    function prints one of the feasible solutions.*/
    boolean solveMaze(int maze[][])
    {
        int sol[][] = new int[maze.length][maze.length];
 
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }
        
        solution.show();
        //printSolution(sol);
        return true;
    }
 
    /* A recursive utility function to solve Maze problem */
    boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]){
        // if (x, y is goal) return true
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 0){
            solution.push("[" + x + "," + y +  "]");
            //sol[x][y] = 1;
            return true;
        }
        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true){
            // Check if the current block is already part of solution path.   
            if (sol[x][y] == 1)
              return false;
           
            // mark x, y as part of solution path
            //sol[x][y] = 1;
            sol[x][y] = 0;
            solution.push("[" + x + "," + y +  "]");
 
            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;
 
            /* If moving in x direction doesn't give solution then Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
 
            /* If none of the above movements works then BACKTRACK: unmark x, y as part of solution path */
            sol[x][y] = 1;
            solution.pop();
            //sol[x][y] = 0;
            return false;
        }
        return false;
    }
 
    public static void main(String args[])
    {
        Actividad5 actividad5 = new Actividad5();
        int maze[][] = {{0, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 0, 0, 0},
                        {1, 1, 1, 0}};
 
        //maze.length = maze.length;
        actividad5.solveMaze(maze);
    }
}
