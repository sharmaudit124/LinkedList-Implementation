package myLinkedList;


import java.util.Iterator;
/*
* This is a Iterator class.
*/
class LinkedListIterator<E> implements Iterator<E> {
    Node<E> current;

    public LinkedListIterator(CustomLinkedList<E> list) {
        current = list.getHead();
    }

    public boolean hasNext() {
        return current != null;
    }

    public E next() {
        E data = current.getData();
        current = current.getNext();
        return data;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}



