JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src/
BINDIR=bin/

all:
	javac -d bin $(SRCDIR)*.java

clean:
	rm ${BINDIR}*.class

run:
	java -cp bin/ LSBSTApp

docs: 
	javadoc -classpath ${BINDIR} -d docs/ src/*.java

cleandocs:
	rm -r docs/*
