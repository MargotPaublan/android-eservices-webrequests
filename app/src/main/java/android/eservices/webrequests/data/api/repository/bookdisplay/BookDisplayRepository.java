package android.eservices.webrequests.data.api.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.api.repository.bookdisplay.database.BookEntity;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class BookDisplayRepository {
    BookDisplayRemoteDataSource bookDisplayRemoteDataSource;
    //BookDisplayLocalDataSource bookDisplayLocalDataSource;

    public BookDisplayRepository(BookDisplayRemoteDataSource bookDisplayRemoteDataSource/*, BookDisplayLocalDataSource bookDisplayLocalDataSource*/) {
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
        //this.bookDisplayLocalDataSource = bookDisplayLocalDataSource;
    }


    public Single<BookSearchResponse> getBooksResponse(String keywords) {
        return bookDisplayRemoteDataSource.searchBooks(keywords);
    }

    /*public Flowable<List<BookEntity> getFavoriteBooksResponse() {
        return bookDisplayLocalDataSource.getFavoriteBooks;
    }*/
}
