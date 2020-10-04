package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import com.katanox.assessment.ari.dto.AriPms1DTO;
import com.katanox.assessment.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/")
public class AriController {

  @Autowired private AriService ariService;

  @PutMapping(
      path = "pms0/ari",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> createAriPms0(@Valid @RequestBody AriPms0DTO ariPms0DTO) {
   List<Ari> aris = ariService.createPms0Ari(ariPms0DTO);
    //TODO Response with the DTO
    return ResponseEntity.ok(ResponseUtil.createJSONResponse(AriConstants.ARI_SUCCESSFULLY_CREATED_MSG));
  }

  @PutMapping(
      path = "pms1/ari",
      consumes = MediaType.APPLICATION_XML_VALUE,
      produces = MediaType.APPLICATION_XML_VALUE)
  public ResponseEntity<String> createAriPms1(@Valid @RequestBody AriPms1DTO ariPms1DTO) {
    List<Ari> aris = ariService.createPms1Ari(ariPms1DTO);
    //TODO Response with the DTO
    return ResponseEntity.ok(ResponseUtil.createXMLResponse(AriConstants.ARI_SUCCESSFULLY_CREATED_MSG));
  }




}
