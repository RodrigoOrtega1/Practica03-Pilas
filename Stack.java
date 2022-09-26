import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementación de un Stack con nodos
 * @author Rodrigo Ortega 318036104
 * @version 1.0 24-9-2022
 * @since Estructuras de Datos 2023-1
 */

public class Stack<T> implements TDAStack<T>{
    
    //Tope de la lista
    Node<T> head = null;

    @Override
    public void push(T e){
        this.head = new Node<>(e, this.head);
    }

    @Override
    public T pop() throws EmptyStackException{
        if (this.head == null){
            throw new EmptyStackException();
        }
        this.head = this.head.getPrevious();
        return this.head.getData();
    }
    
    @Override
    public T top() throws EmptyStackException{
        if (this.head == null){
            throw new EmptyStackException();
        }
        return this.head.getData();
    }
    
    @Override
    public boolean isEmpty(){
        if (head == null){
            return true;
        } else {
            return false;
        }
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