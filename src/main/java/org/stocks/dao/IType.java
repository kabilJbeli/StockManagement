package org.stocks.dao;

import java.util.List;

import org.stocks.entities.Type;


public interface IType {

	public boolean setType(Type type);
	public List<Type> getAll();
	public boolean updateType(Type type);
	public boolean removeType(int id);
	public Type getType(String Name);	
	public Type getType(int id);

}
