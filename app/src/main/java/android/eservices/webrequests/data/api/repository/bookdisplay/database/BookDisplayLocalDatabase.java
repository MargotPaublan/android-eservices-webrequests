package android.eservices.webrequests.data.api.repository.bookdisplay.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {BookEntity.class}, version = 1)
public abstract class BookDisplayLocalDatabase extends RoomDatabase {
    /*private static BookDisplayLocalDatabase BOOKS_LOCAL_DATABASE = null;

    public abstract BookDao bookDao();

    public BookDisplayLocalDatabase getBooksLocalDatabase() {
        if (BOOKS_LOCAL_DATABASE == null) {
            return Room.databaseBuilder(getApplicationContext(), BookDisplayLocalDatabase.class, "database-books").build();
        }
        else {
            return BOOKS_LOCAL_DATABASE;
        }

    }*/

}



