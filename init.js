db = db.getSiblingDB('m165_quiz');

db.createUser({
  user: 'quiz_admin',
  pwd: 'werwirdmillionaer',
  roles: [
    {
      role: 'readWrite',
      db: 'm165_quiz',
    },
  ],
});

db.createCollection('questions');
db.createCollection('quiz');
db.createCollection('games');

db.quiz.insertMany([
  {
    "_id": "63877b982bd515acf41f4743",
    "name": "Software Engineer Quiz",
    "createdBy": "Noah G. (Nevah5)",
  },
]);
db.questions.insertMany([
  {
    "n": 1,
    "quizId": "63877b982bd515acf41f4743",
    "q": "What is VSC?",
    "a1": "Visual Slider Collision",
    "a2": "Very Silly Code",
    "a3": "Visual Studio Code",
    "a4": "Vamos Siuuuu Christiano",
    "c": 3,
  },
  {
    "n": 2,
    "quizId": "63877b982bd515acf41f4743",
    "q": "How many times should you commit?",
    "a1": "after every character",
    "a2": "after a small part of code",
    "a3": "every day",
    "a4": "after a feature or bugfix",
    "c": 4,
  },
  {
    "n": 3,
    "quizId": "63877b982bd515acf41f4743",
    "q": "PHP...",
    "a1": "...is a script-language.",
    "a2": "...is ran in the browser.",
    "a3": "...is barely used anymore.",
    "a4": "...is reactive.",
    "c": 1,
  },
  {
    "n": 4,
    "quizId": "63877b982bd515acf41f4743",
    "q": "MongoDB is like...",
    "a1": "...MariaDB.",
    "a2": "...Firebase Firestore.",
    "a3": "...SQL.",
    "a4": "...Financing.",
    "c": 1,
  },
  {
    "n": 14,
    "quizId": "63877b982bd515acf41f4743",
    "q": "What is the oldest programming language?",
    "a1": "Fortran",
    "a2": "Assembly",
    "a3": "C",
    "a4": "Cobol",
    "c": 2,
  },
  {
    "n": 15,
    "quizId": "63877b982bd515acf41f4743",
    "q": "When was the \"first appearance\" of Assembly?",
    "a1": "1950",
    "a2": "1944",
    "a3": "1947",
    "a4": "1965",
    "c": 3,
  },
]);