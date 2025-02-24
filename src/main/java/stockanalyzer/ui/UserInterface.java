//https://github.com/NavdeepSingh1994/StockAnalyzer.git
package stockanalyzer.ui;
import stockanalyzer.ctrl.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface
{

	private Controller ctrl = new Controller();

	public void getDataFromCtrl1(){
		try{
			ctrl.process("CSCO");
		}		catch (YahooException y){
			System.out.println(y.getMessage());
		}
	}

	public void getDataFromCtrl2()  {
		try{
			ctrl.process("AAPL");
		}		catch (YahooException y){
			System.out.println(y.getMessage());
		}
	}

	public void getDataFromCtrl3(){
		try{
			ctrl.process("UBER");
		}		catch (YahooException y){
			System.out.println(y.getMessage());
		}
	}

	public void getDataForCustomInput() {
		try{
			ctrl.process(readLine());
		}		catch (YahooException y){
			System.out.println(y.getMessage());
		}

	}


	public void start() throws YahooException {
		Menu<Runnable> menu = new Menu<>("User Interface");
		menu.setTitel("Please choose from:");
		menu.insert("a", "Choice Cisco Systems, Inc.", this::getDataFromCtrl1);
		menu.insert("b", "Apple", this::getDataFromCtrl2);
		menu.insert("c", "Uber", this::getDataFromCtrl3);
		menu.insert("d", "Choice User Input:", this::getDataForCustomInput);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			choice.run();
		}
		System.out.println("Program finished");
	}


	protected String readLine()
	{
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
		} catch (IOException e) {
			System.out.println("Die Eingabe war Fehlerhaft!");
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit)
	{
		Double number = null;
		while(number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
			}catch(NumberFormatException e) {
				number=null;
				System.out.println("Please enter a valid number:");
				continue;
			}
			if(number<lowerlimit) {
				System.out.println("Please enter a higher number:");
				number=null;
			}else if(number>upperlimit) {
				System.out.println("Please enter a lower number:");
				number=null;
			}
		}
		return number;
	} }