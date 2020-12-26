package design;

/**
 * 单列共有几种，随便实现一种即可
 * 1、懒汉式
 * 2、饿汉式
 * 3、双重锁
 * 4、内部类
 * 5、枚举类
 */
public class Sigleton {

    private static Sigleton obj = null;

    private Sigleton() {

    }

    public synchronized static Sigleton getIntance() {
        //
        if (obj == null) {
            obj = new Sigleton();
        }
        return obj;
    }

    public static void main(String[] args) {

        Sigleton obj = Sigleton.getIntance();

    }
}
