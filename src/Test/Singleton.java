package Test;

import kotlin.jvm.Synchronized;

/**
 * @Author cuifua
 * @Date 2021/8/17 20:20
 * @Version 1.0
 */
public class Singleton
{
    /**懒汉模式，用的时候再创建
    private static Singleton instanse = null;
    private Singleton(){};

    public static synchronized Singleton getInstance(){
        if(instanse == null)
            instanse = new Singleton();

        return instanse;
    }
     */

    /*
    //饿汉模式，一上来就创建好
    private static Singleton instance = new Singleton();
    private Singleton(){};

    public static synchronized Singleton getInstance(){
        return instance;
    }
     */
}
