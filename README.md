# Arrowhead Model Repository

### Requirements

The project has the following dependencies:
* JRE/JDK 11 [Download from here](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* Maven 3.5+ [Download from here](http://maven.apache.org/download.cgi) | [Install guide](https://www.baeldung.com/install-maven-on-windows-linux-mac)

### Project structure

This is a multi-module maven project relying on the [parent `pom.xml`](https://github.com/arrowhead-f/client-skeleton-java-spring/blob/master/pom.xml) which lists all the modules and common dependencies.

### Getting started

#### How to run the modules
1. Make sure that the ``ServiceRegistry``, ``Orchestration``, and ``Authorization`` Arrowhead systems are running.
2. Run the ``ElasticSearch`` instance through the provided docker file.
2. Start one of the modules (``repository-manager``, ``model-filterer``, ``model-transformer``, and ``model-crawler``) through their Main file.
