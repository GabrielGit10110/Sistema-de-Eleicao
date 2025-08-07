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
* Eleitores com atributos: Numero do Eleitor, Nome do Eleitor e a  
* Secao que ele votou
*/
public class Eleitor {
    // Atributos
    int numElei;
    String nomElei;
    int sec;
    
    // Construtor com valores padrões
    Eleitor() {
        this(0, "", 0);
    }
    
    // Construtor que recebe parametors das funções na classe de métodos
    Eleitor(int numeroEleitor, String nomeEleitor, int secao) {
        numElei = numeroEleitor;
        nomElei = nomeEleitor;
        sec = secao;
    }
            
}
