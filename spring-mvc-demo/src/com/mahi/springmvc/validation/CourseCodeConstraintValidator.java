package com.mahi.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	private String[] coursePrefixes;
	
	@Override
	public void initialize(CourseCode courseCode){
		coursePrefixes = courseCode.value();
	}
	
	@Override
	public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
		boolean result = false;
		
		if(code != null){
			for(String tempPrefix : coursePrefixes){
				result = code.startsWith(tempPrefix);
                
                // if we found a match then break out of the loop
                if (result) {
                    break;
                }
			}
		}
			
		else
			result = true;
		return result;
	}

}
