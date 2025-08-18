package br.com.tmvinicius.util;

import br.com.tmvinicius.model.NotaFiscal;
import lombok.Cleanup;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeitorExcel {

    //Mudança futura: Alterar metodo criar para informar as colunas a serem visualizadas pelo programa
    public List<NotaFiscal> criar() throws IOException {

        List<NotaFiscal> RegistroNFs = new ArrayList<>();

        //Obtendo o arquivo
        @Cleanup FileInputStream file = new FileInputStream("src/main/resources/EntradasPW1.xlsx");
        Workbook workbook = new XSSFWorkbook(file);

        //Setando a aba
        Sheet sheet = workbook.getSheetAt(0);

        //Setando as linhas
        List<Row> linhas = (List<Row>) toList(sheet.iterator());

        //Excluindo linhas - Cabecalho
        //linhas.subList(0, 5).clear();

        linhas.forEach(linha -> {

            //Setando as celulas
            List<Cell> celulas = (List<Cell>) toList(linha.cellIterator());

            Cell cellNumeroNF = linha.getCell(4, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

            if (cellNumeroNF.getCellType() == CellType.BLANK) {
                return;
            }

            //Atribuiu os valores da classe NotaFiscal
            NotaFiscal NFe = NotaFiscal.builder()
                    .numeroNFe(cellNumeroNF.getStringCellValue())
                    .cfop((int) linha.getCell(14, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
                    .nomeFornecedor(linha.getCell(12, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue())
                    .valorContabil(linha.getCell(20, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
                    .valorICMS(linha.getCell(28, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue())
                    .build();

            RegistroNFs.add(NFe);

        });

        return RegistroNFs;
    }

    public List<?> toList(Iterator<?> It) {
        return IteratorUtils.toList(It);
    }

    public void imprimirTudo(List<NotaFiscal> nf) {
        nf.forEach(System.out::println);
    }


}
