package com.lti.myproj.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.myproj.exception.UserNotFoundException;
import com.lti.myproj.model.Document;

import com.lti.myproj.model.User;
import com.lti.myproj.repository.DocumentRepository;
import com.lti.myproj.repository.RegistrationRepository;

@Service
public class DocumentServiceImpl implements DocumentService {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	DocumentRepository documentRepo;
	@Autowired
	RegistrationRepository registrationRepo;

	@Override
	public List<Document> getDocuments() {
		return documentRepo.findAll();
	}

	@Override
	public Document addDocuments(Document documents, int id) throws UserNotFoundException {
		User user = registrationRepo.findById(id);
		// if user not found throw exception
		if (user == null) {
			throw new UserNotFoundException();
		}

		Document existingDocuments = documentRepo.findByCustomerId(id);
		// if details already exist then update and return
		if (existingDocuments != null) {
			existingDocuments.update(documents);
			return existingDocuments;
		}

		// set user for one to one relationship
		documents.setUser(user);
		return documentRepo.save(documents);
	}

}
