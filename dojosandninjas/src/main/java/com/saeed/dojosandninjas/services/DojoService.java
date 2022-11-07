package com.saeed.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saeed.dojosandninjas.models.Dojo;
import com.saeed.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepository;
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
//	public List<Ninja> allNinjasByDojo(Long id){
//		return dojoRepository.findNinjas();
//	}
}
