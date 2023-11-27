package com.yasinyao.awesome.test;


public class NodeReverse {

    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        NodeReverse nodeReverse = new NodeReverse();
        nodeReverse.printNode(node);
        nodeReverse.printNode(nodeReverse.reverseNode(node));
    }


    private void printNode(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        while (node != null) {
            stringBuilder.append(node.value).append(",");
            node = node.next;
        }
        System.out.println(stringBuilder.toString());
    }

    public Node reverseNode(Node node) {
        if (node == null) {
            return null;
        }

        Node headNode = node;
        Node cur = node.next;

        Node tempNode = null;

        while (cur != null) {
            tempNode = cur.next;
            cur.next = headNode;
            headNode = cur;
            cur = tempNode;
        }
        node.next = null;


        return headNode;
    }


    public static class Node {
        public int value;
        public Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }
    }

}
