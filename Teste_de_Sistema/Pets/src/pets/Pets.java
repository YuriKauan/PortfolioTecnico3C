package pets;

import javax.swing.JOptionPane;

//@author maria

public class Pets {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Olá cachorrinho ! Digite seu nome:");
        float peso = Float.parseFloat(JOptionPane.showInputDialog("Olá, " + nome + " ! Digite seu peso:"));
        Caes c = new Caes(nome, peso);
        boolean loop = true;
        while (loop) {
            String menu = JOptionPane.showInputDialog("Prazer te conhecer " + nome + "\n"
                    + "Você pode:\n"
                    + "1 - Mandar uma mensagem\n"
                    + "2 - andar\n"
                    + "3 - comer \n"
                    + "4 - dormir \n"
                    + "sair");
            switch (menu) {
                case "1":
                    String mensagem = JOptionPane.showInputDialog("O que você gostaria de falar?");
                    JOptionPane.showMessageDialog(null, c.falar(mensagem));
                    break;
                case "2":
                    int passos = Integer.parseInt(JOptionPane.showInputDialog("Eai " + nome + ", quantos passos você"
                            + "gostaria de andar?"));
                    if (c.andar(passos) == false) {
                        JOptionPane.showMessageDialog(null, "Sinto muito, você precisa recarregar "
                                + "suas energias dormindo para poder andar");
                    }
                    break;
                case "3":
                    c.comer();
                    JOptionPane.showMessageDialog(null, "Você está alimentado");
                    break;
                case "4":
                    if (c.dormir() == false) {
                        JOptionPane.showMessageDialog(null, "Você não está cansado o suficiente, "
                                + "por isso não conseguiu dormir :/");
                    }
                    break;
                default:
                    loop = false;
                    break;
            }
        }
    }
}