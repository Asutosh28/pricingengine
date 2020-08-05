package dev.zero.pricingengine.rules;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * PricingRules - defines the rules for marking up or down the price.
 * @author ppalit
 *
 */
public class PricingRules implements Rules{
	int year[] = { 2018, 2019, 2020 }; 
	String frames[] = { "steel", "fiber", "carbon fiber" };
	String seats[] = { "racing saddle", "mountain bike saddle", "gel saddle" };
	String wheels[] = { "tubeless wheels", "tubular wheel", "shallow section", "mid section", "deep section", "braking surfaces" };
	String gears[] = { "single speed", "fixed gears", "hub gears", "derailleur gears" };
	String breaks[] = { "racing saddle", "mountain bike saddle", "gel saddle" };

	public int markup(String frameType, String breakType, String seatType, String wheelType, String gearType){
		int markupFactor = 0;
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
//        File file = new File(classLoader.getResource());
//        try (FileReader reader = new FileReader("employees.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
// 
//            JSONArray employeeList = (JSONArray) obj;
//            System.out.println(employeeList);
//             
//            //Iterate over employee array
////            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
// 
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//		if(supply.equalsIgnoreCase("H") && demand.equalsIgnoreCase("H")){
//			markupFactor = 0;
//		}
//		else if(supply.equalsIgnoreCase("H") && demand.equalsIgnoreCase("L")){
//			markupFactor = -5;
//		}
//		else if(supply.equalsIgnoreCase("L") && demand.equalsIgnoreCase("H")){
//			markupFactor = 5;
//		}
//		else if(supply.equalsIgnoreCase("L") && demand.equalsIgnoreCase("L")){
//			markupFactor = 10;
//		}
		return markupFactor; 
	}



}
