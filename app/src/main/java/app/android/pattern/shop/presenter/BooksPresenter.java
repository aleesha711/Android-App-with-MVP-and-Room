package app.android.pattern.shop.presenter;

/**
 * Created by Aleesha Kanwal on 1/05/2018.
 */
public interface BooksPresenter<V> {

    void attachedView(V view);

    void detachView();

    void onResume();

    void onItemSelected(int position);

    void onCardResume();
}
