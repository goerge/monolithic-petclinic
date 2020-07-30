package org.springframework.samples.petclinic.vets;

import java.util.Collection;
import java.util.List;
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
		List<VetDto> vets = vetsRepository.findAll().stream().map(v -> new VetDto(v.getId(), v.getFirstName(), v.getLastName(),
				v.getSpecialties().stream().map(Specialty::getName).collect(Collectors.toSet()))).collect(Collectors.toList());

		return vets;
	}
}
