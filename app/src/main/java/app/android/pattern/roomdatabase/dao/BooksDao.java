package app.android.pattern.roomdatabase.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.entity.Cart;


/**
 * Created by Aleesha Kanwal on 6/05/2018.
 */

@Dao
public interface BooksDao {

    @Insert
    void insert(BookEntity... bookEntity);

    @Insert
    void insert(Cart... cartEntity);

    @Insert
    void insert(List<BookEntity> bookEntityList);

    @Update
    void update(BookEntity... bookEntity);

    @Delete
    void delete(BookEntity... bookEntity);

    @Delete
    void delete(Cart... cartEntity);

    @Delete
    void deleteWord(BookEntity bookEntity);

    @Query("Select * FROM BookEntity")
    BookEntity[] loadAll();

    @Query("Select * FROM Cart")
    List<Cart> loadAllDataList();

    @Query("SELECT name FROM BookEntity")
    String[] loadName();

    @Query("SELECT imageId FROM BookEntity")
    int[] loadImage();

    @Query("SELECT COUNT(*) FROM BookEntity")
    int getSize();
}
