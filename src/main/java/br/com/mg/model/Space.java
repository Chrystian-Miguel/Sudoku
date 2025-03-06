package br.com.mg.model;

public class Space {

    private Integer actual;
    private final int expected;
    private final boolean fixed;


    public Space(int esperando, boolean fixo) {
        this.expected = esperando;
        this.fixed = fixo;
        if (fixo){
            actual =esperando;
        }
    }
    public void ClearSpace(){

        setActual(null);
    }


    public void setActual(Integer actual) {
        if(fixed)return;
        this.actual = actual;
    }


    public Integer getActual() {
        return actual;
    }

    public int getExpected() {
        return expected;
    }

    public boolean isFixed() {
        return fixed;
    }
}
