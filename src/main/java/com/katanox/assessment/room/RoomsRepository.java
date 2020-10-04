package com.katanox.assessment.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {

  public List<Rooms> findByVendorRoomId(String vendorRoomId);

  @Query(
      "SELECT DISTINCT r FROM Rooms r INNER JOIN r.hotel h WHERE r.vendorRoomId=:vendorRoomId AND h.vendorHotelId=:vendorHotelId")
  public Rooms findByVendorHotelIdAndVendorRoomId(
      @Param("vendorHotelId") String vendorHotelId, @Param("vendorRoomId") String vendorRoomId);
}
