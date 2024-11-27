package cadastroProdutos;

import Inicio.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Cadastro extends JFrame implements ActionListener {
    JLabel lNome;
    JLabel lMarca;
    JLabel lQuantidade;
    JLabel lCodigo;
    JLabel lDescricao;

    JTextField tfNome;
    JTextField tfMarca;
    JTextField tfQuantidade;
    JTextField tfCodigo;

    JButton bSalvar;
    JButton bLimpar;
    JButton bSair;
    JButton bVoltar;
    JButton bExcluir;

    JTable tabela;
    JScrollPane scrollPane;
    DefaultTableModel modelTable;

    JPanel painel1;
    JPanel painel2;
    JPanel painel3;

    public Cadastro() {
        super.setLayout(new GridLayout(2, 1));
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 1));
        painel1 = new JPanel();
        painel1.setBackground(Color.GREEN.darker());
        painel2 = new JPanel();
        painel2.setLayout(new FlowLayout());
        painel2.setBackground(Color.GREEN.darker());
        painel3 = new JPanel();
        painel3.setLayout(new FlowLayout());
        painel3.setBackground(Color.GREEN.darker());

        lNome = new JLabel("Nome");
        lNome.setFont(new Font("Arial", Font.BOLD, 18));
        tfNome = new JTextField(20);
        tfNome.setFont(new Font("Arial", Font.BOLD, 15));

        lMarca = new JLabel("Marca");
        lMarca.setFont(new Font("Arial", Font.BOLD, 18));
        tfMarca = new JTextField(15);
        tfMarca.setFont(new Font("Arial", Font.BOLD, 15));

        lQuantidade = new JLabel("Quantidade");
        lQuantidade.setFont(new Font("Arial", Font.BOLD, 18));
        tfQuantidade = new JTextField(20);
        tfQuantidade.setFont(new Font("Arial", Font.BOLD, 15));

        lCodigo = new JLabel("Codigo");
        lCodigo.setFont(new Font("Arial", Font.BOLD, 18));
        tfCodigo = new JTextField(20);
        tfCodigo.setFont(new Font("Arial", Font.BOLD, 15));

        lDescricao = new JLabel("Produto");
        lDescricao.setForeground(Color.BLACK);
        lDescricao.setFont(new Font("Arial", Font.BOLD, 70));


        bSalvar = new JButton("Salvar");
        bSalvar.setBackground(Color.BLACK);
        bSalvar.setForeground(Color.WHITE);
        bSalvar.setFont(new Font("Arial", Font.BOLD, 15));
        bSalvar.addActionListener(this);

        bLimpar = new JButton("Limpar");
        bLimpar.setBackground(Color.BLACK);
        bLimpar.setForeground(Color.WHITE);
        bLimpar.setFont(new Font("Arial", Font.BOLD, 15));
        bLimpar.addActionListener(this);

        bSair = new JButton("Sair");
        bSair.setBackground(Color.BLACK);
        bSair.setForeground(Color.WHITE);
        bSair.setFont(new Font("Arial", Font.BOLD, 15));
        bSair.addActionListener(this);

        bVoltar = new JButton("Voltar");
        bVoltar.setBackground(Color.BLACK);
        bVoltar.setForeground(Color.WHITE);
        bVoltar.setFont(new Font("Arial", Font.BOLD, 15));
        bVoltar.addActionListener(this);

        bExcluir = new JButton("Excluir");
        bExcluir.setBackground(Color.RED);
        bExcluir.setForeground(Color.WHITE);
        bExcluir.setFont(new Font("Arial", Font.BOLD, 15));
        bExcluir.addActionListener(this);

        modelTable = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelTable.addColumn("Nome");
        modelTable.addColumn("Marca");
        modelTable.addColumn("Quantidade");
        modelTable.addColumn("Codigo");

        tabela = new JTable(modelTable);

        scrollPane = new JScrollPane();
        scrollPane.getViewport().setBackground(Color.darkGray);
        scrollPane.getViewport().setPreferredSize(new Dimension(1450,450));
        scrollPane.setViewportView(tabela);


        tabela.getTableHeader().setBackground(Color.black);
        tabela.getTableHeader().setForeground(Color.white);
        tabela.getTableHeader().setFont(new Font("ARIAL", Font.BOLD, 20));

        tabela.setFont(new Font("ARIAL", Font.BOLD, 16));

        painel.setBackground(Color.GREEN.darker());
        painel1.add(lNome);
        painel1.add(tfNome);
        painel1.add(lMarca);
        painel1.add(tfMarca);
        painel1.add(lQuantidade);
        painel1.add(tfQuantidade);
        painel1.add(lCodigo);
        painel1.add(tfCodigo);

        painel2.add(bSalvar);
        painel2.add(bLimpar);
        painel2.add(bSair);
        painel2.add(bVoltar);
        painel2.add(bExcluir);

        painel3.add(lDescricao);

        add(painel);
        painel.add(painel1);
        painel.add(painel2);
        painel.add(painel3);

        add(scrollPane);

        setTitle("Cadastro de Produtos");
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.getContentPane().setBackground(Color.GREEN.darker());

    }
public static void main(String[] args) {
        Cadastro app = new Cadastro();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == bSalvar) {
        String nome = tfNome.getText();
        String marca = tfMarca.getText();
        String quantidade = tfQuantidade.getText();
        String codigo = tfCodigo.getText();
        if(nome.isBlank() || marca.isBlank() || quantidade.isBlank() || codigo.isBlank()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Erro de validação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        modelTable.addRow(new Object[]{nome, marca, quantidade, codigo});
        JOptionPane.showMessageDialog(null, "Medicamento Salvo",
            "Salvo", JOptionPane.INFORMATION_MESSAGE);
    }

    else if(e.getSource() == bLimpar){
            tfNome.setText("");tfMarca.setText("");tfQuantidade.setText("");tfCodigo.setText("");
    }

    else if(e.getSource() == bVoltar){
        dispose();
        new Menu();
    }
    else if(e.getSource() == bExcluir){
        int x = tabela.getSelectedRow();
        if(x == -1){
            JOptionPane.showMessageDialog(null,"Selecione uma linha");
        }
        modelTable.removeRow(x);
    }

    else if(e.getSource() == bSair){
            System.exit(0);
    }
}
}
