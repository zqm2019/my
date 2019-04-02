
package designer.createFactory.singleton;

/**
 * 单例模式
 * Date: 2019-04-02
 *
 * @author zhaqianming
 */
public class Singleton {

    //私有静态变量 -- 防止被引用
    //赋值为 null -- 实现延迟加载
    private static Singleton instance = null;

    //私有构造方法 -- 防止外部
    private Singleton() {

    }

    //提供一个对外获取本实例的方法
    public static Singleton getInstance() {
        if (instance == null) {
            return new Singleton();
        } else {
            return instance;
        }
    }

    /**
     * getInstance() 在多线程情况下会出现问题，如何解决
     */
    public static synchronized Singleton getInstance2(){
        if (instance == null) {
            return new Singleton();
        } else {
            return instance;
        }
    }

    /**
     * getInstance2() 方法每次都要加锁会降低性能，只要对创建对象的时候加锁即可
     */
    public static Singleton getInstance3(){
        if (instance == null){
            synchronized (instance){
                instance = new Singleton();
            }
        }
        return instance;
    }
}
