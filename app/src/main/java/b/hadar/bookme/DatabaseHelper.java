package b.hadar.bookme;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Sapi on 8/21/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

        private static final String DATABASE_NAME = "bookme_database.db";
        private static final int DATABASE_VERSION = 1;


        // TABLE NAMES
        public static final String USERS_BOOKS_TABLE = "users_books";
        public static final String BOOKS_TABLE = "books";

        //USERS_BOOKS_TABLE COLUMNS
        public static final String USER_ID = "userId";
        public static final String USER_NAME = "userName";
        public static final String USER_BOOK_NAME = "userBookName";
        public static final String USER_AUTHOR_NAME = "userAuthor";

        //BOOKS_TABLE COLUMNS
        public static final String BOOK_NAME = "bookName";
        public static final String AUTHOR_NAME = "author";
        public static final String BOOKID = "_id";
        public static final String LIBRARY_FLAG = "flag";




        public DatabaseHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
                db.execSQL( "create table " + "books " + "(_id INTEGER PRIMARY KEY AUTOINCREMENT,bookName TEXT, author TEXT, flag TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i2) {
                //db.execSQL("DROP TABLE IF EXISTS " + USERS_BOOKS_TABLE_CREATE);
                db.execSQL("DROP TABLE IF EXISTS " + BOOKS_TABLE);
                onCreate(db);

        }

        public boolean insertDataToBooksTable(BookModel book) {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(BOOK_NAME, book.getBookName());
                contentValues.put(AUTHOR_NAME, book.getAuthor());
                Long result = db.insert(BOOKS_TABLE,null,contentValues);
                if(result == -1)
                        return false;
                else
                        return true;
        }
        public Cursor getAllDataFromBooksTable(){
                SQLiteDatabase db = this.getWritableDatabase();
                String s = "select * from " + BOOKS_TABLE;

                Cursor res = db.rawQuery("select * from " + BOOKS_TABLE, null);
                return res;
        }


        public BookModel getBookByID(String Id){
                SQLiteDatabase db = this.getReadableDatabase();
                BookModel book = new BookModel();

                Cursor cursor = db.rawQuery( "select * from books where _id="+ Id + "", null );

                if (cursor.moveToFirst()) {
                        do {
                                book.setBookid(cursor.getString(cursor.getColumnIndex("_id")));
                                book.setBookName(cursor.getString(cursor.getColumnIndex("bookName")));
                                book.setAuthor(cursor.getString(cursor.getColumnIndex("author")));;


                        } while (cursor.moveToNext());
                }

                return book;
        }

        public Cursor getRowByID(String Id) {
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery("select * from books where _id=" + Id + "", null);

                if (cursor.moveToFirst()) {
                        do {
//                                book.setBookid(cursor.getString(cursor.getColumnIndex("bookId")));
//                                book.setBookName(cursor.getString(cursor.getColumnIndex("bookName")));
//                                book.setAuthor(cursor.getString(cursor.getColumnIndex("author")));;


                        } while (cursor.moveToNext());
                }

                return cursor;
        }

        public Cursor getRowByName(String name) {
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery("select * from books where bookName like " + "'%" + name + "%'" + "", null);

                return cursor;
        }



        public Cursor getIDByName(String name) {
                SQLiteDatabase db = this.getReadableDatabase();
                Cursor cursor = db.rawQuery("select _id from books where bookName like " + "'%" + name + "%'" + "", null);
                return cursor;
        }

        public Boolean addToLibrary (String id){
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(LIBRARY_FLAG, "X");
                db.update("books ", contentValues, "_id = ? ", new String[]{ id });
                return true;
        }

        public Boolean updateBookTable (String id, BookModel book){
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(BOOKID,id);
                contentValues.put(BOOK_NAME, book.getBookName());
                contentValues.put(AUTHOR_NAME, book.getAuthor());
                db.update("books ", contentValues, "_id = ? ", new String[]{ id });
                return true;
        }

        public Integer deleteDataFromBooksTable (String id) {
                SQLiteDatabase db = this.getWritableDatabase();
                return db.delete("books ", "_id = ? ", new String[] {id});

        }

}
