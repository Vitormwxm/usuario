package com.javanauta.usuario.business.dto;

import lombok.*;

import java.util.List;

// DTO é o data transfer object, uma model que permite
// que nós não expormos os nossos dados internos para o ambiente externo

@Getter // cria os getters
@Setter // cria os setters
@AllArgsConstructor // construtor com todos os argumentos
@NoArgsConstructor // construtor sem os argumentos
@Builder
public class UsuarioDTO {

    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTO> enderecos;
    private List<TelefoneDTO> telefones;
}
