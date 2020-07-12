JAVAC=javac

all: jar

jar : ./src/*.java
	javac -cp ./src ./src/**.java -d ./out/ -classpath ../spigot/spigot-1.15.2.jar
	jar cvfm myjarfile.jar ./src/META-INF/MANIFEST.FM -C ./out/ .

clean :
	rm -f *.class

.PHONY: all jar clean 
