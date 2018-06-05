package app.android.pattern.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.android.pattern.R;
import app.android.pattern.checkout.CreditCardStrategy;
import app.android.pattern.checkout.PaypalStrategy;
import app.android.pattern.checkout.ShoppingCart;
import app.android.pattern.recyclerwidget.ItemOffsetDecoration;
import app.android.pattern.recyclerwidget.RecyclerItemClickListener;
import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;
import app.android.pattern.shop.presenter.BooksPresenterImpl;
import app.android.pattern.shop.view.BooksMvpView;
import app.android.pattern.ui.adapter.AdapterBooksBuy;
import app.android.pattern.ui.adapter.AdapterCart;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Aleesha Kanwal on 5/05/2018.
 */

public abstract class BaseFragment extends Fragment implements BooksMvpView, RecyclerItemClickListener {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.checkoutCC)
    Button checkoutBtn;
    @Bind(R.id.checkoutPayPal)
    Button checkoutPaypal;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    @Bind(R.id.empty)
    TextView emptyTV;
    private BooksPresenterImpl picturePresenterImpl;
    RecyclerView.Adapter adapter;
    ShoppingCart cart;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, rootView);

        picturePresenterImpl = new BooksPresenterImpl();
        picturePresenterImpl.attachedView(this);
        setupRecyclerView();
        cart = new ShoppingCart();

        return rootView;
    }

    public void loadBooksData() {
        picturePresenterImpl.onResume();
    }

    public void loadCartData() {
        picturePresenterImpl.onCardResume();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setItems(List<BookEntity> pictureList) {
        adapter = getAdapter(pictureList);
        recyclerView.setAdapter(adapter);

        if (adapter instanceof AdapterBooksBuy) {
            ((AdapterBooksBuy) adapter).setRecyclerItemClickListener(this);
            checkoutBtn.setVisibility(View.GONE);
            checkoutPaypal.setVisibility(View.GONE);
        } else if (adapter instanceof AdapterCart) {
            ((AdapterCart) adapter).setRecyclerItemClickListener(this);
            checkoutBtn.setVisibility(View.VISIBLE);
            checkoutPaypal.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setCartItems(List<Cart> pictureList) {

        adapter = getAdapter(pictureList);
        recyclerView.setAdapter(adapter);


        if (adapter instanceof AdapterBooksBuy) {
            ((AdapterBooksBuy) adapter).setRecyclerItemClickListener(this);
            checkoutBtn.setVisibility(View.GONE);
            checkoutPaypal.setVisibility(View.GONE);
        } else if (adapter instanceof AdapterCart) {
            ((AdapterCart) adapter).setRecyclerItemClickListener(this);
            checkoutBtn.setVisibility(View.VISIBLE);
            checkoutPaypal.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        checkoutBtn.setVisibility(View.INVISIBLE);
        checkoutPaypal.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
        if (adapter instanceof AdapterCart) {
            checkoutBtn.setVisibility(View.VISIBLE);
            checkoutPaypal.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void hideEmpty(){
        emptyTV.setVisibility(View.GONE);
    }

    @Override
    public void hideCheckoutBtn(){
        checkoutBtn.setVisibility(View.GONE);
        checkoutPaypal.setVisibility(View.GONE);
    }
    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        picturePresenterImpl.detachView();
        super.onDestroy();
    }

    @Override
    public void onItemClickListener(int position) {
        picturePresenterImpl.onItemSelected(position);
    }

    private void setupRecyclerView() {

        if (getLayoutManager() != null)
            recyclerView.setLayoutManager(getLayoutManager());

        recyclerView.addItemDecoration(new ItemOffsetDecoration(recyclerView.getContext(), R.dimen.item_decoration));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    protected abstract int getLayout();

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract RecyclerView.Adapter getAdapter(List<?> bookEntities);

    @OnClick(R.id.checkoutCC)
    public void checkoutThroughCC(){
        cart.pay(new CreditCardStrategy("Aleesha", "1234567890123456", "786", "12/15"));
    }

    @OnClick(R.id.checkoutPayPal)
    public void checkoutThroughPayPal(){
        cart.pay(new PaypalStrategy("email", "password"));

    }

    @Override
    public int getCartAdapterSize(){
        return ((AdapterCart) adapter).getItemCount();
    }
}
