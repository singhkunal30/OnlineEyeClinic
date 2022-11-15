package com.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dto.Test;
import com.exceptions.TestIdNotFoundException;
import com.repository.IfcTestRepository;
import com.service.IfcTestService;
import org.springframework.stereotype.Service;
@Service
public class TestServiceImpl implements IfcTestService{
	
	@Autowired
	private IfcTestRepository testRepository;
	Logger log = LoggerFactory.getLogger(TestServiceImpl.class);

	@Override
	public Test addTest(Test test) {
		log.info("Test Added");
		return testRepository.save(test);
	}

	@Override
	public Test updateTest(Test test) throws TestIdNotFoundException {
		if(testRepository.existsById(test.getTestId())) {
			Test t=testRepository.findById(test.getTestId()).get();
			t.setTestType(test.getTestType());
			t.setTestCost(test.getTestCost());
			t.setTestName(test.getTestName());
			testRepository.save(t);
			log.info("Test Updated");
			return t;
		}
		else { 
			log.error("Test not found exception thrown");
			throw new TestIdNotFoundException("Test Not Found");
		}
	}

	@Override
	public Test removeTest(int testId) throws TestIdNotFoundException {
		if(testRepository.existsById(testId)){
			Test t=testRepository.findById(testId).get();
			testRepository.deleteById(testId);
			log.info("Test Removed");
			return t;
		}
		else {
			log.error("Test not found exception thrown");
			throw new TestIdNotFoundException("Test Not Found");
		}
	}

	@Override
	public Test viewTest(int testId) throws TestIdNotFoundException {
		if(testRepository.existsById(testId)){
			Test t = testRepository.findById(testId).get();
			log.info("Test viewed");
			return t;
		}
		else { 
			log.error("Test not found exception thrown");
			throw new TestIdNotFoundException("Test Not Found");
	}
	}


	@Override
	public List<Test> viewAllTests() throws TestIdNotFoundException {
		List<Test> list = testRepository.findAll();
		if(list.isEmpty()) {
			log.error("Test not found exception thrown");
			throw new  TestIdNotFoundException("No Tests found");
		}
		log.info("All Tests are viewed");
		return list;
	}	
}
