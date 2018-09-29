# clj.native-cli

This project serves as a starting point for creating native CLI tools with Clojure
and GraalVM.

## Usage

1. Make `src/script.clj` do something interesting.
1. Test `src/script.clj` e.g. print usage:
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

See `deps.edn` for dependencies and `clj.native-image` options.
