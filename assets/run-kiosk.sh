#!/usr/bin/env bash
/sbin/init 3
export ENABLE_GLUON_COMMERCIAL_EXTENSIONS=true
java \
  -Degl.displayid=/dev/dri/card0 \
  -Dmonocle.egl.lib=/opt/arm32fb-sdk/lib/libgluon_drm-1.1.3.so \
  -Djava.library.path=/opt/arm32fb-sdk/lib \
  -Dmonocle.platform.traceConfig=false \
  -Dprism.verbose=false \
  -Djavafx.verbose=false \
  -Dmonocle.platform=EGL \
  --module-path .:/opt/arm32fb-sdk/lib \
  --add-modules javafx.controls \
  --module com.pi4j.example/com.pi4j.example.JavaFxExample $@
/sbin/init 5
