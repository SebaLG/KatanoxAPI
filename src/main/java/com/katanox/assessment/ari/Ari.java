package com.katanox.assessment.ari;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Ari {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String ratePlanId;

    @NotNull
    private String hotelId;

    @NotNull
    private String roomId;


    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date from;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date to;

    @NotNull
    private BigDecimal price;

    @NotNull
    private String currency;

    @NotNull
    private Integer numberOfRoomsAvailable;

    private Integer minLengthOfStay;

    private Integer maxLengthOfStay;

    public static class AriBuilder {
    }



}
