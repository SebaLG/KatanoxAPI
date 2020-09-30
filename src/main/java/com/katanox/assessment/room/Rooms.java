package com.katanox.assessment.room;


import com.katanox.assessment.hotel.Hotels;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    @Column(name = "max_adults", columnDefinition = "integer default 2")
    private Integer maxAdults;

    @NotNull
    @Column(name = "max_children", columnDefinition = "integer default 0")
    private Integer maxChildren;

    @NotNull
    @Column(name = "max_occupancy", columnDefinition = "integer default 2")
    private Integer maxOccupancy;

    @NotNull
    @Column(name = "vendor_room_id")
    private String vendorRoomId;

    @NotNull
    @ManyToOne
    private Hotels hotel;

}
