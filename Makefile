JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src/
BINDIR=bin/
 

.PHONY: docs

all:
	javac -d bin $(SRCDIR)*.java

clean:
	rm ${BINDIR}*.class

runAVL1:
	java -cp bin/ LSAVLapp

runAVL2:
	java -cp bin/ LSAVLapp m

runBST1:
	java -cp bin/ LSBSTApp

runBST2:
	java -cp bin/ LSBSTApp m	

docs: 
	javadoc -d docs/ src/*.java

cleandocs:
	rm -r docs/*	
