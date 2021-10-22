package com.tagui;

import java.util.Vector;

public class Roster
{
    Vector<Student> ros = new Vector<Student>();
    String rosName;
    int rosSize;
    //Student stu;

    public Roster() // makes a roster with 15 not null spots
    {
        rosName = "new roster";
        rosSize = 15;

        for(int i = 0; i<15; i++)
        {
            Student s = new Student("No Student", 0.0, "no behavior", 0, "no attendance");
            s.setSeat(i);
            this.addStu(s);
        }

    }

    public Roster(String n)//makes a 15 spot not null roster w n name
    {

        rosName = n;
        rosSize = 15;

        for(int i = 0; i<15; i++)
        {
            Student s = new Student("No Student", 0.0, "no behavior", 0, "no attendance");
            s.setSeat(i);
            this.addStu(s);
        }

    }

    public Roster(String n, int z) // roster w custom name and size
    {
        rosName = n;
        rosSize = z;

        for(int i = 0; i<z; i++)
        {
            Student s = new Student("No Student", 0.0, "no behavior", 0, "no attendance");
            s.setSeat(i);
            this.addStu(s);
        }

    }

    public void addStu(Student s)// adds a student to the next open spot
    {
        ros.add(s);
    }

    public void addStuTo(Student s, int p)// adds student to p spot
    {
        ros.set(p-1,s);
    }

    public int size()
    {
        return ros.size();
    }

    public Student getStu(int i)
    {
        return ros.get(i);
    }

    public String getStuName(int i)
    {
        Student stu = ros.get(i);
        return stu.getName();
    }

    /*public void printRos()
    {
        System.out.println("Class: " + this.rosName);
        for (int i = 0; i < this.size(); i++)
        {
            Student temp = this.getStu(i);
            System.out.println(i +" "+ temp.printStu());
        }
    }*/

}
