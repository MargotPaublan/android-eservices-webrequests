package android.eservices.webrequests.data.api.repository.bookdisplay;

import android.eservices.webrequests.data.api.BookDisplayService;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;

public class BookDisplayRemoteDataSource {
    private BookDisplayService bookDisplayService;

    public BookDisplayRemoteDataSource(BookDisplayService bookDisplayService) {
        this.bookDisplayService = bookDisplayService;
    }

    public Single<BookSearchResponse> searchBook(String keywords) {
        return bookDisplayService.searchBooks(keywords);
    }
}
