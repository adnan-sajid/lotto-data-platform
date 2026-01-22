package de.lottohessen.model;

import java.time.LocalDate;

public class LotteryDraw {

    private int drawId;
    private LocalDate drawDate;
    private String drawNumbers;

    public LotteryDraw(int drawId, LocalDate drawDate, String drawNumbers) {
        this.drawId = drawId;
        this.drawDate = drawDate;
        this.drawNumbers = drawNumbers;
    }

    public int getDrawId() {
        return drawId;
    }

    public LocalDate getDrawDate() {
        return drawDate;
    }

    public String getDrawNumbers() {
        return drawNumbers;
    }
}
