package com.luiz.mg.etesting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.luiz.mg.etesting.R;
import com.luiz.mg.etesting.models.Test;

import java.util.ArrayList;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.ItemTestViewHolder> {

    ArrayList<Test> listTests;

    //Construtor
    public AdapterTest(ArrayList<Test> list) {
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
        Test test = listTests.get(position);
        holder.titleTest.setText(test.getTitle());
        holder.descTest.setText(test.getDesc());
        holder.dateTest.setText(test.getDate());
        String time = "Inicia às " + test.getTime();
        holder.timeTest.setText(time);
        holder.cardTest.setOnClickListener(view ->
                Toast.makeText(view.getContext(), "Vai fazer o teste " + position + "?",
                        Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return listTests.size();
    }

    //INNER CLASS
    public static class ItemTestViewHolder extends RecyclerView.ViewHolder{

        TextView titleTest;
        TextView dateTest;
        TextView descTest;
        TextView timeTest;
        CardView cardTest;

        public ItemTestViewHolder(View view) {
            super(view);
            titleTest = view.findViewById(R.id.titleTestId);
            dateTest = view.findViewById(R.id.dateTestId);
            descTest = view.findViewById(R.id.descTestId);
            timeTest = view.findViewById(R.id.timeTestId);
            cardTest = view.findViewById(R.id.cardViewId);
        }

    }
}
