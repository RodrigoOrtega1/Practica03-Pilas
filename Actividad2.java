import java.util.Scanner;

/**
 * Implementa la Actividad 2 de la Practica03
 * @author Rodrigo Ortega 318036104
 * @version 1.0 24-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Actividad2{
    Stack<String> stack = new Stack<>();
    
    public void pushString(String string){
        int count = string.length();
        while(0 < count){
            char c = string.charAt(count - 1);
            String s = "" + c;
            this.stack.push(s);
            count--;
        }
        stack.push(Integer.toString(string.length()));
    }
    public String popString(){
        int num = Integer.parseInt(this.stack.top());
        String result = "";
        for(int i = 0; i < num; i++){
            result += this.stack.pop();
        }
        this.stack.pop();
        return result;
    }

    public static void main(String[] args){
        Actividad2 actividad2 = new Actividad2();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Insert string:");
        String input = scanner.nextLine();
        actividad2.pushString(input);
        
        System.out.println("Insert string:");
        input = scanner.nextLine();
        scanner.close();
        actividad2.pushString(input);

        actividad2.stack.show();
        
        
        System.out.println("La string es: " + actividad2.popString());
        actividad2.stack.show();
    }
}
