import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionInterfaceTest {

    public void testLambda(){
        func("JDK 7",new FunctionInterface(){
            @Override
            public void testParam(String param) {
                System.out.println("param:"+param);
            }

            @Override
            public void test() {
                System.out.println("JDK 7 test");
            }


        });

    }

    private void func(String param,FunctionInterface functionInterface){
        functionInterface.test();
        functionInterface.testParam(param);
    }

    public static void main(String[] args){
        //---------------------------------------------
        FunctionInterfaceTest test = new FunctionInterfaceTest();
        test.testLambda();

        //----------------------------------------------
        Supplier<Integer> supplier = ()->Integer.valueOf("1");
        System.out.println(supplier.get());

        //----------------------------------------------
        Consumer<Integer> consumer = (x)->{int num = x*2;System.out.println("num:"+num);};

        Consumer<Integer> consumer1 = (x)->{int num = x*3;System.out.println("num:"+num);};

        consumer.andThen(consumer1).accept(10);

    }
}
