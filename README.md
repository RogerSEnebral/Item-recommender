# Item-recommender
 Java project in which users are recommended items based on their ratings, using different algorithms such as k-means and collaborative filtering.

# Compilar

Ir a subgrup-prop10-4\FONTS

-Linux:
Para linux, 2 opciones:
	Opción 1
		Paso 1: Al descargar el archivo, el script Compilar_y_Generar_Ejecutable.sh vendrá sin permisos de ejecución, deberás introducir el siguiente comando $chmod +x Compilar_y_Generar_Ejecutable.sh 
		para poder ejecutar el paso 2.

		Paso 2:Ejecutar el script Compilar_y_Generar_Ejecutable.sh mediante el comando $./Compilar_y_Generar_Ejecutable.sh . Este script va a compilar toda la aplicación y te va a generar el ejecutable.
	  	

		Paso 3:Ejecutar el archivo jar ejecutable disponible en el directorio EXE/Main_Jar/Main_Linux.jar mediante el comando $java -jar Main_Linux.jar.
	
	Opción 2
		Makefile: Ejecutando el comando $make help, puedes observar las distintas opciones que tienes para compilar, ejecutar y borrar archivos .class temporales de nuestra aplicación completa.

Para windows:
	Opción 1
		Paso 1: Ejecutar el script Compilar_y_Generar_Ejecutable.bat mediante doble click. Este script va a compilar toda la aplicación y te va agenerar el ejecutable
	  	el cual puedes encontrar en EXE/Main_Jar/Main_Windows.jar además de borrar los archivos .class temporales.
		
		

# Ejecutar

Hacer doble click en el archivo el cual puedes encontrar en EXE/Main_Jar/Main_Linux.jar o EXE/Main_Jar/Main_Windows.jar (Linux o Windows respectivamente) para ejecutar la aplicación.

A la hora de ejecutar el programa lo primero que debe hacer es importar los datos encontrados en EXE/Jocs_assaig (Series750). 
Puede crear un nuevo usuario o utilizar uno existente. 
Todo usuario preexistente tiene como contraseña su mismo número, siendo estos 1, 2...




