package dev.rollczi.kalkulator.component;

import dev.rollczi.kalkulator.Operator;

public interface Calculable {

    Component calcWith(Component number);

    DigitsAddableComponent getComponent();

    Operator getOperator();

    void setOperator(Operator operator);
}
