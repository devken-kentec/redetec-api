package br.com.kentec.redetec.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Random;

public class Utilidades {
	
	public static String dataAtual() {
		LocalDateTime agora = LocalDateTime.now();
	    DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataFormatada = formatterData.format(agora);
		return dataFormatada;
	}
	
	public static String encodeB64(String senha) {
		var senhaBase64 = Base64.getEncoder().encodeToString(senha.getBytes());
		return senhaBase64;
	}
	
	public static String decodeB64(String senha) {
		byte[] decodedBytes = Base64.getDecoder().decode(senha);
		String decodedString = new String(decodedBytes);
		return decodedString;
	}
	
	public static String gerarSenhaAleatoria() {
		Random random = new Random();
		Integer senhaAle = random.nextInt(1000, 9999);
		return senhaAle.toString();
	}
}
