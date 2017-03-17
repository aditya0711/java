package com.aditya;

/**
 * Created by adityaaggarwal on 5/3/17.
 */
public class SinglyLinkedList<E> {

    private static class Node<E>{
        private E element;
        private Node<E> next;
        public Node(E element, Node<E> node){
            this.next = node;
            this.element = element;
        }
        public E getElement(){ return this.element; }
        public Node<E> getNext(){ return this.next; }
        public void setNext(Node<E> newest){ this.next = newest; }
    }
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public boolean isEmpty(){ return size==0;}
    public int size(){return this.size;}

    public E first(){
        if(isEmpty()) return null;
        return head.getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E element){
        head = new Node<E>(element, head);
        if(size == 0)
            tail = head;
        size++;
    }
    public E removeFirst(){
        if(isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNext();
        size--;

        if(size ==0)
            tail = null;
        return answer;
    }
}
