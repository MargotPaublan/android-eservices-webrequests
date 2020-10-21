package android.eservices.webrequests;

import android.app.Application;
import android.eservices.webrequests.data.di.FakeDependencyInjection;

import com.facebook.stetho.Stetho;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * In this sample application, we decided not to use dependency injection.
 * Thus, there are some objects we don't want to recreate, such as retrofit, gson or API services.
 * Here we use the Application class to store our singletons, but in real case, we shall use DI to
 * handle these issues. In other words, please do not do that in production-aimed apps.
 */
public class BookApplication extends Application {

    public static final String API_KEY = "AIzaSyCb4Sw3Q3nJPpS_AoVOrgwm0A_8FcJRsL4";

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        FakeDependencyInjection.setContext(this);
    }
}
