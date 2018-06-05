package app.android.pattern.shop.interactor;


import android.os.Handler;

import java.util.List;

import app.android.pattern.roomdatabase.database.AppDataBase;
import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;
import app.android.pattern.roomdatabase.utilities.DataSource;
import app.android.pattern.ui.App;

/**
 * Created by Aleesha Kanwal on 1/05/2018.
 */
public class BooksInteractorImpl implements BooksInteractor {

    @Override
    public void loadItems(final LoaderListener loaderListener) {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaderListener.onFinished(loadBooks());
            }
        }, 2000);
    }

    @Override
    public void loadItemsCart(final LoaderListener loaderListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loaderListener.onCartFinished(getCartItemsFromDBEntity());
            }
        }, 2000);
    }


    public List<BookEntity> loadBooks(){
        AppDataBase database = AppDataBase.getAppDatabase(App.getAppContext());
        return DataSource.with(database).getBooks();
    }

    public List<Cart> getCartItemsFromDBEntity(){
        AppDataBase database = AppDataBase.getAppDatabase(App.getAppContext());
        return database.catDao().loadAllDataList();
    }
}
