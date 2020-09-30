package com.katanox.assessment.hotel;


import com.katanox.assessment.metavendors.MetaVendorsHotels;
import com.katanox.assessment.room.Rooms;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Set;

@Data
@Entity
public class Hotels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "address_line_1")
    private String addressLine1;

    @NotNull
    @Column(name = "address_line_2")
    private String addressLine2;

    @NotNull
    private String postcode;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @NotNull
    private String currency;

    @NotNull
    @Column(name = "vendor_hotel_id")
    private String vendorHotelId;

    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY
    )
    private Set<Rooms> rooms;

    @OneToMany(
            mappedBy = "hotel",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<MetaVendorsHotels> metaVendorsHotels;

}
