package azka.com.customer;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_id_sequence",sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy =GenerationType.SEQUENCE, generator = "customer_id_sequence")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer age;

    public Customer(Integer id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Customer( String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
    public Customer() {}

}