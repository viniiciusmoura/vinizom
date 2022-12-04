package br.com.ecommercepalmas.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Table(name="rb_role")
@Entity
public class Role implements GrantedAuthority {


    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private Long id;

    @Getter
    @Setter
    @NotBlank
    private String nome;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios = new ArrayList<>();

    @Override
    public String getAuthority() {
        return nome;
    }
}
