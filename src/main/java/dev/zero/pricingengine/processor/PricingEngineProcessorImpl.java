package dev.zero.pricingengine.processor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import dev.zero.pricingengine.model.PricingModel;
import dev.zero.pricingengine.model.ProductSpecs;
import dev.zero.pricingengine.model.Structure;

/**
 * PricingEngineProcessorImpl - Processing layer of the application
 * 
 * @author ppalit
 *
 */
public class PricingEngineProcessorImpl implements PricingEngineProcessor {

	

	ArrayList<Structure> productPriceMap;

	public PricingEngineProcessorImpl() {
		this.productPriceMap = new ArrayList<Structure>();
	}

	/**
	 * gets avg pricing for each item
	 */

	public List<Structure> getAvgPricing(ProductSpecs prdLst) {
		List<Structure> productPriceMap = new ArrayList<Structure>();
		for (File f : getResourceFolderFiles("pricing")) {
			JSONParser jsonParser = new JSONParser();
	        try (FileReader reader = new FileReader(f))
	        {
	            //Read JSON file
	        	
	            JSONObject obj = (JSONObject) jsonParser.parse(reader);
	            PricingModel model = new Gson().fromJson(obj.toString(), PricingModel.class);
	            
	            if (prdLst.getYear().equals(model.getYear())) {
		            model.getFrames().forEach(frm-> {
		            	if (frm.getType().toLowerCase().equals(prdLst.getFrameType().toLowerCase())) {
		            		productPriceMap.add(frm);
						}
		            });

		            model.getBreaks().forEach(brk-> {

		            	if (brk.getType().toLowerCase().equals(prdLst.getBreakType().toLowerCase())) {
		            		productPriceMap.add(brk);

						}
		            });
		            model.getSeats().forEach(set-> {

		            	if (set.getType().toLowerCase().equals(prdLst.getSeatType().toLowerCase())) {
		            		productPriceMap.add(set);

						}
		            });
		            model.getWheels().forEach(wel-> {

		            	if (wel.getType().toLowerCase().equals(prdLst.getWheelType().toLowerCase())) {
		            		productPriceMap.add(wel);

						}
		            });
		            model.getGears().forEach(ger-> {

		            	if (ger.getType().toLowerCase().equals(prdLst.getGearType().toLowerCase())) {
		            		productPriceMap.add(ger);

						}
		            });
				}

	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		}

		return productPriceMap;
	}

	private static File[] getResourceFolderFiles(String folder) {
		String path = null;
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			URL url = loader.getResource(folder);
			path = url.getPath();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return new File(path).listFiles();
	}


}
