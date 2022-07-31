package com.lti.myproj.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
    private MultipartFile adhar;
    private MultipartFile pan;
    private MultipartFile image;
    private MultipartFile salarySlip;


    FileUpload() {
    }


	public MultipartFile getAdhar() {
		return adhar;
	}


	public void setAdhar(MultipartFile adhar) {
		this.adhar = adhar;
	}


	public MultipartFile getPan() {
		return pan;
	}


	public void setPan(MultipartFile pan) {
		this.pan = pan;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}


	public MultipartFile getSalarySlip() {
		return salarySlip;
	}


	public void setSalarySlip(MultipartFile salarySlip) {
		this.salarySlip = salarySlip;
	}
}