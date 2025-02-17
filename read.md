# Quiz API Documentation

## Base URL
```
http://localhost:8080/quiz
```

## 1. Get Quiz by ID
### Endpoint
```
GET /quiz/{id}
```
### Description
Retrieves a quiz by its ID.
### Path Parameter
| Name  | Type  | Description  |
|--------|------|-------------|
| `id` | Integer | ID of the quiz to fetch |

### Response Example (200 OK)
```json
{
  "quizId": 1,
  "title": "General Knowledge Quiz",
  "description": "Test your general knowledge skills",
  "createdAt": "2024-02-16T12:30:00",
  "user": {
    "userId": 1,
    "username": "john_doe",
    "email": "john@example.com"
  },
  "questions": [
    {
      "questionId": 1,
      "questionText": "Is Paris the capital of France?",
      "isCorrect": true
    }
  ],
  "categories": [
    {
      "categoryId": 1,
      "name": "General Knowledge",
      "description": "Quizzes that test general knowledge"
    }
  ]
}
```

### Possible Errors
| Status Code | Message |
|------------|---------|
| 404 Not Found | "Quiz not found" |

---

## 2. Create a Quiz
### Endpoint
```
POST /quiz
```
### Description
Creates a new quiz.
### Request Body
```json
{
  "userId": 1,
  "title": "Math Challenge",
  "description": "Solve interesting math problems",
  "questions": [
    {
      "questionText": "Is 2 + 2 = 4?",
      "isCorrect": true
    }
  ]
}
```

### Response Example (200 OK)
```
"Quizz has been created"
```

### Possible Errors
| Status Code | Message |
|------------|---------|
| 404 Not Found | "User not found" |
| 401 Unauthorized | "Login is required, please" |

---

## 3. Assign Categories to a Quiz
### Endpoint
```
POST /quiz/assign-categories
```
### Description
Assigns categories to a specific quiz.
### Request Body
```json
{
  "quizId": 1,
  "categoryIds": [1, 2]
}
```
### Response Example (200 OK)
```
"Categories assigned successfully to the quiz."
```
### Possible Errors
| Status Code | Message |
|------------|---------|
| 404 Not Found | "Quiz not found with ID: {quizId}" |
| 404 Not Found | "Category not found with ID: {categoryId}" |

---

## 4. Delete a Quiz
### Endpoint
```
DELETE /quiz/{quizId}
```
### Description
Deletes a quiz and all related categories and questions.
### Path Parameter
| Name  | Type  | Description  |
|--------|------|-------------|
| `quizId` | Integer | ID of the quiz to delete |

### Response Example (200 OK)
```
"Quiz deleted successfully."
```
### Possible Errors
| Status Code | Message |
|------------|---------|
| 404 Not Found | "Quiz not found with ID: {quizId}" |

---

## 5. Remove a Category from a Quiz
### Endpoint
```
DELETE /quiz/{quizId}/categories/{categoryId}
```
### Description
Removes a category from a quiz.
### Path Parameters
| Name  | Type  | Description  |
|--------|------|-------------|
| `quizId` | Integer | ID of the quiz |
| `categoryId` | Integer | ID of the category to remove |

### Response Example (200 OK)
```
"Quiz category deleted successfully."
```
### Possible Errors
| Status Code | Message |
|------------|---------|
| 404 Not Found | "Quiz not found with ID: {quizId}" |
| 404 Not Found | "Category not found with ID: {categoryId}" |
| 404 Not Found | "Category not associated with the quiz" |

---

## 6. Update a Quiz
### Endpoint
```
PUT /quiz/{quizId}
```
### Description
Updates quiz details like title or description.
### Path Parameter
| Name  | Type  | Description  |
|--------|------|-------------|
| `quizId` | Integer | ID of the quiz to update |

### Request Body Example
```json
{
  "title": "Updated Math Challenge",
  "description": "Updated description for the quiz"
}
```

### Response Example (200 OK)
```json
{
  "quizId": 1,
  "title": "Updated Math Challenge",
  "description": "Updated description for the quiz",
  "createdAt": "2024-02-16T12:30:00"
}
```
### Possible Errors
| Status Code | Message |
|------------|---------|
| 404 Not Found | "Quiz not found with ID: {quizId}" |