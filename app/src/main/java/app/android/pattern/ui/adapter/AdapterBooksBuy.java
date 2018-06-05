package app.android.pattern.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import app.android.pattern.R;
import app.android.pattern.recyclerwidget.RecyclerItemClickListener;
import app.android.pattern.roomdatabase.database.AppDataBase;
import app.android.pattern.roomdatabase.entity.BookEntity;
import app.android.pattern.roomdatabase.utilities.DataSource;
import app.android.pattern.ui.App;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Aleesha Kanwal on 4/05/2018.
 */

public class AdapterBooksBuy extends RecyclerView.Adapter<AdapterBooksBuy.ExampleHolder> {

    private List<BookEntity> bookEntityArrayList;
    private int itemLayout;
    private Context context;
    private RecyclerItemClickListener recyclerItemClickListener;

    public void setRecyclerItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    public AdapterBooksBuy(List<BookEntity> pictureArrayList, int itemLayout) {
        this.bookEntityArrayList = pictureArrayList;
        this.itemLayout = itemLayout;
    }

    @Override
    public ExampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ExampleHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExampleHolder holder, final int position) {
        final BookEntity bookEntity = bookEntityArrayList.get(position);
        holder.title.setText(bookEntity.name);
        holder.imageView.setImageResource(bookEntity.imageId);
        holder.imageView.setTag(bookEntity.imageId);

    }


    @Override
    public int getItemCount() {
        return bookEntityArrayList.size();
    }


    public class ExampleHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.txt_title)
        TextView title;
        @Bind(R.id.imageView)
        ImageView imageView;
        @Bind(R.id.addToCart)
        Button addToCartButton;

        public ExampleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            context = itemView.getContext();

        }

        @Override
        public void onClick(View view) {
            if (recyclerItemClickListener != null)
                recyclerItemClickListener.onItemClickListener(getAdapterPosition());
        }

        @OnClick(R.id.addToCart)
        public void addToCart(){

            Toast.makeText(App.getAppContext(), "Item added to cart",
                    Toast.LENGTH_SHORT).show();

            AppDataBase database = AppDataBase.getAppDatabase(context);
            Integer resource = (Integer)imageView.getTag();
            DataSource.with(database).addToCart(title.getText().toString().trim(), resource,resource);

        }
    }

}
