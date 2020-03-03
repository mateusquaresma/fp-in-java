public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> triple = arg -> arg * 3;

        Function<Integer, Integer> square = arg -> arg * arg;

        System.out.println(compose(triple, square).apply(3));

        Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
        System.out.println(add.apply(3).apply(5));

        IntBinaryOperator add2 = x -> y -> x + y;
        IntBinaryOperator mult = x -> y -> x * y;

        System.out.println(add2.apply(2).apply(9));
        System.out.println(mult.apply(5).apply(7));

        Function<Function<Integer, Integer>,
                 Function<Function<Integer, Integer>,
                          Function<Integer, Integer>>> comp = x -> y -> z -> x.apply(y.apply(z));

        Function<Integer, Integer> f = comp.apply(square).apply(triple);
        System.out.println(f.apply(7));



    }

    static <T> T blah(T param) {
        return param;
    }

    static <T, U> U test(T param, Function<T, U> f1) {return f1.apply(param);}
//    static <A, B, R> Function<Function<A, B>,
//            Function<Function<R, A>,
//                    Function<R, B>>> polyCompose = x -> y -> z -> x.apply(y.apply(z));

    static Function<Integer, Integer> compose(final Function<Integer, Integer> f1,
                                              final Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }
}
