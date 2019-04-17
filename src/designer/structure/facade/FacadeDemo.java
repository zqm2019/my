
package designer.structure.facade;

/**
 * 为了启动电脑，必须要启动cpu、内存、磁盘，为了减少三个之间的耦合，我们创建外观模式类。
 * FacadeDemo 拥有三个对象的私有实例，并且默认的构造器中有能获取到三个实例的方法，
 * 然后将功能内聚
 * Date: 2019-04-17
 *
 * @author zhaqianming
 */
public class FacadeDemo {
    private Cpu cpu;
    private Disk disk;
    private Memery memery;

    public FacadeDemo() {
        this.cpu = new Cpu();
        this.disk = new Disk();
        this.memery = new Memery();
    }

    public void startUp(){
        System.out.println("Computer is startUp");
        cpu.startUp();
        memery.startUp();
        disk.startUp();
        System.out.println("Computer is startUp finished");
    }

    public void shutDown(){
        System.out.println("Computer is shotDown");
        cpu.shutDown();
        memery.shutDown();
        disk.shutDown();
        System.out.println("Computer is shotDown finished");
    }

    public static void main(String[] args) {
        FacadeDemo facadeDemo = new FacadeDemo();
        facadeDemo.startUp();
        facadeDemo.shutDown();
    }


}
