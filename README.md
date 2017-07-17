# SAFeS - A Tool for Semi-Automatic Feature Selection
1. Introduction
2. Core Implementation
3. Getting started
    1. Requirements
    2. Installation
4. Usage
5. Author
6. License

# 1. Introduction
For the features selection task of data mining, considerable research has focused on proposing improved feature selection algorithms, yet less attention has been paid to a uniﬁed methodology for feature selection. In this regard, a *Semi-Automatic Feature Selection* (SAFeS) methodology is proposed, which includes an innovative *Ensemble-based Feature Ranking with Scaling* (EFRS) methodology to assist the domain expert in selecting informative features for decision making. The main purpose of the EFRS methodology is to evaluate the feature-set in a comprehensive manner, which is based on diﬀerent feature selection measures, namely information gain, gain ratio, symmetric uncertainty, chi-square and signiﬁcance. In order to realize the SAFeS methodology a web-based *Data-Driven Knowledge Acquisition Tool* (DDKAT) is developed, which provides a data mining service addressed to expert and non-expert data miners.

# 2. Core Implementation
The SAFeS core implementation is mainly include three core components; The *Schema Loader*, *Query Configuration*, and the *Features Ranker*. It is developed according to Spring MVC pattern as a maven project.
The SAFeS methodology is deﬁned to obtain the contents of interest from the data persisted in external data source based on the features or factors established by the domain expert. The *Schema Loader* component takes a schema (i.e. features’ information) as input from the external data source and displays it to the domain expert. Then the *Query Conﬁguration* component facilitates the domain expert to select the features based on his/her own experience and knowledge and to write the conditions for each selected feature. Moreover, for helping the domain expert to select suitable features, the *Features Ranker* component provides a features’ scorecard.
Following are details of implementation component.
- **DDKA Controller**: 
The controller provides bridge between the data models and views of the project. It contains under the package of "com.mm.kcl.ddka.controller" and handles the communication between views and features evaluator model.
- **Feature Evaluator Model**: 
Model is responsible for persisting and fetching the features, computes the (1) features score, (2) features weights, and (3) features priorities.
- **SAFeS Views**: 
According to spring mvc pattern, views are responsible to view the user interfaces by rendering the corresponding html. The rendered html is merged with data retrieved by DDKA controller using feature evaluator model. In this project, there are two views.
    -	Index View: The index view provides an interface to domain expert to open the data selector view.
    -	Data Selector View: The data selector view is the main interface for obtaining the contents of interest from the data persisted in external data source. It loads a schema (i.e. features’ information) as input from the external data source and displays it to the domain expert for selecting the features based on his/her own experience and writing the conditions for each selected feature. After features selection, the data selector view provides a features’ scorecard to assist the domain expert in selecting informative features for decision making.

# 3. Getting Started
This consist of the following sub-headings.

## 3.1 Requirements
- Example:
    -	Java version: JDK 1.8
    -	Maven: Apache-maven-3.2.2
    -	Tomcat: Apache-tomcat-8.0.{xx}
    -	WEKA: Weka-3.7.1-beta.jar
    
## 3.2 Installation
- JDK setup, JAVA_HOME, and WEKA configuration
    -	Make sure JDK is installed, and “JAVA_HOME” variable is added as Windows environment variable
    -	Add weka-3.7.1-beta.jar at C:\Program Files (x86)\Java\jdk1.8\jre\lib\ext\ 
- Apache Maven Installation
    - Download Apache Maven and install it
    - Visit Maven official website, download the Maven zip file, for example: apache-maven-3.3.9-bin.zip. Unzip it to the folder you want to install Maven. (Assume you unzip to this folder – C:\Program Files\Apache\maven)
    - Add MAVEN_HOME
    - Add MAVEN_HOME variables in the Windows environment, and point it to your Maven folder.
    - Add to PATH
    - Update PATH variable, append Maven bin folder, so that you can run the Maven’s command everywhere.
    - Verification by running mvn –version in the command prompt. -Apache Tomcat Installation
    - Goto http://tomcat.apache.org ⇒ Downloads ⇒ Tomcat 8.0 ⇒ "8.0.{xx}" (where {xx} is the latest upgrade number) ⇒ Binary Distributions ⇒ Core ⇒ "ZIP" package (e.g., "apache-tomcat-8.0.{xx}.zip", about 8 MB).
    - Create your project directory, say "drive:\myProject" or "drive:\myProject". UNZIP the downloaded file into your project directory. Tomcat will be unzipped into directory "drive:\myProject\apache-tomcat-8.0.{xx}".
    - For ease of use, we shall shorten and rename this directory to "drive:\myProject\tomcat". -Build Project
    - Download src and pom file into the appropriate project folder
    - Start Command Prompt
    - Change the directory to your project directory and folder
    - Run “mvn clear install” command
    - After succesful project build
    - Go to Project folder and access the target folder to copy SAFeS.war file
    - Go to apache-tomcat\webapps folder and paste war file there.
    - Go to apache-tomcat\bin and start the tomcat server by click on startup.bat file.
    - Open browser to test apache-tomcat
    
# 4. Usage
- Give url : http://localhost:8080/DDKAT/index
- It will render the index view to the domain expert to open the data selector view.
- The data selector view will appear with the *Load Schema* button to send the domain schema request to an external web service that provides the domain schema object (JSON format). For demo purposes, Apiary mock service has been utilized. A schema object has been created, which can be accessed by http://private-b0977-schema5.apiary-mock.com/schema. 
- The data selector view parses the received object to retrieve the schema name such as *Diabetes Schema*, tables such as *USERINFO*, and their attributes along-with data types such as *Age (int)* and then converts these into tree structure using jQuery plugin
- Domain expert selects the features/parameters based on his/her own experience and knowledge
- For applying some constraints, the domain expert loads the query panel and writes the conditions for each selected feature.
- Domain expert clicks the *Visualize Features Scorecard* button that ﬁrst creates the query object based on selected features and their conditions (JSON format), then forwards the query object to an external web service that provides the domain data object (JSON format). For demo purposes, Apiary mock service has been utilized. A data object has been created, which can be accessed by http://private-673d5-data11.apiary-mock.com/data?kcldataquery=query.  
- The data selector view parses the received object to retrieve the data name, attributes’ name and their values. 
- Finally, EFRS methodology is executed and displays the Features Scorecard to the domain expert.

# 5. Author
- Maqbool Ali maqbool.ali@oslab.khu.ac.kr, maqbool.ali@utas.edu.au 

# 6. License
Copyright [2017] [Maqbool Ali]
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

