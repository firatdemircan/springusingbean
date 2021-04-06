# springusingbean
Reading application properties file with bean,reading and intilazting a second database

We create a spring boot application

---First of all with write two different databases all properties in the "application.properties" that spring boot creating for us

---Then we create a util package and create a classand  this class with have 

    @Configuration
    @PropertySource("classpath:application.properties")
this to annotations on top of them. Because spring boot need to know that, this class we created is a configuration file and reading the application.properties

In this class we just 

 @Value("${spring.datasource.url}")
 private String url;
 
 use this and reading the properties.
