package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AriServiceImpl implements AriService{

    @Autowired
    private AriRepository  ariRepository;


    @Override
    public Ari createPms0Ari(AriPms0DTO ariPms0DTO) {
        Ari ari = new Ari();
        //map to
        //ari = ariRepository.save(ari);
        return ari;
    }
}
