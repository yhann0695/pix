package br.com.estudo.pix.enums;

import lombok.Getter;
import lombok.Setter;

public enum OperacaoBancariaEnum {

	DEPOSITO_DINHEIRO("DD", "Depósito de Dinheiro"),
	FILA_SAQUE("FS", "Saque"),
	FILA_TRANSFERENCIA("FT", "Transferência");
    
    @Getter @Setter
    private String codigo;

    @Setter @Getter
    private String descricao;

    private OperacaoBancariaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static OperacaoBancariaEnum recuperarEnum(String codigo) {
//        OperacaoBancariaEnum obe = null;
//        for (OperacaoBancariaEnum itemEnum : OperacaoBancariaEnum.values()) {
//            if (itemEnum.getCodigo().equalsIgnoreCase(codigo)) {
//                obe = itemEnum;
//            }
//        }
        return null;
    }
}

