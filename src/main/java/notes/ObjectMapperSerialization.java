package notes;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/*
Serialization is the conversion of the state of an object into a byte stream;
deserialization does the opposite. Stated differently, serialization is the
conversion of a Java object into a static stream (sequence) of bytes which can
then be saved to a database or transferred over a network.
 */

public class ObjectMapperSerialization {

    //Note the transient variable modifier means that owner will not be serialized
    //You would typically use a transient variable if you had fields that were derived from other fields
    // and should only be done so programmatically rather than having their state be persisted
    private static class Car {
        public String color;
        public String type;
        public transient String owner;

        public Car() {

        }

        public Car(String c, String t) {
            this.color = c;
            this.type = t;
            this.owner = "Me";
        }
    }

    public static void main(String[] args) {

        try {
            String carJson = writeCar();
            System.out.println("Turned a car into json : " + carJson);

            Car car = readCar(carJson);
            System.out.println("Created a car out of json : "  +  car.toString());
        } catch (Exception e) {
            System.out.println("Exception");
        }

    }

    /*
    In order to use Object Mapper I had to import the following maven dependency in my pom.xml
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.11.1</version>
    </dependency>
     */

    //This method creates a car object, then writes its contents to a file in json form
    //The serialized car is then returned in a json string
    private static String writeCar() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "corvette");
        objectMapper.writeValue(new File("target/car.json"), car);

        return objectMapper.writeValueAsString(car);
    }

    //This method takes a json string of a car, and turns it into a java object
    private static Car readCar(String jsonCar) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonCar, Car.class);
    }

}
