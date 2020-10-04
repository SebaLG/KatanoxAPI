package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import com.katanox.assessment.ari.dto.AriPms1DTO;
import com.katanox.assessment.exceptions.RoomNotFoundException;
import com.katanox.assessment.room.Rooms;
import com.katanox.assessment.room.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AriServiceImpl implements AriService {

  @Autowired private AriRepository ariRepository;
  @Autowired private RoomsRepository roomsRepository;

  @Override
  public List<Ari> createPms0Ari(AriPms0DTO ariPms0DTO) {
    List<Ari> arisToPersist = new ArrayList<>();
    String hotelID = ariPms0DTO.getHotelId();

    for (AriPms0DTO.RatePms0DTO rate : ariPms0DTO.getRates()) {
      // Map AriPms0DTO to Ari
      arisToPersist.add(createAriFromAriPms0DTO(hotelID, rate));
    }

    // Persist Ari List
    return saveAris(arisToPersist);
  }

  @Override
  public List<Ari> createPms1Ari(AriPms1DTO ariPms1DTO) {
    List<Ari> arisToPersist = new ArrayList<>();
    String hotelID = ariPms1DTO.getHotelId();
    // Map AriPms1DTO to Ari
    ariPms1DTO.getRates().stream()
        .forEach(rate -> arisToPersist.add(createAriFromAriPms1DTO(hotelID, rate)));
    // Persist Ari List
    return saveAris(arisToPersist);
  }

  /** * PRIVATE METHODS ** */
  private Ari createAriFromAriPms0DTO(String hotelId, AriPms0DTO.RatePms0DTO rate) {
    Rooms room = roomsRepository.findByVendorHotelIdAndVendorRoomId(hotelId, rate.getRoomId());
    if (room == null) throw new RoomNotFoundException();

    // Using the Builder Pattern provided by Lombok with the annotation @Builder
    return Ari.builder()
        .room(room)
        .ratePlanId(rate.getRatePlanId())
        .from(rate.getFrom())
        .to(rate.getTo())
        .numberOfRoomsAvailable(rate.getAvailable())
        .price(rate.getPrice().getGrossAmount())
        .currency(rate.getPrice().getCurrency())
        .minLengthOfStay(rate.getRestrictions().getMinLengthOfStay())
        .maxLengthOfStay(rate.getRestrictions().getMaxLengthOfStay())
        .build();
  }

  private Ari createAriFromAriPms1DTO(String hotelId, AriPms1DTO.RatePms1DTO rate) {
    Rooms room = roomsRepository.findByVendorHotelIdAndVendorRoomId(hotelId, rate.getRoomId());
    if (room == null) throw new RoomNotFoundException();

    // Using the Builder Pattern provided by Lombok with the annotation @Builder
    return Ari.builder()
        .room(room)
        .from(rate.getFrom())
        .to(rate.getTo())
        .price(rate.getPrice())
        .currency(rate.getCurrency())
        .minLengthOfStay(rate.getMinLengthOfStay())
        .numberOfRoomsAvailable(rate.getNumberOfRoomsAvailable())
        .build();
  }

  private List<Ari> saveAris(List<Ari> aris) {
    List<Ari> arisPersisted = new ArrayList<>();
    // Persist the ari and store the repository result in the arisPersisted List
    aris.stream().forEach(ariToPersist -> arisPersisted.add(ariRepository.save(ariToPersist)));
    return arisPersisted;
  }
}
