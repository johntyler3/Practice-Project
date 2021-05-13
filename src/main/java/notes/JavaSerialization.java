package notes;

import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class JavaSerialization {

    public static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        static String country = "ITALY";
        private int age;
        private String name;
        transient int height;

        public void setAge(int i) {
            this.age = i;
        }

        public void setName(String n) {
            this.name = n;
        }

        public int getAge() {
            return this.age;
        }

        public String getName() {
            return this.name;
        }
    }

    @Test
    public void whenSerializingAndDeserializing_ThenObjectIsTheSame() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe");

        FileOutputStream fileOutputStream = new FileOutputStream("target/yourfile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("target/yourfile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person person2 = (Person) objectInputStream.readObject();
        objectInputStream.close();

        assertEquals(person2.getAge(), person.getAge());
        assertEquals(person2.getName(), person.getName());
    }
}
