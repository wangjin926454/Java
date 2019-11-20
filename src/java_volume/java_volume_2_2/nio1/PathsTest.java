package java_volume.java_volume_2_2.nio1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Paths类学习
 * Paths类适合中等长度的文本文件。如果要处理的文件长度比较大，或者是二进制文件，
 * 那么还是应该使用所熟知的输入/输出流或读入/写入流
 * */
public class PathsTest {
    public static void main(String[] args) throws IOException {
        //自动构建一个基于系统的相对路径，如果括号中是绝对路径则返回一个绝对路径
        Path path = Paths.get("src","java_volume","java_volume_2_2","a.txt");

        //p.resolve(q)如果q是绝对路径则返回q，否则根据文件系统的规则，将p后面跟着q作为结果
        Path p = Paths.get("src");
        p = p.resolve("java_volume");

        //解析父路径产生对应的兄弟路径
        Path rsb = p.resolveSibling("effectivejava");

        //p.relativize(r)将产生路径q，而对q进行解析的路径结果正是r
        //下面两行结果一级目录相同    ..\java_volume\java_volume_2_2
        Path path1 = Paths.get("src","effectivejava");
        Path path2 = Paths.get("src","java_volume","java_volume_2_2");
        Path path5 = path1.relativize(path2);
        //下面两行结果一二级目录相同    java_volume\java_volume_2_2
        Path path3 = Paths.get("src","java_volume");
        Path path4 = Paths.get("src","java_volume","java_volume_2_2");
        Path path6 = path3.relativize(path4);
        //产生给定路径的绝对路径
        System.out.println(path3.toAbsolutePath());
        //获取该路径的父路径
        System.out.println(path2.getParent());
        //获取该路径的绝对路径的根路径,相对路径没有根路径
        System.out.println(path2.toAbsolutePath().getRoot());
        //获取路径文件名，没有文件名则获取最后一个路径
        System.out.println(path2.getFileName());
        //利用Paths.get()和Scanner读取文件
        Scanner sc = new Scanner(Paths.get("src","java_volume","java_volume_2_2","a.txt"));
        //当需要File类与Path接口互相转换时可以使用toFile方法和toPath方法从该路径创建一个File或Path对象
        System.out.println(path5);
        System.out.println(path6);
        System.out.println(rsb);
        System.out.println(p);
        System.out.println(path);
    }
}
