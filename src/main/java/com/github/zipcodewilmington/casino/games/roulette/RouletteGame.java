package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.objects.RouletteBet;
import com.github.zipcodewilmington.casino.objects.Wheel;

import java.util.List;
import java.util.Scanner;

public class RouletteGame implements GambleableGame {
    String gameName;
    Wheel wheel;
    List<RoulettePlayer> activePlayers;
    RoulettePlayer player;

    public RouletteGame(String gameName, List<RoulettePlayer> activePlayers, RoulettePlayer player) {
        this.gameName = gameName;
        this.activePlayers = activePlayers;
        this.player = player;

    }


    @Override
    public void add(PlayerInterface player) {
        activePlayers.add(this.player);

    }

    @Override
    public void remove(PlayerInterface player) {
        activePlayers.remove(this.player);
    }

    @Override
    public void run() {
        player.play();
        wheel.getSpinValue();
        while (playerWins()){
            calculateWinnings(player.placeBet());
        }
    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        Scanner scanner = new Scanner(System.in);
        //return (userInput == wheel.getSpinValue());
        return false;

    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    public float calculateWinnings(RouletteBet bet){
        float winnings = 0;
        switch (bet) {
            case SINGLE:
                winnings = (player.amountWagered() * 35);
                break;
            case DOUBLE:
                winnings = (player.amountWagered() * 17);
                break;
            case STREET:
                winnings = (player.amountWagered() * 11);
                break;
            case CORNER:
                winnings = (player.amountWagered() * 8);
                break;
            case SIX:
                winnings = (player.amountWagered() * 5);
                break;
            case COLUMN:
            case DOZEN:
                winnings = (player.amountWagered() * 2);
                break;
            default:
                winnings = player.amountWagered();
                break;

        }

       return winnings;
    }

    @Override
    public void clearGame() {

    }



}
