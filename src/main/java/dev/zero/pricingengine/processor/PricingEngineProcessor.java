package dev.zero.pricingengine.processor;

import java.util.List;

import dev.zero.pricingengine.model.ProductSpecs;
import dev.zero.pricingengine.model.Structure;

public interface PricingEngineProcessor {
	
	public List<Structure> getAvgPricing(ProductSpecs productSpecs);
	
//	public void markSurveyValid(List<Survey> surveyList);
	
//	public Map<String, Double> findBestPriceForProduct(List<Survey> surveyList);
	

}
