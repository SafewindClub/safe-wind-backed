#! /bin/bash

while [ ! -e ./Dockerfile ] && [ "$(pwd)" != '/' ]; do
    cd ..
    echo change directory to "$(pwd)"
done

if [ ! -e ./Dockerfile ]; then
    echo "Unable to find root of the project."
    exit 1
fi

# shellcheck disable=SC2046
export $(xargs <./script/local.env)

if mvn install && mvn -pl Safewind-starter package spring-boot:repackage; then
  docker build -t safewind-backend:latest -f ./script/just_package.dockerfile .
else
  echo "Build failed, Safewind-starter jar not found."
  exit 1
fi

