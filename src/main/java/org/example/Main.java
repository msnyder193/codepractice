package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        duplicateCount("Hello World");
//        stringSplit("aaabbbccc");
//        stringEndsWith("hello world", "rld");
//        findNextSquare(121);
//        reverseString("hello");
//        int[] num = { 1, 2, 3, 4};
//        sumOfNumbers(num);
//        pinIsNumAndFourOrSixDigits("-a12");
//        pinIsNumAndFourOrSixDigits("6666");
        getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1, 5, 6}, new Object[] { 1, 1 }, new Object[] { 5, 6, 7, 8, 9 }});


    }


    public static void duplicateCount(String text) {
        // Write your code here
        String repeat = text.toLowerCase();
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < repeat.length() - 1; i++) {
            if (charCount.containsKey(repeat.charAt(i))) {
                Integer count = charCount.get(repeat.charAt(i));
                charCount.put(repeat.charAt(i), count + 1);
            } else {
                charCount.put(repeat.charAt(i), 1);
            }
        }
        for ( Map.Entry<Character,Integer> set : charCount.entrySet()) {
            System.out.println(set.getKey() + " = " + set.getValue());
        }
    }

    public static void stringSplit(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < text.length() -2; i+=2) {
            sb.append(text.substring(i, i + 2));
            sb.append(" ");
        }
        if (text.length() % 2 == 1) {
            sb.append(text.charAt(text.length() - 1)).append("_");
        }
        System.out.println(sb);
    }

    public static void stringEndsWith(String str, String ending) {
        System.out.println(str.endsWith(ending));
    }

    public static void findNextSquare(long sq) {
        double sr = Math.sqrt(sq);
        if ( (sr - Math.floor(sr)) != 0) {
            System.out.println("not a perfect square");
        } else {
            double result = (Math.sqrt(sq)) + 1;
            long nextSquare = (long) (result * result);
            System.out.println(nextSquare);
        }
    }

    public static void reverseString(String s) {
//        String[] letters = s.split("");
//        List<String> result = new ArrayList<String>(Arrays.asList(letters));
//        Collections.reverse(result);
//
//        String join = String.join("",result);
//        System.out.println(join);

        System.out.println(new StringBuilder(s).reverse().toString());
    }

    public static void sumOfNumbers(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        for (int i : numbers) {
            result.add(i);
        }

        int highest = Collections.max(result);
        int lowest = Collections.min(result);
        result.remove(Integer.valueOf(highest));
        result.remove(Integer.valueOf(lowest));

        System.out.println(result.stream().mapToInt(Integer::intValue).sum());
    }

    public static void pinIsNumAndFourOrSixDigits(String pin) {
        String s = pin.matches("\\d{4}|\\d{6}") ? "true" : "false";
        System.out.println(s);
    }

    public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
    {
//     List<Object[]> sortedList = Arrays.stream(arrayOfArrays).sorted().collect(Collectors.toList());
        int sum = 0;
        if(arrayOfArrays.length == 0){
            return 0;
        }
        sum = (arrayOfArrays.length + 1)*(arrayOfArrays.length + 2)/2;
        for(Object[] o : arrayOfArrays){
            sum = sum - o.length;
            if(o == null){
                return 0;
            }
        }
        return sum;
    }

    public static boolean getXO (String str) {
        //case insensitive
        str = str.toLowerCase();
        String[] letters = str.split("");
        Map<String, Integer> map = new HashMap<String, Integer>();
        //check amount of os and xs
        for(int i = 0; i < letters.length; i++) {
            if(!map.containsKey(letters[i])) {
                map.put(letters[i], 1);
            } else {
                map.put(letters[i], map.get(letters[i]) + 1);
            }
        }
        return (map.get("o") == map.get("x"));

    }
}
