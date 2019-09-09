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
