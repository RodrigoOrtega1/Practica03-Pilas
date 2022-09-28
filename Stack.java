import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import Extras.TDAStack;

/**
 * Implementación de un Stack con nodos
 * @author Rodrigo Ortega 318036104
 * @version 1.0 24-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Stack<T> implements TDAStack<T>{
    
    //Clase interna que representa un nodo
    private class Node<T> {
        T data;
        Node<T> previous;
    
        public Node(T data){
            this.data = data;
        }
        
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

    private Node<T> head = null; //Tope de la lista
    private int size = 0;

    public int getSize(){
        return this.size;
    }

    @Override
    public void push(T e){
        this.head = new Node<>(e, this.head);
    }

    @Override
    public T pop() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T data = this.head.getData();
        this.head = this.head.getPrevious();
        size--;
        return data;
    }
    
    @Override
    public T top() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return this.head.getData();
    }
    
    @Override
    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public void clear(){
        this.head = null;
    }

    /** 
     * Clase interna para implementar el iterador en un Stack
     */
    public class StackIterator implements Iterator<T>{

        private Node<T> current = head;

        /**
         * Verifica si el Node que lo manda a llamar tiene un siguiente
         * @return True si tiene siguiente, False en otro caso
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Accede al Node siguiente
         * @return el siguiente Node
         */
        public T next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            T temp = current.getData();
            current = current.getPrevious();
            return temp;
        }
    }

    @Override
    public void show(){
        Iterator<T> iterator = new StackIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
