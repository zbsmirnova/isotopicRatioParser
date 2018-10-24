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
    private final double ratio8587;
    @Column(name = "err8587", nullable = false)
    @NotNull
    private final double err8587;

    public Rb(Builder builder){
      super(builder);
      this.ratio8587 = builder.ratio8587;
      this.err8587 = builder.err8587;
    }

    public static class Builder extends Element.Builder{
        private double ratio8587;
        private double err8587;

        public Builder(String sampleName, LocalDate date){
            super(sampleName, date);
        }

        public void setRb8587(double rb8587) {
            this.ratio8587 = rb8587;
        }

        public void setRb8587err(double rb8587err) {
            this.err8587 = rb8587err;
        }

        @Override
        public Rb build(){
            return new Rb(this);
        }
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
