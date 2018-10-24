package zbsmirnova.isotopicRatioParser.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = ConcentrationPb.ALL_SORTED, query = "SELECT p FROM ConcentrationPb p ORDER BY p.date DESC"),
        @NamedQuery(name = ConcentrationPb.DELETE_BY_ID, query = "DELETE FROM ConcentrationPb p WHERE p.id=:id"),
        @NamedQuery(name = ConcentrationPb.DELETE_BY_SAMPLE_NAME, query = "DELETE FROM ConcentrationPb p WHERE p.sampleName=:sampleName"),
        @NamedQuery(name = ConcentrationPb.GET_BETWEEN, query = "SELECT p FROM ConcentrationPb p " +
                "WHERE p.date BETWEEN :startDate AND :endDate ORDER BY p.date DESC"),
        @NamedQuery(name = ConcentrationPb.GET_BY_SAMPLE_NAME, query = "SELECT p FROM ConcentrationPb p WHERE p.sampleName=:sampleName")
})

@Entity
@Table(name = "concentration_pb_samples", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"sampleName"}, name = "con_pb_unique_idx")})
public class ConcentrationPb extends AbstractPb{
    public static final String ALL_SORTED = "ConcentrationPb.getAll";
    public static final String GET_BY_SAMPLE_NAME = "ConcentrationPb.getBySampleName";
    public static final String DELETE_BY_ID = "ConcentrationPb.deleteById";
    public static final String DELETE_BY_SAMPLE_NAME = "ConcentrationPb.deleteBySampleName";
    public static final String GET_BETWEEN = "ConcentrationPb.getBetween";

    public ConcentrationPb(){}

    public ConcentrationPb(String sampleName, LocalDate date) {
        super(sampleName, date);
    }

    public ConcentrationPb(int id, String sampleName, LocalDate date) {
        super(id, sampleName, date);
    }

    public ConcentrationPb(String sampleName, LocalDate date, double ratio206207, double err206207, double ratio206208, double err206208) {
        super(sampleName, date, ratio206207, err206207, ratio206208, err206208);
    }

    public ConcentrationPb(int id, String sampleName, LocalDate date, double ratio206207, double err206207, double ratio206208, double err206208) {
        super(id, sampleName, date, ratio206207, err206207, ratio206208, err206208);
    }

    public ConcentrationPb(AbstractPb pb) {
        super(pb);
    }


    @Override
    public String toString() {
        return "Pb Concentration, sample  " + sampleName +
                " measurement date " + date +
                ", isotopic ratios: 206/207 " + this.getPb206207() + ", stdErr " + this.getPb206207err() +
                "; 206/208 " + this.getPb206208() + ", stdErr " + this.getPb206208err();
    }
}
