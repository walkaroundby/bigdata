package entity.inheritence;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author luowei
 * @date 2018/9/6 0006 22:18
 */
@Entity
@Data
public class RetiredEmployee extends Worker {
    private int salary;
    private int experience;

    public RetiredEmployee(String name, int salary, int experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

    public RetiredEmployee() {
    }
}