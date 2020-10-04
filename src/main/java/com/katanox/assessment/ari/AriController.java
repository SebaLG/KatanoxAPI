package com.katanox.assessment.ari;

import com.katanox.assessment.ari.dto.AriPms0DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/")
public class AriController {

    @Autowired
    private AriService ariService;

    @PostMapping(path = "pms0/ari", consumes = "application/json", produces = "application/json")
    public ResponseEntity<AriPms0DTO> createAriPms0(@RequestBody AriPms0DTO ariPms0DTO) {
        List<Ari> aris = ariService.createPms0Ari(ariPms0DTO);
        if (!aris.isEmpty()) {
            return ResponseEntity.ok(ariPms0DTO);
        } else {
            return (ResponseEntity<AriPms0DTO>) ResponseEntity.badRequest();
        }

    }

    @PostMapping("pms1/ari")
    public ResponseEntity<String> createAriPms1() {
        return ResponseEntity.ok("Hello World!");
    }

}
