# Todo Management API
A comprehensive RESTful API built with Spring Boot to manage Todo items.
This project has evolved from simple CRUD operations to include advanced features like 
**File/Image Handling**, **Date Management**, and a  **Centralized Error Handling**
mechanism using custom response wrappers.

## 🛠 Technologies Used
Language: Java 17
Framework: Spring Boot 3+
Build Tool: Maven
Testing: Postman
Data Handling: Jackson (JSON), MultipartFile (File Uploads)

##  Key Features

### 1. Core Todo Management (CRUD)
Create: Add new tasks with descriptions and target dates.
Read: Fetch all tasks or find specific ones by ID.
Update: Modify existing task details.
Delete: Remove completed or unwanted tasks.

### 2.  Advanced File Handling
Image/File Upload: Support for uploading multiple images or files associated with a Todo item.
File Retrieval: Endpoints to download or view uploaded images.


### 3. Global Error Handling 
Global Exception Handler: Implemented @ControllerAdvice to catch errors across the entire application in one place.
Custom Exceptions:
ResourceNotFoundException (Runtime) triggers when info are invalid.
Custom Error Response:
custom exception  return a consistent Custom Response Object (JSON).

##  API Endpoints

## 1.Todo Operations
POST /todos/add : Creates a new Todo item.
GET /todos/fullList : Retrieves the complete list of Todos.
GET /todos/single/{id} : Fetches a specific Todo by ID.
PUT /todos/update/{id} : Updates an existing Todo.
DELETE /todos/delete/{id} : Deletes a Todo by ID.
## 2.File Operations
POST /file/singleUpload : Uploads a single file (form-data key: image).
POST /file/multiple : Uploads multiple files (form-data key: files).
GET /file/getImage : Downloads/Views the hardcoded example image.
GET /file/getFile : Downloads/Views the hardcoded example PDF.

## ⚙️ How to Run
Clone the repository.
Open the project in IntelliJ IDEA.
Let Maven download dependencies.
Run TodoApplication.java.
The API will start at http://localhost:9090.