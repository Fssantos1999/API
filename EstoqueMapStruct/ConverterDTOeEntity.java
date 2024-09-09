package com.EstoqueAPI.Estoque.EstoqueMapStruct;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.DTO.RegistroMovimentacaoDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ConverterDTOeEntity {

    Estoque DTOParaEntidade(EstoqueDTO estoqueDTO);

    EstoqueDTO entidadeParaDTO(Estoque estoque);

    List<EstoqueDTO> entidadeParaListDTO(List<Estoque> estoques);

    List<RegistroMovimentacaoDTO> entidadeParaListRegistroMovimentacaoDTO(List<RegistroMovimentacao> registroMovimentacao);




}
