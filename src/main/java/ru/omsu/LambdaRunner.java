package ru.omsu;

import java.util.function.BiPredicate;
import java.util.function.Function;

public class LambdaRunner {
    public static <T, R> R run(Function<T, R> function, T t) {
        return function.apply(t);
    }

    public static <T, U> boolean run(BiPredicate<T, U> biPredicate, T t, U u) {
        return biPredicate.test(t, u);
    }
}