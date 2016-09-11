package b.hadar.bookme;

import android.app.Activity;
import android.content.Intent;
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
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends Activity {


    DatabaseHelper mydb;
    EditText bookName, Author;
    Button addDatabtn;
    Button btnviewAll;
    Button updatebtn;
    EditText idBook;
    Button btnDelete;
    Button bookQuery;
    Button searchBookbtn;
    ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_book);
        mydb = new DatabaseHelper(this);

        bookName = (EditText) findViewById(R.id.editBookName);
        Author = (EditText) findViewById(R.id.editAuthor);
        addDatabtn = (Button) findViewById(R.id.addbtn);
        btnviewAll = (Button) findViewById(R.id.viewall);
        updatebtn = (Button) findViewById(R.id.updatebtn);
        idBook = (EditText) findViewById(R.id.ideditText);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        bookQuery = (Button) findViewById(R.id.bookbyidbutton);
        searchBookbtn = (Button) findViewById(R.id.SearchBookbtn);

        searchBookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),SearchBook.class);
                startActivity(intent);
            }
        });


        AddData();
        viewAll();
        UpdateData();
        DeleteData();
        ViewById();

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

    public void ViewById() {
        bookQuery.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        populateListViewByID();
                    }
                }


        );
    }


    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        populateListView();

                    }
                }
       );
    }



    public void UpdateData() {
        updatebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BookModel book = new BookModel();
                        book.setBookName(bookName.getText().toString());
                        book.setAuthor(Author.getText().toString());
                        boolean isUpdate = mydb.updateBookTable(idBook.getText().toString(),book);
                        if (isUpdate == true)
                            Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Update",Toast.LENGTH_LONG).show();
                    }
                }


        );
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = mydb.deleteDataFromBooksTable(idBook.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    private void populateListView(){
        Cursor cursor = mydb.getAllDataFromBooksTable();
        String[] fromFieldNames = new String [] {DatabaseHelper.BOOKID,DatabaseHelper.BOOK_NAME,DatabaseHelper.AUTHOR_NAME};
        int [] toViewIDs = new int[] {R.id.idtextView,R.id.booknametextView, R.id.authortextView};
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.book_row, cursor,fromFieldNames,toViewIDs,0);
        mListView = (ListView)findViewById(R.id.booksearchresultlistView1);
        mListView.setAdapter(myCursorAdapter);

    }

    private void populateListViewByID(){
        Cursor cursor = mydb.getRowByID(idBook.getText().toString() );
        String[] fromFieldNames = new String [] {DatabaseHelper.BOOKID,DatabaseHelper.BOOK_NAME,DatabaseHelper.AUTHOR_NAME};
        int [] toViewIDs = new int[] {R.id.idtextView,R.id.booknametextView, R.id.authortextView};
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.book_row, cursor,fromFieldNames,toViewIDs,0);
        mListView = (ListView)findViewById(R.id.booksearchresultlistView1);
        mListView.setAdapter(myCursorAdapter);

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