#!/usr/bin/env bash
sed -i -e 's/test/prod/g' src/main/resources/application.properties
./gradlew clean build
sed -i -e 's/prod/test/g' src/main/resources/application.properties

sshpass -p "z,rL321qC2Eqj6" scp build/libs/ShirpoTripAPI-0.0.1-SNAPSHOT.jar root@80.76.60.28:~/docker

sshpass -p "z,rL321qC2Eqj6" ssh root@80.76.60.28 << EOF
  echo "[CONNECTED TO SERVER]"
  screen -S shirpoapi -X quit
  echo "[STOPPED SERVICE SHIRPOAPI]"
  screen -S shirpoapi -d -m /root/docker_build_script.sh
  echo "[BOOTING NEW SCREEN WITH SERVICE SHIRPOAPI]"
  echo "[FINE]"
EOF