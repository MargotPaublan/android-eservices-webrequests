package android.eservices.webrequests.data.api.repository.bookdisplay;

import android.eservices.webrequests.data.api.repository.bookdisplay.database.BookDao;
import android.eservices.webrequests.data.api.repository.bookdisplay.database.BookEntity;
import android.eservices.webrequests.data.api.repository.bookdisplay.database.BooksDatabase;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class BookDisplayLocalDataSource {
    private BooksDatabase booksDatabase;
    private BookDao bookDao;

    public BookDisplayLocalDataSource(BooksDatabase bookDatabase){
        this.booksDatabase = bookDatabase;
        this.bookDao = bookDatabase.bookDao();
    }

    public Flowable<List<BookEntity>> getFavoriteBooks() {
        return this.bookDao.getFavoriteBooks();
    }

    public Single<BookEntity> getFavBookByName(String name) {
        return this.bookDao.getBookByName(name);
    }

    public Completable insertBook(BookEntity bookEntity) {
        return this.bookDao.insertBook(bookEntity);
    }

    public Completable deleteBook(BookEntity bookEntity) {
        return this.bookDao.deleteBook(bookEntity);
    }
}



