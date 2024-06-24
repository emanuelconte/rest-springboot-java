package br.com.java.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.java.MathValidator;
import br.com.java.SimpleMath;
import br.com.java.exceptions.ResourceNotFoundException;

@RestController
public class MathController {
	
	SimpleMath math = new SimpleMath();
	
	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		
		if (!MathValidator.isNumeric(numberOne) || !MathValidator.isNumeric(numberTwo)) {
			numericException();
		}
		
		return math.sum(MathValidator.convertToDouble(numberOne), MathValidator.convertToDouble(numberTwo));
	}
	
	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		
		if (!MathValidator.isNumeric(numberOne) || !MathValidator.isNumeric(numberTwo)) {
			numericException();
		}
		
		return math.sub(MathValidator.convertToDouble(numberOne), MathValidator.convertToDouble(numberTwo));
	}
	
	@GetMapping("/times/{numberOne}/{numberTwo}")
	public Double times(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		
		if (!MathValidator.isNumeric(numberOne) || !MathValidator.isNumeric(numberTwo)) {
			numericException();
		}
		
		return math.times(MathValidator.convertToDouble(numberOne), MathValidator.convertToDouble(numberTwo));
	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		
		if (!MathValidator.isNumeric(numberOne) || !MathValidator.isNumeric(numberTwo)) {
			numericException();
		}
		
		return math.div(MathValidator.convertToDouble(numberOne), MathValidator.convertToDouble(numberTwo));
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(
			@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo ) throws Exception {
		
		if (!MathValidator.isNumeric(numberOne) || !MathValidator.isNumeric(numberTwo)) {
			numericException();
		}
		
		return math.mean(MathValidator.convertToDouble(numberOne), MathValidator.convertToDouble(numberTwo)) ;
	}
	
	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(
			@PathVariable(value = "number") String number) throws Exception {
		
		if (!MathValidator.isNumeric(number)) {
			numericException();
		}
		
		return math.squareRoot(MathValidator.convertToDouble(number));
	}
	
	private void numericException() {
		throw new ResourceNotFoundException("Please set a numeric value!");
	}

}
