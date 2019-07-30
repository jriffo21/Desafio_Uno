## INSTRUCCIONES DE COMPILACION

1. Ingresar al directorio Desafio_Uno y ejecutar el comando "mvn package"

2. Luego ingresar al directorio target y ejecutar el siguiente comando "java -jar .\desafiouno-0.0.1-SNAPSHOT.jar"
debe estar disponible el puerto 8090 en el PC donde se ejecute esta API.

3. La documentación swagger del API queda disponible en "http://127.0.0.1:8090/swagger-ui.html#" 
y ejecutar el metodo "getFechasFaltantes"

4. Para consumir el servicio se debe invocar la siguiente Url "http://127.0.0.1:8090/periodos/fechasFaltantes"