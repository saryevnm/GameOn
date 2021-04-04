package com.example.game.ui;

import com.example.game.domain.Card;
import com.example.game.domain.Game;

import java.util.ArrayList;
import java.util.List;

public class EmojiGame {
    private Game<String> game;
    public EmojiGame(){
        List<String> content = new ArrayList<>();
        content.add("\uD83D\uDE0D");
        content.add("\uD83C\uDF81");
        content.add("\uD83D\uDC22");
        game = new Game<>(content);
    }

    public void choose(Card<String> card){
        game.choose(card);
    }
    public List<Card<String>> getCards(){
        return game.getCards();
    }

}
