CREATE DATABASE SpringBasicMybatis;

CREATE TABLE tbStudents (
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone_number VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE tbInstructors (
   instructor_id SERIAL PRIMARY KEY,
   instructor_name VARCHAR(255) NOT NULL,
   email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE tbCourses (
   course_id SERIAL PRIMARY KEY,
   course_name VARCHAR(255) NOT NULL,
   description TEXT,
   instructor_id INT,
   CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) REFERENCES tbInstructors(instructor_id) ON DELETE SET NULL
);

CREATE TABLE tbStudent_Course (
  id SERIAL PRIMARY KEY,
  student_id INT NOT NULL,
  course_id INT NOT NULL,
  CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES tbStudents(student_id) ON DELETE CASCADE,
  CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES tbCourses(course_id) ON DELETE CASCADE,
  CONSTRAINT unique_student_course UNIQUE (student_id, course_id)
);
