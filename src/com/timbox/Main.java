package com.timbox;
import WashOut.*;
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
			// Comprobante timbrada
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
        // Los uuids a cancelar puede ser uno mas.
        String[] uuidsCancelacion = { "E28DBCF2-F852-4B2F-8198-CD8383891EB0", "3CFF7200-0DE5-4BEE-AC22-AA2A49052FBC", "51408B33-FE29-47DA-9517-FBF420240FD3" };
		byte[] pfx = Files.readAllBytes(Paths.get("archivoPfx.pfx"));
        String pfxContrasena = "12345678a";
        // Conversion del PFX a base64
        String pfxBase64  = Base64.getEncoder().encodeToString(pfx);

        try {
        	// Servicio de cancelacion
			ServiceLocator service = new ServiceLocator();
			Timbrado_port timbrado = service.gettimbrado_port();
			Cancelar_cfdi_result resultado = timbrado.cancelar_cfdi(usuario, contrasena, rfcEmisorCancelacion, uuidsCancelacion, pfxBase64, pfxContrasena);
			// Comprabantes cancelados
			String facturaCancelada = resultado.getComprobantes_cancelados();
			System.out.println("Comprabantes cancelados: \n");
			System.out.println(facturaCancelada);
        } catch (Exception exception) {
            throw exception;
        }
    }
}
