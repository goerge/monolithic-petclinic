package org.springframework.samples.petclinic.vets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/vets")
public class VetController {

    VetService service;

    public VetController(VetService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<VetDto> findAll() {
        return service.allVets();
    }
}
