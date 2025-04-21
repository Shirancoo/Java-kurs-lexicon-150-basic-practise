package org.example;

public class Student implements Displayable {
    private int age;
    private String name;
    private String program;


    public Student(int age, String name, String program) {
        this.age = age;
        this.name = name;
        this.program = program;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Program: " + program;
    }
}
