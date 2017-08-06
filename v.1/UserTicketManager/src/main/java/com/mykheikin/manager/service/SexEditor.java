package com.mykheikin.manager.service;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.mykheikin.manager.model.Sex;

@Component
public class SexEditor extends PropertyEditorSupport {

	// Do not use @Autowired.
	// Use dependency injection in class constructor.
	private final SexService sexService;

	public SexEditor() {
		this.sexService = null;
	}

	// This constructor will be used to inject the categoryService.
	public SexEditor(SexService sexService) {
		this.sexService = sexService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// Find a category by its categoryId from text
		Sex sex = sexService.findById(Integer.parseInt(text));
		setValue(sex);
	}
}
