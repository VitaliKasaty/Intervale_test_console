package com.vitalikasaty.intervale.test.library.dao;

import com.vitalikasaty.intervale.test.library.dao.impl.LibraryDAOImpl;

public final class DAOProvider {

	private static final DAOProvider instance = new DAOProvider();

	private LibraryDAO libraryDAO = new LibraryDAOImpl();

	private DAOProvider() {
	}

	public LibraryDAO getLibraryDAO() {
		return libraryDAO;
	}

	public void setLibraryDAO(LibraryDAO libraryDAO) {
		this.libraryDAO = libraryDAO;
	}

	public static DAOProvider getInstance() {
		return instance;
	}

}
