package br.com.mg.model;

public enum GameStatusEnum {
    NON_STARTED("Não Iniciado") ,
    INCOMPLETE("Imcompleto"),
    COMPLETE("Completo");

    private String label;

     GameStatusEnum(final String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
