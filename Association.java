
/**
 * Associate key/value pairs.  keys are immutable.
 * 
 * @author Jim Teresco and the CSIS 210 class, Fall 2017
 * Siena College on its birthday.
 *
 * @version Fall 2019
 *
 */
public class Association<K,V>
{
    /* instance variables to store our key and our value */
    private K key;
    private V value;
    
    /**
       construct a new Association with the given key/value pair.

       @param k the immutable key
       @param v the initial value
    */
    public Association(K k, V v) {
     
        key = k;
        value = v;
    }
    
    /**
       construct a new Association with the given key, but no value.
       value defaults to null.

       @param k the immutable key
    */
    public Association(K k) {
     
        key = k;
        value = null;
    }
    
    /**
       Set a new value for this Association

       @param v the new value to set
    */
    public void setValue(V v) {
     
        value = v;
    }
    
    /* accessors */
    /**
       retrieve this Association's key

       @return the key of this Association
    */
    public K getKey() {
     
        return key;
    }
    
    /**
       retrieve this Association's value

       @return the value of this Association
    */
    public V getValue() {
        
        return value;
    }
    
    /**
      Produce human-readable representation of this Association's
      key and value.

      @return a human-readable representation of this Association's
      key and value
    */
    public String toString() {
     
        return "<key: " + key + ", value: " + value + ">";
    }

    /**
       Compare this Association with another for equality, defined by the
       two having equal keys, regardless of values.

       @param o the other Association
       @return true if this Association and o are equal, false otherwise
    */
    public boolean equals(Object o) {
     
        Association<K,V> other = (Association<K,V>) o;
        return other.key.equals(key);
    }
}
