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


    private static class Entry{
        private final String key;
        private Patient value;

        public Entry(String key, Patient value){
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Patient getValue() {
            return value;
        }
        public Patient updateValue(Patient newVal){
            Patient oldVal = value;
            this.value = newVal;
            return oldVal;
        }
    }
}
