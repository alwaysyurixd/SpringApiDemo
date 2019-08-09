# Api de clientes
Api desarrollada para el reto tech de Intercorp Retail.

## Para cumplir con el reto se usaron las siguientes herramientas:
- Framework: Spring boot
- Lenguaje: Java
- Cloud: Azure
- Base de datos: Mysql
- IDE: Visual studio code
- Control de versiones: Git/github

## Enlaces:
- Proyecto en github: https://github.com/alwaysyurixd/SpringApiDemo
- Documentación del api: https://retoinretail.azurewebsites.net/swagger-ui.html
- Api Docs: https://retoinretail.azurewebsites.net/v2/api-docs

## Operaciones disponibles:
- Endpoint de entrada POST /creacliente
  - Nombre
  - Apellido
  - Edad
  - Fecha de nacimiento
- Endpoint de salida GET /kpideclientes
  - Promedio edad entre todos los clientes
  - Desviación estándar entre las edades de todos los clientes
- Endpoint de salida GET /listclientes
  - Lista de personas con todos los datos + fecha probable de muerte de cada una
