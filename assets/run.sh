#!/usr/bin/env bash
java \
  -Dglass.platform=gtk \
  -Djava.library.path=/opt/javafx-sdk17/lib \
  -Dmonocle.platform.traceConfig=false \
  -Dprism.verbose=false \
  -Djavafx.verbose=false \
  --module-path .:/opt/javafx-sdk17/lib \
  --add-modules javafx.controls \
  --module com.pi4j.example/com.pi4j.example.JavaFxExample $@
