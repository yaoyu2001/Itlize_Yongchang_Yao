package com.itlize.EnumsPractice;

public class DuongXinyuEvaluator {
    String input;
    public DuongXinyuEvaluator( String input ) {
        this.input = input;
    }

    DuongXinyuEnum x;

    public boolean isDuong() {
        return input.equals(DuongXinyuEnum.Duong.name());
    }

    public boolean isXinyu() {
        return input.equals(DuongXinyuEnum.Xinyu.name());
    }
}
