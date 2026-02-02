# PluMCP Docs

Documentation for PluMCP, rendered as a static site.

## Setup

Either install Docker and use the included scripts in this repo.
(Or, install Mkdocs-material locally with Python virtual env and
run equivalent commands.)

## Commands

Serve the site (with live reload) from current directory at port 8000:

```shell
./mkdocs-serve
```

To build the static site content in `site` directory:

```shell
./mkdocs-build
```

## Reference

The page icons are looked up here:

Material icons - https://pictogrammers.com/library/mdi/
Icon references - https://squidfunk.github.io/mkdocs-material/reference/icons-emojis/

## Deployment

A new change pushed to the `main` branch causes a CI build to auto deploy
to the `gh-pages` branch.
Ref: https://squidfunk.github.io/mkdocs-material/publishing-your-site/

# License

Copyright © 2025-2026 Shantanu Kumar

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 1.0 which is available at
https://www.eclipse.org/legal/epl/epl-v10.html.
