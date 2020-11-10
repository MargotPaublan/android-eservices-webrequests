package android.eservices.webrequests.data.api.repository.bookdisplay.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BookEntity.class}, version = 1)
public abstract class BooksDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}



