package app.android.pattern.shop.interactor;

import java.util.List;

import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;

/**
 * Created by Aleesha Kanwal on 1/05/2018.
 */
public interface LoaderListener {

    void onFinished(List<BookEntity> pictureList);
    void onCartFinished(List<Cart> pictureList);
}
