package zbsmirnova.isotopicRatioParser.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;
import zbsmirnova.isotopicRatioParser.model.IsotopicPb;

import java.time.LocalDate;


import static zbsmirnova.isotopicRatioParser.testData.PbTestData.*;

public class PbServiceImplTest extends AbstractServiceTest {
    @Autowired
    PbService service;

    @Test
    public void save() {
        IsotopicPb newIsPb = getNewIsPb();
        service.save(newIsPb);
        assertMatch(service.getAllIsotopic(), newIsPb, thirdIsPb, secondIsPb, firstIsPb);
        ConcentrationPb newConPb = getNewConPb();
        service.save(newConPb);
        assertMatchCon(service.getAllConcentration(), newConPb,secondConPb, thirdConPb, firstConPb);
    }

    @Test
    public void deleteBySampleName() {
        service.delete(firstIsPb.getSampleName());
        assertMatch(service.getAllIsotopic(), thirdIsPb, secondIsPb);
        assertMatchCon(service.getAllConcentration(), secondConPb, thirdConPb);
    }

//    @Test(expected = )
//    public void deleteBySampleNameNotFound() {
//        service.delete(" ");
//    }

    @Test
    public void deleteById() {
        service.delete(firstIsPb_ID);
        assertMatch(service.getAllIsotopic(), thirdIsPb, secondIsPb);
        assertMatchCon(service.getAllConcentration(), secondConPb, thirdConPb, firstConPb);
    }

    @Test
    public void getIsotopicById() {
        assertMatch(service.getIsotopic(firstIsPb_ID), firstIsPb);
    }

    @Test
    public void getIsotopicBySampleName() {
        assertMatch(service.getIsotopic(firstIsPb.getSampleName()), firstIsPb);
    }

    @Test
    public void getConcentrationById() {
        assertMatch(service.getConcentration(firstConPb_ID), firstConPb);
    }

    @Test
    public void getConcentrationBySampleName() {
        assertMatch(service.getConcentration(firstConPb.getSampleName()), firstConPb);
    }

    @Test
    public void getBetweenIsotopic() {
        assertMatch(service.getBetweenIsotopic(LocalDate.parse("2015-04-29"), LocalDate.parse("2015-05-30")), secondIsPb, firstIsPb);
    }

    @Test
    public void getBetweenConcentration() {
        assertMatchCon(service.getBetweenConcentration(LocalDate.parse("2015-04-30"), LocalDate.parse("2015-05-30")), secondConPb, thirdConPb);
    }

    @Test
    public void getByDateIsotopic(){
        assertMatch(service.getByDateIsotopic(LocalDate.parse("2015-05-30")), secondIsPb);
    }

    @Test
    public void getByDateConcentration(){
        assertMatchCon(service.getByDateConcentration(LocalDate.parse("2015-04-30")), secondConPb, thirdConPb);
    }

    @Test
    public void getAllIsotopic(){
        assertMatch(service.getAllIsotopic(), thirdIsPb, secondIsPb, firstIsPb);

    }

    @Test
    public void getAllConcentration(){
        assertMatchCon(service.getAllConcentration(),  secondConPb, thirdConPb, firstConPb);
    }
}