import java.util.*;
class Solution {
    static Long MAX;
    static String[] OPS_OFFICIAL = {"+", "-", "*"};
    static String[] OPS_SEQ = new String[3];
    static boolean[] OPS_CHECK = new boolean[3];
    static LinkedList<Node> NODES;
    static class Node {
        int prev = -1;
        int next = -1;
        long num;
        String op;

        public Node(long num, String op) {
            this.num = num;
            this.op = op;
        }
    }
    
    public long solution(String expression) {
        MAX = Long.MIN_VALUE;
        NODES = new LinkedList<>();
        int charIdx = 0, numIdx = 0;

        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char now_c = chars[i];
            if (now_c == '*' || now_c == '-' || now_c == '+') {
                String substring = expression.substring(charIdx, i);
                Node node = new Node(Long.parseLong(substring), String.valueOf(now_c));
                node.prev = numIdx - 1;
                node.next = numIdx + 1;
                NODES.addLast(node);
                charIdx = i + 1;
                numIdx++;
            }
        }
        String substring = expression.substring(charIdx);
        Node node = new Node(Long.parseLong(substring), null);
        node.prev = numIdx - 1;
        NODES.addLast(node);
        
        dfs(0);
        return MAX;
    }
    private void dfs(int depth) {
        if (depth == 3) {
            calcCombination();
            return;
        }
        for (int i = 0; i < 3; i++) {
            if (!OPS_CHECK[i]) {
                OPS_CHECK[i] = true;
                OPS_SEQ[depth] = OPS_OFFICIAL[i];
                dfs(depth + 1);
                OPS_CHECK[i] = false;
            }
        }
    }
     private void calcCombination() {
        LinkedList<Node> copy = new LinkedList<>();
        for (Node elem : NODES) {
            Node node = new Node(elem.num, elem.op);
            node.prev = elem.prev;
            node.next = elem.next;
            copy.addLast(node);
        }
        for (int i = 0; i < 3; i++) {
            String targetOp = OPS_SEQ[i];
            int idx = 0;
            while (idx != -1) {
                Node now_node = copy.get(idx);
                if (now_node.op != null && now_node.op.equals(targetOp)) {
                    Node next_node = copy.get(now_node.next);
                    switch (now_node.op) {
                        case "*" -> next_node.num *= now_node.num;
                        case "+" -> next_node.num += now_node.num;
                        case "-" -> next_node.num = now_node.num - next_node.num;
                    }
                    if (now_node.prev != -1) {
                        Node prev_node = copy.get(now_node.prev);
                        prev_node.next = now_node.next;
                    }
                    next_node.prev = now_node.prev;
                    idx = now_node.next;
                } else {
                    idx = now_node.next;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < NODES.size(); i++) {
            if (copy.get(i).prev == -1 && copy.get(i).next == -1) {
                result = Math.abs(copy.get(i).num);
            }
        }
        MAX = Math.max(result, MAX);
    }
}