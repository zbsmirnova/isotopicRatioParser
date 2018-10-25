package zbsmirnova.isotopicRatioParser.testData;

import zbsmirnova.isotopicRatioParser.model.Rb;

import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RbTestData {
    public static final int FIRST_Rb_ID = 100007;
    public static final int SECOND_Rb_ID = 100008;
    public static final int THIRD_Rb_ID = 100009;

    public static final Rb FIRST_Rb = new Rb(FIRST_Rb_ID, "firstRb", LocalDate.parse("2015-04-29"), 185.187, 0.187);
    public static final Rb SECOND_Rb = new Rb(SECOND_Rb_ID, "secondRb", LocalDate.parse("2015-04-30"), 285.287, 0.287);
    public static final Rb THIRD_Rb = new Rb(THIRD_Rb_ID, "thirdRb", LocalDate.parse("2015-04-30"), 385.387, 0.387);

    public static Rb getNewRb(){
        return new Rb("newRb", LocalDate.now(), 105.107, 0.107);
    }

    public static void assertMatch(Rb actual, Rb expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Rb> actual, Rb... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Rb> actual, Iterable<Rb> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}