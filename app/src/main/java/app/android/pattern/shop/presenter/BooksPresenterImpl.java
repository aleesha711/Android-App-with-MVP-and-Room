package app.android.pattern.shop.presenter;

import java.util.List;

import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;
import app.android.pattern.shop.interactor.BooksInteractorImpl;
import app.android.pattern.shop.interactor.LoaderListener;
import app.android.pattern.shop.view.BooksMvpView;


/**
 * Created by Aleesha Kanwal on 1/05/2018.
 */
public class BooksPresenterImpl implements BooksPresenter<BooksMvpView>, LoaderListener {

    private BooksMvpView booksMvpView;
    private BooksInteractorImpl pictureInteractorImpl;

    public BooksPresenterImpl() {
        pictureInteractorImpl = new BooksInteractorImpl();
    }

    @Override
    public void attachedView(BooksMvpView view) {
        if (view == null)
            throw new IllegalArgumentException("You can't set a null view");

        booksMvpView = view;
    }

    @Override public void detachView() {
        booksMvpView = null;
    }

    @Override public void onResume() {
        booksMvpView.showProgress();
        pictureInteractorImpl.loadItems(this);
    }



    @Override public void onItemSelected(int position) {
        booksMvpView.showMessage(Integer.toString(position));

    }

    @Override
    public void onCardResume() {
        booksMvpView.showProgress();
        pictureInteractorImpl.loadItemsCart(this);
    }


    public void isCartDataPresent(){
        if(pictureInteractorImpl.getCartItemsFromDBEntity().size() ==0)
            booksMvpView.hideCheckoutBtn();
        else
            booksMvpView.hideEmpty();
    }

    public void isDataPresent(){
        if(pictureInteractorImpl.loadBooks().size() ==0)
            return;
        else
            booksMvpView.hideEmpty();
    }

    @Override public void onFinished(List<BookEntity> pictureList) {
        booksMvpView.setItems(pictureList);
        booksMvpView.hideProgress();
        isDataPresent();
    }

    @Override
    public void onCartFinished(List<Cart> pictureList) {
        booksMvpView.setCartItems(pictureList);
        booksMvpView.hideProgress();
        isCartDataPresent();
    }
}
