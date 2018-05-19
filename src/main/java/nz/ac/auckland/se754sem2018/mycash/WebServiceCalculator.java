package nz.ac.auckland.se754sem2018.mycash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServiceCalculator implements ICalculator {

	private String urlBaseString;
	
	public WebServiceCalculator() {
		urlBaseString = "http://api.mathjs.org/v4/?expr=";
	}
	
	public int add(int augend, int addend) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int subtract(int minuend, int subtrahend) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int multiply(int multiplicand, int multiplier) {
		return this.calculate(multiplicand, multiplier, "*");
	}

	public int divide(int dividend, int divisor) {
		try {
			return this.calculate(dividend, divisor, "/");
		}
		catch(ArithmeticException e) {
			throw e;
		}
	}
	
	private int calculate(int operand1, int operand2, String operator){
		
		int result = 0;
		
		try {
			String urlString = this.urlBaseString+operand1+operator+operand2;
			URL url =  new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader((conn.getInputStream())));
			
			String output = br.readLine();
			if(output != null) {
				Double tmp = Double.valueOf(output.trim());
				if(tmp.isInfinite() || tmp.isNaN()) {
					throw new ArithmeticException("Return infinite value or NaN!");
				}
				result = tmp.intValue();
			}

			conn.disconnect();

		} 
		catch(ArithmeticException e) {
			throw e;
		}
		catch(Exception e) {
			e.printStackTrace();;
		}
		
		return result;
	}

}
