/**
 * UniqueTree class that helps searching and sorting non-duplicated datas
 *
 * @author      Oyunomin Munkhkhurel
 * @version     2/18/2018
 */
public class UniqueTree<E> {
    private UniqueNode<E> root;
    private int count;
    private String stringPositions = "";
    
    /**
     * Full constructor for UniqueTree class
     */
    public UniqueTree() {
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
     * @param   UniqueNode<E> startNode assigned starting node
     */
    private UniqueNode<E> add(E data, int position, UniqueNode<E> startNode) {
        if (startNode == null) {
            startNode = new UniqueNode<E>(data, position);
        } else if ((Integer)data < (Integer)startNode.data) {
            startNode.left = add(data, position, startNode.left);
        } else {
            startNode.right = add(data, position, startNode.right);
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
    private String collectStringPositions(UniqueNode<E> startNode) {
        if (startNode != null) {
            collectStringPositions(startNode.left);
            // WE WOULDN'T REALLY PRINT FROM SUPPLIER CODE;
            // THIS IS JUST AN ILLUSTRATION ON THE WAY TO
            // SOMETHING BETTER NEXT TIME WE TALK...
            stringPositions += (startNode.position + ",");
            collectStringPositions(startNode.right);
        }
        return stringPositions;
    }
        
    /*
     * Private constructor for UniqueNode class
     */
    private class UniqueNode<E> {
        public E data;
        public UniqueNode<E> right;
        public UniqueNode<E> left;
        public int position;
        
        /**
         * Full constructor for UniqueNode class
         * 
         * @param   E data data to be added
         * @param   int position position of the array of the objects 
         */
        private UniqueNode(E data, int position) {
            if (data == null) {
                throw new IllegalArgumentException("data cannot be null");
            }
            this.data = data;
            this.position = position;
            right = null;
            left = null;
        }
    }
}
