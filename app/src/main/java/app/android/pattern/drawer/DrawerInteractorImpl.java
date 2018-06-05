package app.android.pattern.drawer;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import app.android.pattern.R;
import app.android.pattern.ui.fragment.BooksFragment;
import app.android.pattern.ui.fragment.CartFragment;

/**
 * Created by Aleesha Kanwal on 13/05/2018.
 */
public class DrawerInteractorImpl implements DrawerInteractor {

    @Override
    public void navigateTo(MenuItem item, DrawerLayout drawerLayout, DrawerListener listener) {

        switch (item.getItemId()) {

            case R.id.nav_linear_h:
                listener.fragmentReplace(BooksFragment.newInstance());
                break;
            case R.id.nav_grid_v:
                listener.fragmentReplace(CartFragment.newInstance());
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
