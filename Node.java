package myLinkedList;
/*
* This is a Node class.
*/
public class Node<E> {
    E data;
    Node<E> next;
/*
* These are the getters and setters.
*/
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
/*
* Constructor
*/
    public Node() {
        this.data = data;
        this.next = null;
    }

}
