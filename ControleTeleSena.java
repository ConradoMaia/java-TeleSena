
/**
 * Classe que cria o sorteio da tele sena e printa as informações solicitadas 
 * 
 * @author (Conrado Maia Heckler) 
 */
public class ControleTeleSena
{
    // Variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String[] nomeParticipantes; 
    private int[] quantidadeDeCartelas;
    
    // Atributo que representa todos os participantes da tele sena.
    private Pessoa[] pessoas = new Pessoa[20];  
    // Atributo que representa todos os ganhadores da tele sena.
    private Pessoa[] ganhadores = new Pessoa[20];
    // Atributo que representa todos os numeros sorteados, para nao haver repetição.
    private int[] numerosSorteados;
    // Atributo que representa os números que foram sorteados no final da tele sena.
    private int[] sorteioFinal;   
    // Atributo que representa a quantidade de ganhadores da tele sena
    private int qtdGanhadores = 0;
    
    /**
     * Construtor para objetos da classe ControleTeleSena
     */
    public ControleTeleSena(String[] nomeParticipantes, int[] qtdCartelas){
        this.nomeParticipantes = nomeParticipantes;
        this.quantidadeDeCartelas = qtdCartelas;
    }
    
    // Método que chama a classe Pessoa, cria os participantes e suas respectivas cartelas
    public void vendasTeleSenas()
    {
        for (int i=0; i<pessoas.length; i++){
            pessoas[i] = new Pessoa(nomeParticipantes[i], quantidadeDeCartelas[i]);
            pessoas[i].gerarTeleSenas();
            pessoas[i].printarCartela();
        }
    }
    
    // Método que realiza o sorteio da tele sena
    public void realizarSorteio()
    {
        // escreva seu código aqui
       this.numerosSorteados = new int[60];

       for (int i=0; i<60; i++){ 
          int numero;
          Boolean repetido = false;
          Boolean acertou25 = false;
           
          do {
              numero = (int)(Math.random() * 60) + 1; //nro aleatorio de 1 a 60
              repetido = existeNumero(this.numerosSorteados, numero);
          } while(repetido); // evita repetição de número
    
          this.numerosSorteados[i] = numero;
          if (i == 25){
              this.sorteioFinal = new int[25];
              if (confereGanhador(acertou25, numerosSorteados))
                  break;
          }
          else if (i > 25){
              this.sorteioFinal = new int[i+1];
              if (confereGanhador(acertou25, numero))    
                  break;
          }    
       }
       
       for (int i=0; i<this.sorteioFinal.length; i++)
           sorteioFinal[i] = numerosSorteados[i];       
    }
    
    /**
     * Método que confere se houve ganhador nos primeiros 25 numeros sorteados.
     * 
     * @param  numerosSorteados   array que representa todos os numeros sorteados.
     * @return     true se a pessoa acertou os 25 numeros da tele sena. 
     */
    private boolean confereGanhador(boolean acertou25, int[] numerosSorteados){
        boolean ganhou = false;
        
        for (int j=0; j<pessoas.length; j++){
            acertou25 = pessoas[j].confereAcertos(numerosSorteados); 
              
            if (acertou25){
                qtdGanhadores += 1;
                ganhadores[qtdGanhadores] = pessoas[j];
                ganhou = true;  
            }               
        }
        
        return ganhou;
    }
    
    /**
     * Sobrecarga do método que confere se houve ganhador após os 25 numeros sorteados.
     * 
     * @param  numerosSorteados   que representa o numero sorteado.
     * @return     true se a pessoa acertou os 25 numeros da tele sena. 
     */
    private boolean confereGanhador(boolean acertou25, int numeroSorteado){
        boolean ganhou = false;
        
        for (int j=0; j<pessoas.length; j++){
            acertou25 = pessoas[j].confereAcertos(numeroSorteado); 
              
            if (acertou25){
               qtdGanhadores += 1;
               ganhadores[qtdGanhadores] = pessoas[j];
               ganhou = true;  
            }                   
        }
        
        return ganhou;
    }
    
    /**
     * Método que recebe todas as vendas de cartelas da tele sena.
     * 
     * @return     o inteiro que representa o numero total de vendas. 
     */
    public int qtdVendasTeleSenas(){
        int vendasTotal = 0;      
        for (int i=0; i<pessoas.length; i++){
            vendasTotal += pessoas[i].getQtdCartelas();
        }
        
        return vendasTotal;
    }
    
    /**
     * Método que calcula o valor final das vendas de cartelas da tele sena.
     * 
     * @return     um double que representa o valor total de vendas. 
     */
    private double calcularValorTotal(){
        int valor = 0;
        for (int j=0; j<pessoas.length; j++){
            valor += pessoas[j].getValorGasto();
        }
        
        return valor;
    }
    
    /**
     * Método que calcula a premiação final para cada ganhador.
     * 
     * @return     um double que representa o valor da premiação final de cada ganhador.. 
     * @param   qtdGanhadores   representa a quantidade de ganhadores da tele sena.
     */
    private double calcularValorPremiacaoPorGanhador(int qtdGanhadores){
        int valor = 0;
        for (int j=0; j<pessoas.length; j++){
            valor += pessoas[j].getValorGasto();
        }
        
        return (valor * 0.8) / qtdGanhadores;
    }
    
    // Imprime as informações solicitadas.
    public void printarInformacoes(){
        System.out.println("\n\n\n\nNumeros sorteados: ");
        for (int j=0; j<numerosSorteados.length; j++) { 
            if (numerosSorteados[j] != 0){
                System.out.print(numerosSorteados[j] + " ");
            }           
        }
        
        System.out.println("\nQuantidade de Tele Senas vendidas: " + qtdVendasTeleSenas());
        
        System.out.println("Quantidade de ganhadores: " + qtdGanhadores);
        
        if (qtdGanhadores > 1)
            System.out.print("Nome dos ganhadores: \n");
        else
            System.out.print("Nome do ganhador: \n");
            
        for (int i=0; i<ganhadores.length; i++){
            if (ganhadores[i] != null)
                System.out.print("- " + ganhadores[i].getNome() + "\n");
        }
        
        
        System.out.println("Valor do prêmio para cada ganhador: R$" + calcularValorPremiacaoPorGanhador(qtdGanhadores));
        
        System.out.println("Valor total de Tele Senas vendidas: R$" + calcularValorTotal());
        
        System.out.println("Lucro obtido pelo Sílvio Santos com a Tele Sena : R$" + (calcularValorTotal() * 0.2));
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
