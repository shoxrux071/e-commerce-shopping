package org.example.domains;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 14/10/22 23:57 (Friday)
 * e-commerce-shopping/IntelliJ IDEA
 */
@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, columnDefinition = "bool default true")
    private boolean active;

    @ManyToMany(targetEntity = AuthRole.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns = @JoinColumn(name = "auth_user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "auth_role_id", referencedColumnName = "id")
    )
    private List<AuthRole> roles = new ArrayList<>();

}
