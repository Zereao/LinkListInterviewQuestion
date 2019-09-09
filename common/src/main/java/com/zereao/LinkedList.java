package com.zereao;

/**
 * 一个 单链表的实现
 *
 * @author Zereao
 * @version 2019/9/6 11:47
 */
public class LinkedList {
    /**
     * 头指针
     */
    private Node head;
    /**
     * 尾指针
     */
    private Node tail;

    public void add(Node node) {
        if (this.tail == null) {
            this.head = node;
        } else {
            this.tail.setNext(node);
        }
        this.tail = node;
    }

    @Override
    public String toString() {
        if (this.head == null) {
            return null;
        }
        Node pointer = this.head;
        Node beforeTail = null;
        StringBuilder sb = new StringBuilder().append(pointer.getValue());
        while (pointer.getNext() != null) {
            Node next = pointer.getNext();
            if (next == tail) {
                if (beforeTail == null) {
                    beforeTail = pointer;
                    sb.append(" --> ").append(next.getValue());
                } else {
                    sb.append(" -----> ").append(next.getValue());
                    break;
                }
            } else {
                sb.append(" --> ").append(next.getValue());
            }
            pointer = next;
        }
        return sb.toString();
    }

    /**
     * 获取头结点
     *
     * @return 头结点
     */
    public Node getHead() {
        return this.head;
    }
}
