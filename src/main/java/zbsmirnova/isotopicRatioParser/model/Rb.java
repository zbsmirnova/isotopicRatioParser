package zbsmirnova.isotopicRatioParser.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "RbSamples", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"sampleName"}, name = "rb_unique_idx")})
public class Rb extends Element {
    @Column(name = "ratio8587", nullable = false)
    @NotNull
    private double ratio8587;
    @Column(name = "err8587", nullable = false)
    @NotNull
    private double err8587;

    public Rb(String sampleName, LocalDate date){
      super(sampleName, date);
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
