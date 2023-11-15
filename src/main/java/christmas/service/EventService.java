package christmas.service;

import christmas.domain.event.BeneficialEvent;
import christmas.domain.event.DDayDiscountEvent;
import christmas.domain.event.DiscountEvent;
import christmas.domain.event.GiveawayEvent;
import christmas.domain.event.SpecialDayDiscountEvent;
import christmas.domain.event.WeekdayDiscountEvent;
import christmas.domain.event.WeekendDiscountEvent;
import christmas.domain.menu.MenuBoard;
import christmas.domain.menu.MenuItem;
import christmas.domain.order.OrderBoard;
import christmas.domain.order.VisitDate;
import java.util.List;

public class EventService {
    public GiveawayEvent initGiveawayEvent(MenuBoard menuBoard, OrderBoard orderBoard) {
        List<MenuItem> eventItem = List.of(menuBoard.findMenuItem("샴페인"));
        return new GiveawayEvent(eventItem, orderBoard, menuBoard);
    }

    public DDayDiscountEvent initDDayDiscountEvent(VisitDate visitDate, MenuBoard menuBoard, OrderBoard orderBoard) {
        return new DDayDiscountEvent(visitDate, orderBoard, menuBoard);
    }

    public WeekdayDiscountEvent initWeekdayDiscount(VisitDate visitDate, MenuBoard menuBoard, OrderBoard orderBoard) {
        return new WeekdayDiscountEvent(visitDate, orderBoard, menuBoard);
    }

    public WeekendDiscountEvent initWeekendDiscount(VisitDate visitDate, MenuBoard menuBoard, OrderBoard orderBoard) {
        return new WeekendDiscountEvent(visitDate, orderBoard, menuBoard);
    }

    public SpecialDayDiscountEvent initSpecialDayDiscount(VisitDate visitDate, MenuBoard menuBoard,
                                                          OrderBoard orderBoard) {
        return new SpecialDayDiscountEvent(visitDate, orderBoard, menuBoard);
    }

    /**
     * 총 혜택가를 계산합니다. "혜택가" 는 실제 고객의 입장에서 얻는 혜택을 금액으로 환산한 것입니다.
     *
     * @param beneficialEvents 적용할 이벤트들
     * @return 이벤트들의 총 혜택 금액
     */
    public int getTotalBenefitPrice(List<BeneficialEvent> beneficialEvents) {
        return beneficialEvents.stream()
                .mapToInt(BeneficialEvent::calculateBenefitPrice)
                .sum();
    }

    /**
     * 총 할인가를 계산합니다. "할인가" 는 실제 고객의 입장에서 실제 결제 금액에 반영되는 할인 금액을 의미합니다.
     *
     * @param discountEvents 적용할 할인 이벤트들
     * @return 이벤트들의 총 할인 금액
     */
    public int getTotalDiscountPrice(List<DiscountEvent> discountEvents) {
        return discountEvents.stream()
                .mapToInt(DiscountEvent::calculateDiscountPrice)
                .sum();
    }
}
