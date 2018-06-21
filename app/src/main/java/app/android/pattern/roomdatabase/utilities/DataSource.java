package app.android.pattern.roomdatabase.utilities;


import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

import app.android.pattern.R;
import app.android.pattern.roomdatabase.database.AppDataBase;
import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;
import app.android.pattern.ui.App;

/**
 * Created by Aleesha Kanwal on 6/05/2018.
 */

public class DataSource {

    private static DataSource instance;
    private static AppDataBase dataBase;
    List<BookEntity> bookEntities;

    public static DataSource with(AppDataBase appDataBase) {
        if (dataBase == null)
            dataBase = appDataBase;

        if (instance == null)
            instance = new DataSource();

        return instance;
    }

    public void addToCart(String name, int imageId, int posId) {
        Cart cart = cartInstance(name, imageId, posId);
        dataBase.catDao().insert(cart);
    }

    private BookEntity bookInstance(String name, int imageId, int posId) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.name = name;
        bookEntity.imageId = imageId;
        bookEntity.posId = posId;
        bookEntity.price = 1;

        return bookEntity;
    }

    private Cart cartInstance(String name, int imageId, int posId) {
        Cart cart = new Cart();
        cart.name = name;
        cart.imageId = imageId;
        cart.posId = posId;
        cart.price = 1;

        return cart;
    }

    public void loadBooks() {
        if (dataBase == null)
            return;

        bookEntities = new ArrayList<>();;
        String[] books_name_array = App.getAppContext().getResources().getStringArray(R.array.books_name);
        TypedArray tArray = App.getAppContext().getResources().obtainTypedArray(
                R.array.books_image);
        int count = tArray.length();
        int[] ids = new int[count];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = tArray.getResourceId(i, 0);
        }
        tArray.recycle();

        for (int i = 0; i < books_name_array.length; i++) {
            BookEntity bookEntity = bookInstance(books_name_array[i],ids[i], i);
            bookEntities.add(bookEntity);
            dataBase.catDao().insert(bookEntities);
        }
    }

    public List<BookEntity> getBooks(){
        loadBooks();
        return bookEntities;
    }
}
