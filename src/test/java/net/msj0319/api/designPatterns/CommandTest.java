package net.msj0319.api.designPatterns;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    //Command 인터페이스, 실행될 기능에 대한 인터페이스
    //실행될 기능을 execute 메서드로 선언한다.
    interface Command {
        void execute();
    }
    class AirconRemoteControl {
        Command command;
        void setCommand(Command command) {this.command = command;}
        void buttonPressed() {command.execute();}    //Consumer
    }
    @Test
    @DisplayName("커맨드 패턴 테스트")
    void main() {
        Aircon aircon = new Aircon();
        AirconRemoteControl control = new AirconRemoteControl();
        control.setCommand(aircon::turnOn);
        control.buttonPressed(); //subScribe의 원리를 설명함

        control.setCommand(aircon::increaseTemp);
        control.buttonPressed();

        control.setCommand(aircon::decreaseTemp);
        control.buttonPressed();

        control.setCommand(aircon::turnOff);
        control.buttonPressed();
    }
}
