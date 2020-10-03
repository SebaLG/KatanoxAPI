package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/")
public class AriController {

    @PostMapping(path = "pms0/ari", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AriPms0DTO> createAriPms0(@RequestBody AriPms0DTO ariPms0DTO) {
        return ResponseEntity.ok(ariPms0DTO);
    }

    @PostMapping("pms1/ari")
    public ResponseEntity<String> createAriPms1() {
        return ResponseEntity.ok("Hello World!");
    }

}
