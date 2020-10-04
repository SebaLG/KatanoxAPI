package com.katanox.assessment.ari.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Data
public class AriPms0DTO {

  @NotNull private String hotelId;

  @Valid @NotNull private ArrayList<RatePms0DTO> rates;

  // Static inner Rate class
  @Data
  public static class RatePms0DTO {

    @NotNull private String ratePlanId;

    @NotNull private String roomId;

    @NotNull private Date from;

    @NotNull private Date to;

    @NotNull @Positive private Integer available;

    @Valid private PricePms0DTO price;

    @Valid private RestrictionPms0DTO restrictions;

    // Static inner Price class
    @Data
    public static class RestrictionPms0DTO {
      private @Positive Integer minLengthOfStay;

      private @Positive Integer maxLengthOfStay;
    }

    // Static inner Price class
    @Data
    public static class PricePms0DTO {
      @NotNull @Positive private BigDecimal grossAmount;

      @NotNull private String currency;
    }
  }
}
