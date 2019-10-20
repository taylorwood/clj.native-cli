# clj.native-cli

This project serves as a starting point for creating native CLI tools with Clojure
and GraalVM.

The template uses Clojure 1.9, clojure.tools.cli for argument parsing, and [clj.native-image](https://github.com/taylorwood/clj.native-image) for GraalVM `native-image` integration.

## Usage

1. Obtain the template:
   - Use GitHub's [create from template](https://github.com/taylorwood/clj.native-cli/generate) feature, or...
   - Download/unpack the latest release into a directory e.g. `my-script-name`:
   ```bash
   $ curl -L https://github.com/taylorwood/clj.native-cli/archive/v0.0.2.tar.gz > release.tar.gz \
     && tar -xzf release.tar.gz && rm release.tar.gz \
     && mv clj.native-cli-0.0.2 my-script-name
   ```
1. Make `src/script.clj` do something interesting. See `deps.edn` for dependencies and `clj.native-image` options.
1. Run your program e.g. print CLI usage help:
   ```bash
   $ clojure -m script -h
   Usage:
     -h, --help
   ```
1. Compile a native executable:
   ```bash
   $ clojure -A:native-image
   $ ./script -h
   Usage:
     -h, --help
   ```

You may find a script useful for instantiating this template:
```bash
#!/usr/bin/env bash
SCRIPT_NAME=$1
RELEASE_VER="0.0.2"
[[ -z "$SCRIPT_NAME" ]] && echo "A script name is required!" && exit 1
curl -L https://github.com/taylorwood/clj.native-cli/archive/v${RELEASE_VER}.tar.gz > release.tar.gz \
  && tar -xzf release.tar.gz && rm release.tar.gz \
  && mv clj.native-cli-${RELEASE_VER} ${SCRIPT_NAME}
```
And execute it with some script name:
```bash
$ ./new-clj-script my-script-name
```
