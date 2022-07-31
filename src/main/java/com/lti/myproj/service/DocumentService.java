package com.lti.myproj.service;

import java.util.List;

import com.lti.myproj.exception.UserNotFoundException;
import com.lti.myproj.model.Document;


public interface DocumentService {
	public List<Document> getDocuments();

	public Document addDocuments(Document documents, int id) throws UserNotFoundException;
}
