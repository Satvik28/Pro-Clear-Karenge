package JavaSols;

/*
 Two approaches added, one using hash map (O(n) extra space) and one using
 */

import java.util.*;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            String str = scanner.next();
            System.out.println(mergeAlpha(str.toLowerCase()));
        }

    }

    private static String mergeAlpha(String str) {
        StringBuilder s = new StringBuilder();
        s.append(str.charAt(0));
        int count = 1;
        for (int i = 1; i <str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
//            System.out.println(curr);
//            System.out.println(prev);
            if (curr == prev) {
                count++;
            } else{
                if (count>1){
                    s.append(count);
                    count = 1;
                }
                s.append(curr);
            }
        }
        if (count>1){
            s.append(count);
            count = 1;
        }
        return s.toString();
    }

//    static String mergeAlpha(String str) {
//        char[] charArr = str.toCharArray();
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        for (Character c: charArr) {
//            if (hashMap.containsKey(c)){
//                int v = hashMap.get(c);
//                hashMap.put(c, v+1);
//            } else {
//                hashMap.put(c, 1);
//            }
//        }
//        StringBuilder compressedStr = new StringBuilder();
//        for (Map.Entry<Character, Integer> m : hashMap.entrySet()) {
//            compressedStr.append(m.getKey());
//            compressedStr.append(m.getValue());
//        }
//        return compressedStr.toString();
//    }
}

