package customer.demo_cap.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user") // Ensure this matches the actual table name in your database
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "userName") // Customizes the column name if needed
    private String userName;

    @Column(name = "email") // This is optional if the field name matches the column name
    private String email;

    @Column(name = "userRoleId")
    private Long userRoleId;

    // Default constructor required by JPA
    public User() {}

    // Constructor with parameters
    public User(Long id, String userName, String email, Long userRoleId) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.userRoleId = userRoleId;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getUserName() {  // Ensure consistent naming with the field
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    // Setters can be added if needed
}
