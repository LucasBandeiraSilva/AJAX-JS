package com.lucas.bandeira.ado_dois;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lucas.bandeira.ado_dois.dto.DadosPessoaisDto;
import com.lucas.bandeira.ado_dois.dto.ExperienciaProfissionalDto;
import com.lucas.bandeira.ado_dois.dto.FormacaoAcademicaDto;
import com.lucas.bandeira.ado_dois.dto.IdiomaDto;

@RestController
@CrossOrigin("*")
public class DadosController {
    // http://127.0.0.1:8080/dados
    @GetMapping("/dados")
    public DadosPessoaisDto obterDadosPessoais() {
        DadosPessoaisDto dados = new DadosPessoaisDto();
        dados.setNome("Lucas Bandeira");
        dados.setTelefone("(11) 96903-4344");
        dados.setEmail("lucasBandeiraSilva@outlook.com");
        dados.setGithub("https://github.com/LucasBandeiraSilva");
        dados.setLinkedin("https://www.linkedin.com/in/lucas-bandeira-08a675277/");
        dados.setDataNascimento("2003-02-02");

        List<ExperienciaProfissionalDto> experienciaProfissional = new ArrayList<>();
        ExperienciaProfissionalDto experiencia1 = new ExperienciaProfissionalDto();
        experiencia1.setEmpresa("Exercito");
        experiencia1.setCargo("Soldado");
        experiencia1.setPeriodo("2022-2023");
        experienciaProfissional.add(experiencia1);
        dados.setExperienciaProfissional(experienciaProfissional);

        List<String> conhecimentos = new ArrayList<>();
        conhecimentos.add("Java");
        conhecimentos.add("JavaScript");
        conhecimentos.add("HTML");
        conhecimentos.add("CSS");
        conhecimentos.add("PhotoShop");
        conhecimentos.add("CorelDraw");
        conhecimentos.add("React Native");
        conhecimentos.add("AWS: CLOUD FOUDATIONS");
        conhecimentos.add("Node.js");
        dados.setConhecimentos(conhecimentos);

        List<FormacaoAcademicaDto> formacaoAcademica = new ArrayList<>();
        FormacaoAcademicaDto formacao1 = new FormacaoAcademicaDto();
        FormacaoAcademicaDto formacao2 = new FormacaoAcademicaDto();
        formacao1.setCurso("Ilustração digital");
        formacao1.setInstituicao("Eurofarma");
        formacao2.setCurso("Aws Cloud foundation");
        formacao2.setInstituicao("Amazon");
        formacao2.setLink("https://www.credly.com/badges/5b2db4a0-1c52-40fb-aa05-ed8fb3b342e3/linked_in?t=rwlyl5");

        formacaoAcademica.add(formacao1);
        formacaoAcademica.add(formacao2);

        dados.setFormacaoAcademica(formacaoAcademica);

        List<IdiomaDto> idiomas = new ArrayList<>();
        IdiomaDto idioma1 = new IdiomaDto();
        IdiomaDto idioma2 = new IdiomaDto();
        IdiomaDto idioma3 = new IdiomaDto();

        idioma1.setIdioma("Inglês");
        idioma1.setLeitura("Médio");
        idioma1.setEscrita("Médio");
        idioma1.setConversacao("Médio");
        idioma2.setIdioma("Espanhol");
        idioma2.setLeitura("Médio");
        idioma2.setEscrita("Médio");
        idioma2.setConversacao("Médio");
        idioma3.setIdioma("chinês");
        idioma3.setLeitura("ruim");
        idioma3.setEscrita("ruim");
        idioma3.setConversacao("ruim");


        idiomas.add(idioma1);
        idiomas.add(idioma2);
        idiomas.add(idioma3);
        dados.setIdiomas(idiomas);

        return dados;
    }

    @GetMapping("/minhaPagina")
    public ModelAndView pagina(Model model) {
        ModelAndView mv = new ModelAndView();
        DadosPessoaisDto dados = obterDadosPessoais();

        model.addAttribute("dados", dados); // Adicione os dados ao modelo

        mv.setViewName("Dados");
        return mv;
    }

}
