package br.com.kentec.redetec.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utilidades {
	
	public static String dataAtual() {
		LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
	}
}
