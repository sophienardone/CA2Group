import java.util.LinkedList;

public class HashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private Entry[] data;
    private int numElements;

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
