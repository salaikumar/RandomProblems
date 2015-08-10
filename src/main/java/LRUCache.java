import java.util.HashMap;

/**
 * Least Recently Used - Discards first Cache.
 * Hash Table - To hold the keys.
 * Doubly linked list. - To hold all the Values based on the frequency of access.
 * -- Cannot use Deque - Deck since we don't have control to rearrange the elements in order which is used.
 */

/*
* Node Structure
*/
class Node<Key,Value>{
    Key key;
    Value value;
    Node left;
    Node right;

    Node(Key key, Value value){
        this.key = key;
        this.value = value;
    }
}

public class LRUCache<Key, Value> {
    private int capacity;  // Max Capacity of LRU Cache
    private int load;      // Number of elements in Cache at a point of time,
    private Node head;
    private HashMap<Key,Node> keyList;

    public LRUCache(int capacity){
        this.capacity = capacity;
        keyList = new HashMap<Key, Node>(capacity);
    }

    public Node getHead() {
        return head;
    }

    public Value get(Key key) {
        if (keyList.isEmpty())
            throw new NullPointerException("Cache is empty");

        if (key == null)
            throw new NullPointerException("Key cannot be null");

        if ( ! keyList.containsKey(key) )
            return null;

        Node node = keyList.get(key);
        removeNode(node);
        makeHead(node);

        return (Value) node.value;
    }

    public void set(Key key, Value value) {
        if ( key == null || value == null)
            throw new NullPointerException("Key / Value cannot be nul");

        checkCapacity();

       if (keyList.containsKey(key)){
           Node node = keyList.get(key);
           node.value = value;   // Value updated.
           removeNode(node);
           makeHead(node);
           keyList.put(key,node);
           return;
       }

       Node node = new Node(key,value);

//     This is the first node being inserted
       if ( head == null )
           head = node;
       else {
           makeHead(node);
       }

       keyList.put(key,node);
       load++;
        }

    /*
     * Check if the Capacity is full. if so, remove the node at last
     */
    private void checkCapacity() {
        if (load == capacity){
            Node end = head;
            while ( end.right != null){
                end = end.right;
            }

//          Get the key of the last node.
            Key key = (Key) end.key;

//          Remove the last node
            end.left.right= null;  // removes the connection from the list.
            end = null; //-- Does it makes sense to make a something as null?
            keyList.remove(key);   // Delete the key from the list

        }
    }

    private void removeNode(Node node){
//      Step 1. Connect the neighbours of the given node
        if (node.left != null)
            node.left.right = node.right;
        if (node.right != null)
            node.right.left = node.left;

//      Step 2. Clear the left and right pointers of the given node.Only key-value should be present
        node.left = null;
        node.right = null;
    }

    private void makeHead(Node node){
         head.left = node;
         node.right = head;
         head = node;
    }
}
