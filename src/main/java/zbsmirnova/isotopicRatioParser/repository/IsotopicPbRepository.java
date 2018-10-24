package zbsmirnova.isotopicRatioParser.repository;


import zbsmirnova.isotopicRatioParser.model.AbstractPb;
import zbsmirnova.isotopicRatioParser.model.ConcentrationPb;
import zbsmirnova.isotopicRatioParser.model.IsotopicPb;

import java.time.LocalDate;
import java.util.List;

public interface IsotopicPbRepository {

    IsotopicPb save(IsotopicPb pb);

    boolean delete(int id);

    boolean delete(String sampleName);

    IsotopicPb get(int id);

    IsotopicPb get(String sampleName);

    List<IsotopicPb> getByDate(LocalDate date);

    // ORDERED dateTime desc
    List<IsotopicPb> getBetween(LocalDate startDate, LocalDate endDate);

    List<IsotopicPb> getAll();

}
