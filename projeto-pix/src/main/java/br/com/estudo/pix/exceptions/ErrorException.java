package br.com.estudo.pix.exceptions;

public class ErrorException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ErrorException(String msg) {
        super(msg);
    }
    
}