package android.eservices.webrequests.data.api.repository.bookdisplay.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface BookDao {
    @Query("SELECT * FROM booksTable")
    Flowable<List<BookEntity>> getFavoriteBooks();

    @Query("SELECT * FROM booksTable WHERE booksTable.title = :name")
    Single<BookEntity> getBookByName(String name);

    @Insert
    Completable insertBook(BookEntity book);

    @Delete
    Completable deleteBook(BookEntity book);
}