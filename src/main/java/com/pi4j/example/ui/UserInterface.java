package com.pi4j.example.ui;

import com.pi4j.example.pi4j.Pi4JHelper;
import com.pi4j.io.gpio.digital.DigitalState;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class UserInterface extends VBox {

    public UserInterface(Pi4JHelper pi4JHelper) throws Exception {
        var led = pi4JHelper.getLed();
        Button bt = new Button("Toggle LED for 2 seconds");
        bt.setOnAction(actionEvent -> {
            try {
                led.pulse(2, TimeUnit.SECONDS);
            } catch (com.pi4j.io.exception.IOException ex) {
                pi4JHelper.getConsole().println("Error while toggling LED: " + ex.getMessage());
            }
        });
        getChildren().add(bt);

        Label lbl = new Label("Press the physical button");
        getChildren().add(lbl);
        var physicalButton = pi4JHelper.getButton();
        physicalButton.addListener(e -> {
            if (e.state() == DigitalState.LOW) {
                Platform.runLater(() -> lbl.setText("Pressed button on " + LocalDate.now()));
            }
        });
    }
}
