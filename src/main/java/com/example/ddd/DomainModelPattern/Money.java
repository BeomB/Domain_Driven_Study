package com.example.ddd.DomainModelPattern;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }


    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }
    public Money add(Money money){return new Money(this.value + money.value);}  // 불변 객체가 아니기 때문에 new 연산자로 추가필요

}
