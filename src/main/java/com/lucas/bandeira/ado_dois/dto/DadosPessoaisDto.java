package com.lucas.bandeira.ado_dois.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class DadosPessoaisDto {
    private String nome;
    private String telefone;
    private String email;
    private String dataNascimento;
    private String linkedin;
    private String github;
    private List<ExperienciaProfissionalDto> experienciaProfissional;
    private List<String> conhecimentos;
    private List<FormacaoAcademicaDto> formacaoAcademica;
    private List<IdiomaDto> idiomas;
    
}
