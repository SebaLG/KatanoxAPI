package com.katanox.assessment.metavendors;


import com.katanox.assessment.room.Rooms;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
public class MetaVendors {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private MetaVendorType type;

    @OneToMany(
            mappedBy = "metaVendor",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private Set<MetaVendorsHotels> metaVendorsHotels;


}
