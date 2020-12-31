package com.peter.primevideoclone.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.peter.primevideoclone.MovieDetailsActivity;
import com.peter.primevideoclone.R;
import com.peter.primevideoclone.model.CategoryItem;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder>
{
    Context context;
    List<CategoryItem> categoryItemList;

    public ItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList)
    {
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.cart_recycler_row_items,parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, final int position)
    {
        Glide.with(context).load(categoryItemList.get(position).getImageUrl()).into(holder.itemImage);
        holder.itemImage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(context, categoryItemList.get(position).getMovieName(), Toast.LENGTH_SHORT).show();

                Intent movieDetailsIntent = new Intent(context, MovieDetailsActivity.class);
                movieDetailsIntent.putExtra("movieId", categoryItemList.get(position).getId());
                movieDetailsIntent.putExtra("movieName", categoryItemList.get(position).getMovieName());
                movieDetailsIntent.putExtra("movieImageUrl", categoryItemList.get(position).getImageUrl());
                movieDetailsIntent.putExtra("movieFileUrl", categoryItemList.get(position).getFileUrl());

                context.startActivity(movieDetailsIntent);

                
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public static final class ItemViewHolder extends RecyclerView.ViewHolder
    {
        ImageView itemImage;

        public ItemViewHolder(@NonNull View itemView)
        {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);
        }
    }
}
