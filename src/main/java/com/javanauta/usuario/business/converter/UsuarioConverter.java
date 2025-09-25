package com.javanauta.usuario.business.converter;

import com.javanauta.usuario.business.dto.EnderecoDTO;
import com.javanauta.usuario.business.dto.TelefoneDTO;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.infrastructure.entity.Endereco;
import com.javanauta.usuario.infrastructure.entity.Telefone;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

// é um converso que pega todos os dados passados para a classe DTO e transforma-os em uma entity
@Component // é um componente a mais da nossa aplicação
public class UsuarioConverter {

    public Usuario paraUsuario(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .nome(usuarioDTO.getNome()) // o atributo nome está rebecendo getNome de DTO
                .email(usuarioDTO.getEmail()) // o atributo email está recebendo email
                .senha(usuarioDTO.getSenha()) // o atributo senha está recebendo senha
                .enderecos(paraListaEnderecos(usuarioDTO.getEnderecos())) // enderecos está recebendo uma lista de
                .telefones(paraListTelefone(usuarioDTO.getTelefones())) // telefone está recebendo uma lista telefônica
                .build();
    }

    // lista de endereços para enderecos
    // que recebe um l
    public List<Endereco> paraListaEnderecos(List<EnderecoDTO> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEndereco).toList();
    }

    public Endereco paraEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<Telefone> paraListTelefone(List<TelefoneDTO> telefonesDTOS) {
        return telefonesDTOS.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDTO telefone) {
        return Telefone.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public UsuarioDTO paraUsuarioDTO(Usuario usuarioDTO) {
        return UsuarioDTO.builder()
                .nome(usuarioDTO.getNome()) // o atributo nome está rebecendo getNome de DTO
                .email(usuarioDTO.getEmail()) // o atributo email está recebendo email
                .senha(usuarioDTO.getSenha()) // o atributo senha está recebendo senha
                .enderecos(paraListaEnderecoDTO(usuarioDTO.getEnderecos())) // enderecos está recebendo uma lista de
                .telefones(paraListTelefoneDTO(usuarioDTO.getTelefones())) // telefone está recebendo uma lista telefônica
                .build();
    }

    public List<EnderecoDTO> paraListaEnderecoDTO(List<Endereco> enderecoDTOS) {
        return enderecoDTOS.stream().map(this::paraEnderecoDTO).toList();
    }

    public EnderecoDTO paraEnderecoDTO(Endereco enderecoDTO) {
        return EnderecoDTO.builder()
                .rua(enderecoDTO.getRua())
                .numero(enderecoDTO.getNumero())
                .cidade(enderecoDTO.getCidade())
                .complemento(enderecoDTO.getComplemento())
                .cep(enderecoDTO.getCep())
                .estado(enderecoDTO.getEstado())
                .build();
    }

    public List<TelefoneDTO> paraListTelefoneDTO(List<Telefone> telefonesDTOS) {
        return telefonesDTOS.stream().map(this::paraTelefoneDTO).toList();
    }

    public TelefoneDTO paraTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }
}
