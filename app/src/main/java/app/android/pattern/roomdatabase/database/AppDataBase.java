package app.android.pattern.roomdatabase.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import app.android.pattern.roomdatabase.dao.BooksDao;
import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;


/**
 * Created by Aleesha Kanwal on 6/05/2018.
 */

@Database(entities = {BookEntity.class, Cart.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;

    public abstract BooksDao catDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class,
                    "books-db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
