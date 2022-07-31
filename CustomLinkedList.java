package myLinkedList;


import java.util.Iterator;
import java.util.Objects;

public class CustomLinkedList<E> implements Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;


    public void Insert(E value) {
        Node<E> temp = new Node<>();
        temp.data = value;
        temp.next = null;

        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    public void InsertAt(int index, E value) {
        if (index < 0 || index > size) {
            System.out.println("Invalid Arguments");
        } else if (index == 0) {
            Node<E> temp = new Node<>();
            temp.data = value;
            temp.next = null;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;

        } else if (index == size) {
            Node<E> temp = new Node<>();
            temp.data = value;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;

        } else {
            Node<E> node = new Node<>();
            node.data = value;

            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            node.next = temp.next;
            temp.next = node;

            size++;
        }
    }

    public void Traverse() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public int Size() {
        return size;
    }

    public void Delete() {
        if (size == 0) {
            System.out.println("Linked List is Empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node<E> temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
            size--;
        }
    }

    public void DeleteAt(int index) {

        if (index < 0 || index > size) {
            System.out.println("Invalid Arguments");

        } else if (index == 0) {
            Node<E> temp = head;
            head = temp.next;
            size--;

        } else if (index == size) {
            Delete();
        } else {
            Node<E> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            size--;
        }
    }

    public E Center() {
        Node<E> slow = head;
        Node<E> fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    private Node<E> getNodeAt(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean contains(E item) {
        boolean checker = false;
        if (head == null) System.out.println("List is Empty");
        Node<E> temp = head;
        while (temp != null) {
            if (Objects.equals(temp.data, item)) {
                checker = true;
                break;
            }
            temp = temp.next;
        }
        return checker;
    }

    public void Reverse() {
        int li = 0;
        int ri = size - 1;

        while (li < ri) {
            Node<E> left = getNodeAt(li);
            Node<E> right = getNodeAt(ri);

            E temp = left.data;
            left.data = right.data;
            right.data = temp;

            li++;
            ri--;
        }
    }

    private Node midNode(Node head, Node tail) {
        Node f = head;
        Node s = head;

        while (f != tail && f.next != tail) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }

    Node<E> getHead() {
        return head;
    }

    Node<E> getTail() {
        return tail;
    }

    public LinkedListIterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }


}
