# ¡Reto Automatizador Sura! 🚀

Este es un proyecto de automatización de pruebas de aceptación usando **Java** como lenguaje de desarrollo, además se implementa el patrón **POM** para la escritura de pruebas. En este proyecto los requerimientos se escriben en lenguaje **Gherkin** con la implementación de **Cucumber** para Java.

Las pruebas están centradas en sitios web de prueba públicos, para este proyecto se ha utilizado el sitio web  [SauceDemo](https://www.saucedemo.com/) con los siguientes escenarios:

- Inicio de sesión en el sitio web
- Agregar productos al carrito de compras
- Finalizar el proceso de compra

## Pre requisitos para ejecutar 📋
- Java version 1.8 o superior y JDK (variables de entorno configuradas).
- Entorno de desarrollo: Eclipse IDE o IntelliJ IDEA
- Gradle version 6.0 o superior (variables de entorno configuradas).
- Plugin de Cucumber para Java
- Gherkin Plugin

## Ejecutar pruebas 🔨

La herramienta de compilación de código y administrador de dependencias para este proyecto es **Gradle**, así que pare ejecutar las pruebas use el siguiente comando en la raíz del proyecto.

	gradle clean test aggregate -i

Si desea ejecutar algún Runner especifico puede usar el siguiente comando, por ejemplo para el Login.

    gradle clean test --tests "LoginRunner"

## Navegador Web 🌐
Actualmente la automatización ejecuta por defecto con Chrome.

## Obtener el código

El código de la automatización está alojado en un repositorio de GitHub, para hacer uso de él puede clonarlo usando Git o descargar el archivo zip del proyecto.

Git:

	 git clone https://github.com/DiegoPinzon20/SuraAutomation.git
	 cd SuraAutomation

O simplemente [descargar archivo zip](https://github.com/DiegoPinzon20/SuraAutomation/archive/refs/heads/master.zip).

## Ver los informes
El comando proporcionado anteriormente para la ejecución de las pruebas, generará un informe de prueba de Serenity **index.html** en el directorio target/site/serenity. Adicionalmente, puede encontrar evidencias generadas por Cucumber en la ruta **target/serenity-reports**, son los siguientes archivos:

- **rerun.txt**: Archivo de texto con la información de la línea donde falló el caso para su revisión.
- **serenity-html-report.html**: Reporte generado con el resultado de cada uno de los pasos del feature incluido en las pruebas.

## Construido con 🛠
La automatización fue desarrollada con:
- BDD - Estrategia de desarrollo
- POM - Patrón de diseño (Page Object Model)
- Gradle - Administrador de dependencias
- Selenium Web Driver - Herramienta para interactuar con navegadores web
- Cucumber - Software que apoya el BDD
- Serenity BDD - Librería de código abierto para escribir pruebas de aceptación automatizadas
- Gherkin - Lenguaje DSL de lectura empresarial (lenguaje específico de dominio)

## Versionamiento 📌
Se usó Git para el control de versiones. 🔀

## Autor 👨

**Diego Pinzón** - [diego.pizon@sofka.com.co]()