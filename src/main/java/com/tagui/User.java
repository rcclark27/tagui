package com.tagui;

public class User
{

    private String name;
    private int userID;
    private String emailAddress;
    private String password;

    User() // default constructor
    {

    }

    User(String fullName, int ID, String email, String passwd) // overloaded constructor
    {
        name = fullName;
        userID = ID;
        emailAddress = email;
        password = passwd;
    }

    public String getName()
    {
        return name;
    }

    public int getUserID()
    {
        return userID;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getPassword()
    {
        return password;
    }

    public void setName(String fullName)
    {
        name = fullName;
    }

    public void setEmailAddress(String email)
    {
        emailAddress = email;
    }

    public void setUserID(int ID)
    {
        userID = ID;
    }

    public void setPassword(String passwd)
    {
        password = passwd;
    }

}
