package br.com.fiap.bluenergy.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.bluenergy.dtos.MetroRequestCreateDto;
import br.com.fiap.bluenergy.dtos.MetroRequestUpdateDto;
import br.com.fiap.bluenergy.dtos.MetroResponseDto;
import br.com.fiap.bluenergy.model.Metro;

@Component
public class MetroMapper {
    @Autowired
    private ModelMapper modelMapper;

    public MetroResponseDto toDto(Metro metro) {
        return modelMapper.map(metro, MetroResponseDto.class);
    }

    public Metro toModel(MetroRequestCreateDto dto) {
        return modelMapper.map(dto, Metro.class);
    }

    public Metro toModel(MetroRequestUpdateDto dto, Long id) {
        return modelMapper.map(dto, Metro.class);
    }
}
