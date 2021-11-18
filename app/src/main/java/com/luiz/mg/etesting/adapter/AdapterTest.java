package com.luiz.mg.etesting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.luiz.mg.etesting.R;

import java.util.ArrayList;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.ItemTestViewHolder> {

    ArrayList<String> listTests;

    //Construtor
    public AdapterTest(ArrayList<String> list) {
        this.listTests = list;
    }

    @NonNull
    @Override
    public ItemTestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_test, parent, false);

        return new ItemTestViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTestViewHolder holder, int position) {
        String test = listTests.get(position);
        holder.textTest.setText(test);
    }

    @Override
    public int getItemCount() {
        return listTests.size();
    }

    //INNER CLASS
    public static class ItemTestViewHolder extends RecyclerView.ViewHolder{

        TextView textTest;

        public ItemTestViewHolder(View view) {
            super(view);
            textTest = view.findViewById(R.id.titleTestId);
        }

    }
}
