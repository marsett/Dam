public class CifradorCesar {
	
	public static String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";
	
	public static String cifrar(String mensaje, int clave) {
		
		String mensajecifrado = "";
		
		mensaje = mensaje.toUpperCase();
		
		for(int i=0;i<mensaje.length();i++) {
			
			char caracter = mensaje.charAt(i);
			if(caracter==' ') {
				mensajecifrado += caracter;
			}else {
				int posicion = abecedario.indexOf(caracter);
				int posicionNueva = posicion + clave;
				int posicionNuevaAvanzada = posicionNueva % abecedario.length();
				char caracterNuevo = abecedario.charAt(posicionNuevaAvanzada);
				mensajecifrado += caracterNuevo;
			}
			
		}
		
		return mensajecifrado;
	}
	
	public static String descifrar(String mensaje, int clave) {
		String mensajedescifrado = "";
		
		mensaje = mensaje.toUpperCase();
		
		for(int i=0;i<mensaje.length();i++) {
			
			char caracter = mensaje.charAt(i);
			if(caracter==' ') {
				mensajedescifrado += caracter;
			}else {
				int posicion = abecedario.indexOf(caracter);
				
				int posicionNueva = (posicion - clave)+abecedario.length();
				while(posicionNueva<0) {
					posicionNueva+=abecedario.length();
				}
				int posicionNuevaAvanzada = posicionNueva % abecedario.length();
				
				char caracterNuevo = abecedario.charAt(posicionNuevaAvanzada);
				mensajedescifrado += caracterNuevo;
			}
			
			
		}
		
		return mensajedescifrado;
	}

}