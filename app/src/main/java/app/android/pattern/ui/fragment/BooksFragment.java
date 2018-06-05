package app.android.pattern.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import app.android.pattern.R;
import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.ui.adapter.AdapterBooksBuy;

/**
 * Created by Aleesha Kanwal on 7/05/2018.
 */

public class BooksFragment extends BaseFragment {

    public static BooksFragment newInstance() {
        return new BooksFragment();
    }

    @Override protected int getLayout() {
        return R.layout.fragment_base;
    }

    @Override protected RecyclerView.LayoutManager getLayoutManager() {
        return getGridLayoutManager();
    }


    @Override
    protected RecyclerView.Adapter getAdapter(List<?> booksArrayList) {
        return new AdapterBooksBuy((List<BookEntity>) booksArrayList,R.layout.fragment_shop);
    }

    private GridLayoutManager getGridLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(
                getActivity(),
                2,
                GridLayoutManager.VERTICAL,
                false);

        return gridLayoutManager;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadBooksData();
    }

}

