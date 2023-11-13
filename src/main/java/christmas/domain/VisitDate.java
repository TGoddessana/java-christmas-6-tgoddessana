package christmas.domain;

public class VisitDate {
    private final int date;

    public VisitDate(Integer date) {
        validate(date);
        this.date = date;
    }

    private void validate(Integer date) {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
