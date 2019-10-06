package util;

public interface KeyValueReader<K,V> {
    public V getValue(K key);
    public void updateValue(K key, V value);
    public void clearContents();
    public boolean hasContents();
}
