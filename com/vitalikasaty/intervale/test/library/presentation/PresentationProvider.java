package com.vitalikasaty.intervale.test.library.presentation;

public class PresentationProvider {

	private static final PresentationProvider instance = new PresentationProvider();
	private  ChangeLibraryOption changeLibraryOption = new ChangeLibraryOption();
	private  FindOption findLibraryOption = new FindOption();//!!!!!
	
	private PresentationProvider() {		
	}

	public ChangeLibraryOption getChangeLibraryOption() {
		return changeLibraryOption;
	}

	public void setChangeLibraryOption(ChangeLibraryOption changeLibraryOption) {
		this.changeLibraryOption = changeLibraryOption;
	}

	public FindOption getFindLibraryOption() {
		return findLibraryOption;
	}

	public void setFindLibraryOption(FindOption findLibraryOption) {
		this.findLibraryOption = findLibraryOption;
	}

	public static PresentationProvider getInstance() {
		return instance;
	}
	
	
	
	
	
}
