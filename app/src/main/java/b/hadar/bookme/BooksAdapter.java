package b.hadar.bookme;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by User on 06/09/2016.
 */
public class BooksAdapter extends ArrayAdapter<String> {
        Context mContext;
        int mLayoutResourceId;
        String idBook[] = null;
        DatabaseHelper db;


        public BooksAdapter(Context context, int resource, String[] data) {
            super(context, resource, data);
            this.mContext = context;
            this.mLayoutResourceId = resource;
            this.idBook = data;

        }

        @Override
        public String getItem(int position) {
            return super.getItem(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            BookHolder holder = null;

            if(row == null){

                //inflate the layout for a single row
                LayoutInflater inflater = LayoutInflater.from(mContext);
                row = inflater.inflate(mLayoutResourceId, parent, false);

                holder = new BookHolder();
                holder.bookNameView = (TextView)row.findViewById(R.id.booknametextView);
                holder.authorNamwView = (TextView)row.findViewById(R.id.authortextView);
                holder.idNameView = (TextView) row.findViewById(R.id.idtextView);
                row.setTag(holder);

            }
            else {
                holder = (BookHolder)row.getTag();
            }

            //get the data from the data array
            String book = idBook[position];

            //setting the view to reflect the data we need to display

            BookModel bookModel= db.getBookByID(book);
            holder.bookNameView.setText(String.valueOf(bookModel.getBookName()));
            holder.authorNamwView.setText(String.valueOf(bookModel.getAuthor()));//always pay attention to your datatypes!
            holder.idNameView.setText(String.valueOf(bookModel.getBookid()));

            return row;

        }

//        View.OnClickListener PopupListener = new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Integer viewPosition = (Integer) view.getTag();
//                Place p = mData[viewPosition];
//                Toast.makeText(getContext(),p.mPopup, Toast.LENGTH_SHORT).show();
//            }
//        };

        static class BookHolder{

            TextView bookNameView;
            TextView authorNamwView;
            TextView idNameView;

        }

    }




