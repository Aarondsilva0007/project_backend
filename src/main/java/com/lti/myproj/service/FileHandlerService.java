package com.lti.myproj.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lti.myproj.model.User;
import com.lti.myproj.model.Document;
import com.lti.myproj.model.FileUpload;

@Service
public class FileHandlerService {
	public static String BASE_PATH = "D:\\Downloads\\LTI\\";

	// transfers file to directory
	public void transferFile(MultipartFile file, String fileName) throws IllegalStateException, IOException {
		file.transferTo(new File(FileHandlerService.BASE_PATH + fileName));
	}

	public String getFileExtension(MultipartFile file) {
		String name = file.getOriginalFilename();
		int lastIndexOf = name.lastIndexOf(".");
		if (lastIndexOf == -1) {
			return ""; // empty extension
		}
		return name.substring(lastIndexOf);
	}

	// creates a custom name for file
	public String fileNamer(MultipartFile file, User user, String fileName) {
		return user.getId() + user.getEmailId() + "_" + fileName + this.getFileExtension(file);
	}

	// creates a custom name for file
	public String fileNamer(MultipartFile file, User user) {
		return user.getId() + user.getEmailId() + this.getFileExtension(file);
	}

	// handles file transfer
	// return filepath on success
	public String uploadFile(MultipartFile file, User user) throws IOException {
		String fileName = this.fileNamer(file, user);
		this.transferFile(file, this.fileNamer(file, user));
		return FileHandlerService.BASE_PATH + fileName;
	}

	// handles file transfer
	// return filepath on success
	public String uploadFile(MultipartFile file, User user, String label) throws IOException {
		String fileName = this.fileNamer(file, user, label);
		this.transferFile(file, fileName);
		return FileHandlerService.BASE_PATH + fileName;
	}

	public Document uploadUsersDocuments(FileUpload fileUpload, User user) throws IOException{
		Document document = new Document();

		// upload aadhaar
		document.setAadhar(this.uploadFile(fileUpload.getAdhar(), user, "adhar"));
		document.setPan(this.uploadFile(fileUpload.getPan(), user, "pan"));
		document.setImage(this.uploadFile(fileUpload.getImage(), user, "image"));
		document.setSalary_slip(this.uploadFile(fileUpload.getSalarySlip(), user, "salary_slip"));

		return document;
	}
}
