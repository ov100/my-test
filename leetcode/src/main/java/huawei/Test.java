package huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: gb
 * @create: 2020/02/02
 */
public class Test {

    private static int MIN = 3;

    private static int exchange(int num) {

        return num < MIN ? 0 : num / MIN;
    }

    private static int batchExchange(int num){

        int count = exchange(num);
        if(count==0){
            return 0;
        }
        return count+batchExchange(count);
    }

    private static int residue(int num) {
        return num < MIN ? 0 : num % MIN;
    }

    private static boolean isBorrow(int num){
        return (num + 1) == MIN;
    }

    private static int getMax(int num){

        int exchange = batchExchange(num);

        int residue1 = residue(exchange(num));
        int residue2 = residue(num);
        int residueExchange = exchange(residue1+residue2);

        return exchange + residueExchange;
    }

    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        int num =  s.nextInt();
        System.out.println(getMax(num));
    }
}
