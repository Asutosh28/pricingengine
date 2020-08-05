package dev.zero.pricingengine;

import java.util.List;

import dev.zero.pricingengine.io.ConsoleDataInputImpl;
import dev.zero.pricingengine.io.ConsoleDataOutput;
import dev.zero.pricingengine.io.DataInput;
import dev.zero.pricingengine.io.DataOutput;
import dev.zero.pricingengine.model.InputBean;
import dev.zero.pricingengine.model.Structure;
import dev.zero.pricingengine.processor.PricingEngineProcessor;
import dev.zero.pricingengine.processor.PricingEngineProcessorImpl;
import dev.zero.pricingengine.rules.PricingRules;
import dev.zero.pricingengine.rules.Rules;
/**
 * AppControl - Class that controls the flow of execution
 * @author ppalit
 *
 */
public class AppControl {
	InputBean inputBean;
	DataInput dataInput;
	DataOutput dataOutput;
	PricingEngineProcessor processor;
	Rules pricingRules;
	
	public AppControl() {
		this.inputBean = new InputBean();
		this.dataInput = new ConsoleDataInputImpl();
		this.dataOutput = new ConsoleDataOutput();
		this.processor = new PricingEngineProcessorImpl();
		this.pricingRules = new PricingRules();
	}
	
	public void execute(){
		
		//get data from user
		inputBean = dataInput.getInputData();
		
		// print to console
		for (int i = 0; i < inputBean.getNumberOfProducts(); i++) {
			List<Structure> productPriceMap =  processor.getAvgPricing(inputBean.getProductList().get(i));
			dataOutput.displayData(productPriceMap);	
		}
			
		
	}
	
//	Map<String, Double> finalPriceForProduct(){
//		List<ProductSpecs> l1 = inputBean.getProductList();
//		double value;
//		Map<String,Double> finalPricingMap = new HashMap<String, Double>();
//		for (ProductSpecs productSpecs : l1) {
//			System.out.println(productSpecs.getBreakType().replace(" ", "_"));
//			System.out.println(productSpecs.getFrameType().replace(" ", "_"));
//			System.out.println(productSpecs.getSeatType().replace(" ", "_"));
//			System.out.println(productSpecs.getWheelType().replace(" ", "_"));
//			System.out.println(productSpecs.getGearType().replace(" ", "_"));
//			
//			int markup = pricingRules.markup(productSpecs.getFrameType(), productSpecs.getBreakType(), productSpecs.getSeatType(), productSpecs.getWheelType(), productSpecs.getGearType());
////			value =  finalPricingMap.get(productSpecs.getProductName());
////			double val = value + (value*markup/100);
////			finalPricingMap.put(productSpecs.getProductName(), val);
//		}
//		return finalPricingMap;
//	}
	

}
