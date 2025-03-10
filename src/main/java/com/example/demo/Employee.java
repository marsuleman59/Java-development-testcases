package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee implements Serializable {


    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    private String ID;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (this.name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return ID != null ? ID.equals(employee.ID) : employee.ID == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (ID != null ? ID.hashCode() : 0);
        return result;
    }
}


