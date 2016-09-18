package b.hadar.bookme;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by User on 07/09/2016.
 */
public class ListViewSearchBook extends Activity {



        private BooksAdapter mBooksAdapter;
        private ListView mListView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.search_book);

//            View row = BooksAdapter.getView();
//            mListView = (ListView) findViewById(R.id.booksearchresultlistView);
//            mBooksAdapter = new BooksAdapter(getApplicationContext(),R.layout.book_row,row);

//            if(mListView != null){
//                mListView.setAdapter((ListAdapter) mBooksAdapter);
//            }
//
//            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    Log.v("PLACE", row[i].mNameOfPlace);
//                }
//            });
        }





}
