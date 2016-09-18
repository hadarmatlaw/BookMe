package b.hadar.bookme;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 05/09/2016.
 */
public class SearchBook extends Activity {

    DatabaseHelper mydb;
    EditText bookNameSearch;
    ListView bookSearchList;
    Button searchbtn;
    Button addtolibrarybtn;
    Button finishbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_book);
        mydb = new DatabaseHelper(this);

        bookNameSearch = (EditText) findViewById(R.id.booksearcheditText);
        bookSearchList = (ListView) findViewById(R.id.booksearchresultlist);
        searchbtn = (Button) findViewById(R.id.searchbtn);
        addtolibrarybtn = (Button) findViewById(R.id.addToLibrarybtn);
        finishbtn = (Button) findViewById(R.id.finishbtn);

        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        SearchBook();
        AddToLibrary();

    }

    public void SearchBook (){
        searchbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SearchBookResult();


                    }
                }
        );

    }

    public void AddToLibrary () {
        addtolibrarybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.getIDByName(bookNameSearch.getText().toString());
                String id = new String(DatabaseHelper.BOOKID);

                boolean isFlagUpdate = mydb.addToLibrary(id);
                if (isFlagUpdate == true)
                    Toast.makeText(SearchBook.this, "Data Update", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SearchBook.this, "Data not Update" + id, Toast.LENGTH_LONG).show();

            }

        });
    }

    private void SearchBookResult(){
        Cursor cursor = mydb.getRowByName(bookNameSearch.getText().toString() );
        String[] fromFieldNames = new String [] {DatabaseHelper.BOOKID,DatabaseHelper.BOOK_NAME,DatabaseHelper.LIBRARY_FLAG};
        int [] toViewIDs = new int[] {R.id.idtextView,R.id.booknametextView, R.id.authortextView};
        SimpleCursorAdapter myCursorAdapter = new SimpleCursorAdapter(getBaseContext(),R.layout.book_row, cursor,fromFieldNames,toViewIDs,0);
        bookSearchList = (ListView)findViewById(R.id.booksearchresultlist);
        bookSearchList.setAdapter(myCursorAdapter);

    }

//    public void showMessage(String title, String Message) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(Message);
//        builder.show();
//    }

}
