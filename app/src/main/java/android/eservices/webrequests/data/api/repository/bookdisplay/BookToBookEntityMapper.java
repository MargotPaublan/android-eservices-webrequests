package android.eservices.webrequests.data.api.repository.bookdisplay;

import android.eservices.webrequests.data.api.model.Book;
import android.eservices.webrequests.data.database.BookEntity;
import android.text.TextUtils;

public class BookToBookEntityMapper {

    // Map a book object to a bookEntity object
    public BookEntity map(Book book) {
        // Create a bookEntity object
        BookEntity bookEntity = new BookEntity();

        // Set bookEntity infos from book object infos
        bookEntity.setTitle(book.getVolumeInfo().getTitle());

        if (book.getVolumeInfo().getAuthorList() == null) {
            bookEntity.setAuthors("Empty author list");
        } else {
            bookEntity.setAuthors(TextUtils.join(", ", book.getVolumeInfo().getAuthorList()));
        }
        bookEntity.setDescription(book.getVolumeInfo().getDescription());
        bookEntity.setId(book.getId());
        bookEntity.setLanguage(book.getVolumeInfo().getLanguage());
        bookEntity.setPublishedDate(book.getVolumeInfo().getPublishedDate());
        bookEntity.setThumbUrl(book.getVolumeInfo().getImageLinks().getThumbnail());
        return bookEntity;
    }
}
