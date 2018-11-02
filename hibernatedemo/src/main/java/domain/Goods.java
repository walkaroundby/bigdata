package domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author luowei
 * @date 2018-09-17 21:36
 */
@Data
@Entity
@Table(name = "goods", schema = "hibernate", catalog = "")
public class Goods {
    @Id
    @Column(name = "sid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "price")
    private Double price;

    public Goods() {
    }

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Goods that = (Goods) o;

        if (sid != that.sid) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
