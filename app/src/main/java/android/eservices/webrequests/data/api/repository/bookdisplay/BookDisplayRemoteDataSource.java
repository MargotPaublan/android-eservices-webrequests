package android.eservices.webrequests.data.api.repository.bookdisplay;

import android.eservices.webrequests.BookApplication;
import android.eservices.webrequests.data.api.BookDisplayService;
import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Single;

public class BookDisplayRemoteDataSource {
    private BookDisplayService bookDisplayService;

    public BookDisplayRemoteDataSource(BookDisplayService bookDisplayService) {
        this.bookDisplayService = bookDisplayService;
    }

    public Single<Book> getBook(String id) {
        return this.bookDisplayService.getBookById(id, BookApplication.API_KEY);
    }

    public Single<BookSearchResponse> searchBooks(String keywords) {
        return bookDisplayService.searchBooks(keywords, BookApplication.API_KEY);
    }
}
