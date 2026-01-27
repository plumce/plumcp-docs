#!/usr/bin/env bash
#

docker run --rm -it -v ${PWD}:/docs -p 8000:8000 squidfunk/mkdocs-material:9 serve --livereload --dev-addr 0.0.0.0:8000

