/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicao;
import javax.swing.JOptionPane;
import java.util.Random;
/**
 *
 * @author gabrielolis
 */

public class Metodos {
    // Define as Seções Válidas
    private final int[] secoesValidas = {1, 3, 4, 5, 9, 10};
    private Random gen = new Random();
    
// #################--#################--#################--#################--#
    // cadastrar os eleitores 
    public Eleitor[] cadastraEleitores (Eleitor[] elei, Boolean modoTeste) {
        
        // coloca valores aleatórios ao invés de pedir inputs com o JOptionPane
        if (modoTeste == true) {
            String[] listaNomes = {"João Silva", "Maria Oliveira", 
                "Carlos Souza", "Ana Costa", "Pedro Santos",
                "Lucia Ferreira", "Marcos Ribeiro", "Juliana Almeida", 
                "Fernando Lima", "Patricia Rocha" };
            
            for (int i = 0; i < elei.length; i++) {
                elei[i] = new Eleitor();
                
                elei[i].numElei = gen.nextInt(100)+1;
                elei[i].nomElei = 
                        listaNomes[gen.nextInt(listaNomes.length)];
                elei[i].sec = 
                        secoesValidas[gen.nextInt(secoesValidas.length)];
            }
            
            elei = organizaSecao(elei);
            operacaoBemSucedida();
            return elei;
        } else {
        
            for (int i = 0; i < elei.length; i++) { 
                // Inicialização do objeto Eleitores
                elei[i] = new Eleitor();

                // Precisa ser feita toda a parte de validação de erro, ou seja,
                // verificar se o "nome" só possui letras e espaços
                // Verificar se o num do eleitor é igual ou maior que 0 e se ele
                // é um número (não pode ser letras, simbolos nem vazio)
                // e a verificacao de secao está dentro dos parametros 
                // estabelecidos

                elei[i].numElei = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite o numero do eleitor: "));
                elei[i].nomElei = JOptionPane.showInputDialog("Digite o "
                        + "nome do eleitor: ");
                elei[i].sec = Integer.parseInt(JOptionPane.showInputDialog
                ("Digite a secao de votacao: "));

                if (verificadorSecao(elei[i].sec) == false) {
                    JOptionPane.showMessageDialog(null,"Sessao"
                            + " invalida, secoes validas (1, 3, 4, 5, 9, 10). "
                            + "Digite novamente...");
                    i--;
                }
            }
            
            elei = organizaSecao(elei);
            operacaoBemSucedida();
            return elei;
        }
    }
    
// #################--#################--#################--#################--#
    /*
    public Obj[] testeMergesort(Obj[] exemplo, Outroobj[] exemplo2) {
        int i = 0, j = 0, k = 0;
    
        Obj[] juntarDois = new Obj[exemplo.lenght + exemplo2.length];
    
        while (i < exemplo.length && j < exemplo2.length) {
            if (exemplo[i].atributo <= exemplo2[j].atributo) {
                juntarDois[k++] = exemplo[i++];
            } else {
                juntarDois[k++] = exemplo2[j++];
            }
        }
    
        while (i < exemplo.length) {
            juntarDois[k++] = exemplo[i++];
        }
    
        while (j < exemplo2.length) {
            juntarDois[k++] = exemplo2[j++];
        }
    }
   
    */
    // cadastrar o grupo de votacao1 ou votacao2
    public Votacao1e2[] cadastroVotacao(Votacao1e2[] grupo, Eleitor[] elei) {
        // Preenche o grupo de acordo com os parametros dos eleitores coletados 
        // e atribui um candidato aleatório, branco ou nulo
        for (int i = 0; i < grupo.length; i++){
            grupo[i].sec = elei[i].sec;
            grupo[i].codcand = gen.nextInt(4) + 1;
            grupo[i].numele = elei[i].numElei;
        }
        ordenaCodCand(grupo);
        operacaoBemSucedida();
        return grupo;
    }
    
// #################--#################--#################--#################--#
    
