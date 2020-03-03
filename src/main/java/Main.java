public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> triple = arg -> arg * 3;

        Function<Integer, Integer> square = arg -> arg * arg;

        System.out.println(compose(triple, square).apply(3));
        System.out.println(add.apply(3).apply(5));
    }

    static Function<Integer, Integer> compose(final Function<Integer, Integer> f1,
                                              final Function<Integer, Integer> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }

    static Function<Integer, Function<Integer, Integer>> add = x -> y -> x + y;
}
