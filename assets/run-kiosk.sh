#!/usr/bin/env bash
/sbin/init 3
export ENABLE_GLUON_COMMERCIAL_EXTENSIONS=true
declare SCRIPT_DIR="$(cd "${0%/*}" ; pwd)"
java \
  -Degl.displayid=/dev/dri/card0 \
  -Dmonocle.egl.lib=/opt/javafx-sdk-17/lib/libgluon_drm-1.1.3.so \
  -Djava.library.path="${SCRIPT_DIR}/openjfx/lib" \
  -Dmonocle.platform.traceConfig=false \
  -Dprism.verbose=false \
  -Djavafx.verbose=false \
  -Dmonocle.platform=EGL \
  --module-path ".:${SCRIPT_DIR}/openjfx/lib" \
  --add-modules javafx.controls \
  --module com.pi4j.example/com.pi4j.example.JavaFxExample $@
/sbin/init 5
