JAVA = java
JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
Server/ProductManagerImpl.java\
Server/PersonFactoryImpl.java\
Server/ServerPerson.java\
Client/ClientPerson.java\

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) */*.class

server: 
	$(JAVA) Server.ServerPerson

clientPerson:
	$(JAVA) Client.ClientPerson