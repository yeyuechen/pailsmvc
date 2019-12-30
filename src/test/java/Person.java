import java.util.function.Supplier;

public class Person {

    private String name;

    Person(String name){
        this.name=name;
    }

    Person(){

    }

    public static  Person create(Supplier<Person> supplier){
        return supplier.get();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println(name+"is running");
    }

    public String toString(){
        return "Person={name:'"+name+"'}";
    }
}
