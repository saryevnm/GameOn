package com.example.game.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.game.R;
import com.example.game.domain.Card;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.listener {
    private EmojiGame emojiGame;
    private EmojiAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        emojiGame = new EmojiGame();
        adapter = new EmojiAdapter(emojiGame,this,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void cardClick(Card<String> card) {
        emojiGame.choose(card);
        if (emojiGame.getCards().size() == 0){
            androidx.appcompat.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Game is over");
            builder.show();
        }
        adapter.notifyDataSetChanged();
    }
}