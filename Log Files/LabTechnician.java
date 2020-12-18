import java.util.ArrayList;

//This is the LabTechnician class that implements User class
//@author Bilgehan Sandikci
//@Date 17.12.2020

public class LabTechnician extends User{

    private ArrayList<Test> tests;

    public LabTechnician(String userName, String password, String email, String name, String surName) {
        super(userName, password, email, name, surName);
        tests = new ArrayList<Test>();
    }

    public void addTest( Test test ){
        tests.add( test );
    }

    public boolean removeTest( Test test ){
        if( !tests.contains( test ) )
            return false;

        tests.add( test );
        return true;

    }

    public Test getText( Test test ){
        if( !tests.contains( test ) )
            return null;

         return tests.get( tests.indexOf( test ) );
    }
}
