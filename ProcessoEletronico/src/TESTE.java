
public class TESTE {

	public static String getDateDiffMillis(Long inicio, Long fim) {
		   long tempo = fim - inicio;  
		   tempo = tempo / 60000;      //Converte o tempo para minutos  
		   int minutos = (int) (tempo % 60);   //Retira os minutos da hora  
		   tempo = tempo / 60;         //Deixa em tempo apenas as horas  
		   return String.format("%02d:%02d", tempo, minutos);  
	}

	public static void main(String[] args) {
		Long entrada = new Long(85000);
		Long saida = new Long(91800);
		String teste = getDateDiffMillis(entrada, saida);	
		System.out.println(teste);
	}

}
/*
import java.sql.Timestamp;  
import java.util.ArrayList;  
import java.util.Calendar;  
import java.util.Date;  
import java.util.List;  
  
/** 
* Esse programa mostra como calcular quantas horas transcorreram entre 
* marcações de uma folha ponto. 
* 
public class TESTE {  
    public static class Tempo {  
        private int horas;  
        private int minutos;  
  
        public Tempo(int horas, int minutos) {  
            this.horas = horas;  
            this.minutos = minutos;  
        }  
  
        public int getHoras() {  
            return horas;  
        }  
  
        public int getMinutos() {  
            return minutos;  
        }  
  
        @Override  
        public String toString() {  
            return String.format("%02d:%02d", horas, minutos);  
        }  
    }  
    public List<Timestamp> timestamps = new ArrayList<Timestamp>();  
  
    public TESTE() {  
        timestamps.add(new Timestamp(2011, 1, 20, 8,  00, 0, 0));  
        timestamps.add(new Timestamp(2011, 1, 20, 12, 00, 0, 0));  
        timestamps.add(new Timestamp(2011, 1, 20, 13, 00, 0, 0));  
        timestamps.add(new Timestamp(2011, 1, 20, 17, 00, 0, 0));  
    }  
  
    /** 
     * Retorna uma data em milisegundos. 
     * Não considera os segundos e milisegundos dessa data na hora de fazer a conversão. 
     *  
     * @param data Data para remover 
     * @return A data sem os segundos e milisegundos 
     /  
    public long toMillis(Date data) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(data);  
  
        //Despreza os segundos e milisegundos  
        cal.set(Calendar.SECOND, 0);  
        cal.set(Calendar.MILLISECOND, 0);  
        return cal.getTimeInMillis();  
    }  
  
    /** 
     * Aceita um array de marcações de tempo do ponto. O array deve conter um 
     * número par de marcações no formato. Cada cada par, uma marcação é 
     * considerada a hora de entrada e a seguinte a hora de saída. 
     * @param marcacoes Marcações do ponto 
     * 
     * @return O total de horas no formato HH:MM 
     /  
    public Tempo calcularTempoMarcacoes(List<? extends Date> marcacoes) {  
        //Calcula o tempo total entre pares de marcações  
        int tempo = 0;  
        for (int i = 0; i < marcacoes.size() / 2; i++) {  
            tempo += (int)(toMillis(marcacoes.get(i * 2 + 1)) - //Entrada  
                    toMillis(marcacoes.get(i * 2)));        //Saída  
        }  
  
        //Formata os misegundos calculados em HH:MM  
        tempo = tempo / 60000;  
        int minutos = tempo % 60;  
        tempo = tempo / 60;  
  
        return new Tempo(tempo, minutos);  
    }  
  
    public void calcular() {  
        System.out.println("Tempo entre marcações:");  
        System.out.println(calcularTempoMarcacoes(timestamps));  
    }  
  
    public static void main(String args[]) {  
        new TESTE().calcular();  
    }  
}*/