package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Test;
import com.exceptions.TestIdNotFoundException;
import com.repository.ITestRepository;
import com.service.ITestService;

@Service
public class TestServiceImpl implements ITestService {
	
	@Autowired
	private ITestRepository testRepository; 
	
	@Override
	public Test addTest(Test test) {
		return testRepository.save(test);
	}

	@Override
	public Test updateTest(Test test) {
		Test t=testRepository.findById(test.getTestId()).get();
		t.setTestType(test.getTestType());
		t.getDoctorList().clear();
		t.getDoctorList().addAll(test.getDoctorList());
		t.getReportList().clear();
		t.getReportList().addAll(test.getReportList());
		t.setTestCost(test.getTestCost());
		t.setTestDescription(test.getTestDescription());
		t.setTestName(test.getTestName());
		testRepository.save(t);
		return t;
	}

	@Override
	public Test removeTest(int testId) throws TestIdNotFoundException {
		Test t=testRepository.findById(testId).get();
		testRepository.deleteById(testId);
		return t;
	}

	@Override
	public Test viewTest(int testId) throws TestIdNotFoundException {
		return testRepository.findById(testId).get();
	}

	@Override
	public List<Test> viewAllTests() {
		return testRepository.findAll();
	}

	
}
