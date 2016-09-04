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

//    private Button save;
//    private EditText text;
    //private List<PersonBook> names = new ArrayList<PersonBook>();
//    DataSource dataSource;
    // ArrayAdapter<PersonBook> adapter;
    //ListView listView;

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
//                        boolean isInserted = mydb.insertDataToBooksTable(bookName.getText().toString(),
//                                Author.getText().toString());

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
                        int count = res.getCount();
                        Toast.makeText(MainActivity.this, count, Toast.LENGTH_LONG).show();

//                        if (res.getCount() == 0) {
                            // show message
//                            showMessage("Error", "Nothing found");
//                            return;
//                        }
//
//                        StringBuffer buffer = new StringBuffer();
//                        while (res.moveToNext()) {
//                            buffer.append("bookId :" + res.getString(0) + "\n");
//                            buffer.append("bookName :" + res.getString(1) + "\n");
//                            buffer.append("author :" + res.getString(2) + "\n");
//                        }
//
//                        // Show all data
//                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

//    public void showMessage(String title, String Message) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }
}
////        dataSource = new DataSource(this);
////        dataSource.open();
//        //names = dataSource.findPeople();
//        //initializeViews();
//        //new MyTask().execute();
//
//    }


//            @Override
//            public void onClick(View view) {
//                if (text.getText().toString() != null){
//                    String name = text.getText().toString();
//    public void initializeViews(){
//        save = (Button)findViewById(R.id.save);
//        text = (EditText)findViewById(R.id.text);
//        listView = (ListView)findViewById(android.R.id.list);
//        listView.setLongClickable(true);
//
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (text.getText().toString() != null){
//                    String name = text.getText().toString();
//                    PersonModel person = new PersonModel();
//                    person.setPersonName(name);
//                    BookModel book = new BookModel();
//                    book.setBookName(text.getText().toString());
//                    book.setAuthor(text.getText().toString());
//
//                    dataSource.create(person, book);
//                    text.setText("");
//                    new MyTask().execute();
//                } else {
//                    Toast.makeText(getApplicationContext(), "Error: EditText cannot be left blank", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });




//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String name = ((TextView) view.findViewById(android.R.id.text1)).getText().toString();
//                dataSource.deletePerson(name);
//                new MyTask().execute();
//                return true;
//            }
//        });
//
//    }
//
//    public void refreshDisplay(){
//        adapter = new ArrayAdapter<PersonBook>(getApplicationContext(), android.R.layout.simple_list_item_1, names);
//        setListAdapter(adapter);
//    }

//    private class MyTask extends AsyncTask<String, String, String>{
//        protected String doInBackground(String... strings){
//            names = dataSource.findPeople();
//            return null;
//        }
//
//        protected void onPostExecute(String result){
//            refreshDisplay();
//        }
//    }

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


   /* Book[] myBooksArray = new Book[]{
            new Book ("Me Before You","Great book about a paralized guy","JojO","Moyer","Romance"),
            new Book("Book 1","Summary1","Author1fn","Author1ln","Comedy"),
            new Book("Book 2","Summary2","Author2fn","Author2ln","Drama"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
*/