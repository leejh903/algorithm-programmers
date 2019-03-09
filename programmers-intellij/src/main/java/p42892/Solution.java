package p42892;

import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        Node root = injectNode(init(nodeinfo));
        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();
        preOrder(preList, root);
        postOrder(postList, root);
        int[][] answer = {preList.stream().mapToInt(Integer::intValue).toArray(),
                        postList.stream().mapToInt(Integer::intValue).toArray()};
        return answer;
    }

    private void postOrder(List<Integer> postList, Node node) {
        if(node.left != null) postOrder(postList, node.left);
        if(node.right != null) postOrder(postList, node.right);
        postList.add(node.num);
    }

    public void preOrder(List<Integer> preList, Node node) {
        preList.add(node.num);
        if(node.left != null) preOrder(preList, node.left);
        if(node.right != null) preOrder(preList, node.right);
    }

    public Queue<Node> init(int[][] nodeinfo) {
        Queue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            queue.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        return queue;
    }

    public Node injectNode(Queue<Node> queue) {
        Node root = queue.poll();
        while (!queue.isEmpty()) {
            Node thisNode = queue.poll();
            root.add(thisNode);
        }
        return root;
    }
}

class Node implements Comparable<Node> {
    int num;
    int x;
    int y;

    Node left;
    Node right;

    public Node(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

    public void add(Node node) {
        if(node.x < this.x) {
            if(left != null) {
                left.add(node);
                return;
            }
            left = node;
        }

        if(node.x > this.x) {
            if(right != null) {
                right.add(node);
                return;
            }
            right = node;
        }
    }

    @Override
    public int compareTo(Node o) {
        if (o.y == this.y) {
            return this.x - o.x;
        }
        return o.y - this.y;
    }
}
