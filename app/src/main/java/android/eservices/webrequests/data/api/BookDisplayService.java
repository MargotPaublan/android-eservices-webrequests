package android.eservices.webrequests.data.api;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookDisplayService {
    @GET("volumes/")
    Single<BookSearchResponse> searchBooks(@Query("q") String keywords, @Query("key") String apikey);

    @GET("volumes/{bookId}")
    Single<Book> getBookById(@Path("bookId") String id, @Query("key") String apikey);


}
