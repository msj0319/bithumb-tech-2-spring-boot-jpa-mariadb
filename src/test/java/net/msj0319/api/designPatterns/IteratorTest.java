package net.msj0319.api.designPatterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class IteratorTest {
    class MyArrayList {
        //Object 타입의 5개 요소를 받을 수 있도록 배열 생성
        Object[] elements = new Object[5];
        //생성자는 배열을 받아 선언된 멤버 배열로 assign
        MyArrayList(Object[] elements) {this.elements = elements;}
        //forEach 메서드는 Object 타입의 Consumer 클래스 변수를 입력받는다.
        //for문으로 배열을 순회하여 Consumer 클래스에 요소들을 모두 받아들인다.
        void forEach(Consumer<Object> action) {
            for (int i = 0; i< elements.length; i++) {
                action.accept(elements[i]);
            }
        }
    }
    @Test
    @DisplayName("이더레이터 패턴 테스트")
    void main() {
        MyArrayList list = new MyArrayList(new Object[]{1,3,5,67,8});
        list.forEach(System.out::println);
    }
}
