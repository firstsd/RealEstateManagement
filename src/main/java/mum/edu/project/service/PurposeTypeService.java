package mum.edu.project.service;

import java.util.List;

import mum.edu.project.model.PurposeType;

public interface PurposeTypeService {
	PurposeType getById(Long id);

	PurposeType save(PurposeType purposeType);

	List<PurposeType> getAll();
}
