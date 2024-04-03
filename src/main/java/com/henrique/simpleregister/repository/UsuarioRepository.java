package com.henrique.simpleregister.repository;

import com.henrique.simpleregister.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
