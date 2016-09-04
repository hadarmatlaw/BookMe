package b.hadar.bookme;

/**
 * Created by Sapi on 8/21/2016.
 */
public class BookModel {

        private String bookName;
        private String author;

        public String getBookName(){
            return bookName;
        }

        public void setBookName(String bookName){
            this.bookName = bookName;
        }

        public String getAuthor(){
            return author;
        }

        public void setAuthor(String author){
            this.author = author;
        }

        @Override
        public String toString(){
            return bookName;
        }

    }



