package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
// Getter, Setter, 생성자 간단하게 만들어 줌
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("adfs");

        String name = helloLombok.getName();
        System.out.println("name = " + name);
    }
}
