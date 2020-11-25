package android.eservices.webrequests.data.database;

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

    @Insert
    Completable insertBook(BookEntity book);

    @Query("DELETE FROM booksTable WHERE id = :id")
    Completable deleteBook(String id);
}