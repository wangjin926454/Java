package athena;

public class MyObject {
    public String field01;
    public MyObject() {
    }
    public MyObject(MyObject object) {
        this.field01 = object.field01;
    }
    public static MyObject newInstance(MyObject object) {
        MyObject myObject = new MyObject();
        myObject.field01 = object.field01;
        return myObject;
    }
}