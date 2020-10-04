package com.katanox.assessment.ari;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Entity
public class Ari {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "rate_plan_id")
  private String ratePlanId;

  @NotNull private String hotelId;

  @NotNull private String roomId;

  // 'From' is a reserved word in Postgre, so we need to define a different name
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "available_from")
  private Date from;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "available_to")
  private Date to;

  @NotNull private BigDecimal price;

  @NotNull private String currency;

  @Column(name = "number_of_rooms_available")
  private Integer numberOfRoomsAvailable;

  @Column(name = "min_length_of_stay")
  private Integer minLengthOfStay;

  @Column(name = "max_length_of_stay")
  private Integer maxLengthOfStay;
}
