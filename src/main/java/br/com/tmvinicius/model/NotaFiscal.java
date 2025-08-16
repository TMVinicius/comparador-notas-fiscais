package br.com.tmvinicius.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotaFiscal {

    private String numeroNFe;
    private Integer cfop;
    private String nomeFornecedor;
    private Double valorICMS;
    private Double valorContabil;




}
