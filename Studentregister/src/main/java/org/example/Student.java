package org.example;

public class Student implements Displayable {
    private int age;
    private String name;
    private StudyProgram program;

    public Student(int age, String name, StudyProgram program) {
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

    public StudyProgram getProgram() {
        return program;
    }

    public void setProgram(StudyProgram program) {
        this.program = program;
    }

    @Override
    public void displayinfo()
    {
        System.out.println("Name " + name);
        System.out.println("Age " + age);
        System.out.println("Program " + program);

    }
}
