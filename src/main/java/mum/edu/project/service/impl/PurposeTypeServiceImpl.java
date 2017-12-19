package mum.edu.project.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.project.model.PurposeType;
import mum.edu.project.repository.PurposeTypeRepository;
import mum.edu.project.service.PurposeTypeService;

@Service
@Transactional
public class PurposeTypeServiceImpl implements PurposeTypeService {
	@Autowired
	PurposeTypeRepository repository;

	@Override
	public PurposeType save(PurposeType purposeType) {
		// TODO Auto-generated method stub
		return repository.save(purposeType);
	}

	@Override
	public PurposeType getById(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	public List<PurposeType> getAll() {
		// TODO Auto-generated method stub
		return (List<PurposeType>) repository.findAll();
	}
}
