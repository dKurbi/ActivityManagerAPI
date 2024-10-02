# README - Activity Manager API

## Idiomas / Languages

- [English](#english-version)
- [Català](#versió-en-català)
- [Español](#versión-en-español)

---

## English Version

### Introduction

The **Activity Manager API** allows for the management of users and activities. This API provides endpoints to create, update, delete, and retrieve users and activities, and to assign users to activities.

### Features

- User management (CRUD operations).
- Activity management (CRUD operations).
- Assign users to activities with validation for capacity and user registration.
- Full integration with Postman collection to test the API.

### Prerequisites

- Java 17 or later
- Maven
- Postman

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/activity-manager-api.git
   cd activity-manager-api
   ```

2. Install dependencies:

   ```mvn clean install```

### Running the Application

To run the application locally, use the following command:

```
mvn spring-boot:run
```

### API Endpoints

| Method | Endpoint                         | Description                           |
|--------|----------------------------------|---------------------------------------|
| GET    | `/api/users`                     | Retrieve all users                    |
| GET    | `/api/users/{id}`                | Retrieve a user by ID                 |
| POST   | `/api/users`                     | Create a new user                     |
| PUT    | `/api/users/{id}`                | Update an existing user               |
| DELETE | `/api/users/{id}`                | Delete a user by ID                   |
| GET    | `/api/activities`                | Retrieve all activities               |
| GET    | `/api/activities/{id}`           | Retrieve an activity by ID            |
| POST   | `/api/activities`                | Create a new activity                 |
| DELETE | `/api/activities/{id}`           | Delete an activity by ID              |
| POST   | `/api/users/{userId}/activities/{activityId}` | Add a user to an activity   |
| DELETE | `/api/users/{userId}/activities/{activityId}` | Remove a user from an activity |

---

## Versió en Català

### Introducció

L'**Activity Manager API** permet la gestió d'usuaris i activitats. Aquesta API proporciona punts finals per crear, actualitzar, eliminar i recuperar usuaris i activitats, així com per assignar usuaris a activitats.

### Funcions

- Gestió d'usuaris (operacions CRUD).
- Gestió d'activitats (operacions CRUD).
- Assignar usuaris a activitats amb validació de capacitat i registre d'usuaris.
- Integració completa amb col·lecció Postman per provar l'API.

### Prerequisits

- Java 17 o posterior
- Maven
- Postman

### Instal·lació

1. Clona aquest repositori:

   ```bash
   git clone https://github.com/your-username/activity-manager-api.git
   cd activity-manager-api
   ```

2. Instal·la les dependències:

   ```mvn clean install```

### Executar l'aplicació

Per executar l'aplicació localment, fes servir la següent comanda:

```
mvn spring-boot:run
```

### Punts finals de l'API

| Mètode | Punts finals                     | Descripció                             |
|--------|----------------------------------|----------------------------------------|
| GET    | `/api/users`                     | Recuperar tots els usuaris             |
| GET    | `/api/users/{id}`                | Recuperar un usuari per ID             |
| POST   | `/api/users`                     | Crear un nou usuari                    |
| PUT    | `/api/users/{id}`                | Actualitzar un usuari existent         |
| DELETE | `/api/users/{id}`                | Eliminar un usuari per ID              |
| GET    | `/api/activities`                | Recuperar totes les activitats         |
| GET    | `/api/activities/{id}`           | Recuperar una activitat per ID         |
| POST   | `/api/activities`                | Crear una nova activitat               |
| DELETE | `/api/activities/{id}`           | Eliminar una activitat per ID          |
| POST   | `/api/users/{userId}/activities/{activityId}` | Afegir un usuari a una activitat |
| DELETE | `/api/users/{userId}/activities/{activityId}` | Treure un usuari d'una activitat |

---

## Versión en Español

### Introducción

La **Activity Manager API** permite la gestión de usuarios y actividades. Esta API proporciona endpoints para crear, actualizar, eliminar y recuperar usuarios y actividades, así como para asignar usuarios a actividades.

### Funcionalidades

- Gestión de usuarios (operaciones CRUD).
- Gestión de actividades (operaciones CRUD).
- Asignar usuarios a actividades con validación de capacidad y registro de usuarios.
- Integración completa con la colección Postman para probar la API.

### Requisitos

- Java 17 o posterior
- Maven
- Postman

### Instalación

1. Clona este repositorio:

   ```bash
   git clone https://github.com/your-username/activity-manager-api.git
   cd activity-manager-api
   ```

2. Instala las dependencias:

   ```mvn clean install```

### Ejecutar la Aplicación

Para ejecutar la aplicación localmente, usa el siguiente comando:

```
mvn spring-boot:run
```

### Endpoints de la API

| Método | Endpoint                         | Descripción                            |
|--------|----------------------------------|----------------------------------------|
| GET    | `/api/users`                     | Recuperar todos los usuarios           |
| GET    | `/api/users/{id}`                | Recuperar un usuario por ID            |
| POST   | `/api/users`                     | Crear un nuevo usuario                 |
| PUT    | `/api/users/{id}`                | Actualizar un usuario existente        |
| DELETE | `/api/users/{id}`                | Eliminar un usuario por ID             |
| GET    | `/api/activities`                | Recuperar todas las actividades        |
| GET    | `/api/activities/{id}`           | Recuperar una actividad por ID         |
| POST   | `/api/activities`                | Crear una nueva actividad              |
| DELETE | `/api/activities/{id}`           | Eliminar una actividad por ID          |
| POST   | `/api/users/{userId}/activities/{activityId}` | Añadir un usuario a una actividad  |
| DELETE | `/api/users/{userId}/activities/{activityId}` | Eliminar un usuario de una actividad |

```
