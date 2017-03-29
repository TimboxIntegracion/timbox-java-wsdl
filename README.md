# Java
Ejemplo con la integración al Webservice de Timbox

Se deberá hacer uso de las URL que hacen referencia al WSDL, en cada petición realizada:

- [Timbox Pruebas](https://staging.ws.timbox.com.mx/timbrado/wsdl)

- [Timbox Producción](https://sistema.timbox.com.mx/timbrado/wsdl)

Para integrar el Webservice al proyecto se requiere hacer uso del modulo Base64:

```
import java.nio.charset.StandardCharsets;
import java.util.Base64;
```

Para desarrollar el ejemplo se recomienda usar el IDE [Eclipse](https://www.eclipse.org/downloads/)

## Creación del cliente para el servicio
Para poder utilizar el servicio se requiere crear un cliente, se genera de la siguiente forma:

- Lo primero que debemos hacer es crear un nuevo archivo.
- Click derecho sobre el proyecto > New > Other.
![imagen 1](http://i.imgur.com/JwmvmAf.png)

- Extender el folder Web Services y seleccionar Web Service Client.
![imagen 1](http://i.imgur.com/dB2cBHg.png)

- En el input de service definition pondremos el url del servicio que estemos utilizando ya sea staging o producción y presionamos el boton Finish.
  - [Timbox Pruebas (https://staging.ws.timbox.com.mx/timbrado/wsdl)](https://staging.ws.timbox.com.mx/timbrado/wsdl)
  - [Timbox Producción (https://sistema.timbox.com.mx/timbrado/wsdl)](https://sistema.timbox.com.mx/timbrado/wsdl)

![imagen 1](http://i.imgur.com/P9UWURK.png)

- De esta tendremos generado nuestro cliente, solo nos faltara incluirlo en las referencias de nuestra aplicación con el siguiente código.
```
import WashOut.*;
```
![imagen 1](http://i.imgur.com/LkuxXli.png)

## Timbrar CFDI
Para hacer una petición de timbrado de un CFDI, deberá enviar las credenciales asignadas, asi como el xml que desea timbrar convertido a una cadena en base64:
```
// Timbrar Factura

// Parametros para el servicio		
String usuario = "AAA010101000";
String contrasena = "h6584D56fVdBbSmmnB";
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
```

## Cancelar CFDI
Para la cancelación son necesarias las credenciales asignadas, RFC del emisor, un arreglo de UUIDs, el archivo PFX convertido a cadena en base64 y el password del archivo PFX:
```
// Cancelar Factura

// Parametros para el servicio
String usuario = "AAA010101000";
String contrasena = "h6584D56fVdBbSmmnB";
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
```
