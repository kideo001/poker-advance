package lintott.stephen;

import lintott.stephen.dealer.Dealer;
import lintott.stephen.deck.Card;
import lintott.stephen.hand.Hand;
import lintott.stephen.player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

public class Game {
    private Dealer dealer= new Dealer();
    private Player[] players;

    private void startGame() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter number of players...");
        int numberOfPlayers =0;
        try {
            numberOfPlayers = Integer.parseInt(in.readLine());
            int timesToShuffel = (int)Math.round(Math.random()*4);
            timesToShuffel++;
            for (int i=0;i<timesToShuffel;i++) {
                System.out.println("Shuffeling...");
                dealer.shuffel();
            }
            System.out.println("Dealing cards...");
            List<Card[]> hands = dealer.deal(numberOfPlayers);
            players = new Player[hands.size()];
            Hand hand = new Hand();
            for (int i = 0; i < hands.size();i++) {
                players[i] = new Player(hands.get(i));
                hand.sortHand(players[i].hand);
                players[i].rank = hand.BestHand(players[i].hand);
            }
            int bestRank = -1;
            int index = 0;
            for (int i =0;i < players.length;i++ ) {
                if (bestRank < players[i].rank) {
                    bestRank = players[i].rank;
                    index = i+1;
                }
            }
            System.out.println("Player " + index +"won");
            System.out.println("...");
            System.out.println("Hands in game");
            System.out.println("...");
            for (int i = 0; i < players.length; i++) {
                System.out.println("Player " + (i+1));
                for (int j =0 ;j < players[i].hand.length;j++){
                    System.out.println(players[i].hand[j].toString());
                }
            }
        } catch (IOException | NumberFormatException e) {

        }
    }

    public void play() {
        boolean playing = true;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (playing) {
            this.startGame();
            System.out.println("Play again? (y/n)");
            try {
                String input = in.readLine();
                boolean dotReadAgain = (input.equalsIgnoreCase("y"));
                if (!dotReadAgain) {
                    dotReadAgain = input.equalsIgnoreCase("n");
                }
                while (!dotReadAgain) {
                    System.out.println("Play again? (y/n)");
                    input = in.readLine().trim();
                    dotReadAgain = (input.equalsIgnoreCase("y"));
                    if (!dotReadAgain) {
                        dotReadAgain = input.equalsIgnoreCase("n");
                    }
                }
                if (input.equalsIgnoreCase("n")) {
                    playing = false;
                }
            } catch(IOException e) {
                //do nothing
            }
        }
    }
}
