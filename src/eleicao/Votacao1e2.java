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
* Grupos de votação com atributos: Seção de votação, Código de Candidato e 
* Numero do Eleitor
*/
public class Votacao1e2 {
    // Atributos
    int sec;
    int codcand;
    int numele;
    
    // Construtor com valores padrão 
    Votacao1e2() {
        this(0, 0, 0);
    }

    // Construtor que recebe parametros das funções na classe de métodos 
    Votacao1e2 (int secao, int codCandidato, int numEleitor) {
        sec = secao;
        codcand = codCandidato;
        numele = numEleitor;
    }
}
