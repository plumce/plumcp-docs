#!/usr/bin/env bash
#
docker run --rm -it -v ${PWD}:/docs -u $(id -u):$(id -g) -p 8000:8000 squidfunk/mkdocs-material:9 build
