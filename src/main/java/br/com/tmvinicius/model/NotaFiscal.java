package br.com.tmvinicius.model;

import lombok.*;

@Data
@Builder
public class NotaFiscal {


    private String numeroNFe;
    private Integer cfop;
    private String nomeFornecedor;
    private Double valorICMS;
    private Double valorContabil;


}
