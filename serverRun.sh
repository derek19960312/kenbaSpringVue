#!/bin/sh
cd front-end;
npm run build;
cd ..;
mvn spring-boot:run;
