# Clinica Management System
 El Clinica Management System es una aplicación Java diseñada para gestionar la información y procesos de una clínica médica. Este sistema permite la gestión eficiente de datos de cirugías, consultas, doctores, pacientes, familiares, ingresos, y reservas. También incluye la funcionalidad para conectar y operar con una base de datos PostgreSQL.
Características

    Gestión de Cirugías: Registro de cirugías, incluyendo detalles como fecha, hora de inicio, hora de fin, y el doctor responsable.
    Gestión de Consultas: Registro y consulta de detalles de consultas médicas, incluyendo fecha de consulta, doctor responsable, y observaciones.
    Gestión de Doctores: Almacenamiento de información sobre doctores, incluyendo especialidades, costo de consulta y total cobrado.
    Gestión de Pacientes: Registro de datos de pacientes, incluyendo información de aseguradora, alergias y número de seguro.
    Gestión de Familiares: Registro de información de familiares de pacientes, incluyendo parentesco y detalles de contacto.
    Gestión de Ingresos: Registro y gestión de ingresos hospitalarios, incluyendo fechas de entrada y salida, motivo y costos de internación.
    Gestión de Reservas: Registro de reservas médicas, incluyendo fechas de reserva y captura, doctor y paciente asociados, y observaciones.
    Conexión a Base de Datos: Funcionalidad para conectar con una base de datos PostgreSQL, facilitando la persistencia y consulta de datos.

Estructura del Proyecto

El proyecto está estructurado en diferentes paquetes para una mejor organización:

    dto.Tablas: Contiene las clases DTO (Data Transfer Object) para las distintas entidades del sistema.
    conectar: Contiene la clase Conexion para manejar la conexión a la base de datos PostgreSQL.

Instalación y Uso

    Clonar el repositorio:

    bash

    git clone https://github.com/MatMont01/Clinica-Management-System.git

    Configurar la base de datos PostgreSQL con las credenciales apropiadas.
    Ejecutar la aplicación desde tu entorno de desarrollo Java preferido.

Requisitos del Sistema

    Java JDK 8 o superior
    PostgreSQL 9.5 o superior
