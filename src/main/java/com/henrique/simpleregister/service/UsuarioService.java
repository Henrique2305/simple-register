package com.henrique.simpleregister.service;

import com.henrique.simpleregister.domain.usuario.DadosAlteracaoUsuario;
import com.henrique.simpleregister.domain.usuario.DadosCadastroUsuario;
import com.henrique.simpleregister.domain.usuario.Usuario;
import com.henrique.simpleregister.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void getDataForForm(Long id, Model model) {
        if (id != null) {
            var usuario = repository.getReferenceById(id);
            model.addAttribute("usuario", usuario);
        }
    }

    public void loadData(Model model) {
        model.addAttribute("lista", repository.findAll());
    }

    public void save(DadosCadastroUsuario dados) {
        var usuario = new Usuario(dados);
        repository.save(usuario);
    }

    public void update(DadosAlteracaoUsuario dados) {
        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizaDados(dados);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
