package com.yadier.agilemethods.models;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Methodology {
	

	private String prg1;
	
	private String prg2;
	
	private String prg3;

	private String prg4;
	
	private String prg5;
	
	private String prg6;
	
	private String prg7;

	private String prg8;
	
	private String prg9;

	private String prg10;
	
	private String prg11;
	
//	public static String ERR_NOMBRE = "El nombre debe tener mas de 3 letras y menos de 20.";

	 public  String[] toStringArray() {
		 //el orden no puede cambir, mucho cuidado.
		  String[] propiedades = {
				  prg1,
				  prg2,
				  prg3,
				  prg4,
				  prg5,
				  prg6,
				  prg7,
				  prg8,
				  prg9,
				  prg10,
				  prg11
				 
	                };
	       
	        return propiedades;
	    }

	public String getPrg1() {
		return prg1;
	}

	public void setPrg1(String prg1) {
		this.prg1 = prg1;
	}

	public String getPrg2() {
		return prg2;
	}

	public void setPrg2(String prg2) {
		this.prg2 = prg2;
	}

	public String getPrg3() {
		return prg3;
	}

	public void setPrg3(String prg3) {
		this.prg3 = prg3;
	}

	public String getPrg4() {
		return prg4;
	}

	public void setPrg4(String prg4) {
		this.prg4 = prg4;
	}

	public String getPrg5() {
		return prg5;
	}

	public void setPrg5(String prg5) {
		this.prg5 = prg5;
	}

	public String getPrg6() {
		return prg6;
	}

	public void setPrg6(String prg6) {
		this.prg6 = prg6;
	}

	public String getPrg7() {
		return prg7;
	}

	public void setPrg7(String prg7) {
		this.prg7 = prg7;
	}

	public String getPrg8() {
		return prg8;
	}

	public void setPrg8(String prg8) {
		this.prg8 = prg8;
	}

	public String getPrg9() {
		return prg9;
	}

	public void setPrg9(String prg9) {
		this.prg9 = prg9;
	}

	public String getPrg10() {
		return prg10;
	}

	public void setPrg10(String prg10) {
		this.prg10 = prg10;
	}
	
	public String getPrg11() {
		return prg11;
	}

	public void setPrg11(String prg11) {
		this.prg11 = prg11;
	}

	
	 // Método para validar los campos
    public String validateFields() {
        StringBuilder errors = new StringBuilder();
       
        if (prg1 == null || prg1.trim().isEmpty()) errors.append("prg1 es obligatorio. ");
        if (prg2 == null || prg2.trim().isEmpty()) errors.append("prg2 es obligatorio. ");
        if (prg3 == null || prg3.trim().isEmpty()) errors.append("prg3 es obligatorio. ");
        if (prg4 == null || prg4.trim().isEmpty()) errors.append("prg4 es obligatorio. ");
        if (prg5 == null || prg5.trim().isEmpty()) errors.append("prg5 es obligatorio. ");
        if (prg6 == null || prg6.trim().isEmpty()) errors.append("prg6 es obligatorio. ");
        if (prg7 == null || prg7.trim().isEmpty()) errors.append("prg7 es obligatorio. ");
        if (prg8 == null || prg8.trim().isEmpty()) errors.append("prg8 es obligatorio. ");
        if (prg9 == null || prg9.trim().isEmpty()) errors.append("prg9 es obligatorio. ");
        if (prg10 == null || prg10.trim().isEmpty()) errors.append("prg10 es obligatorio. ");
        if (prg11 == null || prg11.trim().isEmpty()) errors.append("prg11 es obligatorio. ");
        return errors.toString();
    }
	
}
