package zbsmirnova.isotopicRatioParser.service;

import org.assertj.core.condition.Not;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zbsmirnova.isotopicRatioParser.model.Rb;
import zbsmirnova.isotopicRatioParser.util.exception.NotFoundException;


import java.time.LocalDate;

import static zbsmirnova.isotopicRatioParser.testData.RbTestData.assertMatch;
import static zbsmirnova.isotopicRatioParser.testData.RbTestData.*;


public class RbServiceTest extends AbstractServiceTest{

    @Autowired
    RbService service;

    @Test
    public void save() {
        Rb newRb = getNewRb();
        service.save(newRb);
        assertMatch(service.getAll(), newRb, SECOND_Rb, THIRD_Rb, FIRST_Rb);
    }

    @Test
    public void deleteById() {
        service.delete(FIRST_Rb_ID);
        assertMatch(service.getAll(), SECOND_Rb, THIRD_Rb);
    }

    @Test(expected = NotFoundException.class)
    public void deleteByIdNotFound() {
        service.delete(0);
    }

    @Test
    public void deleteBySampleName() {
        service.delete(FIRST_Rb.getSampleName());
        assertMatch(service.getAll(), SECOND_Rb, THIRD_Rb);
    }

    @Test(expected = NotFoundException.class)
    public void deleteBySampleNameNotFound() {
        service.delete("");
    }

    @Test(expected = NotFoundException.class)
    public void getByIdNotFound() {
        assertMatch(service.get(0), FIRST_Rb);
    }

    @Test
    public void getById() {
        assertMatch(service.get(FIRST_Rb_ID), FIRST_Rb);
    }

    @Test(expected = NotFoundException.class)
    public void getBySampleNameNotFound() {
        assertMatch(service.get(" "), FIRST_Rb);
    }

    @Test
    public void getBySampleName() {
        assertMatch(service.get(FIRST_Rb.getSampleName()), FIRST_Rb);
    }

    @Test
    public void getByDate() {
        assertMatch(service.getByDate(LocalDate.parse("2015-04-30")), SECOND_Rb, THIRD_Rb);
    }

    @Test
    public void getBetween() {
        assertMatch(service.getBetween(LocalDate.parse("2015-03-30"), LocalDate.parse("2015-04-29")), FIRST_Rb);
    }

    @Test
    public void getAll() {
        assertMatch(service.getAll(), SECOND_Rb, THIRD_Rb, FIRST_Rb);
    }
}