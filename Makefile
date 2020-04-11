JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src/
BINDIR=bin/
 

all:
	javac -d bin $(SRCDIR)*.java

clean:
	rm ${BINDIR}*.class

run:
	java -cp bin/ LSAVLapp

docs: 
	javadoc -sourcepath src/* -d docs/

cleandocs:
	rm -r docs/*	
