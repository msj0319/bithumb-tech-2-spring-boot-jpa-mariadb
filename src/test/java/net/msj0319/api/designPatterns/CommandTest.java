package net.msj0319.api.designPatterns;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class CommandTest {
    @Data
    @AllArgsConstructor
    class Aircon {
        void turnOn() {
            System.out.println("에어컨 켜기");
        }
        void turnOff() {
            System.out.println("에어컨 끄기");
        }
        void increaseTemp() {
            System.out.println("온도 올리기");
        }
        void decreaseTemp() {
            System.out.println("온도 내리기");
        }
    }
    interface Command {
        void excute();
    }
    class AirconRemoteControl {
        Command command;
        void setCommand(Command command) {this.command = command;}
        void buttonPressed() {command.excute();}    //Consumer
    }
    @Test
    @DisplayName("커맨드 패턴 테스트")
    void main() {
        Aircon aircon = new Aircon();
        AirconRemoteControl control = new AirconRemoteControl();
        control.setCommand(() -> aircon.turnOn());
        control.buttonPressed(); //subScribe의 원리를 설명함
    }
}
