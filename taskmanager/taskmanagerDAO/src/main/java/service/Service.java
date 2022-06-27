package service;

import dao.DAO;
/**
 * An auxiliary class used to get a necessary DAO 
 * Was created in order to restrict direct access from a command to DAO
 */
public interface Service<T> {
public DAO<?> createDao();
}