package com.example.quotes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuotesViewholder> {
    List<String> quotes = null;
    Context context;

    public QuotesAdapter(List<String> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @NonNull
    @Override
    public QuotesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item_quotes, parent, false);


        return new QuotesViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewholder holder, int position) {
        String[] colors = {"#2CC23A", "#E5BF2E", "#2EE1E5", "#CE2EE5", "#F44CDB"};

        String quote = quotes.get(position);

        holder.textQuote.setText(quote);
        int color = position % colors.length;
        int intcolor = Color.parseColor(colors[color]);

        holder.quotecontainer.setBackgroundColor(intcolor);

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    public class QuotesViewholder extends RecyclerView.ViewHolder {

        TextView textQuote;
        LinearLayout quotecontainer;


        public QuotesViewholder(@NonNull View itemView) {


            super(itemView);
            textQuote = itemView.findViewById(R.id.textQuotes);

            quotecontainer = itemView.findViewById(R.id.quoteContainer);
        }
    }
}
