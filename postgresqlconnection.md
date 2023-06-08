## How to set up a PostgreSQL connection

### First, install the PostgreSQL driver

```bash 
brew install postgresql
```

### Then, Check your $PATH:
```
echo $PATH

export PATH=$PATH:/usr/local/pgsql/bin/
```

### Log in to PostgreSQL with superuser privileges:
```
psql -U postgres
```

### Connect to a database:
```
\connect your_database_name
```

### To see a list of all databases:
```
\list
```

### To check the current database:
```
\c
``` 

### To check port number:
```
SHOW port;
```

### Recommended resources for PostgreSQL database management system:
Navicat for PostgreSQL
https://www.navicat.com/en/products/navicat-for-postgresql






