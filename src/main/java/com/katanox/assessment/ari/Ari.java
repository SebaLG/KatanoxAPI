package com.katanox.assessment.ari;

import com.katanox.assessment.room.Rooms;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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

  // 'From' is a reserved word in Postgre, so we need to define a different name
  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "available_from")
  private Date from;

  @NotNull
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "available_to")
  private Date to;

  @Positive @NotNull private BigDecimal price;

  @NotNull private String currency;

  @Positive
  @Column(name = "number_of_rooms_available")
  private Integer numberOfRoomsAvailable;

  @Positive
  @Column(name = "min_length_of_stay")
  private Integer minLengthOfStay;

  @Positive
  @Column(name = "max_length_of_stay")
  private Integer maxLengthOfStay;

  @NotNull
  @ManyToOne
  @JoinColumn(foreignKey = @ForeignKey(name = "ari_room_id_foreign"))
  private Rooms room;

  @NotNull
  @Column(name = "created_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdOn;

  @NotNull
  @Column(name = "updated_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @PrePersist
  protected void prePersist() {
    if (this.createdOn == null) createdOn = new Date();
    if (this.updatedAt == null) updatedAt = new Date();
  }

  @PreUpdate
  protected void preUpdate() {
    this.updatedAt = new Date();
  }
}
