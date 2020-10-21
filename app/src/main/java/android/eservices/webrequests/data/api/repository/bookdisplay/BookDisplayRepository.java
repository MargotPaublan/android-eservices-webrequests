package android.eservices.webrequests.data.api.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;

public class BookDisplayRepository {
    BookDisplayRemoteDataSource bookDisplayRemoteDataSource;

    public BookDisplayRepository(BookDisplayRemoteDataSource bookDisplayRemoteDataSource) {
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
    }

    public Single<BookSearchResponse> searchBooks(String keywords) {
        return bookDisplayRemoteDataSource.searchBook(keywords);
    }
}
