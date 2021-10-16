# Model Analytics Automation System

An implementation of the Model Analytics Automation System (MAAS), written in Java and running on top of the Arrowhead Framework as several service providers and consumers.

The whole code, until 25.8.2021, is the result of a final Master's Thesis of the Master's degree in Computer Science and Engineering supervised by Prof. Dr. Mark van den Brand, Dr. Önder Babur, and MSc. Mahdi Saeedi Nikoo.  

## This repository uses the following dependencies:

* JRE/JDK 11 [Download from here](https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html)
* Maven 3.5+ [Download from here](http://maven.apache.org/download.cgi) | [Install guide](https://www.baeldung.com/install-maven-on-windows-linux-mac)
* Arrowhead Framework [Core Java Spring](https://github.com/arrowhead-f/core-java-spring)

## Project structure

This is a multi-module maven project relying on the parent `pom.xml` which lists all the modules and common dependencies.

## Getting started

### How to run MAAS
1. Make sure that the ``ServiceRegistry``, ``Orchestration``, and ``Authorization`` Arrowhead systems are running.
2. Run the ``ElasticSearch`` instance through the provided docker file.
3. Run the following modules: ``repository-manager``, ``model-filterer``, ``model-transformer``, and ``model-crawler``.
4. Run the ``webapp`` using the instructions in the provided readme.

## Documentation

### Repository Manager
This System provides the interface to interact with the underlying database through the ``model-storage`` module, which stores process models, domains, and related metadata. 

The purpose of this System is to allow:
* Application Systems to store process models and domains in ElasticSearch.
* They are also allowed to update and delete existing entries in ElasticSearch.
* Application Systems can use this System to fetch all process models and domains.

### Model Crawler
This System crawls/scrapes GitHub for process models. Potential process models (e.g. having a ``.bpmn`` extension) are validated against their metamodel, transformed to the Canonical Process Format, and then stored in ElasticSearch with related metadata. 

### Model Filterer
This System provides services to filter on process models based on a set of filtering criterias. Application Systems can consume these services to filter on process models based on their Canonical Process Elements.

### Model transformer
This System can be used to transform process models from a source language to a target language (e.g. BPMN to EPML) and vice versa.

### Model storage
This Module is used as a dependency by the ``repository-manager``, ``model-filterer``, ``model-transformer``, and ``model-crawler`` Systems, providing a set of services to interact with ElasticSearch. 

### API Commons
This Module is used as a dependency by the ``repository-manager``, ``model-filterer``, ``model-transformer``, and ``model-crawler`` Systems, providing commonly used classes. 
