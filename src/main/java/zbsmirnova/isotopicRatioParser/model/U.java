package zbsmirnova.isotopicRatioParser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "USamples", uniqueConstraints =
        {@UniqueConstraint(columnNames = {"sampleName"}, name = "u_unique_idx")})
public class U extends Element {
    @Column(name = "ratio238235", nullable = false)
    @NotNull
    private final double ratio238235;
    @Column(name = "err238235", nullable = false)
    @NotNull
    private final double err238235;

    public U(Builder builder){
        super(builder);
        this.ratio238235 = builder.ratio238235;
        this.err238235 = builder.err238235;
    }

    public static class Builder extends Element.Builder{
        private double ratio238235;
        private double err238235;

        public Builder(String sampleName, LocalDate date){
            super(sampleName, date);
        }

        public void setU238235(double u238235) {
            this.ratio238235 = u238235;
        }

        public void setU238235err(double u238235err) {
            this.err238235 = u238235err;
        }

        @Override
        public U build(){
            return new U(this);
        }
    }

    public double getU238235() {
        return ratio238235;
    }

    public double getU238235err() {
        return err238235;
    }

    @Override
    public String toString() {
        return "U, sample  " + sampleName +
                " measurement date " + date +
                ", isotopic ratios: 238/235 " + ratio238235 + " stdErr " + err238235;
    }
}
