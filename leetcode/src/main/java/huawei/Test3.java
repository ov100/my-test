package huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @description:
 * @author: gb
 * @create: 2020/09/10
 */
public class Test3 {

    private static Integer[] getNum(String in){
       String[] array = in.split(" ");

        Set<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < array.length; i++) {
            Integer num = Integer.parseInt(array[i]);
            set.add(num);
        }

        Arrays.sort(set.toArray());

        Integer [] result = new Integer[set.size()];
        return set.toArray(result);
    }


    public static void main(String [] args){
        Scanner s = new Scanner(System.in);


        while (s.hasNext()){
            String in = s.next();

            Integer[] result = getNum(in);

            for(int i=0;i<result.length;i++){
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
}
