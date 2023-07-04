package org.example.calculate;

public class PositiveNumber {
    private final int value;

    // PositiveNumber 객채가 만들어졌다 = 음수가 아니다! 양수 보장
    // 음수일 경우 예외처리됨
    public PositiveNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if(isNegativeNumber(value)){
            throw new IllegalArgumentException("0또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt(){
        return value;
    }
}
