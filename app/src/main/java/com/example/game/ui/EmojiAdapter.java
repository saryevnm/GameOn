package com.example.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.game.R;
import com.example.game.domain.Card;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.ViewHolder> {
    private final EmojiGame game;
    private final listener listener;

    public EmojiAdapter(EmojiGame game, listener listener) {
        this.game = game;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final listener listener;
        private final TextView tv_card;
        public ViewHolder(@NonNull View itemView,listener listener) {
            super(itemView);
            this.listener = listener;
            tv_card = itemView.findViewById(R.id.item_text);
        }

        public void onBind(Card<String> card){
            itemView.setOnClickListener(v -> listener.cardClick(card));
            if (card.isFaceUp()){
                tv_card.setBackgroundColor(Color.WHITE);
                tv_card.setText(card.getContent());
            }else {
                tv_card.setBackgroundColor(Color.BLUE);
                tv_card.setText("");
            }
        }
    }
    interface listener{
        void cardClick(Card<String> card);
    }
}
