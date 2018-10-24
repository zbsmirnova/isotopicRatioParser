package zbsmirnova.isotopicRatioParser.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import zbsmirnova.isotopicRatioParser.PbTestData;
import zbsmirnova.isotopicRatioParser.model.Pb;

import java.util.List;

import static zbsmirnova.isotopicRatioParser.PbTestData.*;

public class PbServiceImplTest extends AbstractServiceTest {
    @Autowired
    PbService service;

    @Test
    public void save() {
        Pb newPb = PbTestData.getNewPb();
        service.save(newPb);

    }

    @Test
    public void deleteBySampleName() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void getBySampleName() {
    }

    @Test
    public void getBetween() {
    }

    @Test
    public void getAll() {
        List<Pb> pbSamples = service.getAll();
        System.out.println(pbSamples.get(0).equals(firstPb));
        assertMatch(pbSamples, firstPb, secondPb, thirdPb);
    }
}