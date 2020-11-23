package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ArrayLists {

    public ArrayList<Integer> addShit(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if(list2.size() > 0){
            list1.addAll(list2);
        }
        return list1;
    }

    public Integer addShitTogether(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int res = 0;
        for (Integer n: list1) {
            res += n;
        }
        for (Integer n: list2) {
            res += n;
        }

        return res;
    }

    public ArrayList<Integer> removeAll(ArrayList<Integer> original, Integer toRemove) {
        ArrayList <Integer> res = new ArrayList<Integer>();
        for (Integer integer : original) {
            if (!integer.equals(toRemove)) {
                res.add(integer);
            }
        }
        return res;
    }

    public boolean happyList(ArrayList<String> original) {
        if (original.size() < 2){
            return true;
        }
        Set<Character> prev = new HashSet<Character>();
        boolean hasChar;
        for (int i = 1; i < original.size(); i++) {
            prev.clear();
            hasChar = false;
            for (int j = 0; j<(original.get(i-1).length());j++) {
                prev.add(original.get(i-1).toLowerCase().charAt(j));
            }
            for (int j = 0; j<(original.get(i).length());j++) {
                if(prev.contains(original.get(i).toLowerCase().charAt(j))){
                    hasChar = true;
                    break;
                }
            }
            if(!hasChar){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        ArrayList<Integer> original = new ArrayList<Integer>();
//        original.add(5);
//        original.add(5);
//        original.add(5);
//        original.add(7);
//        original.add(7);
        ArrayLists ar = new ArrayLists();
//        ar.removeAll(original, 5);
//        System.out.println(original);
//        ArrayList<String> originals = new ArrayList<String>();
//        originals.add("getexcited");
//        originals.add("this");
//        originals.add("shit");
//        originals.add("is");
//        originals.add("goingdown");
//        System.out.println(ar.happyList(originals));

        ArrayList<Integer> original = new ArrayList<Integer>();
        original.add(5);
        original.add(5);
        original.add(5);
        original.add(7);
        original.add(7);
        // When
        Integer toRemove = 5;
        ArrayList<Integer> actual = ar.removeAll(original, toRemove);
        original.remove(0);
        System.out.println(original);
        original.remove(0);
        System.out.println(original);
        original.remove(0);
        System.out.println(original);
    }
}
