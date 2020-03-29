public class Runner {

    public static void main(String[] args) {
        new Runner().run();
    }

    private void run() {

    }

    /**
     * a functional method to partially apply a curried function of two arguments to its first argument.
     * @param a
     * @param f
     * @param <A>
     * @param <B>
     * @param <C>
     * @return
     */
    private <A, B, C> Function<B, C> partialA(A a, Function<A, Function<B, C>> f){
        return f.apply(a);
    }
}
