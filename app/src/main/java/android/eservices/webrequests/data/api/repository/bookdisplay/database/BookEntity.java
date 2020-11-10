package android.eservices.webrequests.data.api.repository.bookdisplay.database;

import android.eservices.webrequests.data.api.model.BookInfo;
import android.eservices.webrequests.data.api.model.ImageLinks;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "booksTable")
public class BookEntity {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "imageLinks")
    public String imageLinks;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "language")
    public String language;

    @ColumnInfo(name = "publishedDate")
    public String publishedDate;
}