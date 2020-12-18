//This is the User class
//@author Bilgehan Sandikci
//@Date 17.12.2020

public abstract class User {

    String userName;
    String password;
    String email;
    String name;
    String surName;



    public User( String userName, String password, String email, String name, String surName ){
        setUserName( userName );
        setPassword( password );
        setEmail( email );
        setName( name );
        setSurName( surName );
    }

    public boolean isOnline(){

        //ToDo this method will be implemented later

        return false;
    }

    private void setUserName( String userName ){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }

    private void setPassword( String password ){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    private void setEmail( String email ){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    private void setName( String name ){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    private void setSurName( String surName ){
        this.surName = surName;
    }
    public String getSurName(){
        return this.surName;
    }

}
