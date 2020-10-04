package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import com.katanox.assessment.ari.dto.AriPms1DTO;

import java.util.List;

public interface AriService {

  public List<Ari> createPms0Ari(AriPms0DTO ariPms0DTO);

  public List<Ari> createPms1Ari(AriPms1DTO ariPms1DTO);
}
