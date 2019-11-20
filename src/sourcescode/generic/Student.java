package sourcescode.generic;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    public static void main(String[] args){
        List<? extends Person> list = null;
        List<? super Person> list1 = null;

        List<Person> list2 = new ArrayList<>();
        List<Student> list3 = new ArrayList<>();
        List<Object> list4 = new ArrayList<>();

        Person person = list2.get(0);
        //Student student = list2.get(0);  //父类无法赋值给子类

        list = list2;
        Person person1 = list.get(0);
        //Student student = list.get(0);

        list1 = list2;
        Object object = list1.get(0);

        //list1 = list3;   //error
        list = list3;

        //list = list4;    //error
        list1 = list4;


    }
}
