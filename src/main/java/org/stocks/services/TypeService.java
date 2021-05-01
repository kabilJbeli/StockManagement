package org.stocks.services;

import java.util.List;

import org.stocks.dao.TypeDAO;
import org.stocks.entities.Type;

public class TypeService implements ITypeService {
private TypeDAO typeDAO;

public TypeDAO getTypeDAO() {
	return typeDAO;
}

public void setTypeDAO(TypeDAO typeDAO) {
	this.typeDAO = typeDAO;
}

@Override
public boolean setType(Type type) {
	// TODO Auto-generated method stub
	return typeDAO.setType(type);
}

@Override
public List<Type> getAll() {
	// TODO Auto-generated method stub
	return typeDAO.getAll();
}

@Override
public boolean updateType(Type type) {
	// TODO Auto-generated method stub
	return typeDAO.updateType(type);
}

@Override
public boolean removeType(int id) {
	// TODO Auto-generated method stub
	return typeDAO.removeType(id);
}

@Override
public Type getType(String Name) {
	// TODO Auto-generated method stub
	return typeDAO.getType(Name);
}

@Override
public Type getType(int id) {
	// TODO Auto-generated method stub
	return typeDAO.getType(id);
}
}
