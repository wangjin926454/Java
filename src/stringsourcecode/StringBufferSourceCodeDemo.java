package stringsourcecode;

public class StringBufferSourceCodeDemo {
    //AbstractStringBuilder中初始化
    /*
    默认长度16
    new String(str)时，AbstractStringBuilder初始化长度为str.length+16
    然后append(str)追加
    StringBuffer与StringBuilder都继承与AbstractStringBuilder
    StringBuffer添加synchronized关键字
    * */
    StringBuffer sb = new StringBuffer("wangjin");
    StringBuilder sb1 = new StringBuilder("wangjiN");
}
