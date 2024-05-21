package com.yadier.agilemethods.services;

import java.util.ArrayList;

import com.yadier.agilemethods.models.Methodology;
import com.yadier.agilemethods.models.ResultMethod;



public interface AgileMethodologyService {
   
	public ResultMethod chooseMethodology(Methodology methodology);
}
