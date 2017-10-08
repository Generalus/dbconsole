# dbconsole
Tool for connecting to a database (now it supports mysql and postgresql only) and running some queries
Code was written with true OOP style, inspired by Yegor Bugaenko.

Example:

`java -jar ./dbconsole-0.1-SNAPSHOT.jar --connection="jdbc:mysql://localhost:3306/your_database" --login=your_login --password=your_password --query="select * from your_table"`

If you want to secure your password, don't configure it and the tool will sudgest to input in runtime.

You can invoke the tool with --help option only to print all possible params:

`java -jar ./dbconsole-0.1-SNAPSHOT.jar --help`
