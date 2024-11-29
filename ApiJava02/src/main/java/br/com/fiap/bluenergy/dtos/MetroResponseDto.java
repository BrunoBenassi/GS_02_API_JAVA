package br.com.fiap.bluenergy.dtos;

import lombok.Getter;
import lombok.Setter;






@Getter
@Setter
public class MetroResponseDto {
    
    private Long id;
    private String marca;
    private int potencia;
    private int lotacao;

}
