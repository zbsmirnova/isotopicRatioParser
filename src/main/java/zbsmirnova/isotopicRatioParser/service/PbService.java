package zbsmirnova.isotopicRatioParser.service;

import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;

import java.time.LocalDate;
import java.util.List;

public interface PbService {
    ConcentrationPb save(ConcentrationPb pb);

    boolean delete(int id);

    boolean delete(String sampleName);

    ConcentrationPb get(int id);

    ConcentrationPb get(String sampleName);

    // ORDERED dateTime desc
    List<ConcentrationPb> getBetween(LocalDate startDate, LocalDate endDate);

    List<ConcentrationPb> getAll();
}
