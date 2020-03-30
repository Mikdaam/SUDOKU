# JFLAGS = -g
# JC = javac

# .SUFFIXES: .java .class

# .java.class:
# 	$(JC) $(JFLAGS) $*.java

# CLASSES = \
# 		  Main.java \
# 		  Box.java \
# 		  .java \
# 		  Thing.java

# default: classes

# classes: $(CLASSES:.java=.class)

# clean:
# 	$(RM) *.class
	
# run:
# 	java Main

JCFLAGS = -d class -implicit:none -cp ".\:class"
JVFLAGS = -cp ".\:class"
JC = javac 
JV = java 

.SUFFIXES:	.java .class
 
all:
    $(JC) $(JCFLAGS) *.java
 
run:    
    $(JV) $(JVFLAGS) Main

clean:
	$(RM) *.class