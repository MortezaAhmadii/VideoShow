package com.example.videoshow.Adopter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoshow.R;
import com.example.videoshow.models.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdopter extends RecyclerView.Adapter<CategoryAdopter.CategoryVH> {

    List<Category>categoryList;
    public CategoryAdopter(List<Category>categoryList){
        this.categoryList=categoryList;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.category_row,null);
        return new CategoryVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {

        Category category=categoryList.get(position);

        Picasso.get().load(category.getIcon()).into(holder.img_cat);
        holder.txt_cat.setText(category.getTitle());



    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryVH extends RecyclerView.ViewHolder {

        AppCompatImageView img_cat;
        AppCompatTextView txt_cat,txt_dec;
        public CategoryVH(@NonNull View itemView) {
            super(itemView);

            img_cat=itemView.findViewById(R.id.img_cat);
            txt_cat=itemView.findViewById(R.id.txt_cat);
            txt_dec=itemView.findViewById(R.id.txt_dec);
        }
    }
}
