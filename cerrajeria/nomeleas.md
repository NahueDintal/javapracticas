para levantar la app

podman run -it --rm \
  --name app-local \
  --network cerrajeria-net \
  -e DB_HOST=mysql-local \
  -e DB_NAME=seguridad_db \
  -e DB_USER=usuario_app \
  -e DB_PASSWORD=apppassword \
  cerrajeria-app

para levantar la db

podman run -d \
  --name mysql-local \
  -e MYSQL_ROOT_PASSWORD=rootpassword \
  -e MYSQL_DATABASE=seguridad_db \
  -e MYSQL_USER=usuario_app \
  -e MYSQL_PASSWORD=apppassword \
  -v mysql-data:/var/lib/mysql \
  -p 3306:3306 \
  cerrajeria-sql:latest
