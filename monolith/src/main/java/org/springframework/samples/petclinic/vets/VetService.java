package org.springframework.samples.petclinic.vets;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * @author Markus Claessens
 */

@Service
public class VetService {

	private final VetRepository vetsRepository;

	VetService(VetRepository vetsRepository) {
		this.vetsRepository = vetsRepository;
	}

	public Collection<VetDto> allVets() {
		return vetsRepository.findAll().stream().map(this::getVetDto).collect(Collectors.toList());
	}

	private VetDto getVetDto(Vet v) {
		return new VetDto(v.getId(), v.getFirstName(), v.getLastName(), v.getSpecialties().stream().map(Specialty::getName).collect(Collectors.toSet()));
	}
}
