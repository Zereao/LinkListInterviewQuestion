package com.zereao;

import lombok.Data;

/**
 * @author Zereao
 * @version 2019/9/6 11:45
 */
@Data
public class Node {
    /**
     * 指向前一个节点的引用
     */
    private Node pre;
    /**
     * 指向下一个节点的引用
     */
    private Node next;
    /**
     * 值
     */
    private String value;

    public Node(String value) {
        this.value = value;
    }
}
