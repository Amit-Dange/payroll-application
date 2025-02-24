package com.epam.payroll_management.utility;

import java.util.List;

public class ValidationsUtils {
	
	public static void validateString(String str) {
		if (str == null || str.isBlank()) {
            throw new IllegalArgumentException("String argument is null or blank");
        }
	}
	
	public static void validateValue(double value) {
		if (value < 0) {
            throw new IllegalArgumentException("Value is null or negative");
        }
	}
	
	public static void validateList(List<?> list) {
		if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }
	}
	
	public static void validateArrays(Object[] array) {
		if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
	}
	
	public static void validateObject(Object obj) {
		if(obj == null){
            throw new IllegalArgumentException(" Argument is null");
        }
	}
	
}
