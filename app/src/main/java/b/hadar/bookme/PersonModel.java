package b.hadar.bookme;

/**
 * Created by Sapi on 8/21/2016.
 */
public class PersonModel {
    private long personID;
    private String personName;

    public long getPersonID(){
        return personID;
    }

    public void setPersonID(long personID){
        this.personID = personID;
    }

    public String getPersonName(){
        return personName;
    }

    public void setPersonName(String personName){
        this.personName = personName;
    }

    @Override
    public String toString(){
        return personName;
    }
}

