package cadastroCliente;

import Inicio.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame implements ActionListener {
    JLabel lNome;
    JLabel lCpf;
    JLabel lTelefone;
    JLabel lDatadeNascimento;
    JLabel lDescricao;

    JTextField tfNome;
    JTextField tfCpf;
    JTextField tfTelefone;
    JComboBox<String>cbDias;
    JComboBox<String>cbMes;
    JComboBox<String>cbAno;

    JButton bSalvar;
    JButton bLimpar;
    JButton bSair;
    JButton bExcluir;
    JButton bVoltar;

    JTable tabela;
    JScrollPane scrollPane;
    DefaultTableModel modelTable;

    JPanel painel1;
    JPanel painel2;
    JPanel painel3;
    JPanel painel4;

    JCheckBox checkBox1;
    JCheckBox checkBox2;
    JCheckBox checkBox3;

    public Cadastro() {
        super.setLayout(new GridLayout(2, 1));
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 1));
        painel1 = new JPanel();
        painel1.setLayout(new FlowLayout());
        painel1.setBackground(Color.GREEN.darker());
        painel2 = new JPanel();
        painel2.setLayout(new FlowLayout());
        painel2.setBackground(Color.GREEN.darker());
        painel3 = new JPanel();
        painel3.setLayout(new FlowLayout());
        painel3.setBackground(Color.GREEN.darker());
        painel4 = new JPanel();
        painel4.setLayout(new FlowLayout());
        painel4.setBackground(Color.GREEN.darker());


        lNome = new JLabel("Nome");
        lNome.setFont(new Font("Arial", Font.BOLD, 18));

        tfNome = new JTextField(20);
        tfNome.setFont(new Font("Arial", Font.BOLD, 15));

        lCpf = new JLabel("Cpf");
        lCpf.setFont(new Font("Arial", Font.BOLD, 18));
        tfCpf = new JTextField(11);
        tfCpf.setFont(new Font("Arial", Font.BOLD, 15));

        lTelefone = new JLabel("Telefone");
        lTelefone.setFont(new Font("Arial", Font.BOLD, 15));
        tfTelefone = new JTextField(11);
        tfTelefone.setFont(new Font("Arial", Font.BOLD, 15));

        lDatadeNascimento = new JLabel("Data de Nascimento");
        lDatadeNascimento.setFont(new Font("Arial", Font.BOLD, 15));

        lDescricao = new JLabel("Cliente");
        lDescricao.setFont(new Font("Arial", Font.BOLD, 70));
        lDescricao.setForeground(Color.BLACK);

        checkBox1 = new JCheckBox("Masculino");
        checkBox1.setBackground(Color.black);
        checkBox1.setForeground(Color.WHITE);
        checkBox1.setFont(new Font("Arial", Font.BOLD, 15));
        checkBox2 = new JCheckBox("Feminino");
        checkBox2.setBackground(Color.black);
        checkBox2.setForeground(Color.WHITE);
        checkBox2.setFont(new Font("Arial", Font.BOLD, 15));
        checkBox3 = new JCheckBox("Outro");
        checkBox3.setBackground(Color.black);
        checkBox3.setForeground(Color.WHITE);
        checkBox3.setFont(new Font("Arial", Font.BOLD, 15));


        String[] Dias = new String[31];
        for (int i = 0; i < Dias.length; i++) {
            Dias[i] = String.valueOf(i + 1);
        }
        cbDias = new JComboBox<>(Dias);
        cbDias.setSelectedIndex(-1);

        String[] Mes = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        cbMes = new JComboBox<>(Mes);
        cbMes.setSelectedIndex(-1);

        String[] Anos = new String[201];{
            for (int i = 0; i < 201; i++) {
                Anos[i] = String.valueOf(1900 + i);
            }
        }
        cbAno = new JComboBox<>(Anos);
        cbAno.setSelectedIndex(-1);

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
        modelTable.addColumn("Sexo");
        modelTable.addColumn("Cpf");
        modelTable.addColumn("Telefone");
        modelTable.addColumn("Data de Nascimento");

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
        painel1.add(lCpf);
        painel1.add(tfCpf);
        painel1.add(lTelefone);
        painel1.add(tfTelefone);
        painel1.add(lDatadeNascimento);
        painel1.add(cbDias);
        painel1.add(cbMes);
        painel1.add(cbAno);
        painel2.add(checkBox1);
        painel2.add(checkBox2);
        painel2.add(checkBox3);

        painel3.add(bSalvar);
        painel3.add(bLimpar);
        painel3.add(bSair);
        painel3.add(bVoltar);
        painel3.add(bExcluir);


        painel4.add(lDescricao);

        add(painel);
        painel.add(painel1);
        painel.add(painel2);
        painel.add(painel3);
        painel.add(painel4);

        add(scrollPane);


        setTitle("Cadastro de Clientes");
        super.setExtendedState(JFrame.MAXIMIZED_BOTH);
        super.setLocationRelativeTo(null);
        super.setVisible(true);
        super.getContentPane().setBackground(Color.GREEN.darker());

    }
    public static void main(String[] args) {
        cadastroCliente.Cadastro app = new cadastroCliente.Cadastro();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == bSalvar){
            String Nome = tfNome.getText();
            String Sexo = "outro";
            String Cpf = tfCpf.getText();
            String Telefone = tfTelefone.getText();
            String Datadenascimento = cbDias.getSelectedItem() + " / " + cbMes.getSelectedItem() + " / " + cbAno.getSelectedItem();
            if(Nome.isBlank() || Cpf.isBlank() || Telefone.isBlank() || Datadenascimento.isBlank()){
                JOptionPane.showMessageDialog(null,"Preencha todos os campos", "Erro de validação", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(checkBox1.isSelected()){
                Sexo = checkBox1.getText();
            }
            else if(checkBox2.isSelected()){
                Sexo = checkBox2.getText();
            }
            else if(checkBox3.isSelected()){
                Sexo = checkBox3.getText();
            }
            modelTable.addRow(new Object[]{Nome,Sexo,Cpf,Telefone,Datadenascimento});
            JOptionPane.showMessageDialog(null,"Cliente Salvo",
                    "Salvo", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(e.getSource() == bLimpar){
            tfNome.setText("");tfCpf.setText("");tfTelefone.setText("");
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

