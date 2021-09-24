package dev.rollczi.kalkulator;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Number {

    private final Pair<List<Integer>, List<Integer>> pairDigits = new Pair<>(new ArrayList<>(), new ArrayList<>());
    private boolean right = false;

    public void append(int digit) {
        this.functionOnList(list -> list.add(digit));
    }

    public void dropLast() {
        if (functionOnList(List::isEmpty)) {
            if (pairDigits.second.isEmpty()) {
                right = false;
            }

            return;
        }

        functionOnList(list -> list.remove(list.size() - 1));
    }

    private  <T> T functionOnList(Function<List<Integer>, T> listConsumer) {
        return listConsumer.apply(right ? pairDigits.second : pairDigits.first);
    }

}
