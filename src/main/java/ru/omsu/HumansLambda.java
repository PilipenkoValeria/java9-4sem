package ru.omsu;

public interface HumansLambda<X, Y, Z, U> {
    boolean apply(X x, Y y, Z z, U u);
}
