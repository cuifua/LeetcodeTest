package Test;

import kotlin.jvm.Synchronized;

/**
 * @Author cuifua
 * @Date 2021/8/17 20:20
 * @Version 1.0
 */
public class Singleton
{
    /**����ģʽ���õ�ʱ���ٴ���
    private static Singleton instanse = null;
    private Singleton(){};

    public static synchronized Singleton getInstance(){
        if(instanse == null)
            instanse = new Singleton();

        return instanse;
    }
     */

    /*
    //����ģʽ��һ�����ʹ�����
    private static Singleton instance = new Singleton();
    private Singleton(){};

    public static synchronized Singleton getInstance(){
        return instance;
    }
     */
}
