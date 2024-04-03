package com.henrique.simpleregister.controller;

import com.henrique.simpleregister.domain.usuario.DadosAlteracaoUsuario;
import com.henrique.simpleregister.domain.usuario.DadosCadastroUsuario;
import com.henrique.simpleregister.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        service.getDataForForm(id, model);
        return "usuarios/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        service.loadData(model);
        return "usuarios/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraUsuario(@Valid DadosCadastroUsuario dados) {
        service.save(dados);
        return "redirect:/usuarios";
    }

    @PutMapping
    @Transactional
    public String editaUsuario(DadosAlteracaoUsuario dados) {
        service.update(dados);
        return "redirect:/usuarios";
    }

    @DeleteMapping
    @Transactional
    public String removeUsuario(Long id) {
        service.delete(id);
        return "redirect:/usuarios";
    }
}
