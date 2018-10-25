package zbsmirnova.isotopicRatioParser.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedQueries({
        @NamedQuery(name = Rb.ALL_SORTED, query = "SELECT r FROM Rb r ORDER BY r.date DESC"),
        @NamedQuery(name = Rb.DELETE_BY_ID, query = "DELETE FROM Rb r WHERE r.id=:id"),
        @NamedQuery(name = Rb.DELETE_BY_SAMPLE_NAME, query = "DELETE FROM Rb r WHERE r.sampleName=:sampleName"),
        @NamedQuery(name = Rb.GET_BETWEEN, query = "SELECT r FROM Rb r " +
                "WHERE r.date BETWEEN :startDate AND :endDate ORDER BY r.date DESC"),
        @NamedQuery(name = Rb.GET_BY_SAMPLE_NAME, query = "SELECT r FROM Rb r WHERE r.sampleName=:sampleName"),
        @NamedQuery(name = Rb.GET_BY_DATE, query = "SELECT r FROM Rb r WHERE r.date=:date"),
})

@Entity
@Table(name = "RbSamples", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"sampleName"}, name = "rb_unique_idx")})
public class Rb extends Element {
    public static final String ALL_SORTED = "Rb.getAll";
    public static final String GET_BY_SAMPLE_NAME = "Rb.getBySampleName";
    public static final String GET_BY_DATE = "Rb.getByDate";
    public static final String DELETE_BY_ID = "Rb.deleteById";
    public static final String DELETE_BY_SAMPLE_NAME = "Rb.deleteBySampleName";
    public static final String GET_BETWEEN = "Rb.getBetween";


    @Column(name = "ratio8587", nullable = false)
    @NotNull
    private double ratio8587;
    @Column(name = "err8587", nullable = false)
    @NotNull
    private double err8587;

    public Rb(String sampleName, LocalDate date){
      super(sampleName, date);
    }

    public Rb(int id, String sampleName, LocalDate date){ super(id, sampleName, date);}

    public Rb(String sampleName, LocalDate date, double ratio8587, double err8587){
        super(sampleName, date);
        this.ratio8587 = ratio8587;
        this.err8587 = err8587;
    }

    public Rb(int id, String sampleName, LocalDate date, double ratio8587, double err8587){
        super(id, sampleName, date);
        this.ratio8587 = ratio8587;
        this.err8587 = err8587;
    }

    public Rb(Rb rb){
        this(rb.id, rb.sampleName, rb.date, rb.ratio8587, rb.err8587);
    }

    public double getRb8587() {
        return ratio8587;
    }

    public double getRb8587err() {
        return err8587;
    }

    @Override
    public String toString() {
        return "Rb, sample  " + sampleName +
                " measurement date " + date +
                ", isotopic ratios: 85/87 " + ratio8587 + " stdErr " + err8587;
    }
}
