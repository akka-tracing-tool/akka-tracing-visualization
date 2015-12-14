Akka Tracing - Visualization
============================

Visualization tool for visualizing the traces.

# Configuration

To configure the application you need to specify the database that it should read from. You can do it by copying the
file `conf/database.conf.example` to `conf/database.conf`. There are 2 examples in the file on how to configure it for 
PostgreSQL database and for SQLite database. If you want to use another database, please provide Slick 3.0.0 compliant
configuration (see [Slick's Configuration Guide](http://slick.typesafe.com/doc/3.0.0/database.html#databaseconfig)).

Please remember that if you want to use another database, you need to add its specific JDBC Driver as library 
dependency in file `build.sbt`.

# How to run

Clone the repository, please configure it (see the above section), go to its root directory and simply type:

```
$ sbt run
```

It will launch the application. Then go to the `http://127.0.0.1:9000/`.

# More info

The application uses Play version 2.4.4, Slick version 3.0.0 and Akka Tracing Core version 0.0.1-SNAPSHOT.

It requires Java 8 JDK.
