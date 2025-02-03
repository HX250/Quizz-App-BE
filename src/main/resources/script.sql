USE QuizApp;

DROP TABLE IF EXISTS quiz_categories;
DROP TABLE IF EXISTS quiz_completions;
DROP TABLE IF EXISTS questions;
DROP TABLE IF EXISTS quizzes;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       user_id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(191) NOT NULL UNIQUE,
                       email VARCHAR(191) NOT NULL UNIQUE,
                       password VARCHAR(191) NOT NULL
);

CREATE TABLE categories (
                            category_id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(191) NOT NULL UNIQUE,
                            description TEXT
);

CREATE TABLE quizzes (
                         quiz_id INT AUTO_INCREMENT PRIMARY KEY,
                         user_id INT NOT NULL,
                         title VARCHAR(191) NOT NULL,
                         description TEXT,
                         created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE quiz_categories (
                                 quiz_id INT NOT NULL,
                                 category_id INT NOT NULL,
                                 PRIMARY KEY (quiz_id, category_id),
                                 FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id) ON DELETE CASCADE,
                                 FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE
);

CREATE TABLE questions (
                           question_id INT AUTO_INCREMENT PRIMARY KEY,
                           quiz_id INT NOT NULL,
                           question_text TEXT NOT NULL,
                           isCorrect BOOLEAN,
                           FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id) ON DELETE CASCADE
);

CREATE TABLE quiz_completions (
                                  completion_id INT AUTO_INCREMENT PRIMARY KEY,
                                  user_id INT NOT NULL,
                                  quiz_id INT NOT NULL,
                                  score INT,
                                  completed_at DATETIME DEFAULT CURRENT_TIMESTAMP,
                                  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                                  FOREIGN KEY (quiz_id) REFERENCES quizzes(quiz_id) ON DELETE CASCADE
);

INSERT INTO users (username, email, password) VALUES
                                                  ('john_doe', 'john@example.com', 'password123'),
                                                  ('jane_smith', 'jane@example.com', 'securepass'),
                                                  ('alice_jones', 'alice@example.com', 'mypassword');

INSERT INTO categories (name, description) VALUES
                                               ('General Knowledge', 'Quizzes that test general knowledge'),
                                               ('Mathematics', 'Math-related quizzes'),
                                               ('Science', 'Science-related quizzes');

INSERT INTO quizzes (user_id, title, description) VALUES
                                                      (1, 'General Knowledge Quiz', 'Test your general knowledge skills'),
                                                      (2, 'Math Challenge', 'Solve interesting math problems'),
                                                      (3, 'Science Quiz', 'Check your science knowledge');

INSERT INTO quiz_categories (quiz_id, category_id) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 2),
                                                       (3, 3);

INSERT INTO questions (quiz_id, question_text, isCorrect) VALUES
                                                              (1, 'What is the capital of France?', TRUE),
                                                              (1, 'Is the Earth flat?', FALSE),
                                                              (2, 'What is 2 + 2?', TRUE),
                                                              (3, 'Does water boil at 100 degrees Celsius?', TRUE);

INSERT INTO quiz_completions (user_id, quiz_id, score) VALUES
                                                           (1, 1, 80),
                                                           (2, 2, 90),
                                                           (3, 3, 85);