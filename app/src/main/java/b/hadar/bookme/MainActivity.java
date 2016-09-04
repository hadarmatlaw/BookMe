package b.hadar.bookme;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends Activity {


    DatabaseHelper mydb;
    EditText bookName, Author;
    Button addDatabtn;
    Button btnviewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_book);
        mydb = new DatabaseHelper(this);

        bookName = (EditText) findViewById(R.id.editBookName);
        Author = (EditText) findViewById(R.id.editAuthor);
        addDatabtn = (Button) findViewById(R.id.addbtn);
        btnviewAll = (Button) findViewById(R.id.viewall);
        AddData();
        viewAll();
    }

    public void AddData() {
        addDatabtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BookModel book = new BookModel();
                        book.setBookName(bookName.getText().toString());
                        book.setAuthor(Author.getText().toString());
                        boolean isInserted = mydb.insertDataToBooksTable(book);

                        if (isInserted = true)
                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );

    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = mydb.getAllDataFromBooksTable();

                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("bookId :" + res.getString(0) + "\n");
                            buffer.append("bookName :" + res.getString(1) + "\n");
                            buffer.append("author :" + res.getString(2) + "\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}



//    @Override
//    public void onResume(){
//        super.onResume();
//        dataSource.open();
//    }
//
//    @Override
//    public void onPause(){
//        super.onPause();
//        dataSource.close();
//    }

//}


//    Book[] myBooksArray = new Book[]{
//            new Book ("Me Before You","Great book about a paralized guy","JojO","Moyer","Romance"),
//            new Book("Book 1","Summary1","Author1fn","Author1ln","Comedy"),
//            new Book("Book 2","Summary2","Author2fn","Author2ln","Drama"),
//    };