package zbsmirnova.isotopicRatioParser.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zbsmirnova.isotopicRatioParser.model.U;

import java.time.LocalDate;

import static zbsmirnova.isotopicRatioParser.testData.UTestData.assertMatch;
import static zbsmirnova.isotopicRatioParser.testData.UTestData.*;

public class UServiceTest extends AbstractServiceTest {

    @Autowired
    UService service;

    @Test
    public void save() {
        U newU = getNewU();
        service.save(newU);
        assertMatch(service.getAll(), newU, SECOND_U, THIRD_U, FIRST_U);
    }

    @Test
    public void deleteById() {
        service.delete(FIRST_U_ID);
        assertMatch(service.getAll(), SECOND_U, THIRD_U);
    }

    @Test
    public void deleteBySampleName() {
        service.delete(FIRST_U.getSampleName());
        assertMatch(service.getAll(), SECOND_U, THIRD_U);
    }

    @Test
    public void getById() {
        assertMatch(service.get(FIRST_U_ID), FIRST_U);
    }

    @Test
    public void getBySampleName() {
        assertMatch(service.get(FIRST_U.getSampleName()), FIRST_U);
    }

    @Test
    public void getByDate() {
        assertMatch(service.getByDate(LocalDate.parse("2015-04-30")), SECOND_U, THIRD_U);
    }

    @Test
    public void getBetween() {
        assertMatch(service.getBetween(LocalDate.parse("2015-03-30"), LocalDate.parse("2015-04-29")), FIRST_U);
    }

    @Test
    public void getAll() {
        assertMatch(service.getAll(), SECOND_U, THIRD_U, FIRST_U);
    }
}