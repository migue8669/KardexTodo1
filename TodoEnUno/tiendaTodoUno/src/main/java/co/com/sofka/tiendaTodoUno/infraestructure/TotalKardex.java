package co.com.sofka.tiendaTodoUno.infraestructure;

import co.com.sofka.tiendaTodoUno.model.Kardex;

public class TotalKardex {
	
	public String kardexTotalTicket(Kardex kardex) {
		
		int Value = Integer.parseInt(kardex.getValue());
		int TotalEntry = Integer.parseInt(kardex.getInputAmount());
		String result = String.valueOf(Value*TotalEntry);
		return result;
	}
}
