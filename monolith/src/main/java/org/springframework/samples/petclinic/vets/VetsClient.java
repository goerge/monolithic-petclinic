package org.springframework.samples.petclinic.vets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class VetsClient implements IVetService {
    private final String url;

    public VetsClient(@Value("${vet.url}") String url) {
        this.url = url;
    }

    public List<VetDto> allVets() {
        RestTemplate rest = new RestTemplate();
        VetDto[] vets = rest.getForObject(url, VetDto[].class);
        return Arrays.asList(vets);
    }
}
