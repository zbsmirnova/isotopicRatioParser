package zbsmirnova.isotopicRatioParser.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = IsotopicPb.ALL_SORTED, query = "SELECT p FROM IsotopicPb p ORDER BY p.date DESC"),
        @NamedQuery(name = IsotopicPb.DELETE_BY_ID, query = "DELETE FROM IsotopicPb p WHERE p.id=:id"),
        @NamedQuery(name = IsotopicPb.DELETE_BY_SAMPLE_NAME, query = "DELETE FROM IsotopicPb p WHERE p.sampleName=:sampleName"),
        @NamedQuery(name = IsotopicPb.GET_BETWEEN, query = "SELECT p FROM IsotopicPb p " +
                "WHERE p.date BETWEEN :startDate AND :endDate ORDER BY p.date DESC"),
        @NamedQuery(name = IsotopicPb.GET_BY_SAMPLE_NAME, query = "SELECT p FROM IsotopicPb p WHERE p.sampleName=:sampleName"),
        @NamedQuery(name = IsotopicPb.GET_BY_DATE, query = "SELECT p FROM IsotopicPb p WHERE p.date=:date")
})

@Entity
@Table(name = "isotopic_pb_samples", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"sampleName"}, name = "is_pb_unique_idx")})

public class IsotopicPb extends ConcentrationPb {
    public static final String ALL_SORTED = "IsotopicPb.getAll";
    public static final String GET_BY_SAMPLE_NAME = "IsotopicPb.getBySampleName";
    public static final String GET_BY_DATE = "IsotopicPb.getByDate";
    public static final String DELETE_BY_ID = "IsotopicPb.deleteById";
    public static final String DELETE_BY_SAMPLE_NAME = "IsotopicPb.deleteBySampleName";
    public static final String GET_BETWEEN = "IsotopicPb.getBetween";

    @Column(name = "ratio206204", nullable = false)
    @NotNull
    private double ratio206204;
    @Column(name = "err206204", nullable = false)
    @NotNull
    private double err206204;

    public IsotopicPb(){}

    public IsotopicPb(String sampleName, LocalDate date) {
        super(sampleName, date);
    }

    public IsotopicPb(int id, String sampleName, LocalDate date){
        super(id, sampleName, date);
    }

    public IsotopicPb(String sampleName, LocalDate date, double ratio206204, double err206204, double ratio206207,
              double err206207, double ratio206208, double err206208){
        super(sampleName, date, ratio206207, err206207, ratio206208, err206208);
        this.ratio206204 = ratio206204;
        this.err206204 = err206204;
    }

    public IsotopicPb(int id, String sampleName, LocalDate date, double ratio206204, double err206204, double ratio206207,
              double err206207, double ratio206208, double err206208){
        super(id, sampleName, date,ratio206207, err206207, ratio206208, err206208);
        this.ratio206204 = ratio206204;
        this.err206204 = err206204;
    }

    public IsotopicPb(IsotopicPb pb){
        this(pb.id, pb.sampleName, pb.date, pb.ratio206204, pb.err206204, pb.getPb206207(), pb.getPb206207err(),
                pb.getPb206208(), pb.getPb206208err());
    }
    public void setRatio206204(double ratio206204) {
        this.ratio206204 = ratio206204;
    }

    public void setErr206204(double err206204) {
        this.err206204 = err206204;
    }

    public double getPb206204() {
        return ratio206204;
    }

    public double getPb206204err() {
        return err206204;
    }

    @Override
    public String toString() {
        return "Pb Isotopic, sample  " + sampleName +
                " measurement date " + date +
                ", isotopic ratios: 206/204 " + ratio206204 + ", stdErr " + err206204 +
                "; 206/207 " + this.getPb206207() + ", stdErr " + this.getPb206207err() +
                "; 206/208 " + this.getPb206208() + ", stdErr " + this.getPb206208err();
    }
}
