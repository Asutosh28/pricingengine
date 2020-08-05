package dev.zero.pricingengine.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

import dev.zero.pricingengine.model.InputBean;
import dev.zero.pricingengine.model.PricingModel;
import dev.zero.pricingengine.model.ProductSpecs;

public class ConsoleDataInputImpl implements DataInput {

	private String lineArr[];
	private ProductSpecs spec;
	private List<ProductSpecs> productList;

	public ConsoleDataInputImpl() {
		this.productList = new ArrayList<ProductSpecs>();
		this.lineArr = new String[10];
	}

	public InputBean getInputData() {
		InputBean inputBean = new InputBean();
		readInputFromConsole(inputBean);
		return inputBean;
	}

	private void readInputFromConsole(InputBean inputBean) {
		System.out.println("Enter Number of products do you want to count");
		System.out.println();
		Scanner scanner = new Scanner(System.in);

		try {
			inputBean.setNumberOfProducts(scanner.nextInt());
			System.out.println("Choose options from below");

			Set<String> yr = new HashSet<>();
			Set<String> fm = new HashSet<>();
			Set<String> bk = new HashSet<>();
			Set<String> st = new HashSet<>();
			Set<String> wl = new HashSet<>();
			Set<String> gr = new HashSet<>();
			for (File f : getResourceFolderFiles("pricing")) {
//					System.out.println(f.getName().replace(".json", ""));
				JSONParser jsonParser = new JSONParser();

				try (FileReader reader = new FileReader(f)) {
//			            //Read JSON file
					JSONObject obj = (JSONObject) jsonParser.parse(reader);
					PricingModel model = new Gson().fromJson(obj.toString(), PricingModel.class);

					yr.add(model.getYear());
					model.getFrames().forEach(frm -> {
						fm.add(frm.getType());
					});
					model.getBreaks().forEach(brk -> {
						bk.add(brk.getType());
					});
					model.getSeats().forEach(set -> {
						st.add(set.getType());
					});
					model.getWheels().forEach(wel -> {
						wl.add(wel.getType());
					});
					model.getGears().forEach(ger -> {
						gr.add(ger.getType());
					});

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			System.out.print("Year: ");
			yr.forEach(y -> System.out.print(y + ", "));
			System.out.println();

			System.out.print("Frame: ");
			fm.forEach(f -> System.out.print(f + ", "));
			System.out.println();

			System.out.print("Seats: ");
			st.forEach(s -> System.out.print(s + ", "));
			System.out.println();

			System.out.print("Wheels: ");
			wl.forEach(w -> System.out.print(w + ", "));
			System.out.println();

			System.out.print("Gears: ");
			gr.forEach(g -> System.out.print(g + ", "));
			System.out.println();

			System.out.print("Breaks: ");
			bk.forEach(b -> System.out.print(b + ", "));
			System.out.println();

			System.out.println("Enter in below format");
			System.out.println("year frame seats wheels gears breaks");
			for (int i = 0; i < inputBean.getNumberOfProducts(); i++) {

				scanner = new Scanner(System.in);
				lineArr = scanner.nextLine().split(" ");
				spec = new ProductSpecs(lineArr[0], lineArr[1], lineArr[2], lineArr[3], lineArr[4], lineArr[5]);
				productList.add(spec);

			}

			inputBean.setProductList(productList);

		} catch (Exception e) {
			System.out.println("Invalid user input!");
		} finally {
			scanner.close();
		}

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
