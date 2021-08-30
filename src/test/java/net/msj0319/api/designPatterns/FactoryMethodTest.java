package net.msj0319.api.designPatterns;

import java.util.function.Supplier;

public class FactoryMethodTest {

}
//인터페이스를 통해 installation 메서드를 선언
interface Flooring {void installation();}

//서브클래스가 직접 인터페이스 메서드를 오버라이드하여 조건에 맞는 객체를 생성하도록 구현함
class ConcreteFlooring implements Flooring{
    @Override
    public void installation() {
        System.out.println("컨크리트 바닥 시공됨");
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
        //Supplier 인터페이스에 Flooring 객체를 담아 서브클래스가 어떤 객체를 생성할 지 결정함
        Supplier<Flooring> flooring;
        //만약 min, max가 5~20 사이 범위면 목재 바닥 시공
        if (min <= 5 && max <=20) {flooring = WoodenFlooring::new;}
        //만약 min, max가 5~45 사이 범위면 코르크 바닥 시공
        else if (min <= 5 && max <=45) {flooring = CorkFlooring::new;}
        //나머지는 컨크리트 바닥 시공
        else {flooring = ConcreteFlooring::new;}
        return flooring.get();
    }
}

