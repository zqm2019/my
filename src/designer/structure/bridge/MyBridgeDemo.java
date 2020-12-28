
package designer.structure.bridge;

/**
 *
 * Date: 2019-04-18
 *
 * @author zhaqianming
 */
public class MyBridgeDemo extends Bridge{

    public void method(){
        getSourceAble().bridge();
    }
    public static void main(String[] args) {
        Bridge bridge =  new MyBridgeDemo();
        SubSourceOne subSourceOne = new SubSourceOne();
        bridge.setSourceAble(subSourceOne);
        bridge.method();

        SubSourceTwo subSourceTwo = new SubSourceTwo();
        bridge.setSourceAble(subSourceTwo);
        bridge.method();
    }
}
