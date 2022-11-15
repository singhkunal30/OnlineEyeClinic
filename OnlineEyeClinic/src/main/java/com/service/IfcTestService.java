package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dto.Test;
import com.exceptions.TestIdNotFoundException;
@Service
public interface IfcTestService {
	Test addTest(Test test);
	Test updateTest(Test test) throws TestIdNotFoundException;
	Test removeTest(int testId) throws TestIdNotFoundException;
	Test viewTest(int testId)throws TestIdNotFoundException;
	List<Test> viewAllTests() throws TestIdNotFoundException;
}
