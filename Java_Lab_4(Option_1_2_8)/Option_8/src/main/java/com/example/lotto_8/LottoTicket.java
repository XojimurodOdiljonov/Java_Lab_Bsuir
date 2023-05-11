package com.example.lotto_8;

import java.util.ArrayList;

public class LottoTicket {
    private int maxValue;
    private ArrayList<Integer> numbers;

    public LottoTicket(int numberOfValue, int maxValue){
        numbers = new ArrayList<>();
        this.maxValue = maxValue;

        for (int number = 0; number < numberOfValue; number++){
            numbers.add((int)(Math.random() * maxValue) + 1);
        }
    }

    public boolean isWinner(LottoTicket winningTicket){
        if (maxValue != winningTicket.getMaxValue() || numbers.size() != winningTicket.getNumbers().size() ){
            return false;
        }

        for (int index = 0; index < numbers.size(); index++){
            if (numbers.get(index) != winningTicket.getNumbers().get(index)){
                return false;
            }
        }

        return true;
    }

    public int getMaxValue(){
        return maxValue;
    }

    public ArrayList<Integer> getNumbers(){
        return (ArrayList<Integer>) numbers.clone();
    }
}
