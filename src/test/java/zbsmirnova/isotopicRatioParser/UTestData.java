package zbsmirnova.isotopicRatioParser;

import zbsmirnova.isotopicRatioParser.model.U;

import java.time.LocalDate;
import java.util.Arrays;

public class UTestData {
    public static final int FIRST_U_ID = 100010;
    public static final int SECOND_U_ID = 100010;
    public static final int THIRD_U_ID = 100010;

    public static final U FIRST_U = new U(FIRST_U_ID, "firstU", LocalDate.parse("2015-05-29"), 138.135, 0.135);
    public static final U SECOND_U = new U(SECOND_U_ID, "secondU", LocalDate.parse("2015-05-30"), 338.335, 0.335);
    public static final U THIRD_U = new U(THIRD_U_ID, "secondU", LocalDate.parse("2015-05-30"), 338.335, 0.335);

    public static U getNewU(){
        return new U("newU", LocalDate.now(), 205.208, 0.205);
    }

    public static void assertMatch(U actual, U expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<U> actual, U... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<U> actual, Iterable<U> expected) {
        assertThat(actual).isEqualTo(expected);
    }



}
