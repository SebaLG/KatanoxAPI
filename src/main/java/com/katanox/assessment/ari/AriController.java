package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import com.katanox.assessment.ari.dto.AriPms1DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/")
public class AriController {

  @Autowired private AriService ariService;

  @PutMapping(
      path = "pms0/ari",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AriPms0DTO> createAriPms0(@RequestBody AriPms0DTO ariPms0DTO) {
    List<Ari> aris = ariService.createPms0Ari(ariPms0DTO);
    if (!aris.isEmpty()) {
      return ResponseEntity.ok(ariPms0DTO);
    } else {
      return (ResponseEntity<AriPms0DTO>) ResponseEntity.badRequest();
    }
  }

  @PutMapping(
      path = "pms1/ari",
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<AriPms1DTO> createAriPms1(@RequestBody AriPms1DTO ariPms1DTO) {
      List<Ari> aris = ariService.createPms1Ari(ariPms1DTO);
      if (!aris.isEmpty()) {
          return ResponseEntity.ok(ariPms1DTO);
      } else {
          return (ResponseEntity<AriPms1DTO>) ResponseEntity.badRequest();
      }
  }
}
