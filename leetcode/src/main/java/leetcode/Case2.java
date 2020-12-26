package leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * @author: gb
 * @create: 2020/09/29
 */
public class Case2 {

    public Node sum(Node l1, Node l2) {
        List<Integer> list = new ArrayList<>();
        sumValue(l1, l2, list);

        if (list.size() == 0) {
            return new Node(0);
        }

        for (int i = 0; i < list.size(); i++) {

            //两个node结果不大于10
            int val = list.get(i);
            if (val < 10) {
                continue;
            }

            list.set(i, val % 10);

            //两个node结果大于10
            int next = i + 1;

            //是否链尾
            if (next == list.size()) {
                continue;
            }

            //10进位到下位数中
            int nextValue = list.get(next);
            nextValue++;
            list.set(next, nextValue);
        }

        Node first = new Node(list.get(0));
        Node current = first;
        for (int i = 1; i < list.size(); i++) {
            current.next = new Node(list.get(i));
            current = current.next;
        }

        return first;
    }

    private void sumValue(Node l1, Node l2, List<Integer> list) {
        if (null == l1 && null == l2) {
            return;
        }

        if (l1 == null) {
            l1 = new Node(0);
        }

        if (l2 == null) {
            l2 = new Node(0);
        }

        int sum = l1.val + l2.val;
        list.add(sum);

        sumValue(l1.next, l2.next, list);
    }


    private static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        Node a0 = new Node(8);
        Node a1 = new Node(3);
        Node a2 = new Node(6);
        Node a3 = new Node(6);

        a0.next = a1;
        a1.next = a2;
        a2.next = a3;

        Node b0 = new Node(1);
        Node b1 = new Node(8);
        Node b2 = new Node(2);
        Node b3 = new Node(6);

        b0.next = b1;
        b1.next = b2;
        b2.next = b3;

        Node n= new Case2().sum(a0, b0);


        while (n!=null){
            System.out.println(n.val);
            n = n.next;
        }
    }
}
