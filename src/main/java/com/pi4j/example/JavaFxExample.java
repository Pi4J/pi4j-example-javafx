package com.pi4j.example;

/*-
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: EXAMPLE  :: Sample Code
 * FILENAME      :  JavaFXExample.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2020 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.example.pi4j.Pi4JHelper;
import com.pi4j.example.ui.UserInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <p>This example fully describes the base usage of Pi4J in combination with JavaFX.</p>
 *
 * @author Frank Delporte (<a href="https://www.webtechie.be">https://www.webtechie.be</a>)
 * @version $Id: $Id
 */
public class JavaFxExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new UserInterface(new Pi4JHelper()), 400, 300);
        stage.setTitle("Demo of Pi4J and JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Small example application which combines Pi4J and JavaFX.
     *
     * @param args an array of {@link java.lang.String} objects.
     * @throws java.lang.Exception if any.
     */
    public static void main(String[] args) throws Exception {
        // Start the JavaFX application
        launch();
    }
}
