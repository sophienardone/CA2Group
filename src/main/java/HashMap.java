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

    /**
     * Hash function that takes a key and returns an index in the data array.
     * @param key String to be hashed in order to get an apportpit index
     * @return the abosulte value of the key modded by the length
     */
    private int hashFunction(String key){
        int slot = Math.abs(key.hashCode());
        slot = slot % data.length;
        return slot;
    }
    /**
     * Returns the number of elements in the HashMap.
     */
    public int size(){
        return numElements;
    }

    /**
     * Adds a key and value into the map
     * @param key the key (String) to be added
     * @param value the value (patient)
     * @return If a collision occurs it returns what value had the same hashed key
     */
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

    /**
     * Gets the value assigned to a key
     * @param key the key's value to be checked
     * @return a Patient object or null if one can't be found
     * @throws IllegalArgumentException If key provided is null
     */
    public Patient get(String key){
        if (key == null){
            throw new IllegalArgumentException("The key provided is null");
        }
        if (numElements == 0){
            return null;
        }

        int slot = hashFunction(key);
        if (data[slot] == null){
            return null;
        }
        for (Entry e:data[slot]){
            if (e.key.equals(key)){
                return e.value;
            }
        }
        return null;
    }

    /**
     * Removes a value attached to the key given
     * @param key the key of the value to be removed
     * @return The removed Patient or null if nothing was removed
     * @throws IllegalArgumentException If key provided is null
     */
    public Patient remove(String key) {
        if (key == null) {
            throw new IllegalArgumentException("The key provided is null");
        }
        if (numElements == 0) {
            return null;
        }

        int slot = hashFunction(key);
        if (data[slot] == null) {
            return null;
        }

        for (Entry e : data[slot]) {
            if (e.key.equals(key)) {
                Patient valueToBeDeleted = e.value;
                data[slot].remove(e);
                numElements--;
                return valueToBeDeleted;
            }
        }
        return null;
    }

    /**
     * gets all the keys in one list
     * @return a linkedlist of all the keys
     */
    public LinkedList<String> getKeys() {
        LinkedList<String> keys = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                for (int j = 0; j < data[i].size(); j++) {
                    keys.add(data[i].get(j).key);
                }
            }
        }
        return keys;
    }

    /**
     * gets a list of all the values
     * @return a linkedlist of all the values
     */
    public LinkedList<Patient> getValues() {
        LinkedList<Patient> values = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                for (int j = 0; j < data[i].size(); j++) {
                    values.add(data[i].get(j).value);
                }
            }
        }
        return values;
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
