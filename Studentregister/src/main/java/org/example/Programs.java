package org.example;

public class Programs implements Displayable{

    @Override
    public void displayinfo() {
        System.out.println(StudyProgram.SO + "\n" + StudyProgram.MATH + "\n" + StudyProgram.ECONOMICS);
    }
}
