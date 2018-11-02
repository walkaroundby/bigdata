package entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student")
public class StudentEntity {

    @Id
    private int s_id;
    private String s_name;
    private int s_age;

    public StudentEntity(int s_id, String s_name, int s_age) {
        super();
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_age = s_age;
    }
}