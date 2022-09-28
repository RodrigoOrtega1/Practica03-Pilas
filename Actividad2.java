/**
 * Implementa la Actividad 2 de la Practica03
 * @author Rodrigo Ortega 318036104
 * @version 1.0 24-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Actividad2{
    Stack<String> stack = new Stack<>(); //Donde se almacenan los caracteres
    
    /**
     * Mete todos los caracteres de una cadena a una pila
     * @param string la cadena a meter a la pila
     */
    public void pushString(String string){
        int count = string.length();
        while(count > 0){
            char c = string.charAt(count - 1);
            String s = "" + c;
            this.stack.push(s);
            count--;
        }
        stack.push(Integer.toString(string.length()));
    }

    /**
     * Saca la primer cadena registrada en la pila
     * @return una cadena
     */
    public String popString(){
        int num = Integer.parseInt(this.stack.pop());
        String result = "";
        for(int i = 0; i < num; i++){
            result += this.stack.pop();
        }
        return result;
    }
}
