package model;

public class University {
    private String name;
    private Faculty[] faculties;

    public University(String name, Faculty[] faculties) {
        this.name = name;
        this.faculties = faculties;
    }

}

 class Faculty {
    private String name;
    private Department[] departments;

    public Faculty(String name, Department[] departments) {
        this.name = name;
        this.departments = departments;
    }


}

 class Department {
    private String name;
    private Group[] groups;

    public Department(String name, Group[] groups) {
        this.name = name;
        this.groups = groups;
    }


}

 class Group {
    private String name;
    private Student[] students;

    public Group(String name, Student[] students) {
        this.name = name;
        this.students = students;
    }


}

class Student {
    private String name;
    private Human human;

    public Student(String name, Human human) {
        this.name = name;
        this.human = human;
    }


}

class Human {
    private String firstName;
    private String lastName;
    private String parentage;
    private Sex gender;

    public Human(String firstName, String lastName, String parentage, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.parentage = parentage;
        this.gender = gender;
    }


}

 enum Sex {
    MALE,
    FEMALE
}

package controller;

import model.*;

public class UniversityCreator {
    public University createTypicalUniversity() {
        // створювати учнів
        StudentCreator studentCreator = new StudentCreator();
        Student[] students = new Student[10];
        for (int i = 0; i < 10; i++) {
            students[i] = studentCreator.createStudent("Student " + i, new Human("John", "Doe", "Mary", Sex.MALE));
        }

        // створювати групи
        GroupCreator groupCreator = new GroupCreator();
        Group[] groups = new Group[3];
        for (int i = 0; i < 3; i++) {
            groups[i] = groupCreator.createGroup("Group " + i, students);
        }

        // створювати відділи
        DepartmentCreator departmentCreator = new DepartmentCreator();
        Department[] departments = new Department[2];
        departments[0] = departmentCreator.createDepartment("Department 1", new Group[]{groups[0]});
        departments[1] = departmentCreator.createDepartment("Department 2", new Group[]{groups[1], groups[2]});

        // створювати факультети
        FacultyCreator facultyCreator = new FacultyCreator();
        Faculty[] faculties = new Faculty[1];
        faculties[0] = facultyCreator.createFaculty("Faculty 1", departments);

        // створити університет
        return new University("My University", faculties);
    }
}

class StudentCreator {
    public Student createStudent(String name, Human human) {
        return new Student(name, human);
    }
}

public class GroupCreator {
    public Group createGroup(String name, Student[] students) {
        return new Group(name, students;
    }
}