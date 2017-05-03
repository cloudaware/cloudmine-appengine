#!/usr/bin/env bash
find discovery -type f -name *.discovery -exec /usr/local/bin/generate_library --language=java --input={} --output_dir=target/client \;
cp client/pom.xml target/client/pom.xml