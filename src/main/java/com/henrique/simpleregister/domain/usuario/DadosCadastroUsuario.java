package com.henrique.simpleregister.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
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
