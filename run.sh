#!/bin/sh
set -eu

build_dir="$(mktemp -d)"
trap 'rm -rf "$build_dir"' EXIT HUP INT TERM

javac --release 17 -d "$build_dir" $(find src/main/java -name '*.java' -print)
java -cp "$build_dir" filesystem.Main
