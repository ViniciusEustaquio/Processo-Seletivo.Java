import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    
    public static void main(String[] args) {
        
        
        imprimirSelecionados();
        
        candidatos();
    
        analisarCandidato(1900.00);
        analisarCandidato(1500.00);
        analisarCandidato(2500.00);
        analisarCandidato(2000.00);
        
        String [] candidatos = {"JOÃO", "FELIPE", "MATHEUS", "VINICIUS", "FABIO", "GUILHERME", "ERICK"};
        
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }
    
    static void entrandoEmContato(String candidato){
        int tentativaRealizada = 1;
        boolean continuarLigando = true;
        boolean atendeu = false;
        
        do {
            
            atendeu = atender();
            if (continuarLigando) {
                tentativaRealizada++;
            } else{
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }
            
        } while (continuarLigando && tentativaRealizada < 3);
        
        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativaRealizada + " TENTATIVA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " NUMERO MAXIMO DE TENTATIVAS " + tentativaRealizada + " REALIZADA");     
        }
            
    }
    
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    
    
    static void imprimirSelecionados(){
        String [] candidatos = {"JOÃO", "FELIPE", "MATHEUS", "VINICIUS", "FABIO", "GUILHERME", "ERICK"};
        System.out.println("Imprimindo a lista de candidatos informado o indice do elemento");
        
        for(int i = 1; i < candidatos.length; i++ ){
            System.out.println("O candidato de numero: " + i + " è " + candidatos[i]);
        }
    }
    
    
    static void candidatos (){
        
        String [] candidatos = {"JOÃO", "FELIPE", "MATHEUS", "VINICIUS", "FABIO", "GUILHERME", "ERICK"};
        
        
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            
            
            System.out.println("O Candidato " + candidato + " Solicitou este valor de salario " + salarioPretendido);
            
            if (salarioBase >= salarioPretendido) {
                System.out.println("O Candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            
            candidatoAtual++;
        }
    }
     
    
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.00;
        
        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO DEMAIS CANDIDATOS");
        }
    }
    
    
}
