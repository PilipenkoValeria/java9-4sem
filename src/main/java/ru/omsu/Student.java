package ru.omsu;

import java.util.Objects;

    public class Student extends Human{
        private String university, faculty, specialty;

        public Student(String surname, String name, String patronymic, int age, Gender gender, String university, String faculty, String specialty) {
            super(surname, name, patronymic, age, gender);
            if(university == null || university.length() < 1 || faculty == null || faculty.length() < 1 ||
                    specialty == null || specialty.length() < 1){
                throw new IllegalArgumentException("Ошибка! Получены неверные данные");
            }
            this.university = university;
            this.faculty = faculty;
            this.specialty = specialty;
        }

        public Student(Student student) {
            super(student.getSurname(), student.getName(), student.getPatronymic(), student.getAge(), student.getGender());
            if(university == null || university.length() < 1 || faculty == null || faculty.length() < 1 ||
                    specialty == null || specialty.length() < 1){
                throw new IllegalArgumentException("Ошибка! Получены неверные данные");
            }
            this.university = student.getUniversity();
            this.faculty = student.getFaculty();
            this.specialty = student.getSpecialty();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "university='" + university + '\'' +
                    ", faculty='" + faculty + '\'' +
                    ", specialty='" + specialty + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Student student = (Student) o;
            return university.equals(student.university) &&
                    faculty.equals(student.faculty) &&
                    specialty.equals(student.specialty);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), university, faculty, specialty);
        }

        public String getUniversity() {
            return university;
        }

        public void setUniversity(String university) {
            this.university = university;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }
    }


