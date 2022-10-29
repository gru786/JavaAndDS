package HashMaps;

import java.util.ArrayList;

public class Map <K,V> {
    private ArrayList<MapNode<K,V>> bucket;
    private int count = 0;
    private int bucketSize;

    public Map(){
        bucketSize = 5;
        bucket =  new ArrayList<>();
        for(int i=0; i< bucketSize; i++){
            bucket.add(null);
        }
    }

    private int getHC(K key){
        int hashC = key.hashCode();
        return hashC % bucketSize;
    }
    public void insert(K key, V value){
        MapNode<K,V> head = new MapNode<>(key, value);
        int index = getHC(key);
        MapNode<K,V> temp = bucket.get(index);
        while(temp!= null){
            if(temp.key.equals(key)){
                temp.value = value;
            }

            temp = temp.next;
        }
        temp = bucket.get(index);
        bucket.set(index, head);
        head.next = temp;
        
        count++;
        double loadFactor = (1.0 * count)/bucketSize;
        if(loadFactor > 0.7){
            reHash();
        }

    }
    public double getLoadFactor(){
        double loadFactor = (1.0 * count)/bucketSize;
        return loadFactor;
    }

    private void reHash(){
        ArrayList<MapNode<K,V>> temp = bucket;
        bucket = new ArrayList<>();
        bucketSize = bucketSize*2;
        for(int i =0; i< bucketSize; i++){
            bucket.add(null);
        }
        count = 0;
        for(int i=0; i<temp.size(); i++){
            MapNode<K,V> head = temp.get(i);
            while(head!= null){
                insert(head.key, head.value);
                head = head.next;
            }
        }
    }

    public V get(K key){
        int index = getHC(key);
        MapNode<K,V> temp = bucket.get(index);
        while(temp!= null){
            if(temp.key.equals(key)){
                return temp.value;
            }

            temp = temp.next;
        }

        return null;

    }

    public int size(){
        return this.count;
    }

    public V delete(K key){
        int index = getHC(key);
        MapNode<K,V> temp = bucket.get(index);
        MapNode<K,V> prev = null;
        while(temp!= null){
            if(temp.key.equals(key)){
                if(prev!=null){
                    prev.next = temp.next;
                }
                else{
                    bucket.set(index, temp.next);
                }
                count--;
                return temp.value;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }
}
