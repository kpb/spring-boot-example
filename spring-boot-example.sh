#!/usr/bin/env bash
#
# Builds/tags the spring-boot-example image

set -e

docker build -t kpb/spring-boot-example:0.0.1 .
