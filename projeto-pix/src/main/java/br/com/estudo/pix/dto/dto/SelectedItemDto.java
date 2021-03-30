package br.com.estudo.pix.dto.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectedItemDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private String value;
    private String label;

    public SelectedItemDto() {}

    public SelectedItemDto(String value, String label) {
        this.value = value;
        this.label = label;
    }

    
}