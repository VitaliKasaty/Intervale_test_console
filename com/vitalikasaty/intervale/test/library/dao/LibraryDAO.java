package com.vitalikasaty.intervale.test.library.dao;

import com.vitalikasaty.intervale.test.library.bean.Library;

public interface LibraryDAO {
	boolean saveLibrary(Library library) throws DAOException;
	Library getLibrary() throws DAOException;
}
