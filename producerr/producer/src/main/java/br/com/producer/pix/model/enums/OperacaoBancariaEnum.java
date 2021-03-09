package br.com.producer.pix.model.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public enum OperacaoBancariaEnum {

    DEPOSITO_DINHEIRO("DD", "Depósito de Dinheiro"),
	FILA_SAQUE("FS", "Saque"),
	FILA_TRANSFERENCIA("FT", "Transferência");

    private String codigo;
    private String descricao;

    private OperacaoBancariaEnum(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static OperacaoBancariaEnum recuperarEnum(String codigo) {
        OperacaoBancariaEnum obe = null;
        for (OperacaoBancariaEnum itemEnum : OperacaoBancariaEnum.values()) {
            if (itemEnum.getCodigo().equalsIgnoreCase(codigo)) {
                obe = itemEnum;
            }
        }
        return obe;
    }
}

