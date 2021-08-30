package net.msj0319.api.designPatterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

public class DecoratorTest {
    class Burger {
        private String burgerType;
        //버거가 어떤 야채와 치즈로 이루어진 음식인지 이름을 붙여나가는 생성자
        public Burger() {
            this.burgerType = "";
        }

        private Burger(String type) {
            this.burgerType = type;
        }

        public Burger addVeggies() {
            System.out.println("Adding veggies to the burger");
            return new Burger(this.burgerType += " Veggie");
        }
        public Burger addCheese() {
            System.out.println("Adding cheese to the burger");
            return new Burger(this.burgerType += " Cheese");
        }
        //버거가 모두 완성되면 마지막에 버거 문자열을 붙여 햄버거 이름으로 출력하도록 함
        public String toString() {
            return String.format("%s", burgerType + " burger");
        }
    }
    class BurgerShop {
        Function<Burger, Burger> decoration;

        public BurgerShop(Function<Burger,Burger> decoration) {
            this.decoration = decoration;
        }
        //토핑 추가 메서드 버거를 입력받고 더코레이팅한 버거를 반환
        public Burger use(Burger burger) {
            System.out.println("Base Burger : " + burger);
            return decoration.apply(burger);
        }
    }
    @Test
    @DisplayName("데코레이터 패턴 테스트")
    void main() {
        Burger myOrder = new BurgerShop(Burger::addCheese)
        .use(new BurgerShop(Burger::addVeggies)
        .use(new Burger()));
        System.out.println("주문한 내용 : " + myOrder);
    }
}
