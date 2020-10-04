package com.katanox.assessment.ari.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Data
@JacksonXmlRootElement(localName = "hotel")
public class AriPms1DTO {

  @NotNull
  @JacksonXmlProperty(localName = "id")
  private String hotelId;

  @Valid @NotNull private ArrayList<RatePms1DTO> rates;

  // Static inner Rate class
  @Data
  @JacksonXmlRootElement(localName = "rate")
  public static class RatePms1DTO {

    @NotNull private String roomId;

    @NotNull private Date from;

    @NotNull private Date to;

    @NotNull @Positive private Integer numberOfRoomsAvailable;

    @NotNull @Positive private BigDecimal price;

    @NotNull private String currency;

    private @Positive Integer minLengthOfStay;
  }
}
