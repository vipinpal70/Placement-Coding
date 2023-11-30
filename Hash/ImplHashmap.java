package Hash;

import java.util.*;

public class ImplHashmap {

    static class HashMap<K, V> { // generic
        private class node {
            K key;
            V value;

            node(K key, V data) {
                this.key = key;
                this.value = data;

            }
        }

        private int n; // size
        private int N; 
        private LinkedList<node> buckets[]; // n buckets

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N ;
        }
        private int SearchInLL(K key, int bi){
            LinkedList<node>  ll = buckets[bi];
            int di = 0;
            for (int i = 0; i < ll.size(); i++) {
                node n = ll.get(i);
                if(n.key == key){
                    return di;
                }
                di++;
            }

            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    node n = ll.remove();
                    put(n.key, n.value);
                }

            }
        }
        // put function
        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = SearchInLL(key,bi);   // valid:  -1

            if (di != -1) {
                node n = buckets[bi].get(di);
                n.value = value;
            } else{
                buckets[bi].add(new node(key,value));
                n++;
            }


            double lambda  = (double)(n/N);
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key,bi); // valid:
            
            if (di != -1) {
               return true;
            } else{
                return false;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key,bi); // valid:
            
            if (di != -1) {
                node n = buckets[bi].get(di);
                return n.value;
            } else{
                return null;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key,bi); // valid:
            
            if (di != -1) {
                node nd = buckets[bi].remove(di);
                n--;
                return nd.value;
            } else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<K>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<node> ll = buckets[i];
                for (node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {

    }
}