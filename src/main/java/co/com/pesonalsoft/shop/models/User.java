package co.com.pesonalsoft.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author William Johan Novoa Melendrez
 * @date 18/07/2022
 */
@ToString
@NoArgsConstructor
//@Table(name = "users")
public class User implements UserDetails {

    //@Id
    //private Long id;
    private String username;
    private String password;
    @Getter @Setter
    private Boolean enabled;

    /*@Getter @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "ROLES_USERS",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_roles")}
    )*/
    @Getter @Setter
    private List<Role> roles;

    public User(String username, String password, Boolean enabled, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }


    public User(String username, String password, Boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    @Override
    //@JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(authority ->
                new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    //@JsonIgnore
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    //@JsonIgnore
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    //@JsonIgnore
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}