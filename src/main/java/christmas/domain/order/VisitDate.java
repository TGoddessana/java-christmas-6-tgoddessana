package christmas.domain.order;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class VisitDate {
    private static final int CURRENT_YEAR = 2023;
    private final LocalDate date;

    public VisitDate(int dayOfMonth) {
        validate(dayOfMonth);
        this.date = LocalDate.of(CURRENT_YEAR, 12, dayOfMonth);
    }

    private void validate(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 31) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }

    public int getUntilChristmas() {
        LocalDate christmas = LocalDate.of(CURRENT_YEAR, 12, 25);
        return date.until(christmas).getDays();
    }

    public boolean isWeekend() {
        DayOfWeek dayOfWeek = getDayOfWeek();
        return dayOfWeek == DayOfWeek.FRIDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}