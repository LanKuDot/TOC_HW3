JC = javac
JRUN = java
JFLAGS = -g
JAR = -cp ".:json.jar"

MAINCLASS = TocHW3

.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $(JAR) $*.java

CLASSES = \
		  DataRequest.java \
		  JsonWebReader.java \
		  TocHW3.java

default: classes

classes: $(CLASSES:.java=.class)

run: default
	$(JRUN) $(JAR) $(MAINCLASS) http://www.datagarage.io/api/5365dee31bc6e9d9463a0057 金山寺 淹水啦 123

clean:
	$(RM) *.class
