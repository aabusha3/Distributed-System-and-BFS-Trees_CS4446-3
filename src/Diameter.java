//import java.util.*;
//
//public class Diameter extends Algorithm {
//    /*
//    * 5x A
//    * 4x D
//    * 2x E
//    * 1x B F
//    * 0x C G I J K L H
//    * */
//
//    private static int ans;
//
//    public static int diameter(TreeNode root) {
//        ans = 0;
//        dfs(root);
//        System.out.println(ans);
//        return ans;
//    }
//
//    private static int dfs(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int m1 = 0, m2 = 0;
//        for (TreeNode child : root.children) {
//            int t = dfs(child);
//            if (t > m1) {
//                m2 = m1;
//                m1 = t;
//            } else if (t > m2) {
//                m2 = t;
//            }
//        }
//        ans = Math.max(ans, m1 + m2);
//        return 1 + m1;
//    }
//
//    public static class TreeNode{
//        String val;
//        List<TreeNode> children = new LinkedList<>();
//
//        TreeNode(String data){
//            val = data;
//        }
//
//        TreeNode(String data,List<TreeNode> child){
//            val = data;
//            children = child;
//        }
//    }
//
//    private static void printNAryTree(TreeNode root){
//        if(root == null) return;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        while(!queue.isEmpty()) {
//            int len = queue.size();
//            for(int i=0;i<len;i++) { // so that we can reach each level
//                TreeNode node = queue.poll();
//                System.out.print(node.val + " ");
//                for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
//                    queue.offer(item);
//                }
//            }
//            System.out.println();
//        }
//    }
//
//    public String computeDiameter(String id) {
//        try {
//            Message rcv, msg = null;
//            TreeNode root = new TreeNode(id);
//            if(numChildren() == 0) {
//                printDiameter(diameter(root));
//                msg=makeMessage(getParent(), pack(root));
//            }
//
//            while (waitForNextRound()) {
//                while((rcv = receive()) != null) {
//
//                }
//                return "";
//            }
//                return "";
////            Message message, msg = null;
////            String[] data;
////            int[] branches;
////            HashMap<String, String> leaves = new HashMap<String, String>();
////            int sum = numChildren(), childrenLeft = numChildren(), largest=0;
////            if(numChildren() == 0) {
////                printDiameter(numChildren());
////                msg=makeMessage(getParent(), pack(id,pack(v)));
////            }
////
////            while (waitForNextRound()) {
////                if(msg != null) {
////                    send(msg);
////                    return "";
////                }
////
////                while((message = receive()) != null) {
////                    data = unpack(message.data());
////                    System.out.println(data[0]+": "+data[1]);
////                    leaves.put(data[0],data[1]);
////                    childrenLeft--;
////                }
////
////                printDiameter(sum);
////                System.out.println(id+": "+Collections.max(leaves.entrySet(), Map.Entry.comparingByValue()).getKey());
////
////                if(childrenLeft <= 0) {
////                    if(getParent() == null) return "";
////                    else msg = makeMessage(getParent(), pack(id,integerToString(numChildren())));
////                }
////            }
//        } catch(SimulatorException e) {
//            System.out.println("ERROR: " + e.toString());
//        }
//
//        return "";
//    }
//
///* ===============================================================================
//   Do not modify any of the methods below
//   =============================================================================== */
//   private Vector<String> children1 = new Vector<String>(), children2 = new Vector<String>();
//
//    public Object run() {
//        String result = computeDiameter(getID());
//        return result;
//    }
//
//    /* Show the diameter of the subtree roooted at a processor */
//    private void printDiameter(int diam) {
//    	showMessage("diameter: "+integerToString(diam));
//    }
//
//    /* Receives as input a message containing several data items and the
//       position of a data item, and it returns the corresponding data item.
//       The first data item is at position 1, the second is ar posiiton 2,
//       and so on.                                                           */
//    private String getDataItem(int numItem, Message msg) {
//    	String[] messages = unpack(msg.data());
//    	return messages[numItem - 1];
//    }
//
//
//    /* Creates a message <destination,source, dataItem1, dataItem2, ...> with data
//        containing an arbitray number of data items.                                */
//    private Message createMessage(String destination, String... dataItems) {
//    	String msg = "";
//    	for (int i = 0; i < dataItems.length - 1; ++i) msg = msg + dataItems[i] + ",";
//    	msg = msg + dataItems[dataItems.length - 1];
//    	return makeMessage(destination,msg);
//    }
//
//}
