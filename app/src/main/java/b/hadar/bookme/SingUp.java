package b.hadar.bookme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by User on 18/09/2016.
 */
public class SingUp extends Activity{

    DatabaseHelper mydb;
    EditText firstName;
    EditText lastName;
    EditText userName;
    EditText password;
    EditText confirmPassword;
    EditText email;
    EditText address;
    RadioButton male;
    RadioButton female;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        mydb = new DatabaseHelper(this);
        firstName= (EditText) findViewById(R.id.NameET);
        lastName= (EditText) findViewById(R.id.LastNameET);
        userName= (EditText) findViewById(R.id.UserNameET);
        password= (EditText) findViewById(R.id.PasswordET);
        confirmPassword= (EditText) findViewById(R.id.ConfirmPasswordET);
        email= (EditText) findViewById(R.id.EmailET);
        address= (EditText) findViewById(R.id.AddressET);
        male= (RadioButton) findViewById(R.id.MaleradioButton);
        female= (RadioButton) findViewById(R.id.FemaleradioButton);
        signUp= (Button) findViewById(R.id.SingUpbtn);

        AddUser();



    }


    public void AddUser() {
        signUp.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PersonModel person = new PersonModel();

                        person.setPersonName(firstName.getText().toString());
                        person.setLastName(lastName.getText().toString());
                        person.setUserName(userName.getText().toString());
                        person.setPassword(password.getText().toString());
                        person.setEmail(email.getText().toString());
                        person.setaddress(address.getText().toString());
                        boolean isInserted = mydb.insertDataToUsersTable(person);
                        if (isInserted = true)
                            Toast.makeText(SingUp.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(SingUp.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}
