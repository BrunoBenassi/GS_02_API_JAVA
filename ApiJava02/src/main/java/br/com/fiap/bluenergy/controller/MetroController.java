package br.com.fiap.bluenergy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bluenergy.dtos.MetroRequestCreateDto;
import br.com.fiap.bluenergy.dtos.MetroRequestUpdateDto;
import br.com.fiap.bluenergy.dtos.MetroResponseDto;
import br.com.fiap.bluenergy.mapper.MetroMapper;
import br.com.fiap.bluenergy.service.MetroService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("metro")
public class MetroController {
    private final MetroService metroService;
    private final MetroMapper metroMapper;

    @GetMapping
    public ResponseEntity<List<MetroResponseDto>> list() {
        List<MetroResponseDto> dtos = metroService.list()
                                            .stream()
                                            .map(e -> metroMapper.toDto(e))
                                            .toList();
        return ResponseEntity.ok().body(dtos);
    }

    
    
    
    @PostMapping
    public ResponseEntity<MetroResponseDto> create(@RequestBody MetroRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    metroMapper.toDto(
                        metroService.save(metroMapper.toModel(dto))
                    )
                );
    }

   
   
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (! metroService.existsById(id)) {
            throw new RuntimeException("Id não existe");
        }
        metroService.delete(id);
    }

    
    
    @PutMapping("{id}")
    public ResponseEntity<MetroResponseDto> update(
        @PathVariable Long id,
        @RequestBody MetroRequestUpdateDto dto
    ) {
        if (!metroService.existsById(id)) {
            throw new RuntimeException("Id não existe");
        }
        return ResponseEntity
                .ok()
                .body(
                    metroMapper.toDto(
                        metroService.save(metroMapper.toModel(dto, id))
                    )
                );
    }

    
    
    @GetMapping("{id}")
    public ResponseEntity<MetroResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity
                .ok()
                .body(
                    metroService
                        .findById(id)
                        .map(e -> metroMapper.toDto(e))
                        .orElseThrow(() -> new RuntimeException("Id não existe"))
                );
                
    }

}
