import java.lang.Comparable;

/**
 * NonUniqueTree class that helps searching and sorting duplicated datas
 *
 * @author      Oyunomin Munkhkhurel
 * @version     2/18/2018
 */
public class NonUniqueTree<E> {
    private NonUniqueNode<E> root;
    private int count;
    private String stringPositions = "";
    
    /**
     * Full constructor for NonUniqueTree class
     */
    public NonUniqueTree() {
        root = null;
    }
    
    /*
     * Adds data to the tree starting from the root
     * 
     * @param   E data that wants to be added
     * @param   int position E's position in the array
     */
    public void add(E data, int position) {
        root = add(data, position, root);
        count++;
    }
    
    /*
     * Adds data to the tree starting from the assigned startNode recursively
     * 
     * @param   E data that wants to be added
     * @param   int position E's position in the array
     * @param   NonUniqueNode<E> startNode assigned starting node
     */
    private NonUniqueNode<E> add(E data, int position, NonUniqueNode<E> startNode) {
        if (startNode == null) {
            NonUniqueNode<E> newNode = new NonUniqueNode<E>(data, position);
            startNode = newNode;
        } else if (startNode.compareTo(data) == 0) {
            startNode.same = add(position, startNode.same);
        } else if (startNode.compareTo(data) > 0) {
            startNode.left = add(data, position, startNode.left);
        } else {
            startNode.right = add(data, position, startNode.right);
        }
        return startNode;
    }
    
    /*
     * Creates new Intnode and adds to the tree
     * 
     * @param   int position data of the Intnode (position of the array of objects)
     * @param   IntNode startNode starting Node 
     */
    private IntNode add(int position, IntNode startNode) {
        if (startNode == null) {
            IntNode newSame = new IntNode(position);
            startNode = newSame;
        } else {
            startNode.same = add(position, startNode.same);
        }
        return startNode;
    }
    
    /*
     * Does the in-order traverse through the tree and returns their position of the array respectively
     * 
     * @return  array of position of the array of the objects
     */
    public int[] getPosition() {
        return inOrder(collectStringPositions(root));
    }
    
    /*
     * Helper method gets the string version of the integer array and parse the value from it into integer array
     * 
     * @param   String  string version of the integer array
     * @return  array of position of the array of the objects
     */
    private int[] inOrder(String stringPositions) {
        int[] positions = new int[count];
        String[] tempPositions = stringPositions.split(",");
        for (int i = 0; i < tempPositions.length; i++) {
            positions[i] = Integer.valueOf(tempPositions[i]);
        }
        return positions;
    }

    /*
     * Recursive helper function for collecting position within nodes of the tree, using in-order traversal
     * 
     * @param   startNode       the node at which to start searching for the data within nodes
     * @return  
     */
    private String collectStringPositions(NonUniqueNode<E> startNode) {
        if (startNode != null) {
            collectStringPositions(startNode.left);
            collectStringPositionFromSame(startNode.same);
            stringPositions += (startNode.position + ",");
            collectStringPositions(startNode.right);
        }
        return stringPositions;
    }
    
    private String collectStringPositionFromSame(IntNode startNode) {
        if (startNode != null) {
            collectStringPositionFromSame(startNode.same);
            stringPositions += (startNode.position + ",");
        }
        return stringPositions;
    }
    
    private class NonUniqueNode<E> implements Comparable<E>{
        public E data;
        public NonUniqueNode<E> right;
        public NonUniqueNode<E> left;
        public IntNode same;
        public int position;
        
        /**
         * Full constructor for NonUniqueNode class
         * 
         * @param   E data data to be added
         * @param   int position position of the array of the objects 
         */
        private NonUniqueNode(E data, int position) {
            this.data = data;
            this.position = position;
            right = null;
            left = null;
            same = null;
        }
        
        @Override
        public int compareTo(E data) {
            if (data.getClass() == String.class) {
                String rootString = new String((String)this.data);
                String incomingString = new String((String)data);
                return rootString.compareTo(incomingString);
            } else {
                Double rootData = new Double((Double)this.data);
                Double incomingData = new Double((Double)data);
                return rootData.compareTo(incomingData);
            }
        }
    }
    
    private class IntNode {
        public int position;
        public IntNode same;
        
        /**
         * Full constructor for IntNode class
         * 
         * @param   int position position in the array of objects
         */
        private IntNode(int position) {
            this.position = position;
            same = null;
        }
    }
}
