package com.zereao;

/**
 * @author Zereao
 * @version 2019/9/11 17:43
 */
public class Main {
    public static void main(String[] args) {
        Main runner = new Main();
        LinkedList list = runner.buildLinkedList();
        Node middleNode = runner.getMiddleNode(list);
        System.out.println("中间节点的值为：" + middleNode.getValue());
        Node last3Node = runner.getLast3Node(list, 3);
        System.out.println("倒数第三个节点的值为：" + last3Node.getValue());
    }


    /**
     * 获取倒数第N个节点
     *
     * @param list      单链表
     * @param lastIndex 倒数索引
     * @return 倒数第N个节点
     */
    private Node getLast3Node(LinkedList list, int lastIndex) {
        Node p1 = list.getHead();
        Node p2 = list.getHead();
        int index = 1;
        while (p1.getNext() != null) {
            if (index == lastIndex) {
                p2 = p2.getNext();
            } else {
                ++index;
            }
            p1 = p1.getNext();
        }
        return p2;
    }

    /**
     * 获取中间节点
     *
     * @param list 链表
     * @return 中间节点
     */
    private Node getMiddleNode(LinkedList list) {
        Node slow = list.getHead();
        Node fast = list.getHead();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    /**
     * 构建出示例中的的链表
     *
     * @return 包含环的链表
     */
    private LinkedList buildLinkedList() {
        LinkedList list = new LinkedList();
        for (int i = 1; i <= 7; i++) {
            Node node = new Node(String.valueOf(i) + i);
            list.add(node);
        }
        return list;
    }
}
