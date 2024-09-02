
/**
 * Classe principal do código
 * 
 * @author (Conrado Maia Heckler) 
 */
public class Principal
{
    // Nomes participantes do sorteio.
    private static String nomesParticipantes[] = {"João", "Marcio", "Cortez", "Wanderson", "Edenilson", "Bressan", "Maria", "Julia", "Fernanda", "Silvia", "Edenilson", "Bressan", "Rodrigo", "Fernando", "Rodrigo", "Bustos", "Alan", "Taison", "Joaquin", "Otavio", "Moises"};
    // Array da quantidade de cartelas para cada pessao
    private static int[] quantidadeDeCartelas = new int[20];
    
    /**
     * método principal do código, que implementa todos os métodos das classes.
     */
    public static void main(String[] arguments)
    {      
        for (int i=0; i<quantidadeDeCartelas.length; i++){
            quantidadeDeCartelas[i] = (int)(Math.random() * 15) + 1;
        }
        
        ControleTeleSena cont = new ControleTeleSena(nomesParticipantes, quantidadeDeCartelas);
        cont.vendasTeleSenas();
        cont.realizarSorteio();   
        cont.printarInformacoes();
    }
}
