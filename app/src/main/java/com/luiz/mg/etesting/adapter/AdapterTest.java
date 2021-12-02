package com.luiz.mg.etesting.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.luiz.mg.etesting.QuestionActivity;
import com.luiz.mg.etesting.R;
import com.luiz.mg.etesting.models.Test;

import java.util.ArrayList;

public class AdapterTest extends RecyclerView.Adapter<AdapterTest.ItemTestViewHolder> {

    ArrayList<Test> listTests;

    //Constructor
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
                showAlertDialog(holder.titleTest.getContext()));
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

    private void showAlertDialog(Context ctx) {

        AlertDialog.Builder alert = new AlertDialog.Builder(ctx);
        alert.setIcon(android.R.drawable.ic_dialog_alert);

        alert.setTitle(ctx.getResources().getString(R.string.to_do_test));
        alert.setMessage(ctx.getResources().getString(R.string.really_to_do_test));

        alert.setPositiveButton(ctx.getResources().getString(R.string.positive),
                (dialogInterface, i) -> {
                    Intent intent = new Intent(ctx, QuestionActivity.class);
                    ctx.startActivity(intent);

        });

        alert.setNegativeButton(ctx.getResources().getString(R.string.negative),
                (dialogInterface, i) -> {

        });

        alert.create();
        alert.show();
    }
}
