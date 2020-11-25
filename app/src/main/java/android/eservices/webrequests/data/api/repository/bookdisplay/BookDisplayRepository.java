package android.eservices.webrequests.data.api.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;
import android.eservices.webrequests.data.database.BookEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class BookDisplayRepository {
    BookDisplayRemoteDataSource bookDisplayRemoteDataSource;
    BookDisplayLocalDataSource bookDisplayLocalDataSource;
    BookToBookEntityMapper bookToBookEntityMapper;


    public BookDisplayRepository(BookDisplayLocalDataSource bookDisplayLocalDataSource, BookDisplayRemoteDataSource bookDisplayRemoteDataSource) {
        this.bookDisplayRemoteDataSource = bookDisplayRemoteDataSource;
        this.bookDisplayLocalDataSource = bookDisplayLocalDataSource;
        this.bookToBookEntityMapper = new BookToBookEntityMapper();
    }


    public Single<BookSearchResponse> getBooksResponse(String keywords) {
        return bookDisplayRemoteDataSource.searchBooks(keywords);
    }

    public Flowable<List<BookEntity>> getFavoriteBooksResponse() {
        return bookDisplayLocalDataSource.getFavoriteBooks();
    }

    public Completable addFavBook(String bookId) {
        Single<Book> book =  bookDisplayRemoteDataSource.getBookDetails(bookId);
        Single<BookEntity> bookEntity = book.map(new Function<Book, BookEntity>() {
                    @Override
                    public BookEntity apply(Book book) throws Exception {
                        return bookToBookEntityMapper.map(book);
                    }
                });
        Completable bookEntityResult = bookEntity.flatMapCompletable(new Function<BookEntity, CompletableSource>() {
            @Override
            public CompletableSource apply(BookEntity bookEntity) throws Exception {
                return bookDisplayLocalDataSource.insertBook(bookEntity);
            }
        });
        return bookEntityResult;
    }

    public Completable deleteFavBook(String id) {
        return bookDisplayLocalDataSource.deleteBook(id);
    }

}
