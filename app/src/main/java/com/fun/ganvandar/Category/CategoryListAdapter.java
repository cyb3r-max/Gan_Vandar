package com.fun.ganvandar.Category;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.fun.ganvandar.Article.ArticleListActivity;
import com.fun.ganvandar.LoginActivity;
import com.fun.ganvandar.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.MyViewHolder> {

    List<Category> categories;
    Context context;

    public CategoryListAdapter(List<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }


    @NonNull
    @Override
    public CategoryListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_category, viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.MyViewHolder holder, final int position) {
        holder.tvCategoryList.setText(categories.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryListActivity activity = (CategoryListActivity) context;
                activity.callBack(categories.get(position));
            }
        });
        //Glide.with(context).load(categories.get(position).getImage()).into(holder.ivCategoryList);

/*        holder.tvCategoryList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(String.valueOf(ArticleListActivity.class));
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryList;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryList = itemView.findViewById(R.id.tvCategory);
        }
    }
}
