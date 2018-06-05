package app.android.pattern.shop.interactor;

/**
 * Created by Aleesha Kanwal on 1/05/2018.
 */
public interface BooksInteractor {

    void loadItems(LoaderListener loaderListener);
    void loadItemsCart(LoaderListener loaderListener);
}
