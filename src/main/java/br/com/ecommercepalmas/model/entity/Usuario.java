package br.com.ecommercepalmas.model.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Table(name="tb_usuario")
@Entity
public class Usuario  implements Serializable, UserDetails {

    @Getter
    @Setter
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String nome;

    @Getter
    @Setter
    @NotBlank
    private String email;
    @Getter
    @Setter
    @NotBlank
    private String password;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(name = "tb_usuarios_roles",
    joinColumns = @JoinColumn(name = "id_usuario"),
    inverseJoinColumns =@JoinColumn(name = "id_role"))
    private List<Role> roles = new ArrayList<>();

    @Getter
    @Setter
    @OneToOne(mappedBy = "usuario")
    private Cliente cliente;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
