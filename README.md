# Mars-api for Preoday

This tutorial will asume that you have JDK and MAVE installed in your machine and in your class path. If you need help with that, here's a link that can help you: https://mkyong.com/maven/how-to-install-maven-in-windows/

The first thing you need to do is download the project by clicking on "Clone or Download" and select the download option.

Once downloaded, you can go ahead and unzip the file anywhere you want. Let's assume that you unziped it on your C:/

Now, press the shortcut key "Window+R" to open the executable window. Type "cmd" and press enter.

With the command line open, go to the folder that you unziped the project ("cd C:/mars-api-master/mars-api/" for example) and tyoe "mvn clean install"

After that, go to the "target" folder by typing "cd target" and type "java -jar marsapi-0.0.1-SNAPSHOT.jar" and that's it, the server will be running until you close your command line window.

The project has two API and if you did everything and the server is running without a problem, you can go on your browser and type "http://localhost:8080/mars/sols" or "http://localhost:8080/mars/temperature"

# http://localhost:8080/mars/sols
This will return the number of sols that you can currently search using the other API.

# http://localhost:8080/mars/temperature/{solNumber}

This will give you the average temperature of mars for the given solNumber that you can replace at the end of the url. 

# http://localhost:8080/mars/temperature

This will give you the average temperature of mars for all the sol available at the moment.

For more information you can access http://localhost:8080/swagger-ui.html
