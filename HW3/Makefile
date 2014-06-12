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

test1: default
	$(JRUN) $(JAR) $(MAINCLASS) http://www.datagarage.io/api/5365dee31bc6e9d9463a0057 文山區 辛亥路 103

test2: default
	$(JRUN) $(JAR) $(MAINCLASS) http://www.datagarage.io/api/5365dee31bc6e9d9463a0057 大安區 復興南路 103 

clean:
	$(RM) *.class
