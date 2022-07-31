package com.lti.myproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.myproj.model.Document;
import com.lti.myproj.model.User;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
	public Document findByCustomerId(int customerId);
}
