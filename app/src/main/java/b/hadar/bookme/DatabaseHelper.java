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
        public static final String BOOK_ID = "bookId";

//        //CREATE USERS_BOOKS_TABLE
//        private static final String USERS_BOOKS_TABLE_CREATE =
//                "CREATE TABLE " + USERS_BOOKS_TABLE + " (" +
//                        USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                        USER_NAME + " TEXT, " + USER_BOOK_NAME + " TEXT, " +
//                        USER_AUTHOR_NAME + " TEXT)";
//
//
//        //CREATE BOOKS_TABLE
//        private static final String BOOKS_TABLE_CREATE =
//                "CREATE TABLE " + BOOKS_TABLE + " (" +
//                        BOOK_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                        AUTHOR_NAME + " TEXT, ";
//

        public DatabaseHelper(Context context) {
                super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
                db.execSQL( "create table " + "books " + "(bookId INTEGER PRIMARY KEY AUTOINCREMENT,bookName TEXT, author TEXT)");
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
                Cursor res = db.rawQuery("select * from" + BOOKS_TABLE, null);
                return res;
        }

}