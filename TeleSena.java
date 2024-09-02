
/**
 * Classe que representa uma cartela da tele sena
 * 
 * @author (Conrado Maia Heckler) 
 */
public class TeleSena
{
    // variavel estática que representa o valor de venda de uma cartela da tele sena.
    public static final int valorDeVenda = 10; 
    // array que representa o os numeros do conjunto 1 da cartela da tele sena.
    private int[] conjunto1;
    // array que representa o os numeros do conjunto 2.
    private int[] conjunto2;
    //inteiro que representa o os acertos no conjunto 1.
    private int acertosConjunto1 = 0;
    //inteiro que representa o os acertos no conjunto 2.
    private int acertosConjunto2 = 0;
    
    /**
     * Construtor para objetos da classe TeleSena
     */
    public TeleSena()
    {
        this.conjunto1 = criarTeleSena();
        this.conjunto2 = criarTeleSena();
    }
    
    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public static int[] criarTeleSena()
    {
       int[] conjunto = new int[25];
       
       for (int i=0; i<=24; i++){
          int numero;
          Boolean repetido = false;
           
          do {
              numero = (int)(Math.random() * 60) + 1; //nro aleatorio de 1 a 60
              repetido = existeNumero(conjunto, numero);
          } while(repetido); // evita repetição de número

          conjunto[i] = numero;
       }
       
       return conjunto;
    }
    
    // Recebe o valor da variável conjunto1
    public int[] getConjunto1(){
        return conjunto1;
    }
    
    // Recebe o valor da variável conjunto2
    public int[] getConjunto2(){
        return conjunto2;
    }
    
    // Recebe o valor da variável acertosConjunto1
    public int getAcertosConjunto1(){
        return acertosConjunto1;
    }
    
    // Recebe o valor da variável acertosConjunto2
    public int getAcertosConjunto2(){
        return acertosConjunto2;
    }
    
    // Define o valor de acertos do conjunto 1 para o seu valor + 1 ao ser chamada
     public void setAcertoConjunto1(){
        this.acertosConjunto1 += 1;
    }
    
    // Define o valor de acertos do conjunto 2 para o seu valor + 1 ao ser chamada
    public void setAcertoConjunto2(){
        this.acertosConjunto2 += 1;
    }
    
    /**
     * Verfica se o numero indicado existe no array de entrada.
     * 
     * @param  numero   inteiro que será procurado no array.
     * @param  numeros   array de inteiros que será varrido
     * @return     true se encontrar o numero no array
     */
    private static boolean existeNumero(int[] numeros, int numero) {
        for (int j=0; j<numeros.length; j++) {
            if (numeros[j] == numero) {
                return true;
            }
        }
        return false;
    }
}
