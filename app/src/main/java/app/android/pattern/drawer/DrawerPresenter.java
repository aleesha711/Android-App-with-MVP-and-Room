package app.android.pattern.drawer;

import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

/**
 * Created by Aleesha Kanwal on 13/05/2018.
 */

public interface DrawerPresenter {
    void navigationItemSelected(MenuItem item, DrawerLayout drawerLayout);
}
