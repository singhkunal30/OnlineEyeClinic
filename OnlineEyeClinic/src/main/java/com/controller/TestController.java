package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.Test;
import com.exceptions.TestIdNotFoundException;
import com.service.IfcTestService;

@RestController
@CrossOrigin("*")
public class TestController {
	@Autowired
	private IfcTestService testService;
	
	@PostMapping(path="test/add")
	public Test addTest (@RequestBody Test test) {
		return testService.addTest(test);
	}
	
	@PutMapping(path="test/update")
	public Test updateTest(@RequestBody Test test) throws TestIdNotFoundException{
		return testService.updateTest(test);
	}
	
	@DeleteMapping(path="test/delete/{testId}")
	public Test removeTest(@PathVariable int testId) throws TestIdNotFoundException{
		return testService.removeTest(testId);
	}
	
	@GetMapping(path="test/viewById/{testId}")
	public Test viewTest(@PathVariable int testId) throws TestIdNotFoundException{
		return testService.viewTest(testId);
	}
	
	@GetMapping(path="test/viewAll")
	public List<Test> viewAllTests() throws TestIdNotFoundException{
		return testService.viewAllTests();
	}

}