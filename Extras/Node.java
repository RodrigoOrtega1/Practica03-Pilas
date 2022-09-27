package Extras;
/**
 * Implementación de un Nodo
 * @author Rodrigo Ortega 318036104
 * @version 1.0 24-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Node<T> {
    T data;
    Node<T> previous;

    public Node(T data, Node<T> previous){
        this.data = data;
        this.previous = previous;
    }

    public T getData(){
        return data;
    }

    public Node<T> getPrevious(){
        return previous;
    }
}
