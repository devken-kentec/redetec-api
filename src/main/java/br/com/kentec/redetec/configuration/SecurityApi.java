package br.com.kentec.redetec.configuration;

public  class SecurityApi {
	
	static Boolean X45FA3;
	
	public static void setSecurityApi() {
		X45FA3 = true;
		System.out.println(X45FA3);
	}
	
	
	public static void verificaValidacaoApi() {
		if(X45FA3) {
			System.out.println("Passando");
		} else {
			System.exit(1);
		}
		
	}
}
