package com.katanox.assessment.ari.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Data
public class AriPms0DTO {


    @NotNull
    private String hotelId;


    @NotNull
    private ArrayList<RatePms0DTO> rates;

    //Static inner Rate class
    @Data
    public static class RatePms0DTO {

        @NotNull
        private String roomId;

        @NotNull
        private Date from;

        @NotNull
        private Date to;

        @NotNull
        private Integer available;

        private PricePms0DTO price;

        private RestrictionPms0DTO restrictions;

        //Static inner Price class
        @Data
        public static class RestrictionPms0DTO {
            private Integer minLengthOfStay;

            private Integer maxLengthOfStay;
        }

        //Static inner Price class
        @Data
        public static class PricePms0DTO {
            @NotNull
            private BigDecimal grossAmount;

            @NotNull
            private String currency;
        }


    }


}
