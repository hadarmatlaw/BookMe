//package b.hadar.bookme;
//import android.content.Context;
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import java.util.ArrayList;
//import java.util.List;
///**
// * Created by Sapi on 8/21/2016.
// */
//public class DataSource {
//    public final String[] columns = {
//            DatabaseHelper.USER_ID,
//            DatabaseHelper.USER_NAME,
//            DatabaseHelper.USER_BOOK_NAME,
//            DatabaseHelper.USER_AUTHOR_NAME
//    };
//
//    SQLiteOpenHelper dbHelper;
//    SQLiteDatabase database;
//
//    public DataSource(Context context){
//        dbHelper = new DatabaseHelper(context);
//    }
//
//    public void open(){
//        database = dbHelper.getWritableDatabase();
//    }
//
//    public void close(){
//        dbHelper.close();
//    }
//
//   /* public PersonModel create(PersonModel person, BookModel book) {
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHelper.USER_NAME, person.getPersonName());
//        values.put(DatabaseHelper.USER_ID, person.getPersonID());
//        values.put(DatabaseHelper.USER_BOOK_NAME, book.getBookName());
//        values.put(DatabaseHelper.USER_AUTHOR_NAME, book.getAuthor());
//        // long insertId = database.insert(DatabaseHelper.PEOPLE_TABLE, null, values);
//        // person.setPersonID(insertId);
//        return person;
//    }
//*/
//
//
//    public List<PersonBook> findPeople(){
//        List<PersonBook> name = new ArrayList<PersonBook>();
//        Cursor cursor = database.query(DatabaseHelper.USERS_BOOKS_TABLE, columns, null, null, null, null, DatabaseHelper.USER_NAME);
//        if (cursor.getCount() > 0){
//            while(cursor.moveToNext()){
//                PersonModel person = new PersonModel();
//                BookModel book = new BookModel();
//                person.setPersonID(cursor.getLong(cursor.getColumnIndex(DatabaseHelper.USER_ID)));
//                person.setPersonName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_NAME)));
//                book.setBookName(cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_BOOK_NAME)));
//                book.setAuthor(cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_AUTHOR_NAME)));
//                PersonBook personBook = new PersonBook();
//                personBook.person = person;
//                personBook.bookname= book;
//
//                name.add(personBook);
//            }
//        }
//        return name;
//    }
//
//
//
//
//    public boolean deletePerson(String person){
//        String where = DatabaseHelper.USER_NAME + "=?";
//        int result = database.delete(DatabaseHelper.USERS_BOOKS_TABLE, where, new String[] {person});
//        return (result == 1);
//    }
//
//}
//
//
//
