package br.com.fiap.bluenergy.dtos;

import lombok.Getter;
import lombok.Setter;





@Getter
@Setter
public class MetroRequestCreateDto {
    String marca;
	String EnergiaAzulTipo;
	int potencia;
	int lotacao;
}
