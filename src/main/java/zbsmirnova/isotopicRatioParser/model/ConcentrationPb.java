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
public class ConcentrationPb extends Element{
    public static final String ALL_SORTED = "ConcentrationPb.getAll";
    public static final String GET_BY_SAMPLE_NAME = "ConcentrationPb.getBySampleName";
    public static final String DELETE_BY_ID = "ConcentrationPb.deleteById";
    public static final String DELETE_BY_SAMPLE_NAME = "ConcentrationPb.deleteBySampleName";
    public static final String GET_BETWEEN = "ConcentrationPb.getBetween";

    @Column(name = "ratio206207", nullable = false)
    @NotNull
    private double ratio206207;
    @Column(name = "err206207", nullable = false)
    @NotNull
    private double err206207;
    @Column(name = "ratio206208", nullable = false)
    @NotNull
    private double ratio206208;
    @Column(name = "err206208", nullable = false)
    @NotNull
    private double err206208;

    public ConcentrationPb(){}

    public ConcentrationPb(String sampleName, LocalDate date) {
        super(sampleName, date);
    }

    public ConcentrationPb(int id, String sampleName, LocalDate date){
        super(id, sampleName, date);
    }

    public ConcentrationPb(String sampleName, LocalDate date, double ratio206207,
                      double err206207, double ratio206208, double err206208){
        super(sampleName, date);
        this.ratio206207 = ratio206207;
        this.err206207 = err206207;
        this.ratio206208 = ratio206208;
        this.err206208 = err206208;
    }

    public ConcentrationPb(int id, String sampleName, LocalDate date, double ratio206207,
                      double err206207, double ratio206208, double err206208){
        this(sampleName, date, ratio206207, err206207, ratio206208, err206208);
        this.id = id;
    }

    public ConcentrationPb(ConcentrationPb pb){
        this(pb.id, pb.sampleName, pb.date, pb.ratio206207, pb.err206207,
                pb.ratio206208, pb.err206208);
    }

    public void setRatio206207(double ratio206207) {
        this.ratio206207 = ratio206207;
    }

    public void setErr206207(double err206207) {
        this.err206207 = err206207;
    }

    public void setRatio206208(double ratio206208) {
        this.ratio206208 = ratio206208;
    }

    public void setErr206208(double err206208) {
        this.err206208 = err206208;
    }

    public double getPb206207() {
        return ratio206207;
    }

    public double getPb206207err() {
        return err206207;
    }

    public double getPb206208() {
        return ratio206208;
    }

    public double getPb206208err() {
        return err206208;
    }

    @Override
    public String toString() {
        return "Pb Concentration, sample  " + sampleName +
                " measurement date " + date +
                ", isotopic ratios: 206/207 " + ratio206207 + ", stdErr " + err206207 +
                "; 206/208 " + ratio206208 + ", stdErr " + err206208;
    }
}
