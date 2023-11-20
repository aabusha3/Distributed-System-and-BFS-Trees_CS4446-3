//import java.util.Vector; //Do not delete or modify this line
//
//public class DoubleBFS extends Algorithm {
//
//    public String bfsTrees(String id) {
//        try {
//            boolean r1sent = false, r2sent = false;
//            String root, parent, ID, parent1=null, parent2=null;
//            Message m,s1=null,s2=null;     // Variable used to read messages
//            int rounds_left = 2;// Variable used to know when to terminate the algorithm
//            if(Integer.parseInt(id)==1 && !r1sent){
//                s1=messageForNeighbours("",id,parent1,id);
//                r1sent = true;
//            }
//            if(Integer.parseInt(id)==2 && !r2sent){
//                s2=messageForNeighbours("",id,parent2,id);
//                r2sent = true;
//            }
//            /* Declare and initialize your variables here */
//
//            while (waitForNextRound()) {
//                /* Add your code to send messages here */
//
//                if(s1!=null)send(s1);
//                if(s2!=null)send(s2);
//                if(s1!=null||s2!=null)rounds_left=2;
//                if(r1sent) s1 = null;
//                if(r2sent) s2 = null;
//                /* Add code below to read the messages. Code for reading the first message was added for you */
//                m = receive();
//                while (m != null) {
//                    root = getDataItem(1,m);
//                    parent = getDataItem(2,m);
//                    ID = getDataItem(3,m);
//
//                    if(root.equals("1")){
//                        if(!r1sent){
//                            parent1=ID;
//                            s1=messageForNeighbours("",root,parent1,id);
//                            r1sent=true;
//                        }
//                        else if(r1sent && parent.equals(id)) {
//                            addChild1(ID);
//                            rounds_left=2;
//                        }
//                    }
//
//                    if(root.equals("2")){
//                        if(!r2sent){
//                            parent2=ID;
//                            s2=messageForNeighbours("",root,parent2,id);
//                            r2sent=true;
//                        }
//                        else if(r2sent && parent.equals(id)) {
//                            addChild2(ID);
//                            rounds_left=2;
//                        }
//                    }
//
//                    m=null;
//                    printParentsChildren(parent1, parent2, children1, children2);
//                }
//
//		/* Terminate the algorithm two rounds after the last message was sent.
//		    You need to determine when the value of rounds_left must be changed from -1 to 1. */
//                if (rounds_left == 0 ) {
//                    printParentsChildren(parent1, parent2, children1, children2);
//                    return "";
//                }
//                else if(id.equals("1") && parent2!=null && rounds_left>0) rounds_left--;
//                else if(id.equals("2") && parent1!=null && rounds_left>0) rounds_left--;
//                else if(parent1!=null && parent2!=null && rounds_left>0) rounds_left--;
//            }
//        } catch (SimulatorException e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
//
//        return "";
//    }
//
///* ===============================================================================
//   Do not modify any of the methods below
//   =============================================================================== */
//
//    private Vector<String> children1 = new Vector<String>(), children2 = new Vector<String>();
//
//    public Object run() {
//        String result = bfsTrees(getID());
//        return result;
//    }
//
//    /* Add a child to the list of children for the tree with root "1" */
//    private void addChild1(String child) {
//        children1.add(child);
//    }
//
//    /* Add a child to the list of children for the tree with root "2" */
//    private void addChild2(String child) {
//        children2.add(child);
//    }
//
//    /* Receives as input a message containing several data items and the
//       position of a data item, and it returns the corresponding data item.
//       The first data item is at position 1, the second is ar posiiton 2,
//       and so on.                                                           */
//    private String getDataItem(int numItem, Message msg) {
//        String[] messages = unpack(msg.data());
//        return messages[numItem - 1];
//    }
//
//    /* Creates a message <destination,source, dataItem1, dataItem2, ...> with data
//        containing an arbitray number of data items.                                */
//    private Message messageForNeighbours(String parent, String... dataItems) {
//        Vector<String> adjacent = neighbours();
//        if (!parent.equals("")) adjacent.remove(parent);
//        String msg = "";
//        for (int i = 0; i < dataItems.length - 1; ++i) msg = msg + dataItems[i] + ",";
//        msg = msg + dataItems[dataItems.length - 1];
//        return makeMessage(adjacent, msg);
//    }
//
//    /* Creates a message <destination,source, dataItem1, dataItem2, ...> with data
//        containing an arbitray number of data items.                                */
//    private Message createMessage(String destination, String... dataItems) {
//        String msg = "";
//        for (int i = 0; i < dataItems.length - 1; ++i) msg = msg + dataItems[i] + ",";
//        msg = msg + dataItems[dataItems.length - 1];
//        return makeMessage(destination, msg);
//    }
//
//
//    /* Print information about the parent and children of this processor in both BFS trees */
//    private void printParentsChildren(String parent1, String parent2, Vector<String> children1,
//                                      Vector<String> children2) {
//        String outMssg = "[" + parent1 + ":";
//        for (int i = 0; i < children1.size() - 1; ++i)
//            outMssg = outMssg + children1.elementAt(i) + " ";
//        if (children1.size() > 0)
//            outMssg = outMssg + children1.elementAt(children1.size() - 1) + "] [" + parent2 + ":";
//        else outMssg = outMssg + "] [" + parent2 + ":";
//        for (int i = 0; i < children2.size() - 1; ++i)
//            outMssg = outMssg + children2.elementAt(i) + " ";
//        if (children2.size() > 0)
//            outMssg = outMssg + children2.elementAt(children2.size() - 1) + "]";
//        else outMssg = outMssg + "]";
//        showMessage(outMssg);
//        printMessage(outMssg);
//    }
//}
