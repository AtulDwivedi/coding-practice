package com.atuldwivedi.cp.algo.sorting.merge;

/**
 * @author Atul Dwivedi
 */
public class MergeSortOnLinkedList {

    public Node sort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node midNode = getMidNode(head);
        Node nextOfMidNode = midNode.next;
        midNode.next = null;

        Node leftList = sort(head);
        Node rightList = sort(nextOfMidNode);

        return sortedMerge(leftList, rightList);
    }

    private Node sortedMerge(Node leftList, Node rightList) {
        Node sortedList = null;
        if (leftList == null) {
            return rightList;
        }
        if (rightList == null) {
            return leftList;
        }

        if (leftList.val <= rightList.val) {
            sortedList = leftList;
            sortedList.next = sortedMerge(leftList.next, rightList);
        } else {
            sortedList = rightList;
            sortedList.next = sortedMerge(leftList, rightList.next);
        }
        return sortedList;
    }

    private Node getMidNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //2->3->20->5->10->15->null
        Node node1 = new Node(15, null);
        Node node2 = new Node(10, node1);
        Node node3 = new Node(5, node2);
        Node node4 = new Node(20, node3);
        Node node5 = new Node(3, node4);
        Node node6 = new Node(2, node5);

        MergeSortOnLinkedList obj = new MergeSortOnLinkedList();
        Node sortedList = obj.sort(node6);

        Node step = sortedList;
        while (step != null) {
            System.out.print(step.val + "\t");
            step = step.next;
        }
    }
}
