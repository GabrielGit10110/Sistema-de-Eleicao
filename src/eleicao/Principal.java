/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicao;

/**
 *
 * @author gabrielolis
 */

/*
* Classe principal, cria um menu com JOptionPane e instância os objetos Votacao1e2 (grupos de votação) e
* Eleitor, envia os objetos para serem preenchidos e tratados em funções numa classe de métodos, e
* depois poderá ser feita uma apuração dos resultados para determinar as estatísticas da eleição, o 
* acesso das estatísticas se dá por outro menu criado a partir da classe JOptionpane
*/
import javax.swing.JOptionPane;
public class Principal {
    public static void main(String args[]) {
        int menuPrincipal = 0;
        
        // criar um parametro de teste, 6969 é a opcao secreta, digite no menu principal...
        boolean modoTeste = false;
        
        // Instância da classe de métodos
        Metodos met = new Metodos();
        
        // Instância e inicialização dos grupos
        Votacao1e2[] grupo1 = new Votacao1e2[5];
        Votacao1e2[] grupo2 = new Votacao1e2[5];
        
        for (int i = 0; i < grupo1.length; i++) {
            grupo1[i] = new Votacao1e2();
            grupo2[i] = new Votacao1e2();
        }
       
        // Instância e inicialização da apuração
        Votacao1e2[] apuracao = new Votacao1e2[1];
        
        for (int i = 0; i < apuracao.length; i++) {
            apuracao[i] = new Votacao1e2();
        }
        
        // Instânciamento  dos eleitores
        Eleitor[] eleitores = new Eleitor[10];
  
        // Menu Principal
        do {
            menuPrincipal = Integer.parseInt(JOptionPane.showInputDialog(null,"""
                                                                         1 - Cadastra eleitor
                                                                         2 - Cadastra Votação 1 e 2
                                                                         3 - Agrupa Apuração
                                                                         4 - Menu Estatística
                                                                         9 - FIM
                                                                         """, "MENU PRINCIPAL", JOptionPane.PLAIN_MESSAGE));
            switch (menuPrincipal) {
                case 1:
                    met.cadastraEleitores(eleitores, modoTeste);
                    break;
                case 2:
                    int grupoVotacao = 0;
                    
                    do {
                        grupoVotacao = Integer.parseInt(JOptionPane.showInputDialog(null,"""
                                                                                    1 - Cadastro Votacao 1
                                                                                    2 - Cadastro Votacao 2
                                                                                    9 - Fim
                                                                                    """, "Cadastro Votacao 1, 2", JOptionPane.PLAIN_MESSAGE));
                        switch (grupoVotacao) {
                            case 1:
                                met.cadastroVotacao(grupo1,eleitores);
                                break;
                            case 2:
                                met.cadastroVotacao(grupo2,eleitores);
                                break;
                            case 9:
                                JOptionPane.showMessageDialog(null, "Finalizando...");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Digite um valor válido...");
                        }
                    } while (grupoVotacao != 9);
                    break;
                case 3:
                    apuracao = met.agrupaApuracao(grupo1, grupo2);
                    break;
                case 4:
                        int estatistica = 0;
                        Estatisticas est = new Estatisticas();
                        
                        do {
                            estatistica = Integer.parseInt(JOptionPane.showInputDialog(null,"""
                                                                                       1 - Vencedor
                                                                                       2 - Segundo colocado
                                                                                       3 - Quantidade de votos em branco
                                                                                       4 - Quantidade de votos nulos
                                                                                       5 - Mostra eleitores
                                                                                       6 - Mostra apuração
                                                                                       9 - FIM
                                                                                       """, "Menu Estatistica", JOptionPane.PLAIN_MESSAGE));
                            switch (estatistica) {
                                case 1:
                                    est.Pvencedor(apuracao);
                                    break;
                                case 2:
                                    est.PsegundoLugar(apuracao);
                                    break;
                                case 3:
                                    est.Pbrancos(apuracao);
                                    break;
                                case 4:
                                    est.Pnulos(apuracao);
                                    break;
                                case 5: 
                                    est.Peleitores(eleitores);
                                    break;
                                case 6:
                                    est.Papuracao(apuracao);
                                    break;
                                case 9:
                                    JOptionPane.showMessageDialog(null, "Finalizando...");
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "Opção inválida. Digite novamente...");
                                    
                        }
                        } while(estatistica != 9);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Finalizando...");
                    break;
                case 6969:
                    modoTeste = true;
                    JOptionPane.showMessageDialog(null, "Bem vindo ao modo de teste :D");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Valor Inválido, digite novamente...");
            }
        } while (menuPrincipal != 9);
    }
}
