JCFLAGS = -d class -implicit:none -cp ".\:class"
JVFLAGS = -cp class
JC = javac 
JV = java 

.SUFFIXES:	.java .class
 
all:
	$(JC) $(JCFLAGS) *.java

run:    
	$(JV) $(JVFLAGS) Main

clean:
	$(RM) *.class