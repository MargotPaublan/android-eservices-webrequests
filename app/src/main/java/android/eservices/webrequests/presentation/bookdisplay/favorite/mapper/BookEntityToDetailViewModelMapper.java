package android.eservices.webrequests.presentation.bookdisplay.favorite.mapper;


import android.eservices.webrequests.data.database.BookEntity;
import android.eservices.webrequests.presentation.bookdisplay.favorite.adapter.BookDetailViewItem;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BookEntityToDetailViewModelMapper {


    // Map a BookEntity to a BookDetailViewItem
    public BookDetailViewItem map(BookEntity bookEntity){
        // Create BookDetailViewItem
        BookDetailViewItem bookDetailViewItem = new BookDetailViewItem();

        // Set BookDetailViewItem infos from bookEntity parameter
        bookDetailViewItem.setBookTitle(bookEntity.getTitle());
        bookDetailViewItem.setBookAuthors(bookEntity.getAuthors());
        if(bookEntity.getDescription() != null) {
            bookDetailViewItem.setBookDescription(bookEntity.getDescription());
        }
        bookDetailViewItem.setBookId(bookEntity.getId());
        bookDetailViewItem.setBookLanguage(languageMapper(bookEntity.getLanguage()));
        bookDetailViewItem.setBookPublishedDate(bookEntity.getPublishedDate());
        bookDetailViewItem.setIconUrl(bookEntity.getThumbUrl());
        return bookDetailViewItem;
    }

    // Map a list of BookEntities to a list of BookDetailViewItems
    public List<BookDetailViewItem> map(List<BookEntity> bookEntitiesList) {
        ArrayList<BookDetailViewItem> bookDetailViewItemList = new ArrayList<>();
        for(BookEntity bookEntity : bookEntitiesList){
            bookDetailViewItemList.add(map(bookEntity));
        }
        return bookDetailViewItemList;
    }

    // Map symbol language to a full string (used to map book entities infos)
    private String languageMapper(String input) {
        switch (input) {
            case "en":
                return "English";
            case "fr":
                return "French";
            default:
                return "Unknown (" + input + ")";
        }
    }
}
