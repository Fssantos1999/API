package com.EstoqueAPI.Estoque.EstoqueMapStruct;

import com.EstoqueAPI.Estoque.DTO.EstoqueDTO;
import com.EstoqueAPI.Estoque.Model.Estoque;
import org.mapstruct.Mapper;

@Mapper
public interface ConverterDTOeEntity {

Estoque EntidadeParaDTO(EstoqueDTO estoqueDTO);
EstoqueDTO DTOParaEntidade(Estoque estoque);





}
