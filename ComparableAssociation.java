
/**
 * Associate key/value pairs.  keys are immutable and comparable.
 * 
 * @author Jim Teresco 
 * @version Fall 2020
 *
 */
public class ComparableAssociation<K extends Comparable,V> implements Comparable<ComparableAssociation<K,V>>
{
    /* instance variables to store our key and our value */
    private K key;
    private V value;

    /**
    construct a new Association with the given key/value pair.

    @param k the immutable key
    @param v the initial value
     */
    public ComparableAssociation(K k, V v) {

        key = k;
        value = v;
    }

    /**
    construct a new Association with the given key, but no value.
    value defaults to null.

    @param k the immutable key
     */
    public ComparableAssociation(K k) {

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
    retrieve this ComparableAssociation's key

    @return the key of this ComparableAssociation
     */
    public K getKey() {

        return key;
    }

    /**
    retrieve this ComparableAssociation's value

    @return the value of this ComparableAssociation
     */
    public V getValue() {

        return value;
    }

    /**
    Produce human-readable representation of this ComparableAssociation's
    key and value.

    @return a human-readable representation of this ComparableAssociation's
    key and value
     */
    public String toString() {

        return "<key: " + key + ", value: " + value + ">";
    }

    /**
    Compare this ComparableAssociation with another for equality, defined by the
    two having equal keys, regardless of values.

    @param o the other ComparableAssociation
    @return true if this ComparableAssociation and o are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {

        ComparableAssociation<K,V> other = (ComparableAssociation<K,V>) o;
        return other.key.equals(key);
    }

    /**
     * Compare ComparableAssociation with another, using the compareTo
     * method of the keys.
     * 
     * @param o The other ComparableAssociation
     * @return The comparison of this ComparableAssociation with the other.
     */
    @Override
    public int compareTo(ComparableAssociation<K,V> o) {
        
        return key.compareTo(o.key);
    }

}
