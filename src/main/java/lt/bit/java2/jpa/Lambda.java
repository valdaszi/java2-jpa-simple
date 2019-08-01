package lt.bit.java2.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lambda {

    public static void main(String[] args) {
        new Lambda().a();
    }

    void a() {

        List<Double> list = new ArrayList<>();
        list.add(10.0);
        list.add(Math.PI);
        System.out.println("1: " + list);

        list = modifyList(list, x -> x + 1);
        System.out.println("2: " + list);

        list = modifyList(list, x -> x * x);
        System.out.println("3: " + list);

        //list = modifyList(list, (x) -> this.sqrt(x));
        list = modifyList(list, this::sqrt);
        System.out.println("4: " + list);

        list = list.stream()
                .map(x -> x * x)
                .sorted()
                .collect(Collectors.toList());

    }

    Double sqrt(Double a) {
        return Math.sqrt(a);
    }

    List<Double> modifyList(List<Double> src, Function<Double, Double> calc) {
        List<Double> result = new ArrayList<>();
        for (Double d : src) {
            result.add(calc.apply(d));
        }
        return result;
    }
}



