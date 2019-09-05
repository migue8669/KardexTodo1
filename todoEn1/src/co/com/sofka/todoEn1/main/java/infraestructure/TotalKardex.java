package co.com.sofka.kardexTd1.infraestructure;

import co.com.sofka.kardexTd1.model.KardexTd1;

public class TotalKardex {
	
	public String kardexTotalTicket(KardexTd1 kardex) {
		
		int Value = Integer.parseInt(kardex.getValue());
		int TotalEntry = Integer.parseInt(kardex.getInputAmount());
		String result = String.valueOf(Value*TotalEntry);
		return result;
	}
}
