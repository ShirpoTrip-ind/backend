#!/usr/bin/env bash
./gradlew clean build
cd build/libs
sshpass -p "z,rL321qC2Eqj6" scp ShirpoTripAPI-0.0.1-SNAPSHOT.jar root@80.76.60.28:~/docker

sshpass -p "z,rL321qC2Eqj6" ssh root@80.76.60.28 << EOF
  echo "[CONNECTED TO SERVER]"
  screen -S shirpoapi -X quit
  echo "[STOPPED SERVICE SHIRPOAPI]"
  screen -S shirpoapi -d -m /root/docker_build_script.sh
  echo "[BOOTING NEW SCREEN WITH SERVICE SHIRPOAPI]"
  echo "[FINE]"
EOF