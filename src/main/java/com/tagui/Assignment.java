package com.tagui;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Assignment {
    public String assignment;
    public String grade;
    public String maxScore;

    public Assignment(){
        assignment = ("no assignments");
        grade = ("0");
        maxScore = ("100");
    }

    public Assignment(String assignment, String grade, String maxScore){
        this.assignment = assignment;
        this.grade = grade;
        this.maxScore = maxScore;
    }


    public String getAssignment(){
        return assignment;
    }

    public String getGrade(){
        return grade;

    }

    public String getMaxScore(){
        return maxScore;
    }

    public void setAssignment(String name){
        this.assignment = name;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }
}
