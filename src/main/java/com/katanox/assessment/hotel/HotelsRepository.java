package com.katanox.assessment.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelsRepository extends JpaRepository<Hotels, Long> {

    public List<Hotels> findByVendorHotelId(String vendorHotelId);


}
