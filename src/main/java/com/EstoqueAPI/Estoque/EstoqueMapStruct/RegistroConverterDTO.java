package com.EstoqueAPI.Estoque.EstoqueMapStruct;


import com.EstoqueAPI.Estoque.DTO.RegistroMovimentacaoDTO;
import com.EstoqueAPI.Estoque.Model.RegistroMovimentacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")


public interface RegistroConverterDTO {
    RegistroMovimentacaoDTO toDTO(RegistroMovimentacao entity);
    RegistroMovimentacao toEntity(RegistroMovimentacaoDTO dto);
    List<RegistroMovimentacaoDTO> toDTO(List<RegistroMovimentacao> entities);



}
