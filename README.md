# Builder-Pattern-with-Java-Records

The Builder pattern, which is one of the 23 Gang of Four (GoF) design patterns, is a creational design pattern that lets you construct complex objects step by step. The Builder pattern also allows for easy state validation by implementing or calling the validation logic in the build method, before the actual object is created. This avoids the creation of objects with an invalid state.
Java Records are a concise way to create immutable data structures, automatically generating constructors, getters, and standard methods like equals(), hashCode(), and toString(). However, when dealing with objects that have many fields or optional fields, using the canonical constructor directly can become cumbersome and less readable.
The Builder Pattern comes to the rescue here. It allows step-by-step construction of complex objects and can be particularly useful when you have several optional parameters.
Java record types being immutable, by default, the builder pattern is an excellent match for records.
Below are three approaches to implementing the builder pattern with Java Records.
**1. Using Nested Static Class**
Step 1: Define the Record
We start by defining an Employee record with multiple fields.
public record Employee(Long id, String name, String company, Integer salary) {}
Step 2: Create the Builder Class
We then create a static inner builder class inside the Employee record.
public record Employee(Long id, String name, String company, Integer age) {

 public static class EmployeeBuilder {

  private Long id;
  private String name;
  private String company;
  private Integer age;

  public EmployeeBuilder id(Long id) {
   this.id = id;
   return this;
  }
  
  public EmployeeBuilder name(String name) {
   this.name = name;
   return this;
  }
  
  public EmployeeBuilder company(String company) {
   this.company = company;
   return this;
  }
  
  public EmployeeBuilder age(Integer age) {
   this.age = age;
   return this;
  }
  
  public Employee build() {
            return new Employee(id, name, company, age);
        }
 }
}
Step 3: Using the Builder
public class Main {
 public static void main(String[] args) {
  
  Employee employee = new Employee.EmployeeBuilder()
    .id(1l)
    .name("pravin")
    .company("dummy")
    .age(30)
    .build();

  System.out.println(employee);
 }
}
Output:
Employee[id=1, name=pravin, company=dummy, age=30]

**2. Using @Builder Lombok Annotation**
The Lombok is a pretty useful library when minimizing the boilerplate code for features such as implementing the builder pattern in a class or record. Start with including the latest version of Lombok in the project.
Step 1: Add the Maven dependency
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
Step 2: Use the @Builder annotation with Record
import lombok.Builder;

@Builder
public record Employee(Long id, String name, String company, Integer age) {}
Step 3: Using the Lombok Builder
public class Main {
 public static void main(String[] args) {
  
  Employee employee = Employee.builder()
                .id(1l)
                .name("pravin")
                .company("dummy")
                .age(30)
                .build();

  System.out.println(employeeRecord);
 }
}
Output:
Employee[id=1, name=pravin, company=dummy, age=30]

**3. Using RecordBuilder Library**
The RecordBuilder is an opensource library for adding new features to the record types, such as:
a companion builder class for Java records
an interface that adds "with" copy methods
an annotation that generates a Java record from an Interface template

Start with adding the RecordBuilder dependency in the project.
Step 1: Add the Maven dependency
<dependency>
   <groupId>io.soabase.record-builder</groupId>
   <artifactId>record-builder-core</artifactId>
   <version>41</version>
</dependency>
Step 2: Enable the annotation processing
Enable the annotation processing by adding record-builder-processor to the annotation processor path. Depending on your IDE you are likely to need to enable Annotation Processing in your IDE settings.
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.8.1</version>
    <configuration>
     <source>17</source>
     <target>17</target>
     <annotationProcessorPaths>
      <path>
       <groupId>io.soabase.record-builder</groupId>
       <artifactId>record-builder-processor</artifactId>
       <version>34</version>
      </path>
     </annotationProcessorPaths>
    </configuration>
   </plugin>
Step 2: Use @RecordBuilder Annotation
The annotation enables the fluent builder API in the annotated record type.
import io.soabase.recordbuilder.core.RecordBuilder;

@RecordBuilder
public record Employee(Long id, String name, String company, Integer age) {}
Step 3: Using the RecordBuilder
This annotation generates a new class with a record name appended with "Builder". For example, for Employee record, the generated builder class is EmployeeBuilder.
public class Main {
 public static void main(String[] args) {
  
  Employee employee = EmployeeBuilder.builder()
                .id(1l)
                .name("pravin")
                .company("dummy")
                .age(30)
                .build();

  System.out.println(employee);
 }
}
Output:
Employee[id=1, name=pravin, company=dummy, age=30]
Conclusion
In this Java tutorial, we learned to implement the builder pattern style fluent API for creating records in an incremental manner. we also learned to use the RecordBuilder library to implement copy constructors on the records.
