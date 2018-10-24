package zbsmirnova.isotopicRatioParser.repository;


import zbsmirnova.isotopicRatioParser.model.AbstractPb;
import zbsmirnova.isotopicRatioParser.model.IsotopicPb;

import java.time.LocalDate;
import java.util.List;

public interface PbRepository {

    AbstractPb save(IsotopicPb pb);

    boolean delete(int id);

    boolean delete(String sampleName);

    AbstractPb get(int id);

    AbstractPb get(String sampleName);

    List<? extends AbstractPb> getByDate(LocalDate date);

    // ORDERED dateTime desc
    List<? extends AbstractPb> getBetween(LocalDate startDate, LocalDate endDate);

    List<? extends AbstractPb> getAll();

}
