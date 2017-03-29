package com.timbox;
import WashOut.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
    	// Parametros generales para el sevicio
		String usuario = "AAA010101000";
		String contrasena = "h6584D56fVdBbSmmnB";
		
		//
		// Timbrar Factura
		//
		// Parametros para el servicio
		byte[] archivoXml = Files.readAllBytes(Paths.get("archivoXml.xml"));
        String xmlBase64 = Base64.getEncoder().encodeToString(archivoXml);
		
		try {
			// Servicio de timbrado
			ServiceLocator service = new ServiceLocator();
			Timbrado_port timbrado = service.gettimbrado_port();
			Timbrar_cfdi_result resultado = timbrado.timbrar_cfdi(usuario, contrasena, xmlBase64);
			// Factura timbrada
			String facturaTimbrada = resultado.getXml();
			System.out.println("Comprobante timbrado: \n");
			System.out.println(facturaTimbrada);
		} catch (Exception exception) {
			throw exception;
		}
		
		//
        // Cancelar Factura
		//
        // Parametros para el servicio
        String rfcEmisorCancelacion = "AAA010101AAA";
        String[] uuidsCancelacion = { "E28DBCF2-F852-4B2F-8198-CD8383891EB0" };
		byte[] pfx = Files.readAllBytes(Paths.get("archivoPfx.pfx"));
        String pfxContrasena = "12345678a";
        // Conversion del PFX a base64
        String pfxBase64  = Base64.getEncoder().encodeToString(pfx);

        try {
        	// Servicio de timbrado
			ServiceLocator service = new ServiceLocator();
			Timbrado_port timbrado = service.gettimbrado_port();
			//(java.lang.String username, java.lang.String password, java.lang.String rfcemisor, java.lang.String[] uuids, java.lang.String pfxbase64, java.lang.String pfxpassword)
			Cancelar_cfdi_result resultado = timbrado.cancelar_cfdi(usuario, contrasena, rfcEmisorCancelacion, uuidsCancelacion, pfxBase64, pfxContrasena);
			// Factura timbrada
			String facturaCancelada = resultado.getComprobantes_cancelados();
			System.out.println("Comprabantes cancelados: \n");
			System.out.println(facturaCancelada);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
