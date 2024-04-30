import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;

public class HashMap {
    private LinkedList<Entry>[] data;
    private int numElements;

    public HashMap() {
        //50 is the default capacity
        data = new LinkedList[50];
        numElements = 0;
    }

    public HashMap(LinkedList<Entry>[] data) {
        this.data = data;
        numElements = 0;
    }

    private int hashFunction(String key){
        int slot = Math.abs(key.hashCode());
        slot = slot % data.length;
        return slot;
    }

    public int size(){
        return numElements;
    }

    public Patient put(String key, Patient value){
        int slot = hashFunction(key);
        //There is no linkedlist in that spot
        if (data[slot]==null){
            /*Entry e = new Entry(key,value);
            data[slot] = e;*/

            /*LinkedList<Entry> e = new LinkedList<Entry>();
            data[slot] = e;*/
            data[slot] = new LinkedList<Entry>();
        } else {
            //There is a linkedlist in data[slot] so now we iterate over each Entry
            //to see if there's one with the same key
            for (Entry e:data[slot]){
                //If the key was found
                if (e.key.equals(key)){
                    Patient old = e.value;
                    e.value = value;
                    return old;
                }
            }
        }
        Entry newEntry = new Entry(key,value);
        data[slot].add(newEntry);
        numElements++;

        return null;
    }

    private static class Entry{
        protected final String key;
        protected Patient value;

        public Entry(String key, Patient value){
            this.key = key;
            this.value = value;
        }

        /*public String getKey() {
            return key;
        }

        public Patient getValue() {
            return value;
        }
        public Patient updateValue(Patient newVal){
            Patient oldVal = value;
            this.value = newVal;
            return oldVal;
        }*/
    }
}
