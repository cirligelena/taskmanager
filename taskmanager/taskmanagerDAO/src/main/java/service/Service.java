package service;

import dao.DAO;

public interface Service<T> {
public DAO<?> createDao();
}