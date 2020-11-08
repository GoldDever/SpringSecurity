package data.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long id;
    @Column(name = "role")
    private String role;

    public Role() {
    }

    @Override
    public String getAuthority() {

        return role;
    }

    public long getId() {
        return id;
    }

   /* public void setId(long id) {
        this.id = id;
    }*/

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
