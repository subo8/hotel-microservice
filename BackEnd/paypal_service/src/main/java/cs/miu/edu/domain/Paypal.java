package cs.miu.edu.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.function.DoubleUnaryOperator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Paypal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
//    private String firstName;
//    private String lastName;
    private String emailAddress;
    private String secureKey;
    private Double balance;


}
