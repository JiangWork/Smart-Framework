package org.smartframework.datebase.dao;

public interface DaoCommand<T> {
	
	public T execute(SqlExecutor executor);
	
}
