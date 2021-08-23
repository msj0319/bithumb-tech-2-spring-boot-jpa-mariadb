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

    @Data class MobileBuilder {
        private int ram; /* if final, Default Constructor Error */
        private int storage;
        private int battery;
        private int camera;
        private String processor;
        private double screenSize;
                                //Setter
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
        MobileBuilder builder = new MobileBuilder();
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
