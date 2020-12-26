package huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: gb
 * @create: 2020/09/10
 */
public class Test4 {
    private static int getNum(String s){
        return Integer.parseInt(s.replace("0x",""),16);
    }


    public static void main(String [] args) {
        Scanner s = new Scanner(System.in);


        while (s.hasNext()) {
            String in = s.next();

            System.out.println(getNum(in));
        }
    }
}
