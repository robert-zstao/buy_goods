package com.robert.goods.exception;

/**
 * 原型设计模式
 * @Author robert
 * @Date 2021/3/23 11:44
 * @Version 1.0
 *
 * 原型设计模式是为了减少重复对象的创建次数，而是使用clone
 * 假设在我们使用构造方法的时候需要从数据库查询数据封装到实体中，
 * 每次创建都会进行查询数据库操作。在查询到的数据一定时间内不会改变的情况下这种行为是浪费性能的。
 *  我们可以在初始化的时候查询数据库数据封装到实体中，每次创建新的对象时复制此对象并返回。
 */
public class Prototype implements Cloneable{
    private String name;

    public Prototype(){
        this.name = "张三";
        System.out.println("这是在创建原型对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone(){
        Object clone = null;
        try {
            clone = super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}

/**
 * 对象工厂
 */
class PrototypeFactory {

    //此处使用饿汉式单例模式 只执行一次构造方法 使用静态是为了保证构造只使用一次.如果使用多次那么和new一个对象没什么区别
    private static Prototype persion = new Prototype();

    public static Prototype getPrototype(){

        return  (Prototype) persion.clone();
    }
}

class Test{
    public static void main(String[] args) {
        prototypeMode();
    }
    public static void prototypeMode(){
            Prototype prototype = PrototypeFactory.getPrototype();
            Prototype prototype1 = PrototypeFactory.getPrototype();
            Prototype prototype2 = PrototypeFactory.getPrototype();
            System.out.println("地址值==:"+prototype );
            System.out.println("地址值==:"+prototype1);
            System.out.println("地址值==:"+prototype2);

    }
}
