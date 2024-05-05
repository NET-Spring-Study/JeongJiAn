# Introduction to Spring Ch.0 ~ 8

Date: 2024년 5월 4일
Period: 1st

## Environment

> Java: openjdk 17.0.10 2024-01-16
IDE: Intellij IDEA Community Edition 2023.2.1
OS: Ubuntu Desktop 22.04.4 LTS
ISA: x86_64
Memory: 16G
> 

- Section 1 - Project Setting
    
    ## Create Project
    
    [https://start.spring.io/](https://start.spring.io/)
    
    Spring Boot based website that creates Spring project
    
    ![Untitled](https://github.com/NET-Spring-Study/JeongJiAn/assets/83760210/b6d11266-607f-4a8c-bc79-53ea260400cb)
    
    First view of [start.spring.io](http://start.spring.io) 
    
    1. Project
        
        Java build tools
        
        - Gradle VS Maven
            
            
            | Basis | Gradle | Maven |
            | --- | --- | --- |
            | Based on | Gradle is based on developing domain-specific language projects.domain-specific language projects. | Maven is based on developing pure Java language-based software. |
            | Configuration | It uses a Groovy-based Domain-specific language (DSL) for creating project structure. | It uses Extensible Markup Language (XML) for creating project structure. |
            | Focuses on | Developing applications by adding new features to them. | Developing applications in a given time limit. |
            | Performance | It performs better than maven as it optimized for tracking only current running task. | It does not create local temporary files during software creation and is hence – slower. |
            | Java Compilation | It avoids compilation. | It is necessary to compile. |
            | Usability | It is a new tool, which requires users to spend a lot of time to get used to it. | This tool is a known tool for many users and is easily available. |
            | Customization | This tool is highly customizable as it supports a variety of IDE’s. | This tool serves a limited number of developers and is not that customizable. |
            | Languages supported | It supports software development in Java, C, C++, and Groovy. | It supports software development in Java, Scala, C#, and Ruby and it does not natively support C and C++ but can support through plugins like “maven-native-plugin” or we can integrate other build systems like CMake or Makefile. |
            | Project Configuration | For declaring the project configuration, it does not use the XML files. | For declaring the project configuration, it uses the XML files. |
            | Based on | Graph of task dependencies that do the work. | On the phases of the fixed and linear model. |
            | Goal | To add functionality in the project is the main goal of the Gradle. | To finish the project in the given timeline is the main goal of the Maven. |
        - Groovy VS Kotlin
            
            
            |  | Groovy | Kotlin |
            | --- | --- | --- |
            | Purpose | The Groovy is to be a dynamic typed programming language with concise and expressive syntax. | The primary purpose of Kotlin is to be a Static typed programming language with concise syntax. |
            | Usage | Groovy is used mostly for scripting tasks and Domain-Specific language. If your project contains a significant amount of scripting then Groovy is the best choice. | Kotlin is the official language for Android app development. After Java Kotlin is the second largest language that is being used for Android application development. |
            | Null Safety | Groovy does not provide such a feature. | Kotlin ensures null safety by using appropriate operators. |
            | Compilation | Groovy comes with advantages of supporting Static and Dynamic types. Setting type as dynamic is applicable by default while for defining it static needs to define annotation @ CompileStatic | To overcome redundancy and boilerplate code Kotlin was developed as a Static typed language. Compile time checks results in performance optimization. |
            | IDE supports | Groovy does not have dedicated IDE support as Kotlin but popular IDEs like InteliJ IDEAand Eclipse gives support to Groovy. | Kotlin provides excellent integration with InteliJ IDEA. Android Studio is the most commonly used IDE for Android application development. |
            | Java Interoperability | Like Kotlin, Groovy is also fully interoperable with Java.Integration of Groovy code to existing Java projects is also easy. | Kotlin provides seamless integration with Java. Kotlin code can work with Java code and vice versa. |
            | Example | Print “Hello World”:Class HelloWorld{Static void main(string[] args){ println “Hello GFG”}} | Print “Hello World”:
            
            fun mian(){
            println(“Hello GFG”)
            } |
            | Code comparison | // Groovy example code snippet for creating Employee classclass Employee {String nameint age}// Creating an instance of the Employee classdef emp = new Employee(name: “Rahul Dravid”, salary: 25000)// Accessing properties of the employeeprintln(“Name: ${emp.name}”)println(“Age: ${emp.salary}”) | // Kotlin example code snippet for creating Employee class
            data class Employee(val name: String, val salary: Int)
            
            fun main() {
            // Creating an instance of the Person class
            
            val emp = Employee(name = “Rahul Dravid”, salary = 25000)
            
            // Accessing properties of the person
            
            println(“Name:${emp.name}”)
            println(“Age: ${emp.salary}”)
            
            } |
        
        Summary - Gradle is faster and newer than Maven.
                           Kotlin is newer than Groovy.
                           USE **GRADLE GROOVY**
        
    2. Language
        
        CHOOSE **JAVA**
        
    3. Spring Boot
        
        version of Spring Boot
        USE **3.X.X**
        
    4. Project Metadata
        
        Group - domain of corporate
        
        Artifact - result of build
        
        Name - Project Name
        
    5. Dependencies - **Important**
        
        Libraries to use in project
        
        **Spring Web, Thymeleaf**
        
        Spring Web - Provide support for building web applications (MVC, Request Mapping, etc…)
        
        Thymeleaf - HTML template engine
        
    
    ![Untitled 1](https://github.com/NET-Spring-Study/JeongJiAn/assets/83760210/9087942f-f6a2-44f9-816e-3d2d8b45e711)
    
    Spring Project Directory Architecture
    
    .idea : Intellij config files
    
    gradle : gradle wrapper
    
    src - main : java packages & resources
    
    src - test : java test codes
    
    **build.gradle** : ****generated by spring boot, version + jdk setting & implementing libraries for dependencies(basic library repository = mavenCentral(), manually adding repository is possible)
    
    gradlew & gradlew.bat : for building gradle
    
    settings.gradle : used to define settings related to gradle build
    
    Tomcat runs on 8080 ports when project runs
    
    **CHANGE BUILD TOOL FROM GRADLE TO INTELLIJ IDEA** (for fast build by bypassing gradle)
    
    ```java
    SpringApplication.run(HelloSpringApplication.class, args);
    ```
    
    ## Library
    
    Gradle & Maven manage dependencies, EVEN RECURSIVE DEPENDENCIES
    
    ## View
    
    `resources/static/index.html` → index.html(welcome page) directory
    
    ⇒ Static page
    
    For dynamic page, thymeleaf is used
    
    `resources/templates/*.html` → dynamic page directory
    
    viewName Mapping : `resources:templates/{ViewName}.html`
    
    ```java
    @Controller // First Entrypoint in Web App
    public class HelloController {
    	@GetMapping("hello") // path: /hello
    	public String hello(Model model) { // MVC
    		model.addAttribute("data", "hello!!");
    		return "hello";
    	}
    }
    ```
    
    Web browser → Tomcat → HelloController → viewResolver → Web Browser
    
    HelloController returns model to viewResolver
    
    viewResolver receives model, makes static html file, and sends it to Client
    
    ## Build & Execute
    
    ```bash
    # in project working directory
    
    ./gradlew build
    cd build/libs
    java -jar hello-spring-0.0.1-SNAPSHOT.jar
    
    # unbuild
    ./gradlew clean
    
    # rebuild
    ./gradlew clean build
    ```
    
- Section 2 - Spring Web Development Basics
    
    ## Static Content
    
    Send original html files (static pages) to clients
    
    Web browser → Tomcat → Controller(NO CONTROLLER) → resources:static/.html → Web browser
    
    **Controller has a higher priority than static resource**
    
    `resources/static/*` 
    
    access path : `{ServerAddress}/{path-to-static-file}/{static-file-name}.html`
    
    ## MVC & Template Engine
    
    JSP, PHP
    
    Send modified html files (dynamic pages) to clients
    
    Web browser → Tomcat → Controller(model) → viewResolver → Web Browser
    
    MVC : Model, View, Controller
    
    Model, Controller → Focus on business logic or internal processing
    
    View → Focus on drawing page
    
    Controller
    
    ```java
    @Controller
    public class HelloController {
    	@GetMapping("hello-mvc")
    	// GET -> use parameters (not body)
    	// @RequestParam(value, required) in default, required == true
    	public String helloMVC(@RequestParam("name") String name, Model model) {
    		model.addAttribute("name", name);
    		return "hello-template";
    	}
    }
    ```
    
    View
    
    ```html
    <html xmlns:th="http://www.thymeleaf.org">
    <body>
    <!-- if name is null, `hello! empty` will be showed  -->
    <p th:text="'hello ' + ${name}">hello! empty</p>
    </body>
    </html>
    ```
    
    access path : `{ServerAddress}/{path-to-Mapping}?param1=value&param2=value...`
    
    ## API
    
    Send xml or JSON formatted file (data) to clients or servers
    
    Web browser → Tomcat → Controller(response body) → HttpMessageConverter → Web browser
    
    ```java
    @Controller
    public class HelloController {
    	@GetMapping("hello-string")
    	@ResponseBody // Return to body of http packet directly(using HttpMessageConverter) instead of using viewResolver
    	public String helloString(@RequestParam("name") String name) {
    		return "hello " + name;
    	}
    }
    ```
    
    It is also possible to return an object
    
    ```java
    @Controller
    public class HelloController {
    	@GetMapping("hello-api")
    	@ResponseBody
    	// Return type is Hello object
    	public Hello helloApi(@RequestParam("name") String name) {
    		Hello hello = new Hello();
    		hello.setName(name);
    		return hello;
    	}
    
    	static class Hello {
    		private String name;
    		public String getName() {
    			return name;
    		}
    		public void setName(Stirng name) {
    			this.name = name;
    		}
    }
    ```
    
    HttpMessageConverter
    
    - StringHttpMessageConverter → basic string
    - MappingJackson2HttpMessageConverter → basic object
    - etc
    
    Client’s HTTP Accept Header + Controller’s return type
    
    ⇒ Choose proper HttpMessageConverter
    
- Section 3 - Member Management Example ~ Backend Development
    
    Basic Web App Architecture
    
    - Controller: Contoller of Web MVC
    - Service: Implementation of core business logic
    - Repository: DB acceess & manage and save domain objects
    - Domain: Business domain object
    
    Class Dependencies
    
    ```mermaid
    graph LR
      MemberService --> MemberRepository
      MemoryMemberRepository --> MemberRepository
    ```
    
    MemberRepository = interface
    
    MemberRepository will be changed to MemoryMemberRepository
    
- Section 4 - Spring Beans and Dependency Injection
    
    Controller has to use Services and Repositories ⇒ in a dependency 
    
    Controllers depend on services and repositories
    
    ## Component Scan & Auto Wired
    
    `@Controller` → Create, store and manage objects in spring container as a controller
    
    ⇒ Spring Bean
    
    `@Autowired` → Gets and connects objects in spring container
    
    Controllers, Services, and Repositories must have appropriate annotation
    
    ```mermaid
    graph LR
      memberController --> memberService --> memberRepository
    ```
    
    dependency injection: Import and connect objects from spring containers when creating objects
    
    ## Registering Spring Beans Directly in Java Code
    
    `@Bean` → Register  to Spring Bean
    
    ```java
    @Configuration
    public class SpringConfig {
    	// Register to Spring Bean
    	@Bean
    	public MemberService memberService() {
    		return new MemberService(memberRepository());
    	}
    
    	@Bean
    	public MemberRepository memberRepository() {
    		return new MemberRepository();
    	}
    }
    ```
    
    ## Dependency Injection
    
    - Field Injection
        
        ```java
        @Autowired private final MemverService memberService;
        ```
        
    - Constructor Injection
        
        ```java
        @Autowired
        public MemberController(MemberService memberService) {
        	this.memberService = memberService;
        }
        ```
        
    - Setter Injection
        
        ```java
        @Autowired
        public void setMemberService(MemberService memberService) {
        	this.memberService = memberService;
        }
        ```
        
    
- Section 5 - Member Management Example ~ Web MVC Development
    
    Controller has higher priority than static file
    
- Section 6 - DB Access in Spring
    
    ## H2 Database
    
    h2 DB: Simple, light DB
    
    https://www.h2database.com
    
    1. install from website
    2. unzip
    3. sudo chmod 755 h2/bin/h2.sh
    4. run h2/bin/h2.sh → port 8082
    5. jdbc:h2:~/test
    6. jdbc:h2:tcp://localhost/~/test → connect DB via tcp socket
    
    ```sql
    DROP TABLE IF EXISTS member CASCADE;
    CREATE TABLE member (
    	id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    	name VARCHAR(255).
    	PRIMARY KEY (id)
    )
    ```
    
    | id (BIGINT) | name (VARCHAR(255)) |
    | --- | --- |
    |  |  |
    
    ## Pure JDBC
    
    1. edit build.gradle
        
        ```
        dependencies {
        	implementation 'org.springframework.boot:spring-boot-starter-jdbc'
        	runtimeOnly 'com.h2database:h2'
        }
        ```
        
    2. edit application.properties
        
        ```
        spring.datasource.url=jdbc:h2:tcp://localhost/~/test
        spring.datasource.driver-class-name=org.h2.Driver
        spring.datasource.username=admin
        ```
        
    3. Edit SpringConfig
        
        ```java
        @Configuration
        public class SpringConfig {
        	private final DataSource dataSource;
        
        	public SpringConfig(DataSource dataSource) {
        		this.dataSource = dataSource;
        	}
        
        	@Bean
        	public MemberService memberService() {
        		return new MemberService(memberRepository());
        	}
        
        	@Bean
        	public MemberRepository membertRepository() {
        		return new JdbcMemberRepository(dataSource);
        	}
        }
        ```
        
    
    `executeUpdate()` VS `executeQuery()`
    
    - `executeUpdate()`
        - used to INSERT, UPDATE, DELETE, CREATE, ALTER, DROP, etc.
        - It returns an integer representing the number of rows affected by the statement
    - `executeQuery()`
        - used to execute SELECT statements
        - It returns a ResultSet object containing the data retrieved by the query
    
    ## Open-Closed Principle (OCP)
    
    Opened for extension but closed for modification
    
    By using DI, it's possible to change the implementation class solely through configuration without altering existing code at all.
    
    ```mermaid
    graph LR
      MemberService --> MemberRepository
    	JdbcMemberRepository --> MemberRepository
      MemoryMemberRepository
    ```
    
    ## JDBC Template
    
    Remove repetitive code from JDBC API
    
    ## Java Persistence API (JPA)
    
    SQL query automation
    
    1. edit build.gradle
        
        ```
        dependencies {
        //implementation 'org.springframework.boot:spring-boot-starter-jdbc'
        	implementation 'org.springframwork.boot:spring-boot-starter-data-jpa'
        }
        ```
        
    2. edit application.properties
        
        ```
        spring.jpa.show-sql=true
        spring.jpa.hibernate.ddl-auto=none
        ```
        
    3. entity mapping
        
        ```java
        @Entity
        public class Member {
        	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        	private Long id;
        	private String name;
        
        	public Long getId() {
        		return id;
        	}
        	
        	public String getName() {
        		return name;
        	}
        
        	public void setId(Long id) {
        		this.id = id;
        	}
        
        	public void setName(String name) {
        		this.name = name;
        	}
        }
        ```
        
    4. create repository
        
        ```java
        public class JpaMemberRepository implements MemberRepository {
        	private final EntityManager em;
        	
        	public JpaMemberRepository(EntityManager em) {
        		this.em = em;
        	}
        }
        ```
        
    5. add transaction in service
        
        ```java
        @Transactional
        public class MemberService {}
        ```
        
    6. edit SpringConfig
        
        ```java
        @Configuration
        public class SpringConfig {
        	private final EntityManager em;
        	private final DataSource dataSource;
        
        	public SpringConfig(DataSource dataSource, EntityManager em) {
        		this.dataSource = dataSource;
        	}
        
        	@Bean
        	public MemberService memberService() {
        		return new MemberService(memberRepository());
        	}
        
        	@Bean
        	public MemberRepository membertRepository() {
        		return new JpaMemberRepository(em);
        	}
        }
        ```
        
    
    ## Spring Data JPA
    
    for EVEN convenient use of JPA
    
- Section 7 - AOP
    
    ## Aspect Oriented Programming (AOP)
    
    Core and cross-cutting concrete must be separated
    
    memberController → memberService Proxy(joinPoint.proceed()) → memberService
    
- Section 8 - To the Next
    
    Wrap-up
