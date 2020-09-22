package Objetos;

public class RegistroAcademico {
    private int anio;
    private String correlativo;

    public RegistroAcademico(int anio, String correlativo){
        this.anio = anio;
        this.correlativo = correlativo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public boolean cheequearCarnet(){
        String carnet = getAnio() + getCorrelativo();
        boolean chequeoTamanio = carnet.length() == 9 && String.valueOf(getAnio()).length()==4;
        if(chequeoTamanio){
            try{
                int chequeoCorrelativo = Integer.parseInt(getCorrelativo());
                if(anio > 1900){
                    return true;
                }else{
                    throw new Exception("A�o no valido.");
                }
            }catch(Exception e){
                return false;
            }
        }
        else{
            return false;
        }
    }



}
