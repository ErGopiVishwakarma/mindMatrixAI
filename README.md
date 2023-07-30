# MindMatrix - AI-Powered Interview Mastery Platform <p> <img src="logo.png" alt="Project Logo" width="160" style="border: 1px solid black; border-radius: 10px;"> </p>

Welcome to MindMatrix, an AI-Powered Interview Mastery platform! This innovative platform is designed to help students practice for job interviews by simulating real interview scenarios and providing personalized feedback. With the magic of AI and language processing, students can improve their interview skills, build confidence, and increase their chances of success during real interviews.

## Key Features

### Interview Simulator

MindMatrix allows students to have realistic conversations with an AI using the powerful [OpenAI API](https://openai.com/product#made-for-developers). Students can choose the type of interview they want to practice, such as MERN, Node, or Java, and receive a series of relevant questions. The AI will dynamically generate questions and adapt its tone and style of questioning based on the selected interview type, making the practice sessions more engaging and tailored to the student's needs.

### Personalized Feedback

Our AI system analyzes students' interview responses and provides constructive feedback. The feedback evaluates the content, delivery, and overall performance of the student's answers. It highlights the student's strengths and suggests areas for improvement, such as communication skills, technical knowledge, or problem-solving abilities. This valuable feedback helps students identify their weaknesses and work on enhancing their skills.

### User-Friendly Interface

We have designed a user-friendly web interface that is intuitive, visually appealing, and easy to navigate. The platform provides a seamless experience for users, allowing them to focus on their interview preparation without any technical issues. The interface is built using React with TypeScript for the frontend and styled with Tailwind CSS.

## Tech Stack

- Frontend: React with TypeScript, Tailwind CSS
- Backend: Java Spring Boot with MySQL
- OpenAI Integration: [OpenAI API](https://openai.com/) for dynamic question generation and responses
- Data Visualization and Insights: Charts (optional)

## Team Members

We have a talented team of 3 members working on this project:

1. [Akhtar Ansari](https://github.com/akhtaransari) - Backend (Java Spring Boot with MySQL)
2. [Gopi Vishwakarma](https://github.com/ErGopiVishwakarma) - Frontend (React with TypeScript, Tailwind CSS)
3. [Sharvari Hupare](https://github.com/sharvarihupare-369) - Frontend (React with TypeScript, Tailwind CSS)


## Setup Instructions

1. Clone the repository: `git clone [repository_url]`
2. Install dependencies for frontend: `cd frontend && npm install`
3. Install dependencies for backend: `cd backend && mvn install`
4. Start the frontend development server: `npm start`
5. Start the backend server: `mvn spring-boot:run`
6. Access the platform in your web browser at: `http://localhost:3000`

## Presentation

Our team will present the MindMatrix - AI-Powered Interview Mastery platform on Monday, 31st July. We will demonstrate the key features, the technology used, and the overall flow of the platform. We look forward to showcasing our hard work and receiving valuable feedback.

Let's unlock the potential of AI in interview preparation and help students excel in their careers! Thank you for your attention.


# ER Diagram and Relations Explanation

## Introduction
This document explains the Entity-Relationship (ER) diagram and the relations between tables in the provided database schema. The database contains three tables: `users`, `chat`, and `conversations`. These tables represent various aspects of a chat application where users can have conversations with bots. Let's explore each table and its relations in detail:

## Tables

### 1. Table `users`
This table stores information about registered users of the chat application.

Attributes:
- `user_id` (integer, primary key): Unique identifier for each user.
- `chat_id` (integer): A reference to the chat the user is currently engaged in.
- `email` (varchar): The email address of the user.
- `name` (varchar): The name of the user.
- `password` (varchar): The password associated with the user account.

### 2. Table `chat`
This table contains information about chat sessions between users and bots.

Attributes:
- `chat_id` (integer, primary key): Unique identifier for each chat session.
- `user_id` (integer): A reference to the user participating in the chat.
- `conversations_id` (integer): A reference to the conversation associated with this chat.
- `difficulty_level` (varchar): Indicates the difficulty level of the chat, likely related to the complexity of the conversation.
- `industry_type` (varchar): The industry type or domain of the conversation (e.g., finance, technology, healthcare).
- `interview_mode` (varchar): Represents the mode of the chat, possibly indicating if it's an interview simulation.
- `job_role` (varchar): The job role associated with the conversation, if applicable.
- `recommendation` (enum): A field that likely stores a predefined set of values representing recommendations related to the chat.
- `score` (integer): An integer value representing the score or rating of the chat.

### 3. Table `conversations`
This table stores individual conversations between users and bots within a chat.

Attributes:
- `chat_id` (integer): A reference to the chat session in which the conversation took place.
- `user_id` (integer): A reference to the user involved in the conversation.
- `conversations_id` (integer): Unique identifier for each conversation within a chat.
- `botResponse` (varchar): The response generated by the bot during the conversation.
- `userResponse` (varchar): The response provided by the user during the conversation.

## Relations

### Relationship 1: users.chat_id < chat.chat_id
This relationship signifies that a user can be associated with multiple chat sessions, but each chat session can be linked to only one user. It establishes a one-to-many relationship between the `users` and `chat` tables using the `chat_id` attribute.

### Relationship 2: chat.conversations_id < conversations.conversations_id
This relationship represents that a chat can have multiple conversations, but each conversation belongs to only one chat. It creates a one-to-many relationship between the `chat` and `conversations` tables using the `conversations_id` attribute.

## Conclusion
The provided ER diagram and database schema represent a chat application where users can engage in chat sessions with bots. The `users` table stores user information, the `chat` table stores information about chat sessions, and the `conversations` table stores the individual conversations within those chat sessions. The relationships between tables establish the connections between users, chat sessions, and conversations, allowing for efficient querying and management of chat-related data.


## ERDiagram <p> <img src="logo.png" alt="Project Logo" width="160" style="border: 1px solid black; border-radius: 10px;"> </p>
