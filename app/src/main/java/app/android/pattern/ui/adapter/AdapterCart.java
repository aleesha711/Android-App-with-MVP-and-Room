package app.android.pattern.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.android.pattern.R;
import app.android.pattern.recyclerwidget.RecyclerItemClickListener;
import app.android.pattern.roomdatabase.database.AppDataBase;
import app.android.pattern.roomdatabase.entity.Cart;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Aleesha Kanwal on 4/05/2018.
 */

public class AdapterCart extends RecyclerView.Adapter<AdapterCart.ExampleHolder> {


    private List<Cart> pictureArrayList;
    private int itemLayout;
    private Context context;
    private RecyclerItemClickListener recyclerItemClickListener;


    public void setRecyclerItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    public AdapterCart(List<Cart> pictureArrayList, int itemLayout) {
        this.pictureArrayList = pictureArrayList;
        this.itemLayout = itemLayout;
    }

    @Override
    public ExampleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ExampleHolder(view);
    }

    @Override
    public void onBindViewHolder(final ExampleHolder holder, final int position) {

        final Cart bookEntity =pictureArrayList.get(position);

        holder.title.setText(bookEntity.name);
        holder.imageView.setImageResource(bookEntity.imageId);
        holder.imageView.setTag(bookEntity.imageId);


    }


    @Override
    public int getItemCount() {
        return pictureArrayList.size();
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
            addToCartButton.setText("Remove From Cart");
        }

        @Override
        public void onClick(View view) {
            if (recyclerItemClickListener != null)
                recyclerItemClickListener.onItemClickListener(getAdapterPosition());
        }

        @OnClick(R.id.addToCart)
        public void removeFromCart(){
            AppDataBase database = AppDataBase.getAppDatabase(context);
            database.catDao().delete(database.catDao().loadAllDataList().get(getAdapterPosition()));
            pictureArrayList.remove(getAdapterPosition());
            notifyDataSetChanged();
        }
    }
}
