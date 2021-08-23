package net.msj0319.api.designPatterns;

import java.util.function.Supplier;

public class FactoryMethodTest {

}
interface Flooring {void installation();}
class ConcreteFlooring implements Flooring{
    @Override
    public void installation() {
        System.out.println("'코크 바닥 시공됨");
    }
}
class WoodenFlooring implements Flooring{
    @Override
    public void installation() {
        System.out.println("'목재 바닥 시공됨");
    }
}
class CorkFlooring implements Flooring{
    @Override
    public void installation() {
        System.out.println("'코르크 바닥 시공됨");
    }
}
class FlooringFactoty {
    static Flooring getFlooring(int min, int max) {
        Supplier<Flooring> flooring;
        if (min <= 5 && max <=20) {flooring = WoodenFlooring::new;}
        else if (min <= 5 && max <=45) {flooring = CorkFlooring::new;}
        else {flooring = ConcreteFlooring::new;}
        return flooring.get();
    }
}

