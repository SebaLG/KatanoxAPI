package com.katanox.assessment.metavendors;


import com.katanox.assessment.hotel.Hotels;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

//In the assessment is called Integration, but "MetaVendorsHotels" give more information in the class name and is more correct in terms of Clean Code

@Data
@Entity
public class MetaVendorsHotels {

    @EmbeddedId
    private MetaVendorsHotelsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey=@ForeignKey(name="integrations_meta_vendors_id_foreign"))
    @MapsId("meta_vendors_id")
    private MetaVendors metaVendor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey=@ForeignKey(name="integrations_hotel_id_foreign"))
    @MapsId("hotel_id")
    private Hotels hotel;

    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;


}
