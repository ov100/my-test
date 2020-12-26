package huawei;

import java.util.Scanner;

/**
 * @description:
 * @author: gb
 * @create: 2020/09/09
 */
public class Test2 {
    private static int MIN = 3;
    private static int SUB_NUM = 2;

    private static int getMax(int num){
        int exchange = 0;

        //开始兑换
        while(num>=MIN){

            //每次减去3个兑换，新增1个
            num -= SUB_NUM;
            exchange ++;
        }

        //最后余下2个时，向老板借1
        if((num+1)==MIN){
            exchange ++;
        }

        return exchange;
    }

    public static void main(String [] args){
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            int num =  s.nextInt();
            System.out.println(getMax(num));
        }
    }
}
