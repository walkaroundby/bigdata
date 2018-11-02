package entity;

import lombok.Data;

import java.util.*;

import javax.persistence.*;

@Entity
@Data
/**
 * 主键生成策略
 * TABLE：使用一个特定的数据库表格来保存主键。
 * SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。（Oracle不支持IDENTITY，需要使用SEQUENCE）
 * IDENTITY：主键由数据库自动生成（主要是自动增长型）
 * AUTO：主键由程序控制。
 */
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int e_id;
    private String e_name;

    @ElementCollection
    private List<Address> address = new ArrayList();

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}