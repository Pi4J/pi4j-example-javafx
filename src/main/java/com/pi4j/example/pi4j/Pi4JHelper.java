package com.pi4j.example.pi4j;

import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalInput;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;
import com.pi4j.io.gpio.digital.PullResistance;
import com.pi4j.util.Console;

public class Pi4JHelper {

    private static final int PIN_BUTTON = 24; // PIN 18 = BCM 24
    private static final int PIN_LED = 22; // PIN 15 = BCM 22

    private static Console console;
    private static Context pi4j;

    public Pi4JHelper() throws Exception {
        console = new Console();
        pi4j = Pi4J.newAutoContext();

        // Print program title/header
        console.title("<-- The Pi4J Project -->", "JavaFX Example project");
    }

    public Console getConsole() {
        return console;
    }

    public DigitalOutput getLed() {
        try {
            var ledConfig = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led")
                    .name("LED")
                    .address(PIN_LED)
                    .shutdown(DigitalState.LOW)
                    .initial(DigitalState.LOW)
                    .provider("pigpio-digital-output");
            return pi4j.create(ledConfig);
        } catch (Exception ex) {
            console.println("Can not init the LED: " + ex.getMessage());
        }
        return null;
    }

    public DigitalInput getButton() {
        try {
            var buttonConfig = DigitalInput.newConfigBuilder(pi4j)
                    .id("button")
                    .name("Press button")
                    .address(PIN_BUTTON)
                    .pull(PullResistance.PULL_DOWN)
                    .debounce(3000L)
                    .provider("pigpio-digital-input");
            return pi4j.create(buttonConfig);
        } catch (Exception ex) {
            console.println("Can not init the button: " + ex.getMessage());
        }
        return null;
    }
}
