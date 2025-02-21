# API Documentation for Quiz Management System

## Base URL
```
https://quiz-app-fsfnbuf8dcgwaghk.canadacentral-01.azurewebsites.net
```

## **1. Quiz Management API**

### **1.1 Get Quiz by ID**
- **Endpoint:** `GET /api/quiz/{id}`
- **Description:** Retrieves a quiz by its unique ID.
- **Path Parameters:**
    - `id` (Integer): The unique ID of the quiz.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** `QuizDTO` object containing quiz details.
- **Example Response:**
```json
{
  "quizId": 1,
  "title": "Sample Quiz",
  "description": "This is a sample quiz.",
  "createdAt": "2025-02-17T10:00:00",
  "user": {
    "userId": 1,
    "username": "john_doe",
    "email": "john@example.com"
  },
  "questions": [
    {
      "questionText": "What is 2+2?",
      "isCorrect": true
    }
  ],
  "categories": [
    {
      "categoryId": 1,
      "categoryName": "Mathematics"
    }
  ]
}
```

### **1.2 Create a Quiz**
- **Endpoint:** `POST /api/quiz`
- **Description:** Creates a new quiz.
- **Request Body:**
```json
{
  "userId": 1,
  "title": "New Quiz",
  "description": "Description of the new quiz",
  "questions": [
    {
      "questionText": "What is 3+3?",
      "isCorrect": true
    }
  ]
}
```
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** `"Quiz has been created"`
    - **Error Responses:**
        - `404 NOT FOUND`: If the user is not found.
        - `401 UNAUTHORIZED`: If the user is not logged in.
        - `500 INTERNAL SERVER ERROR`: For unexpected issues.

### **1.3 Assign Categories to Quiz**
- **Endpoint:** `POST /api/quiz/assign-categories`
- **Description:** Assigns categories to a quiz.
- **Request Body:**
```json
{
  "quizId": 1,
  "categoryIds": [1, 2]
}
```
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** `"Categories assigned successfully to the quiz."`

### **1.4 Delete a Quiz**
- **Endpoint:** `DELETE /api/quiz/{quizId}`
- **Description:** Deletes a quiz by its unique ID.
- **Path Parameters:**
    - `quizId` (Integer): The unique ID of the quiz.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** `"Quiz deleted successfully."`

### **1.5 Delete a Category from Quiz**
- **Endpoint:** `DELETE /api/quiz/{quizId}/categories/{categoryId}`
- **Description:** Removes a category from a quiz.
- **Path Parameters:**
    - `quizId` (Integer): The unique ID of the quiz.
    - `categoryId` (Integer): The unique ID of the category.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** `"Quiz category deleted successfully."`

### **1.6 Update a Quiz**
- **Endpoint:** `PUT /api/quiz/{quizId}`
- **Description:** Updates the title and description of an existing quiz.
- **Path Parameters:**
    - `quizId` (Integer): The unique ID of the quiz to be updated.
- **Request Body:**
```json
{
  "title": "Updated Quiz Title",
  "description": "Updated description for the quiz"
}
```
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** The updated `Quiz` object.

## **2. Authentication API**

### **2.1 User Registration**
- **Endpoint:** `POST /api/auth/register`
- **Description:** Registers a new user.
- **Request Body:**
```json
{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "securepassword"
}
```
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** `{}`

### **2.2 User Login**
- **Endpoint:** `POST /api/auth/login`
- **Description:** Authenticates an existing user.
- **Request Body:**
```json
{
  "email": "john@example.com",
  "password": "securepassword"
}
```
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

## **3. Test API**

### **3.1 Connection Test**
- **Endpoint:** `GET /api/test`
- **Description:** Tests the API connection.
- **Response:**
    - **Status Code:** `200 OK`
    - **Body:** `"Connection works"`

## **4. Error Handling**
- **404 NOT FOUND:** If the requested resource (quiz or category) is not found.
- **401 UNAUTHORIZED:** If the user is not logged in or authorized.
- **500 INTERNAL SERVER ERROR:** For unexpected errors or internal issues.
