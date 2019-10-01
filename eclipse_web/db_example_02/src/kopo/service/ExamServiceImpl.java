package kopo.service;

import java.util.ArrayList;
import java.util.List;

import kopo.dao.ExamDao;
import kopo.domain.Exam;
import kopo.dto.ExamScore;

public class ExamServiceImpl implements ExamService{

	@Override
	public int create(ExamScore examScore) {
		
		return ExamDao.save(
			new Exam(examScore.getName(), examScore.getStudentid(), examScore.getKor(), examScore.getEng(), examScore.getMat())
			);
	}

	@Override
	public ExamScore selectOne(int id) {
		Exam exam = ExamDao.getRecordById(id);
		return new ExamScore(
				exam.getName(), exam.getStudentid(), exam.getKor(), exam.getEng(), exam.getMat()	
			);
	}

	@Override
	public List<ExamScore> selectAll() {
		List<Exam> exams = ExamDao.getAllRecords();
		List<ExamScore> examScores = new ArrayList<ExamScore>();
		for (Exam exam : exams) {
			examScores.add(new ExamScore(
					exam.getName(), exam.getStudentid(), exam.getKor(), exam.getEng(), exam.getMat()	
				));
		}
		return examScores;
	}

	@Override
	public List<ExamScore> selectAllByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(int id, ExamScore examScore) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ExamScore examScore) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(ExamScore examScore) {
		// TODO Auto-generated method stub
		return 0;
	}

}
