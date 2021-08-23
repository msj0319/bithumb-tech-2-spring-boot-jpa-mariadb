package net.msj0319.api.util;

import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Component
public class Proxy {    //자주 사용하는 것을 미리 작성
    public static Consumer<String> print = System.out::print;

    public static Function<Object, String> toString = String::valueOf;
    public static Function<String, Integer> strToInteger = Integer::parseInt;

    public static Function<Integer, Integer> intAbs = Math::abs;
    public static Function<Double, Double> doubleAbs = Math::abs;
    public static Function<Float, Float> floatAbs = Math::abs;
    public static Function<Long, Long> longAbs = Math::abs;

    public static Function<Double, Double> ceil = Math::ceil;
    public static Function<Double, Double> floor = Math::floor;

    public static BiFunction<Integer, Integer, Integer> intMax = (f, s) -> Math.max(f, s);
    public static BiFunction<Double, Double, Double> doubleMax = (f, s) -> Math.max(f, s);
    public static BiFunction<Long, Long, Long> longMax = (f, s) -> Math.max(f, s);
    public static BiFunction<Float, Float, Float> floatMax = (f, s) -> Math.max(f, s);

    public static BiFunction<Integer, Integer, Integer> intMin = Math::min;
    public static BiFunction<Long, Long, Long> longMin = Math::min;
    public static BiFunction<Double, Double, Double> doubleMin = Math::min;
    public static BiFunction<Float, Float, Float> floatMin = Math::min;

    public static Supplier<Double> random = Math::random;
    public static BiFunction<Integer, Integer, Integer> rangeRandom = (f, s) -> (int)(Math.random() * (s - f)) + f + 1;

    public static Function<Double, Double> rint = Math::rint;
}
