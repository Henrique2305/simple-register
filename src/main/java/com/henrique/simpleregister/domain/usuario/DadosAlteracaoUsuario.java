package com.henrique.simpleregister.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoUsuario(
        @NotNull(message = "ID não pode ser nulo")
        Long id,
        @NotBlank(message = "Nome não pode estar vazio")
        String nome,
        @NotBlank(message = "Data de nascimento não pode estar vazio")
        String dataNascimento,
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Senha não pode estar vazia")
        String senha
) {
}
