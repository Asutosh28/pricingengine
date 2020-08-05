package dev.zero.pricingengine.io;

import java.util.List;

import dev.zero.pricingengine.model.Structure;

public class ConsoleDataOutput implements DataOutput {

	public void displayData(List<Structure> productPriceMap) {
		Double[] total = {0.0};
		productPriceMap.forEach(priceMp->{
			System.out.print(priceMp.getType() + " " + priceMp.getPrice() + " , ");
			total[0] = total[0] + priceMp.getPrice();
		});
		System.out.println();
		System.out.println("------------------");
		System.out.println("Total Price : " + total[0] );
		System.out.println("------------------");
	}

}
