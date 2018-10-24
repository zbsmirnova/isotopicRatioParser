package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.AbstractPb;
import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;

import java.time.LocalDate;
import java.util.List;

public interface PbService {
    AbstractPb save(AbstractPb pb);

    boolean delete(int id);

    boolean delete(String sampleName);

    AbstractPb get(int id);

    AbstractPb get(String sampleName);

    // ORDERED dateTime desc
    List<AbstractPb> getBetween(LocalDate startDate, LocalDate endDate);

    List<AbstractPb> getAll();
}
