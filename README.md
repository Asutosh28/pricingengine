# pricing-engine
An online cycle company conducts market research to competitively price their products.

the company is making custom cycle as per the user requirement.
through this application you can calculate the price of customise cycle

Follow the instructions while giving input.
1. 1st you need to enter number of customized products ou want to calculate
2. You can choose cycle sparepart options from below options
	`Year: 2019, 2018, 
	Frame: steel, fiber, carbon fiber, 
	Seats: mountain, racing, gel, 
	Wheels: deep, tubeless, mid, shallow, tubular, braking, 
	Gears: single, hub, fixed, derailleur, 
	Breaks: Hydraulic, Disc, V, Roller, Cantilever,`

3. Enter in below format
	`year frame seats wheels gears breaks`
	eg.
	`2019 steel mountain deep single Hydraulic`
4. Output will look like below
	steel 1100.0 , Hydraulic 350.0 , mountain 980.0 , deep 750.0 , single 200.0 , 
	------------------
	Total Price : 3380.0
	------------------
 


#Build and execute instructions:
clone or download the project and run:   
mvn clean install		
 jar is created in /target folder of the project
and then run:  	
java -jar pricing-engine.jar

