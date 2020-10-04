package com.katanox.assessment;

import com.katanox.assessment.room.Rooms;
import com.katanox.assessment.room.RoomsRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableJpaRepositories(basePackageClasses = RoomsRepository.class)
public class RoomsRepositoryTest {

  @Autowired RoomsRepository repository;

  @Test
  public void givenVendorRoomAndVendorHotel_thenNotEmpty() throws Exception {
    Rooms room = repository.findByVendorHotelIdAndVendorRoomId("KQIU|BER", "KQIU|BER-SGL");
    Assertions.assertNotNull(room);
  }

  @Test
  public void givenVendorRoomAndVendorHotel_thenEmpty() throws Exception {
    Rooms room = repository.findByVendorHotelIdAndVendorRoomId("KQIU|BER", "KQIU|BER-SGLE");
    Assertions.assertNull(room);
  }
}
