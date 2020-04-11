JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src/
BINDIR=bin/
 

all:
	javac -d bin $(SRCDIR)*.java

clean:
	rm ${BINDIR}*.class

runAVL:
	java -cp bin/ LSAVLapp

runBST:
	java -cp bin/ LSBSTApp	

docs: 
	javadoc -d docs src/*.java

cleandocs:
	rm -r docs/*	
