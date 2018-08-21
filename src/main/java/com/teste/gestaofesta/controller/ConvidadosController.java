package com.teste.gestaofesta.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.teste.gestaofesta.model.Convidado;
import com.teste.gestaofesta.repository.Convidados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ConvidadosController {

    @Autowired
    private Convidados convidados;

    @RequestMapping(value = "/convidados", method = RequestMethod.GET)
    public ModelAndView listar(){

        ModelAndView modelAndView = new ModelAndView("listaConvidados");

        modelAndView.addObject("convidados", convidados.findAll());
        modelAndView.addObject(new Convidado());

        return modelAndView;
    }

    @RequestMapping(value = "/convidados", method = RequestMethod.POST)
    public String salvar(Convidado convidado) {
        this.convidados.save(convidado);
        return "redirect:/convidados";
    }
}
