package br.com.tmvinicius;


import br.com.tmvinicius.model.NotaFiscal;
import br.com.tmvinicius.util.LeitorExcel;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        LeitorExcel leitor = new LeitorExcel();

        List<NotaFiscal> notas = leitor.criar();

        System.out.print(notas.get(0));




    }
}