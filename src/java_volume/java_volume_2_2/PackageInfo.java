package java_volume.java_volume_2_2;

/**
 * java.io操作集合
 *
 * 文字类采用字符流。图片视频等采用字节流  。  只是复制文件采用什么都可以，需要读到程序中则需要分类
 *      因为现实出来会有编码问题。汉字占3字节，如果读可能一次会出现只读了一个字的1/3 或 2/3导致乱码
 * InputStream OutputStream Reader Writer
 * Closeable接口 Flushable接口 Appendable接口 Readable接口
 * 其中Closeable接口实现了AutoCloseable接口,Closeable接口只抛出IOException，AutoCloseable抛出Exception
 * InputStream实现了Closeable
 * OutputStream实现了Closeable、Flushable
 * Reader实现了Closeable、Readable
 * Writer实现了Closeable、Flushable、Appendable
 * StringBuilder实现了Appendable接口
 * CharBuffer实现了Appendable
 * */
public class PackageInfo {
}
