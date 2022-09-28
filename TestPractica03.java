import java.util.EmptyStackException;
import java.util.Scanner;

/**
 * Prueba las actividades de la Practica 03
 * @author Rodrigo Ortega 318036104
 * @version 1.0 Septiembre 2022.
 * @since Estructuras de datos 2023-1.
 */
public class TestPractica03 {
  
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    Actividad2 act2 = new Actividad2();
    Actividad4 act4 = new Actividad4();
    Actividad5 act5 = new Actividad5();
    
    // Actividad 1
    System.out.println("-- ACTIVIDAD 1 --");
    try {
      System.out.println("El tope es " + stack.top());
    } catch (EmptyStackException e) {
      System.out.println("La pila esta vacia");
    }

    stack.push("Buho");
    stack.push("Pinguino");
    stack.push("Gato");
    stack.push("Oso");
    stack.push("Gallo");

    stack.show();

    System.out.println("El tope es " + stack.top());

    stack.pop();

    stack.show();

    stack.clear();

    System.err.println("La pila es vacia: " + stack.isEmpty());

    stack.show();

    //Actividad 2
    System.out.println("\n -- ACTIVIDAD 2 --");
    Scanner scanner = new Scanner(System.in);
      
    System.out.println("Insert string:");
    String input = scanner.nextLine();
    act2.pushString(input);

    System.out.println("Insert string:");
    input = scanner.nextLine();
    act2.pushString(input);

    System.out.println("Insert string:");
    input = scanner.nextLine();
    act2.pushString(input);

    scanner.close();
    System.out.println("La string es: " + act2.popString());
    System.out.println("La string es: " + act2.popString());
    System.out.println("La string es: " + act2.popString());
    System.out.println("La string es: " + act2.popString());

    //Actividad 4
    System.out.println("\n -- ACTIVIDAD 4 --");
    String[][] board = act4.genBoard(4);
    act4.solve(board, 0);
    System.out.println(act4.result);

    //Actividad 5
    System.out.println("\n -- ACTIVIDAD 5 --");
      int maze[][] = {{0, 0, 0, 0},
                      {1, 1, 0, 1},
                      {0, 0, 0, 0},
                      {1, 1, 0, 0}};

      act5.solveM(maze);
  }
}
