package org.coll2;

import java.util.Objects;

/**
 * The Department class represents a department within an organization.
 * It includes properties for the department's ID and name, along with methods to access and modify these properties.
 */
public class Department {
    private int id;
    private String name;

    /**
     * Constructs a new Department object with the specified ID and name.
     *
     * @param id   the ID of the department
     * @param name the name of the department
     */
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Returns the ID of the department.
     *
     * @return the ID of the department
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the department.
     *
     * @param id the ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the name of the department.
     *
     * @return the name of the department
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the department.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
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
        Department that = (Department) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
