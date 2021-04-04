package com.example.game.domain;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Game<CardContent> {
    private List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents) {
        for (int i = 0; i <contents.size(); i++) {
            cards.add(new Card<>(false,false,contents.get(i),i*2));
            cards.add(new Card<>(false,false,contents.get(i),i*2+1));
        }
        Collections.shuffle(cards);
    }

  public void choose(Card<CardContent> card){
      card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()){
            findPairs(card);
        }
  }

    private void findPairs(Card<CardContent> card) {
        for (Card<CardContent> searchCard:cards) {
            if (searchCard.isFaceUp()
                    && searchCard.getId()!=card.getId()){
                if (searchCard.equals(card)){
                    cards.remove(searchCard);
                    cards.remove(card);
                    Log.d("remove","remove successful");
                    return;
                }else{
                    searchCard.setFaceUp(!searchCard.isFaceUp());
                    card.setFaceUp(!card.isFaceUp());
                }
            }

        }
    }

    public List<Card<CardContent>> getCards() {
        return cards;
    }

}
