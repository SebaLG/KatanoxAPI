package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AriServiceImpl implements AriService {

    @Autowired
    private AriRepository ariRepository;


    @Override
    public List<Ari> createPms0Ari(AriPms0DTO ariPms0DTO) {
        List<Ari> arisToPersist = new ArrayList<>();
        String hotelID = ariPms0DTO.getHotelId();
        // Map AriPms0DTO to Ari
        ariPms0DTO.getRates().stream().forEach(rate -> arisToPersist.add(createAriFromAriPms0DTO(hotelID, rate)));
        // Persist Ari List
        return saveAris(arisToPersist);
    }


    private Ari createAriFromAriPms0DTO(String hotelId, AriPms0DTO.RatePms0DTO rate) {
        return Ari.builder()
                .ratePlanId(rate.getRatePlanId())
                .hotelId(hotelId)
                .roomId(rate.getRoomId())
                .from(rate.getFrom())
                .to(rate.getTo())
                .price(rate.getPrice().getGrossAmount())
                .currency(rate.getPrice().getCurrency())
                .minLengthOfStay(rate.getRestrictions().getMinLengthOfStay())
                .maxLengthOfStay(rate.getRestrictions().getMaxLengthOfStay())
                .build();
    }

    private List<Ari> saveAris(List<Ari> aris) {
        List<Ari> arisPersisted = new ArrayList<>();
        //Persist the ari and store the repository result in the arisPersisted List
        aris.stream().forEach(ariToPersist -> arisPersisted.add(ariRepository.save(ariToPersist)));
        return arisPersisted;
    }
}
