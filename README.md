# MapStruct
How to make your mapping task to be fancy and interesting
# What is it?

MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.

The generated mapping code uses plain method invocations and thus is fast, type-safe and easy to understand.

# Why?

Multi-layered applications often require to map between different object models (e.g. entities and DTOs). Writing such mapping code is a tedious and error-prone task. MapStruct aims at simplifying this work by automating it as much as possible.

In contrast to other mapping frameworks MapStruct generates bean mappings at compile-time which ensures a high performance, allows for fast developer feedback and thorough error checking.
# How?

MapStruct is an annotation processor which is plugged into the Java compiler and can be used in command-line builds (Maven, Gradle etc.) as well as from within your preferred IDE.

MapStruct uses sensible defaults but steps out of your way when it comes to configuring or implementing special behavior.

# Setting pom.xml
```XML
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>ch.axonivy.coolstuff</groupId>
  <artifactId>mapstruct-demo</artifactId>
  <version>0.0.1-SNAPSHOT</version>
<properties>
    <org.mapstruct.version>1.1.0.Final</org.mapstruct.version>
</properties>
  <build>
    <plugins>
	   <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.5.1</version>
            <configuration>
                <source>1.8</source> <!-- or higher, depending on your project -->
                <target>1.8</target> <!-- or higher, depending on your project -->
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>${org.mapstruct.version}</version>
                    </path>
                </annotationProcessorPaths>
            </configuration>
        </plugin>
	  <plugin>
			<artifactId>maven-dependency-plugin</artifactId>
			<!-- <executions>
				<execution>
					<id>copy-libraries-to-libs-folder</id>
					<phase>validate</phase>
					<goals>
						<goal>copy-dependencies</goal>
					</goals>
				</execution>
			</executions> -->
			<configuration>
				<outputDirectory>${basedir}/lib</outputDirectory>
				<stripVersion>true</stripVersion>
			</configuration>
		</plugin>
    </plugins>
  </build>
  <dependencies>
       <dependency>
			<groupId>org.mapstruct</groupId>
			<artifactId>mapstruct</artifactId> <!-- use mapstruct-jdk8 for Java 8 or higher -->
			<version>${org.mapstruct.version}</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
		    <groupId>junit</groupId>
		    <artifactId>junit</artifactId>
		    <version>4.8.1</version>
		    <scope>test</scope>
		</dependency>
		
    </dependencies>
</project>
```

# Example
This example show how to map between Person and PersonDTO
1. Person.java
```java
public class Person {
	private String firstName;
	private String lastName;
	private Address address;
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}
```
2. Address.java
```java
public class Address {
	private String street;
	private int houseNo;
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getHouseNo() {
		return houseNo;
	}
	
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	
	
}
```
3. PersonDTO.java
```java
public class PersonDTO {
	private String firstName;
	private String lastName;
	private String streetName;
	private int houseNumber;
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
}
```
Finally we have basic mapping between Person and PersonDTO
```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import ch.axonactive.demo.bean.Person;
import ch.axonactive.demo.bean.PersonDTO;

@Mapper
public interface PersonMapper {
	PersonMapper INSTANCE = Mappers.getMapper( PersonMapper.class );
	@Mappings({
		@Mapping(source = "firstName", target = "firstName"),
		@Mapping(source = "lastName", target = "lastName"),
		@Mapping(source = "streetName", target = "address.street"),
		@Mapping(source = "houseNumber", target = "address.houseNo")
	})
    Person toEntity(PersonDTO personDto);
	
	@Mappings({
		@Mapping(target = "firstName", source = "firstName"),
		@Mapping(target = "lastName", source = "lastName"),
		@Mapping(target = "streetName", source = "address.street"),
		@Mapping(target = "houseNumber", source = "address.houseNo")
	})
    PersonDTO toDTO(Person person);
}
```
