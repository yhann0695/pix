package br.com.estudo.pix.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class OperacaoBancariaEnumConverter implements AttributeConverter<OperacaoBancariaEnum, String> {

	@Override
	public String convertToDatabaseColumn(OperacaoBancariaEnum attribute) {
		return attribute.getCodigo();
	}

	@Override
	public OperacaoBancariaEnum convertToEntityAttribute(String dbData) {
		return OperacaoBancariaEnum.recuperarEnum(dbData);
	}

}
