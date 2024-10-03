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

###  **Data Models**

This section explains the data models used in the API, including the attributes of each model and any auditing attributes that are present in entities but absent in the DTOs.

##### **Activity Model (`Activity`)**

The `Activity` model represents an activity that users can register for. The model includes the following attributes:

- `activityId`: Unique identifier for the activity.
- `name`: Name of the activity (required, max 50 characters).
- `description`: Optional description (max 200 characters).
- `maxCapacity`: The maximum number of participants allowed for the activity.
- `users`: A list of users who are registered for the activity.

###### **Auditing Attributes**:
- `createdAt`: The date and time when the activity was created.
- `updatedAt`: The date and time when the activity was last updated.

##### **User Model (`User`)**

The `User` model represents a user who can register for activities. It includes the following attributes:

- `userId`: Unique identifier for the user.
- `name`: The user’s first name (required, max 50 characters).
- `surname`: The user’s last name (required, max 50 characters).
- `birthDate`: The user’s birth date.
- `email`: The user’s email address (unique, required).

###### **Auditing Attributes**:
- `createdAt`: The date and time when the user was created.
- `updatedAt`: The date and time when the user was last updated.


### **Error Handling and Exceptions**

The API handles various exceptions and errors, providing meaningful messages and proper HTTP status codes.

##### **Global Exception Handler**

The API uses a global exception handler to capture and handle exceptions across all endpoints. Here are some key exceptions:

1. **ActivityNotFoundException**:
   - **Description**: Thrown when an activity is not found.
   - **HTTP Status**: 404 Not Found
   - **Message**: "Activity with ID {id} not found."

2. **UserNotFoundException**:
   - **Description**: Thrown when a user is not found.
   - **HTTP Status**: 404 Not Found
   - **Message**: "User with ID {id} not found."

3. **EmailAlreadyExistsException**:
   - **Description**: Thrown when a user tries to register with an email that already exists in the system.
   - **HTTP Status**: 409 Conflict
   - **Message**: "Email {email} already exists."

4. **ActivityFullException**:
   - **Description**: Thrown when trying to add a user to an activity that has reached its maximum capacity.
   - **HTTP Status**: 409 Conflict
   - **Message**: "Activity {name} is full."

5. **UserAlreadyRegisteredException**:
   - **Description**: Thrown when a user is already registered for a particular activity.
   - **HTTP Status**: 409 Conflict
   - **Message**: "User {name} is already registered for activity {activityName}."

6. **UserNotRegisteredException**:
   - **Description**: Thrown when a user is not registered for a particular activity.
   - **HTTP Status**: 409 Conflict
   - **Message**: "User {name} is not registered in activity {activityName}."

##### **Validation Handler**

For validation errors, the API provides detailed messages using a custom validation handler:

- **MethodArgumentNotValidException**:
   - **HTTP Status**: 400 Bad Request
   - **Description**: Thrown when a request body fails validation.
   - **Response**: A JSON map with the field name as the key and the validation error message as the value.

- **HttpMessageNotReadableException**:
   - **HTTP Status**: 400 Bad Request
   - **Description**: Thrown when the request body is unreadable or contains formatting issues (e.g., incorrect date format).
   - **Response**: A message indicating the error, such as "Invalid input format. Please check the date format or input structure."

### Postman Collection

To test the API, a Postman collection is provided. Follow these steps to import and use it:

