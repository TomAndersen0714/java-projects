package cn.tomandersen.java.DesignPattern.SimpleFactoryPattern;

/**
 * @Author TomAndersen
 * @Date 2020/1/14
 * @Version
 * @Description
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
