
/**
 * Classe destinada para a pessoa que partipará do sorteio da tele sena
 * 
 * @author Conrado Maia Heckler 
 */
public class Pessoa
{
    // variáveis de instância 
    private String nome;    
    private TeleSena[] teleSenas;
    private int valorGasto = 0;
    private int qtdCartelas;
    
    // Atributo que recebe uma instancia da classe TeleSena.
    private TeleSena teleSena = new TeleSena();
    // Array que representa os numeros sorteados
    private int[] numerosVencedores = new int [25];
    // Atributo que representa o vaklor final da premiação.
    private double valorPremiacao;
    
    /**
     * Construtor para objetos da classe Pessoa
     */
    public Pessoa(String nome, int qtdCartelas)
    {
        this.nome = nome;   
        this.qtdCartelas = qtdCartelas;
        this.teleSenas = new TeleSena[qtdCartelas];
        this.valorGasto = teleSena.valorDeVenda * qtdCartelas;
    }
    
    /**
     * Método que confere os acertos para as cartelas da tele sena.
     * 
     * @param  numerosSorteados   array dos numeros sorteados.
     * @return     true se a pessoa acertou 25 numeros.
     */
    public boolean confereAcertos(int[] numerosSorteados){
        boolean ganhou = false;
        
        for (int j=0; j<numerosSorteados.length; j++){
           int numeroSorteado = numerosSorteados[j];
            
           for (int i=0; i<teleSenas.length; i++){
                TeleSena teleSena = teleSenas[i];
                
               if (existeNumero(teleSena.getConjunto1(), numeroSorteado))
                   teleSena.setAcertoConjunto1();
        
               if (existeNumero(teleSena.getConjunto2(), numeroSorteado))
                   teleSena.setAcertoConjunto2();
                
               if (teleSena.getAcertosConjunto1() == 25){
                   numerosVencedores = teleSena.getConjunto1();
                   ganhou = true;
               }
               else if (teleSena.getAcertosConjunto2() == 25){
                  ganhou = true; 
                  numerosVencedores = teleSena.getConjunto2();
               }   
           }
           
           if(ganhou)
               return true;           
        }
        
        return ganhou;
    }
    
    /**
     * Sobrecarga do método que confere os acertos das cartelas da tele sena.
     * 
     * @param  numerosSorteados   numero sorteado.
     * @return     true se a pessoa acertou 25 numeros.
     */
    public boolean confereAcertos(int numeroSorteado){
        boolean ganhou = false;
        
        for (int i=0; i<teleSenas.length; i++){
               TeleSena teleSena = teleSenas[i];
                
               if (existeNumero(teleSena.getConjunto1(), numeroSorteado))
                   teleSena.setAcertoConjunto1();
        
               if (existeNumero(teleSena.getConjunto2(), numeroSorteado))
                   teleSena.setAcertoConjunto2();
                
               if (teleSena.getAcertosConjunto1() == 25){
                   numerosVencedores = teleSena.getConjunto1();
                   ganhou = true;
               }
               else if (teleSena.getAcertosConjunto2() == 25){
                  ganhou = true; 
                  numerosVencedores = teleSena.getConjunto2();
               }   
        }
        
        return ganhou;
    }
      
    // Recebe o valor da variável numerosVencedores
    public int[] getConjuntoVencedor(){
        return numerosVencedores;
    }
    
    // Recebe o valor da variável valorGasto
    public int getValorGasto(){
        return valorGasto;
    }
    
    // Recebe o valor da variável nome
        public String getNome(){
        return nome;
    }
    
    // Recebe o valor da variável qtdCartelas
    public int getQtdCartelas(){
        return qtdCartelas;
    }
    
    // Recebe o valor da variável valorPremiacao
    public double getValorPremiacao(){
        return valorPremiacao;
    }
    
    // Define o valor para a variável valorPremiacao
    public void setValorPremiacao(double valorPremiacao){
        this.valorPremiacao = valorPremiacao;
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
    
    // Método que cria as tele senas conforme a quantidade definida na classe princpal.
    public void gerarTeleSenas()
    {
        for (int i=0; i<teleSenas.length; i++){
            teleSenas[i] = new TeleSena();
            valorGasto += teleSenas[i].valorDeVenda;
        }
    }
    
    // Método que imprime as informações de cada cartela da pessoa.
    public void printarCartela(){
        System.out.print("\n\n\nNome: " + nome);
        for (int i=0; i<teleSenas.length; i++){
            System.out.print("\nCartela " + ((int)i+1));
            
            System.out.print("\nConjunto 1: " );
            for (int j=0; j<teleSenas[i].getConjunto1().length; j++){
                System.out.print(teleSenas[i].getConjunto1()[j] + " ");
            }
            
            System.out.print("\nConjunto 2: " );
            for (int j=0; j<teleSenas[i].getConjunto2().length; j++){
                System.out.print(teleSenas[i].getConjunto2()[j] + " ");
            }
            
        }
    }
}