1. Download the [`Activity_Manager_API.postman_collection.json`](https://github.com/dKurbi/ActivityManagerAPI/blob/main/postman/Activity_Manager_API.postman_collection.json) file from the `/postman` directory of this repository.
2. Open Postman.
3. Click on **Import**.
4. Select the downloaded `.json` file and import it.
5. Once imported, you can test all the API endpoints provided in the collection.

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


### **Models de dades**

Aquesta secció explica els models de dades utilitzats en l'API, inclosos els atributs de cada model i els atributs d'auditoria que són presents a les entitats però absents als DTO.

##### **Model d'Activitat (`Activity`)**

El model `Activity` representa una activitat on els usuaris es poden registrar. El model inclou els següents atributs:

- `activityId`: Identificador únic per a l'activitat.
- `name`: Nom de l'activitat (obligatori, màxim 50 caràcters).
- `description`: Descripció opcional (màxim 200 caràcters).
- `maxCapacity`: El nombre màxim de participants permès per a l'activitat.
- `users`: Una llista d'usuaris registrats per a l'activitat.

###### **Atributs d'auditoria**:
- `createdAt`: La data i l'hora de creació de l'activitat.
- `updatedAt`: La data i l'hora de l'última actualització de l'activitat.

##### **Model d'Usuari (`User`)**

El model `User` representa un usuari que es pot registrar a les activitats. Inclou els següents atributs:

- `userId`: Identificador únic per a l'usuari.
- `name`: Nom de l'usuari (obligatori, màxim 50 caràcters).
- `surname`: Cognom de l'usuari (obligatori, màxim 50 caràcters).
- `birthDate`: Data de naixement de l'usuari.
- `email`: Correu electrònic de l'usuari (únic, obligatori).

###### **Atributs d'auditoria**:
- `createdAt`: La data i l'hora de creació de l'usuari.
- `updatedAt`: La data i l'hora de l'última actualització de l'usuari.


### **Gestió d'errors i excepcions**

L'API gestiona diverses excepcions i errors, proporcionant missatges significatius i codis d'estat HTTP adequats.

##### **Gestor global d'excepcions**

L'API utilitza un gestor global d'excepcions per capturar i gestionar excepcions a tots els punts finals. A continuació es detallen algunes excepcions clau:

1. **ActivityNotFoundException**:
    - **Descripció**: Llançada quan no es troba una activitat.
    - **Estat HTTP**: 404 Not Found
    - **Missatge**: "Activity with ID {id} not found."

2. **UserNotFoundException**:
    - **Descripció**: Llançada quan no es troba un usuari.
    - **Estat HTTP**: 404 Not Found
    - **Missatge**: "User with ID {id} not found."

3. **EmailAlreadyExistsException**:
    - **Descripció**: Llançada quan un usuari intenta registrar-se amb un correu electrònic que ja existeix al sistema.
    - **Estat HTTP**: 409 Conflict
    - **Missatge**: "Email {email} already exists."

4. **ActivityFullException**:
    - **Descripció**: Llançada quan s'intenta afegir un usuari a una activitat que ha arribat a la seva capacitat màxima.
    - **Estat HTTP**: 409 Conflict
    - **Missatge**: "Activity {name} is full."

5. **UserAlreadyRegisteredException**:
    - **Descripció**: Llançada quan un usuari ja està registrat per a una activitat concreta.
    - **Estat HTTP**: 409 Conflict
    - **Missatge**: "User {name} is already registered for activity {activityName}."

6. **UserNotRegisteredException**:
    - **Descripció**: Llançada quan un usuari no està registrat per a una activitat concreta.
    - **Estat HTTP**: 409 Conflict
    - **Missatge**: "User {name} is not registered in activity {activityName}."


##### **Gestor de validacions**

Per a errors de validació, l'API proporciona missatges detallats utilitzant un gestor de validacions personalitzat:

- **MethodArgumentNotValidException**:
    - **Estat HTTP**: 400 Bad Request
    - **Descripció**: Llançada quan un cos de sol·licitud no compleix la validació.
    - **Resposta**: Un mapa JSON amb el nom del camp com a clau i el missatge d'error de validació com a valor.

- **HttpMessageNotReadableException**:
    - **Estat HTTP**: 400 Bad Request
    - **Descripció**: Llançada quan el cos de la sol·licitud és il·legible o conté problemes de format (per exemple, format de data incorrecte).
    - **Resposta**: Un missatge indicant l'error, com ara "Invalid input format. Please check the date format or input structure."

### Col·lecció de Postman

Per provar l'API, es proporciona una col·lecció de Postman. Segueix aquests passos per importar-la i utilitzar-la:

1. Descarrega l'arxiu [`Activity_Manager_API.postman_collection.json`](https://github.com/dKurbi/ActivityManagerAPI/blob/main/postman/Activity_Manager_API.postman_collection.json) del directori `/postman` d'aquest repositori.
2. Obre Postman.
3. Fes clic a **Importar**.
4. Selecciona l'arxiu `.json` descarregat i importa'l.
5. Un cop importat, pots provar tots els punts finals de l'API inclosos a la col·lecció.

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


### **Modelos de datos**

Esta sección explica los modelos de datos utilizados en la API, incluidos los atributos de cada modelo y los atributos de auditoría que están presentes en las entidades pero ausentes en los DTO.

##### **Modelo de Actividad (`Activity`)**

El modelo `Activity` representa una actividad en la que los usuarios pueden registrarse. El modelo incluye los siguientes atributos:

- `activityId`: Identificador único para la actividad.
- `name`: Nombre de la actividad (obligatorio, máximo 50 caracteres).
- `description`: Descripción opcional (máximo 200 caracteres).
- `maxCapacity`: El número máximo de participantes permitidos para la actividad.
- `users`: Una lista de usuarios registrados para la actividad.

###### **Atributos de auditoría**:
- `createdAt`: La fecha y hora de creación de la actividad.
- `updatedAt`: La fecha y hora de la última actualización de la actividad.

##### **Modelo de Usuario (`User`)**

El modelo `User` representa un usuario que puede registrarse en actividades. Incluye los siguientes atributos:

- `userId`: Identificador único para el usuario.
- `name`: Nombre del usuario (obligatorio, máximo 50 caracteres).
- `surname`: Apellido del usuario (obligatorio, máximo 50 caracteres).
- `birthDate`: Fecha de nacimiento del usuario.
- `email`: Correo electrónico del usuario (único, obligatorio).

###### **Atributos de auditoría**:
- `createdAt`: La fecha y hora de creación del usuario.
- `updatedAt`: La fecha y hora de la última actualización del usuario.


### **Gestión de errores y excepciones**

La API maneja varias excepciones y errores, proporcionando mensajes significativos y códigos de estado HTTP adecuados.

##### **Manejador global de excepciones**

La API utiliza un manejador global de excepciones para capturar y manejar excepciones en todos los endpoints. A continuación se muestran algunas excepciones clave:

1. **ActivityNotFoundException**:
    - **Descripción**: Se lanza cuando no se encuentra una actividad.
    - **Estado HTTP**: 404 Not Found
    - **Mensaje**: "Activity with ID {id} not found."

2. **UserNotFoundException**:
    - **Descripción**: Se lanza cuando no se encuentra un usuario.
    - **Estado HTTP**: 404 Not Found
    - **Mensaje**: "User with ID {id} not found."

3. **EmailAlreadyExistsException**:
    - **Descripción**: Se lanza cuando un usuario intenta registrarse con un correo electrónico que ya existe en el sistema.
    - **Estado HTTP**: 409 Conflict
    - **Mensaje**: "Email {email} already exists."

4. **ActivityFullException**:
    - **Descripción**: Se lanza cuando se intenta añadir un usuario a una actividad que ha alcanzado su capacidad máxima.
    - **Estado HTTP**: 409 Conflict
    - **Mensaje**: "Activity {name} is full."

5. **UserAlreadyRegisteredException**:
    - **Descripción**: Se lanza cuando un usuario ya está registrado en una actividad en particular.
    - **Estado HTTP**: 409 Conflict
    - **Mensaje**: "User {name} is already registered for activity {activityName}."

6. **UserNotRegisteredException**:
    - **Descripción**: Se lanza cuando un usuario no está registrado en una actividad en particular.
    - **Estado HTTP**: 409 Conflict
    - **Mensaje**: "User {name} is already registered for activity {activityName}."

##### **Manejador de validaciones**

Para errores de validación, la API proporciona mensajes detallados utilizando un manejador de validaciones personalizado:

- **MethodArgumentNotValidException**:
    - **Estado HTTP**: 400 Bad Request
    - **Descripción**: Se lanza cuando el cuerpo de una solicitud no pasa la validación.
    - **Respuesta**: Un mapa JSON con el nombre del campo como clave y el mensaje de error de validación como valor.

- **HttpMessageNotReadableException**:
    - **Estado HTTP**: 400 Bad Request
    - **Descripción**: Se lanza cuando el cuerpo de la solicitud no se puede leer o contiene problemas de formato (por ejemplo, formato de fecha incorrecto).
    - **Respuesta**: Un mensaje indicando el error, como "Invalid input format. Please check the date format or input structure."

### Colección de Postman

Para probar la API, se proporciona una colección de Postman. Sigue estos pasos para importarla y usarla:

1. Descarga el archivo [`Activity_Manager_API.postman_collection.json`](https://github.com/dKurbi/ActivityManagerAPI/blob/main/postman/Activity_Manager_API.postman_collection.json) del directorio `/postman` de este repositorio.
2. Abre Postman.
3. Haz clic en **Importar**.
4. Selecciona el archivo `.json` descargado e impórtalo.
5. Una vez importado, puedes probar todos los endpoints de la API incluidos en la colección.
```
