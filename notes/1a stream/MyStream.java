import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MyStream {

    public static void main(String[] strings){

        List<String> l1=new ArrayList<>();
        l1.add("aaa");
        l1.add("bbb");
        Stream<String> s1=l1.stream();
        l1.add("sdfsdf");
        s1.forEach(unit -> System.out.println(unit));
        //s1只能被消费一次,否则会报错,再次消费需要重新stream()生成对象

        List<String> l2=new ArrayList<>();
        l1.stream().forEach(unit -> 
        {
            l2.add(unit);
            System.out.println(1);
        }
        );

        Stream<String> s2=l1.stream().filter(unit -> unit.startsWith("a"));
        s2.forEach(unit -> System.out.println(unit));


        //判断List里有没有
        Boolean b=l1.stream().anyMatch(u ->u.startsWith("a"));

        //找到List里第一个符合条件的
        Optional<String> o1=l1.stream().filter(u ->u.startsWith("a")).findFirst();
        o1.get();

    }
}
