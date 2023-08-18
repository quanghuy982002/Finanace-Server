# Finance

## Setup demo database with docker

```bash
docker run -d --name=mariadb -p 8306:3306 -e MARIADB_ROOT_PASSWORD=123456 -e MARIADB_DATABASE=finance-demo mariadb/server
```
