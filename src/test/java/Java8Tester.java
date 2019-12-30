import java.util.*;

public class Java8Tester {


    public static void main(String[] args){

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("JDK 7 Hello world!");
            }
        }).start();


        new Thread(()->System.out.println("JDK 8 Hello World")).start();

        //-------------------------------------------
        Person person = Person.create(Person::new);
        person.setName("张三");
        System.out.println(person);

        //----------------------------------------
        List<Person> list = Arrays.asList(
                new Person("张三"),
                new Person("李四"),
                new Person("王五"),
                new Person("赵六"));
        list.forEach(System.out::println);
        list.forEach(Person::run);

    }


}
