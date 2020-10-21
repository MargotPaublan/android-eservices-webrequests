package android.eservices.webrequests.data.api;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.api.model.BookSearchResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BookDisplayService {
    @GET("volumes/")
    Single<BookSearchResponse> searchBooks(@Path("id") String keywords);
}
