package Collections;

import java.util.*;

public class MapPractice {

    public Object findValueOf(Map map, Object key) {
        return map.get(key);
    }

    public Object[] findKeysOf(Map map, Object value) {
        List<Object> res = new ArrayList<Object>();
        for (Object key:map.keySet()) {
            if (map.get(key).equals(value)){
                res.add(key);
            }
        }
        return res.toArray();
    }

    public Map<Integer, Integer> fibonacciTree(int size) {
        Map<Integer, Integer> res = new TreeMap<Integer, Integer>();
        if (size == 0){
            return res;
        }else if (size == 1){
            res.put(1,1);
            return res;
        }else{
            res.put(1,1);
            res.put(2,1);
            int start = 3;
            while (start <= size){
                res.put(start, res.get(start-2) + res.get(start-1));
                start++;
            }
        }
        return res;
    }

    public Map<Integer, Integer> crazySpiral(Integer first, Integer second, Integer size) {
        Map<Integer, Integer> res = new TreeMap<Integer, Integer>();
        if (size == 0){
            return res;
        }else if (size == 1){
            res.put(1,first);
            return res;
        }else{
            res.put(1,first);
            res.put(2,second);
            int start = 3;
            while (start <= size){
                res.put(start, res.get(start-2) + res.get(start-1));
                start++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MapPractice map_p = new MapPractice();
        System.out.println(map_p.fibonacciTree(2));
        System.out.println(map_p.crazySpiral(3, -4, 12));

        Map map1 = new TreeMap<String, String>();
        map1.put("Mario", "Mario Bros.");
        map1.put("Donkey Kong", "Donkey Kong");
        map1.put("Link", "Legend of Zelda");
        map1.put("Samus Aran", "Metroid");
        map1.put("Yoshi", "Yoshi's World");
        map1.put("Kirby", "Kirby");
        map1.put("Fox McCloud", "Star Fox");
        map1.put("Pikachu", "Pokemon");
        map1.put("Luigi", "Mario Bros.");
        map1.put("Captain Falcon", "F-Zero");
        map1.put("Ness", "EarthBound");
        map1.put("Jigglypuff", "Pokemon");
        System.out.println(Arrays.toString(map_p.findKeysOf(map1,"Pokemon")));

    }
}