    public Votacao1e2[] agrupaApuracao(Votacao1e2[] grp1, Votacao1e2[] grp2) {
        // Define o vetor de apuração com o tamanho dos indices dos dois grupos
        // juntos
        Votacao1e2[] apuracao = new Votacao1e2[grp1.length + grp2.length];
        
        // Definir os 3 contadores, i, j e k representando o grupo1, o grupo2 e
        // o vetor de apuração
        int i = 0, j = 0, k = 0;
        
        // Faz um "para" simultaneamente entre os dois vetores, pelo menos foi
        // o que eu entendi
        while (i < grp1.length && j < grp2.length) {
            /*
            * O que eu entendi que está acontecendo aqui: 
            * O grupo1 é comparado com o grupo2, ou seja, se o valor do Código
            * do Candidato for menor do que o do outro vetor, ele coloca esse
            * indice do grupo no novo vetor de apuração (o vetor inteiro, não só
            * o Código do Candidato), caso não seja, quem é colocado é o valor
            * do indice do vetor do grupo2
            */
            if (grp1[i].codcand <= grp2[j].codcand) {
                /* 
                * [k++] e [i++] são uma adaptação direta disso:
                * apuracao[k] = grp1[i];
                * k++;
                * i++;
                */
                apuracao[k++] = grp1[i++];
            } else {
                apuracao[k++] = grp2[j++];
            }
        }
        
        /*
        * percorre o vetor de apuração somente a partir do limite de cada um
        * dos vetores, ou seja se grp1[5] só percorre os 5 primeiros indices e 
        * preenche apuracao até seu 5° indice com os valores de grp1, e depois
        * preenche o resto com os outros 5 indices de grp2 sem resetar o contador
        * de k
        */
        while (i < grp1.length) {
            apuracao[k++] = grp1[i++];
        }
        
        while (j < grp2.length) {
            apuracao[k++] = grp2[j++];
        }
        
        operacaoBemSucedida();
        return apuracao;
    }
            
// #################--#################--#################--#################--#
            
// Métodos utilizados somente nessa classe, por isso é do tipo private
    
    // ordena o objeto do grupo (Votacao1e2)
    private Votacao1e2[] ordenaCodCand(Votacao1e2[] grupo) {
        
        Votacao1e2[] aux = new Votacao1e2[1];
        
        for (int i = 0; i < grupo.length - 1; i++) {
            for (int j = (i+1); j < grupo.length; j++) {
                if (grupo[i].codcand > grupo[j].codcand) {
                    aux[0] = grupo[i];
                    grupo[i] = grupo[j];
                    grupo[j] = aux[0];
                }
            }
        }
        
        return grupo;
    }
    
    // Verifica se a secao faz parte da lista de secoes validas
    private Boolean verificadorSecao(int secao) {
                
        Boolean valido = false;
        
        /*
        * Explicação do sec : secoesValidas:
        * nada mais é do que um loop mais direto ao ponto, no caso o loop 
        * original seria:
        * for (int i = 0; i < secoesValidas.length; i++) {
        *      if (secao == secoesValidas[i]) {
        *          valido = true;
        *          break;
        *      }
        * }
        * Funcionamento:
        * 1. "Passa" por todos elementos de secoesValidas
        * 2. Em cada passagem, atribui o valor do elemento atual à 
        * variável 'sec'
        * 3. Não fornece acesso ao índice, apenas ao valor
        * 4. Ou seja, é como se você "fosse com o dedo" através do vetor, ao 
        * invés de precisar de um indice
        */
        
        for (int sec : secoesValidas) {
            if (secao == sec) {
                valido = true;
                break;
            }
        }
        return valido;
    }
    
// #################--#################--#################--#################--#
    
    // organiza os eleitores pela menor sessão até a maior com bubble sort
    private Eleitor[] organizaSecao(Eleitor[] elei) {
        Eleitor[] aux = new Eleitor[1];
        for (int i = 0; i < elei.length - 1; i++) {
            for (int j = (i + 1); j < elei.length; j++) {
                if (elei[i].sec > elei[j].sec) {
                    aux[0] = elei[i];
                    elei[i] = elei[j];
                    elei[j] = aux[0];
                } 
            }
        }
        
        return elei;
    }
    
// #################--#################--#################--#################--#

    // Mensagem de sucesso
    private void operacaoBemSucedida() {
        JOptionPane.showMessageDialog(null, 
                "Operacao bem sucedida");
    }
}
