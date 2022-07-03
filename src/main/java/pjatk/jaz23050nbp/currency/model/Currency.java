package pjatk.jaz23050nbp.currency.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@ApiModel("Currency Model")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Unique ID of checked currency")
    private Integer id;
    @ApiModelProperty("Short code of avg")
    private Double avg;
    @ApiModelProperty("Numbers of avg exchanges")
    private Double num;
    @ApiModelProperty("Date from which we will check avg")
    private String datefrom;
    @ApiModelProperty("Date to which we will check avg")
    private String dateto;
    @ApiModelProperty("Date and time when avg was checked")
    private Date date;

    public Currency(Integer id, Double avg, String datefrom, String dateto, Double num, Date date) {
        this.id = id;
        this.avg = avg;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.num = num;
        this.date = date;
    }

    public Currency(Double avg, String datefrom, String dateto, Double num, Date date) {
        this.avg = avg;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.num = num;
        this.date = date;
    }

    public Currency() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAvg() {
        return avg;
    }

    public void setAvg(Double name) {
        this.avg = avg;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getDateto() {
        return dateto;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
