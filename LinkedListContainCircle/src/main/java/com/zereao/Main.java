package com.zereao;

/**
 * @author Zereao
 * @version 2019/9/9 11:46
 */
public class Main {
    public static void main(String[] args) {
        Main runner = new Main();
        LinkedList list = runner.buildLinkedListWithCircle();
        boolean containCircle = runner.isContainCircle(list);
        System.out.println("该链表是否包含环：" + containCircle);
        Node meetNode = runner.getMeetNode(list);
        System.out.println("碰撞点的值为：" + meetNode.getValue());
        Node entranceNode = runner.getEntranceNode(list);
        System.out.println("入口节点的值为：" + entranceNode.getValue());
        int circleLen = runner.getLinkedListCircleLength(list);
        System.out.println("链表环长为：" + circleLen);
    }

    /**
     * 判断一个链表是否成环
     *
     * @param list 链表
     * @return true Or false
     */
    private boolean isContainCircle(LinkedList list) {
        // 两个指针，刚开始都指向 头结点
        Node slow = list.getHead();
        Node fast = list.getHead();
        // 如果链表成环，则直到量指针相遇之前，该循环将一直进行；
        while (fast != null && fast.getNext() != null) {
            /* fast 每次走两步，slow 走一步；
             * 在 fast 为null 之前，slow一定不为 null */
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            // 这里直接比较其地址即可
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取碰撞节点
     *
     * @param list 一个包含环的链表
     * @return 碰撞节点
     */
    private Node getMeetNode(LinkedList list) {
        Node slow = list.getHead();
        Node fast = list.getHead();
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                // 这里随便返回 fast 或者 slow 都可以
                return slow;
            }
        }
        throw new IllegalArgumentException("链表不含环！");
    }

    /**
     * 获取 链表环的入口节点
     *
     * @param list 链表
     * @return 入口节点
     */
    private Node getEntranceNode(LinkedList list) {
        // p1 从头结点出发
        Node p1 = list.getHead();
        // p2 从碰撞点出发
        Node p2 = this.getMeetNode(list);
        if (p1 == p2) {
            return meetNode;
        }
        while (p1.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
            if (p1 == p2) {
                return p1;
            }
        }
        throw new IllegalArgumentException("链表不含环！");
    }

    /**
     * 获取链表环长
     *
     * @param list 链表
     * @return 环长
     */
    private int getLinkedListCircleLength(LinkedList list) {
        Node meetNode = this.getMeetNode(list);
        Node p = meetNode;
        int len = 0;
        while (p.getNext() != null) {
            p = p.getNext();
            ++len;
            if (p == meetNode) {
                return len;
            }
        }
        throw new IllegalArgumentException("链表不含环！");
    }

    /**
     * 构建出示例中的包含环的链表
     *
     * @return 包含环的链表
     */
    private LinkedList buildLinkedListWithCircle() {
        LinkedList list = new LinkedList();
        Node nodeOf2 = null;
        for (int i = 1; i <= 7; i++) {
            Node node = new Node(String.valueOf(i) + i);
            list.add(node);
            if (i == 2) {
                nodeOf2 = node;
            }
        }
        list.add(nodeOf2);
        return list;
    }
}
