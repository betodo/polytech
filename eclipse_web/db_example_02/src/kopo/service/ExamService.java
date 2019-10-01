package kopo.service;

import java.util.List;

import kopo.dto.ExamScore;

public interface ExamService {

	// Create
	int create(ExamScore examScore);
	
	// Read
	ExamScore selectOne(int id);
	List<ExamScore> selectAll();
	List<ExamScore> selectAllByName(String name);
	
	// Update
	int update(int id, ExamScore examScore);
	int update(ExamScore examScore);
		
	// Delete
	int delete(int id);
	int delete(ExamScore examScore);
	
}
