package christmas.domain.event;

/**
 * 혜택가가 존재하는 이벤트를 나타냅니다.
 */
public abstract class BeneficialEvent {
    public abstract int calculateBenefitPrice();
}
