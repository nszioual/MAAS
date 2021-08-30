## BPMN and EPML Canoniser CLI-tool
This tool uses the [apromore](https://github.com/apromore/ApromoreCore) canonizer for translating BPMN to EPML and vice versa.

### Building the project
#### Requirements
* Java SE 8 "Server JRE" or "JDK" Edition 1.8.
* Apache Maven 3.5.2 or newer.

#### How to build the jar file
From the root of the project run: ``mvn clean install``

### Running the tool
From the ``target`` directory run: ``java -jar java-bpmn-epml-1.0-jar-with-dependencies.jar -i <path to source model> -o <path to output model>``