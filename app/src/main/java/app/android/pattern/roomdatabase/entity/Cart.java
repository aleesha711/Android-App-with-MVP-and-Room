package app.android.pattern.roomdatabase.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Aleesha Kanwal on 25/05/2018.
 */
@Entity
public class Cart {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public int imageId;
    public int price;

    @ColumnInfo(name = "pos_id")
    public int posId;
}
