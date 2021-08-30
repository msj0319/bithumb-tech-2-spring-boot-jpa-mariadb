package net.msj0319.api.designPatterns;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class BuilderTest {
    @Data
    @AllArgsConstructor
    class Mobile {
        private final int ram;
        private final int storage;
        private final int battery;
        private final int camera;
        private final String processor;
        private final double screenSize;

        public Mobile(MobileBuilder builder) {
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.battery = builder.battery;
            this.camera = builder.camera;
            this.processor = builder.processor;
            this.screenSize = builder.screenSize;
        }
    }
    //빌더를 통해 원하는 객체를 만들기 위해 Mobile 클래스와 같은 멤버를 갖는 MobileBuilder Data 클래스를 생성
    @Data class MobileBuilder {
        private int ram; /* if final, Default Constructor Error */
        private int storage;
        private int battery;
        private int camera;
        private String processor;
        private double screenSize;
                                //Setter
        //MobileBuilder 객체를 반환하는 with 메서드, 단일 MobileBuilder 타입 객체를 입력받는다.
        //
        public MobileBuilder with(Consumer<MobileBuilder> buildFields) {
            buildFields.accept(this);
            return this;
        }

        public Mobile createMobile() {
            return new Mobile(this);
        }
    }
    @Test @DisplayName("빌더 패턴")
    //내가 선별한 몇개 필드만을 가지고 객체를 만들때 빌더를 사용한다.
    void main() {
        //빌더 객체를 먼저 생성
        MobileBuilder builder = new MobileBuilder();
        //빌더를 통해 새로운 Mobile 객체를 만든다. with 메서드를 통해 원하는 멤버에만 값을 Setting 하여 객체를 만든다.
        Mobile mymobile = builder.with( myBuilder -> {
            myBuilder.ram = 4;
            myBuilder.battery = 4000;
            myBuilder.processor = "A12";
        }).createMobile();

        assertThat(mymobile.getRam(), is(4));
        assertThat(mymobile.getBattery(), is(4000));
        assertThat(mymobile.getProcessor(), is(equalTo("A12")));
    }
}
