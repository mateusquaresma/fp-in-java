public interface Function<T, U> {
    U apply(T arg);

    static <T, U, V> Function<T, V> compose(final Function<U, V> f,
                                            final Function<T, U> g) {
        return x -> f.apply(g.apply(x));
    }

    static <T, U, V> Function<Function<U, V>,
                     Function<Function<T, U>,
                              Function<T, V>>> higherCompose() {
        return f -> g -> x -> f.apply(g.apply(x));
    }

    static <T, U, V> Function<Function<T, U>,
                     Function<Function<U, V>,
                              Function<T, V>>> higherAndThen(){
        return f -> g -> x -> g.apply(f.apply(x));
    }

}
