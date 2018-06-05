package app.android.pattern.shop.view;

import java.util.List;

import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;

/**
 * Created by Aleesha Kanwal on 2/05/2018.
 */
public interface BooksMvpView {

    void setItems(List<BookEntity> pictureList);

    void setCartItems(List<Cart> pictureList);

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void hideEmpty();

    void hideCheckoutBtn();

    int getCartAdapterSize();
}
