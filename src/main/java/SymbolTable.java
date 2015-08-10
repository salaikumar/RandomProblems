
import java.util.NoSuchElementException;

class Pair<Key,Value>{

    private Key key;
    private Value value;

    public Pair(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public Value getValue(){
        return this.value;
    }

    public void setValue(Value value){
        this.value = value;
    }

    public boolean hasValue(){
        return ( value != null );
    }

    public Key getKey() {
        return key;
    }
}

public class SymbolTable<Key, Value> {

    private  Pair[] pair;
    private int index;
    private int size;

    public SymbolTable(int initialCapacity){
        pair = new Pair[initialCapacity];
    }

    public SymbolTable(){
        pair = new Pair[8];
    }

    public int getSize() {
        return size;
    }
    public void set(Key key,Value value){

        Pair keyPair;

        if ( key == null || value == null)
            throw  new NullPointerException("Key or Value cannot be null");

        if (size ==  pair.length)
            resize(pair.length * 2);

        if (hasKey(key)){
              int keyPosition = getIndex(key);
              keyPair = pair[keyPosition];
              keyPair.setValue(value);
              pair[keyPosition] = keyPair;
              return;
        }

        keyPair = new Pair(key,value);
        pair[index++] = keyPair;
        size++;
    }

    private int getIndex(Key key) {
        Pair keyValue;

        if (key == null)
            return -1;

        for ( int i = 0; i <pair.length; ++i){
             keyValue = pair[i];
             if (keyValue.getKey().equals(key))
                 return i;
        }

        return -1;
    }

    private boolean hasKey(Key key) {

        if (key == null)
            return false;

        for (Pair keyValue : pair) {
            if (keyValue != null) {
                if (keyValue.getKey().equals(key))
                    return true;
            }
        }

        return false;
    }

    private Value get(Key key){

        if (!hasKey(key))
             return null;

        for (Pair keyValue : pair) {
            if (keyValue.getKey().equals(key))
                return (Value) keyValue.getValue();
        }

        return null;
    }

    private void resize(int size) {
        Pair[] temp;
        temp = new Pair [ size ];
        int index = 0;
        for (int i = 0; i< pair.length; ++i){
            Pair keyValue = pair[i];
            if ( keyValue != null) {
                if (keyValue.hasValue())
                    temp[index++] = keyValue;
            }
        }
        pair = temp;
//       Reset the index.
        this.index = index;
    }

    public void remove(Key key){

        Pair keyPair;

        if(key == null)
            throw  new  NullPointerException("Key is null");

        if (! hasKey(key))
             throw new NoSuchElementException("Key is not present");

        if (hasKey(key)){
            int keyPosition = getIndex(key);
            keyPair = pair[keyPosition];
            if (keyPair.getValue() != null) {
                keyPair.setValue(null);
                pair[keyPosition] = keyPair;
                size--;
            }
        }
        if (size == pair.length/2)
            resize((pair.length/2) + 1);

    }
}
