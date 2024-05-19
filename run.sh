#!/bin/bash
set -e 
clojure -X  sample.main/generate "$1" "$2" "$3" "$4" "$5" "$6"
