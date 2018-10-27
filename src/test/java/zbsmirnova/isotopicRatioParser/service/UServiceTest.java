package zbsmirnova.isotopicRatioParser.service;

import org.assertj.core.condition.Not;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zbsmirnova.isotopicRatioParser.model.U;
import zbsmirnova.isotopicRatioParser.util.exception.NotFoundException;

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

    @Test(expected = NotFoundException.class)
    public void deleteByIdNotFound() {
        service.delete(0);
    }

    @Test
    public void deleteBySampleName() {
        service.delete(FIRST_U.getSampleName());
        assertMatch(service.getAll(), SECOND_U, THIRD_U);
    }

    @Test(expected = NotFoundException.class)
    public void deleteBySampleNameNotFound() {
        service.delete("");
    }

    @Test(expected = NotFoundException.class)
    public void getByIdNotFound() {
        assertMatch(service.get(0), FIRST_U);
    }

    @Test
    public void getById() {
        assertMatch(service.get(FIRST_U_ID), FIRST_U);
    }

    @Test
    public void getBySampleName() {
        assertMatch(service.get(FIRST_U.getSampleName()), FIRST_U);
    }

    @Test(expected = NotFoundException.class)
    public void getBySampleNameNotFound() {
        assertMatch(service.get(""), FIRST_U);
    }


    @Test
    public void getByDate() {
        assertMatch(service.getByDate(LocalDate.parse("2015-05-30")), SECOND_U, THIRD_U);
    }

    @Test
    public void getBetween() {
        assertMatch(service.getBetween(LocalDate.parse("2015-03-30"), LocalDate.parse("2015-05-29")), FIRST_U);
    }

    @Test
    public void getAll() {
        assertMatch(service.getAll(), SECOND_U, THIRD_U, FIRST_U);
    }
}