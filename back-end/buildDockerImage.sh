cd ../front-end && npm run build
cd ../back-end && mvn -Dmaven.test.skip=true package
docker build -t derek19960312/kenba-server:v4 .
docker push derek19960312/kenba-server:v4