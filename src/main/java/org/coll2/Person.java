package org.coll2;

import java.util.Objects;

/**
 * The Person class represents an individual with various attributes such as ID, name, gender, department, salary, and birth date.
 * It includes methods to access and modify these properties.
 */
public class Person {
    private int id;
    private String name;
    private String gender;
    private Department department;
    private double salary;
    private String birthDate;

    /**
     * Constructs a new Person object with the specified attributes.
     *
     * @param id         the ID of the person
     * @param name       the name of the person
     * @param gender     the gender of the person
     * @param department the department to which the person belongs
     * @param salary     the salary of the person
     * @param birthDate  the birth date of the person
     */
    public Person(int id, String name, String gender, Department department, double salary, String birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Returns the ID of the person.
     *
     * @return the ID of the person
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the person.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the gender of the person.
     *
     * @return the gender of the person
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the department to which the person belongs.
     *
     * @return the department of the person
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Sets the department to which the person belongs.
     *
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Returns the salary of the person.
     *
     * @return the salary of the person
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the person.
     *
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns the birth date of the person.
     *
     * @return the birth date of the person
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the birth date of the person.
     *
     * @param birthDate the birth date to set
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Double.compare(person.salary, salary) == 0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(gender, person.gender) &&
                Objects.equals(department, person.department) &&
                Objects.equals(birthDate, person.birthDate);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, department, salary, birthDate);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                ", birthDate='" + birthDate + '\'' +
                '}';
    }
}
