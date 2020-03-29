public interface Function<T, U> {
    U apply(T arg);

    static <T, U, V> Function<T, V> compose(final Function<U, V> f1,
                                            final Function<T, U> f2) {
        return arg -> f1.apply(f2.apply(arg));
    }
}
