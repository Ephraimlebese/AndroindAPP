package za.ac.cput.myapplication;

/**
 * Created by Thabo on 8/31/2016.
 */
public class DataAdapter
{
    private String name;
    private String surname;
    private String IDnumber;

    public DataAdapter(String name, String surname, String IDnumber) {
        this.name = name;
        this.surname = surname;
        this.IDnumber = IDnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIDnumber() {
        return IDnumber;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }
}
