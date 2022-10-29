package HashMaps;

public class MapUse {
    public static void main(String[] args){
        Map<String, Integer> hashMap = new Map<>();
        for(int i =0; i<10; i++){
            hashMap.insert("abc" + i, i+1);
            System.out.println(hashMap.getLoadFactor());
        }
        for(int i = 0; i<10; i++){
            System.out.print("abc" +i + " -> ");
            System.out.println(hashMap.get("abc" + i));
        }

    }
    
}
