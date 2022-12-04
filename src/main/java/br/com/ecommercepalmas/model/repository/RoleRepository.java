package br.com.ecommercepalmas.model.repository;

import br.com.ecommercepalmas.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByNome (String nome);
}
