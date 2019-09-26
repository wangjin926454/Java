package java_volume.java_volume_2_1.lambda;

/**
 * @see java_volume.java_volume_2_1.lambda.LambdaTest
 * lambda表达式的使用
 *
 * 1.举例:（o1,o2) -> Integer.compare(o1,o2)
 *
 * 2.格式:
 *      ->     : lambda操作符
 *      ->左边 :  lambda形参列表，不需要类型(接口只有一个方法的接口都可以用lambda表达式)
 *      ->右边 :  lambda表达体，重写的抽象方法的方法体
 *
 * 3.总结:
 *      ->左边 : lambda新参列表类型可以省略 如果lambda形参列表只有一个小括号可以省略
 *      ->右边 : 如果只有一条执行语句(可能是return)语句，大括号跟return都可以省略
 *
 * 4.本质 :作为函数式接口的实现(只有一个方法的接口称为函数式接口)
 * */
public class PackageInfo {
}
