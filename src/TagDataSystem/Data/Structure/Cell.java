package TagDataSystem.Data.Structure;

public class Cell<K, V> {
    private NodeCell<K,V>[] table;

  /*  public V getValue(K k) {
        for (int i = 0; i < table.length; i++) {
            if (name[i].equals(k)) {
                return value[i];
            }
        }
        return null;
    }*/

    public void add(V v, K k) {
        //   V[] newValue = new V [this.value.length+1];
    }

    public Class getClassValue() {
        V v = null;
        return v.getClass();
    }

    public Class getClassKey() {
        K k = null;
        return k.getClass();
    }
}


