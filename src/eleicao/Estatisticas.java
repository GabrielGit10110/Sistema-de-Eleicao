/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eleicao;
import javax.swing.JOptionPane;
/**
 *
 * @author FATEC ZONA LESTE
 */

public class Estatisticas {
    public void Pvencedor(Votacao1e2[] apuracao) {
        int[] vencedor = FtotalVotos(apuracao);
        int maior = 0;
        int qtdVotos = 0;
        String ven = "";
                        
        if (vencedor[0] > vencedor[1]) {
            maior = 0;
            qtdVotos = vencedor[0];
        } else {
            maior = 1;
            qtdVotos = vencedor[1];
        }
                
        switch (maior) {
            case 0:
                ven = "Jose";
                break;
            case 1:
                ven = "Maria";
                break;
        }
        
        JOptionPane.showMessageDialog(null, "Vencedor: " + ven + " com " + qtdVotos + " votos");
    }
    
// #################--#################--#################--#################--#

    public void PsegundoLugar(Votacao1e2[] apuracao) {
        int[] segundoLugar = FtotalVotos(apuracao);
        int menor = 0;
        int qtdVotos = 0;
        String seg = "";
                        
        if (segundoLugar[0] < segundoLugar[1]) {
            menor = 0;
            qtdVotos = segundoLugar[0];
        } else {
            menor = 1;
            qtdVotos = segundoLugar[1];
        }
                
        switch (menor) {
            case 0:
                seg = "Jose";
                break;
            case 1:
                seg = "Maria";
                break;
        }
        
        JOptionPane.showMessageDialog(null, "Segundo Lugar: " + seg + " com " + qtdVotos + " votos");
    }

// #################--#################--#################--#################--#
          
    public void Pbrancos(Votacao1e2[] apuracao) {
        int[] brancos = FtotalVotos(apuracao);
        
        JOptionPane.showMessageDialog(null, "Votos em branco: " + brancos[2]);
    }

// #################--#################--#################--#################--#

    public void Pnulos(Votacao1e2[] apuracao) {
        int[] nulos = FtotalVotos(apuracao);
        
        JOptionPane.showMessageDialog(null, "Votos nulos: " + nulos[3]);
    }
    
// #################--#################--#################--#################--#
    
    public void Peleitores(Eleitor[] eleitores) {
        
        StringBuilder msg = new StringBuilder("Eleitores: " + "\n");
        
        for (int i = 0; i < eleitores.length; i++) {
            msg.append("Numero do eleitor: ").append(
                    eleitores[i].numElei + ", ").append(
                    " Nome do Eleitor: ").append(
                    eleitores[i].nomElei+ ", ").append(
                    "Secao do Eleitor: ").append(
                    eleitores[i].sec).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, msg.toString());
    }
    
// #################--#################--#################--#################--#

    public void Papuracao(Votacao1e2[] apuracao) {
        StringBuilder msg = new StringBuilder("Apuração: " + "\n");
        
        
        for (int i = 0; i < apuracao.length; i++) {
            msg.append("código: ").append(apuracao[i].codcand).append(
                    "," + " numero do eleitor: ").append(
                    apuracao[i].numele).append(
                    ", secao de eleicao: ").append(
                    apuracao[i].sec).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, msg.toString());
    }
    
// #################--#################--#################--#################--#
    
    // Métodos utilizados somente nessa classe, por isso é do tipo private
    private int[] FtotalVotos(Votacao1e2[] apuracao) {
        int[] totalVotos = new int[4];
        
        for (int i = 0; i < apuracao.length; i++) {
            switch (apuracao[i].codcand) {
                case 1:
                    totalVotos[0]++;
                    break;
                case 2:
                    totalVotos[1]++;
                    break;
                case 3:
                    totalVotos[2]++;
                    break;
                case 4:
                    totalVotos[3]++;
                    break;
            }
        }
        
        return totalVotos;
    }
}
