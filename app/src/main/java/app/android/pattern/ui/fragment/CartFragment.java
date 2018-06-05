package app.android.pattern.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import app.android.pattern.R;
import app.android.pattern.roomdatabase.entity.Cart;
import app.android.pattern.ui.adapter.AdapterCart;

/**
 * Created by Aleesha Kanwal on 7/05/2018.
 */

public class CartFragment extends BaseFragment {

    public static CartFragment newInstance() {
        return new CartFragment();
    }

    @Override protected int getLayout() {
        return R.layout.fragment_base;
    }

    @Override protected RecyclerView.LayoutManager getLayoutManager() {
        return getLinearLayoutManager();
    }

    @Override
    protected RecyclerView.Adapter getAdapter(List<?> bookEntities) {
        return new AdapterCart((List<Cart>)bookEntities,R.layout.fragment_shop);
    }

    private LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(
                getActivity(),
                LinearLayoutManager.HORIZONTAL,
                false);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCartData();
    }
}

