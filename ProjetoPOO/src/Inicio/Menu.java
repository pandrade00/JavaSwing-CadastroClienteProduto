package Inicio;

import cadastroCliente.Cadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{

    JLabel ldescricao;
    JButton bcadastrodecliente;
    JButton bcadastrodeproduto;
    JButton bsair;


    public Menu(){
        super.setLayout(new GridLayout(2,1));
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());

       ldescricao = new JLabel("Selecione uma Opção");
       ldescricao.setVerticalAlignment(SwingConstants.CENTER);
       ldescricao.setHorizontalAlignment(SwingConstants.CENTER);
       ldescricao.setFont(new Font("Arial", Font.BOLD, 25));
       ldescricao.setForeground(Color.BLACK);
       add(ldescricao);

       Dimension dimension = new Dimension(200,70);
       bcadastrodecliente = new JButton("Cadastro de Cliente");
       bcadastrodecliente.setPreferredSize(dimension);
       bcadastrodecliente.addActionListener(this);
       bcadastrodecliente.setBackground(Color.BLACK);
       bcadastrodecliente.setForeground(Color.WHITE);
       bcadastrodecliente.setFont(new Font("Arial", Font.BOLD, 15));
       bcadastrodecliente.setBorder(BorderFactory.createLineBorder(Color.WHITE));

       bcadastrodeproduto = new JButton("Cadastro de Produto");
       bcadastrodeproduto.setPreferredSize(dimension);
       bcadastrodeproduto.addActionListener(this);
       bcadastrodeproduto.setBackground(Color.BLACK);
       bcadastrodeproduto.setForeground(Color.WHITE);
       bcadastrodeproduto.setFont(new Font("Arial", Font.BOLD, 15));
       bcadastrodeproduto.setBorder(BorderFactory.createLineBorder(Color.WHITE));

       bsair = new JButton("Sair");
       bsair.setPreferredSize(dimension);
       bsair.addActionListener(this);
       bsair.setBackground(Color.BLACK);
       bsair.setForeground(Color.WHITE);
       bsair.setFont(new Font("Arial", Font.BOLD, 15));
       bsair.setBorder(BorderFactory.createLineBorder(Color.WHITE));

       painel.setBackground(Color.GREEN.darker());
       painel.add(bcadastrodecliente);
       painel.add(bcadastrodeproduto);
       painel.add(bsair);
       add(painel);


        setTitle("Menu");
        super.setSize(450,450);
        super.setLocationRelativeTo(null);
        super.getContentPane().setBackground(Color.GREEN.darker());
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tela.width - super.getWidth()) / 2;
        int y = (tela.height - super.getHeight()) / 2;
        super.setLocation(x, y);
        super.setVisible(true);

    }

    public static void main (String[] args){
        Menu app = new Menu();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bcadastrodecliente){
            dispose();
            new Cadastro();
        }
        else if(e.getSource() == bcadastrodeproduto){
            dispose();
            new cadastroProdutos.Cadastro();
        }
        else if(e.getSource() == bsair){
            System.exit(0);
        }

    }
}
