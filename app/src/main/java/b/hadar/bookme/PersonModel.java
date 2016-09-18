package b.hadar.bookme;


/**
 * Created by Sapi on 8/21/2016.
 */
public class PersonModel {
    private long personID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String address;

    public long getPersonID(){
        return personID;
    }

    public void setPersonID(long personID){
        this.personID = personID;
    }

    public String getPersonName(){
        return firstName;
    }

    public void setPersonName(String personName){
        this.firstName = personName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String personLastName){
        this.lastName = personLastName;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getaddress(){
        return address;
    }

    public void setaddress(String address){
        this.address = address;
    }

    @Override
    public String toString(){
        return firstName;
    }
}

