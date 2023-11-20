import java.util.*;

public class Solution {
//    static class Node {
//        public int val;
//        public List<Node> children;
//
//
//        public Node() {
//            children = new ArrayList<Node>();
//        }
//
//        public Node(int _val) {
//            val = _val;
//            children = new ArrayList<Node>();
//        }
//
//        public Node(int _val,ArrayList<Node> _children) {
//            val = _val;
//            children = _children;
//        }
//    }
    private static int ans;

    public static int diameter(TreeNode root) {
        ans = 0;
        dfs(root);
        System.out.println(ans);
        return ans;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int m1 = 0, m2 = 0;
        for (TreeNode child : root.children) {
            int t = dfs(child);
            if (t > m1) {
                m2 = m1;
                m1 = t;
            } else if (t > m2) {
                m2 = t;
            }
        }
        ans = Math.max(ans, m1 + m2);
        return 1 + m1;
    }

    public static class TreeNode{
        String val;
        List<TreeNode> children = new LinkedList<>();

        TreeNode(String data){
            val = data;
        }

        TreeNode(String data,List<TreeNode> child){
            val = data;
            children = child;
        }
    }

    private static void printNAryTree(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) { // so that we can reach each level
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }



    // Node class for the Tree
    static class Node
    {
        char data;
        Node left,right;

        Node(char data)
        {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // static variable to point to the
// starting index of the string.
    static int start = 0;

    // Construct Tree Function which accepts
// a string and return root of the tree;
    static Node constructTree(String s)
    {

        // Check for null or empty string
        // and return null;
        if (s.length() == 0 || s == null)
        {
            return null;
        }

        if (start >= s.length())
            return null;

        // Boolean variable to check
        // for negative numbers
//        boolean neg = false;

        // Condition to check for negative number
//        if (s.charAt(start) == '-')
//        {
//            neg = true;
//            start++;
//        }

        // This loop basically construct the
        // number from the continuous digits
//        int num = 0;
//        while (start < s.length() && Character.isAlphabetic(s.charAt(start))) {
////            int digit = Character.getNumericValue(s.charAt(start));
////            num = num * 10 + digit;
//            start++;
//        }

        // If string contains - minus sign
        // then append - to the number;
//        if (neg)
//            num = -num;

        // Create the node object i.e. root of
        // the tree with data = num;
        Node node = new Node(s.charAt(start++));

        if (start >= s.length())
        {
            return node;
        }

        // Check for open bracket and add the
        // data to the left subtree recursively
        if (start < s.length() && s.charAt(start) == '(' )
        {
            start++;
            node.left = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')')
        {
            start++;
            return node;
        }

        // Check for open bracket and add the data
        // to the right subtree recursively
        if (start < s.length() && s.charAt(start) == '(')
        {
            start++;
            node.right = constructTree(s);
        }

        if (start < s.length() && s.charAt(start) == ')')
        {
            start++;
            return node;
        }
        return node;
    }

    // Print tree function
    public static void printTree(Node node)
    {
        if (node == null)
            return;

        System.out.println(node.data + " ");
        printTree(node.left);
        printTree(node.right);
    }



    public static void main(String[] args) {
//        String str = "4(2(3)(1))(6(5))";
        String str = "A(B(D)(E))(C(F))";
        Node root = constructTree(str);
        printTree(root);

//        printNAryTree(root);
//        diameter(root);


//        String[] nodes = new String[]{"A:C","A:B:D:E:F"}; //"A:B"  //"A:B:C"  //"A:B:C:D:..."
//        TreeNode nodeX, nodeY, root;

//        root = new TreeNode("A");
//
//        nodeX = new TreeNode("E");
//        nodeX.children.add(new TreeNode("F"));
//
//        nodeY = new TreeNode("D");
//        nodeY.children.add(nodeX);
//
//        nodeX = new TreeNode("B");
//        nodeX.children.add(nodeY);
//
//        root.children.add(nodeX);
//        root.children.add(new TreeNode("C"));


//        TreeNode nodeB = new TreeNode("B");
//        nodeB.children.add(new TreeNode("D"));
//        TreeNode nodeA = new TreeNode("A");
//        nodeA.children.add(nodeB);
//        nodeA.children.add(new TreeNode("C"));


//        TreeNode nodeH = new TreeNode("H");
//        TreeNode nodeI = new TreeNode("I");
//
//        TreeNode nodeG = new TreeNode("G");
//        nodeG.children.add(nodeI);
//        TreeNode nodeF = new TreeNode("F");
//        nodeF.children.add(nodeH);
//
//        TreeNode nodeE = new TreeNode("E");
//        nodeE.children.add(nodeG);
//        TreeNode nodeD = new TreeNode("D");
//        nodeD.children.add(nodeF);
//
//        TreeNode nodeB = new TreeNode("B");
//        nodeB.children.add(nodeD);
//        nodeB.children.add(nodeE);
//
//        TreeNode nodeC = new TreeNode("C");
//        TreeNode nodeA = new TreeNode("A");
//        nodeA.children.add(nodeB);
//        nodeA.children.add(nodeC);



//        TreeNode root = new TreeNode("A");
//        root.children.add(new TreeNode("B"));
//        root.children.get(0).children.add(new TreeNode("D"));
//        root.children.get(0).children.get(0).children.add(new TreeNode("F"));
//        root.children.get(0).children.get(0).children.get(0).children.add(new TreeNode("H"));
//        root.children.get(0).children.add(new TreeNode("E"));
//        root.children.get(0).children.get(1).children.add(new TreeNode("G"));
//        root.children.get(0).children.get(1).children.get(0).children.add(new TreeNode("I"));
//        root.children.add(new TreeNode("C"));


//        TreeNode root = new TreeNode("A");
//        root.children.add(new TreeNode("B"));
//        root.children.get(0).children.add(new TreeNode("F"));
//        root.children.get(0).children.get(0).children.add(new TreeNode("K"));
//        root.children.get(0).children.add(new TreeNode("G"));
//        root.children.add(new TreeNode("C"));
//        root.children.add(new TreeNode("D"));
//        root.children.get(2).children.add(new TreeNode("H"));
//        root.children.get(2).children.get(0).children.add(new TreeNode("L"));
//        root.children.get(2).children.get(0).children.add(new TreeNode("M"));
//        root.children.add(new TreeNode("E"));
//        root.children.get(3).children.add(new TreeNode("I"));
//        root.children.get(3).children.add(new TreeNode("J"));

//        System.out.println(root.val);

    }
}
