import java.io.*;

public class test2 {
    final static int N = 5;
    final static char MARKER = ')';

    // A node of N-ary tree
    static class Node {
        char key;
        Node[] child; // An array of pointers for N children

        Node(char key) {
            this.key = key;
            child = new Node[N];
        }
    }

    // This function stores the given N-ary tree in a file pointed by fp
    static void serialize(Node root, PrintWriter writer) {
        // Base case
        if (root == null) {
            return;
        }

        // Else, store current node and recur for its children
        writer.print(root.key + " ");
        for (int i = 0; i < N && root.child[i] != null; i++) {
            serialize(root.child[i], writer);
        }

        // Store marker at the end of children
        writer.print(MARKER + " ");
    }

    // This function constructs N-ary tree from a file pointed by 'reader'.
    static Node deSerialize(BufferedReader reader) throws IOException {
        // Read next item from file. If there are no more items or next
        // item is marker, then return null to indicate same
        int val = reader.read();
        if (val == -1 || val == MARKER) {
            return null;
        }
        char c = (char) val;

        // Else create node with this item and recur for children
        Node root = new Node(c);
        for (int i = 0; i < N; i++) {
            root.child[i] = deSerialize(reader);
            if (root.child[i] == null) {
                break;
            }
        }

        return root;
    }

    // A utility function to create a dummy tree shown in above diagram
    static Node createDummyTree() {
        Node root = new Node('A');
        root.child[0] = new Node('B');
        root.child[1] = new Node('C');
        root.child[2] = new Node('D');
        root.child[0].child[0] = new Node('E');
        root.child[0].child[1] = new Node('F');
        root.child[2].child[0] = new Node('G');
        root.child[2].child[1] = new Node('H');
        root.child[2].child[2] = new Node('I');
        root.child[2].child[3] = new Node('J');
        root.child[0].child[1].child[0] = new Node('K');
        return root;
    }

    // A utility function to traverse the constructed N-ary tree
    static void traverse(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            for (int i = 0; i < N; i++) {
                traverse(root.child[i]);
            }
        }
    }

    // Driver program to test above functions
    public static void main(String[] args) throws IOException {
        // Let us create an N-ary tree shown in above diagram
        Node root = createDummyTree();

        // Let us open a file and serialize the tree into the file
        PrintWriter writer = new PrintWriter(new FileWriter("tree.txt"));
        serialize(root, writer);
        writer.close();

        // Let us deserialize the stored tree into root1
        Node root1;
        BufferedReader reader = new BufferedReader(new FileReader("tree.txt"));
        root1 = deSerialize(reader);
        reader.close();

        System.out.println("Constructed N-Ary Tree from file is: ");
        traverse(root1);
    }
}
