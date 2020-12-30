package com.peter.primevideoclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.peter.primevideoclone.R;
import com.peter.primevideoclone.model.AllCategory;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder>
{

    Context context;
    List<AllCategory> allCategoryList;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position)
    {
        holder.categoryName.setText(allCategoryList.get(position).getCategoryTitle());

    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder
    {
        TextView categoryName;

        public MainViewHolder(@NonNull View itemView)
        {
            super(itemView);
            categoryName = itemView.findViewById(R.id.item_category);


        }
    }
}
