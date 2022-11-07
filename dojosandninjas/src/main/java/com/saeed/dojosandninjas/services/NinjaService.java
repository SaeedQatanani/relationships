package com.saeed.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeed.dojosandninjas.models.Ninja;
import com.saeed.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepository;
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
}
