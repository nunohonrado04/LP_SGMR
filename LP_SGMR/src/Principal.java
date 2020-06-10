import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {

	public static void main(String[] args) {



		BinSearchTree b=new BinSearchTree();
		b.inserir(2);
		b.inserir(3);
		b.inserir(50);
		b.inserir(70);
		System.out.println("antes"+b);
		b.atribuirMesa(50);
		System.out.println("depois"+b);
		System.out.println("---------------");
		System.out.println("preORder"+b.preOrdem());


	/*	JFrame janela= new JFrame("Restaurante");
		JPanel panel = new JPanel(new BorderLayout());
		JPanel panel1 = new JPanel();
		janela.setVisible(true);
		panel1.setLayout(new GridLayout(2,1));

		JButton Ocupacao= new JButton("Ocupacao");
		JButton Desocupacao= new JButton("Desocupacao");
		panel1.add(Ocupacao);
		panel1.add(Desocupacao);

		panel.add(panel1,BorderLayout.SOUTH);
		janela.add(panel);




		Ocupacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame janelaOcup= new JFrame("Ocupacao Mesa");
				JPanel panelOcup = new JPanel(new BorderLayout());
				JPanel panelOcup1 = new JPanel();
				janelaOcup.setVisible(true);
				panelOcup1.setLayout(new GridLayout(2,1));

				JButton Ocupacao= new JButton("Test1");
				JButton Desocupacao= new JButton("Test2");
				panelOcup1.add(Ocupacao);
				panelOcup1.add(Desocupacao);

				panelOcup.add(panelOcup1,BorderLayout.SOUTH);
				janelaOcup.add(panelOcup);

				BinSearchTree t =new BinSearchTree();

				t.inserir(2);
				t.inserir(4);
				t.inserir(8);
				t.inserir(82);

				JTextField areaProcurar = new JTextField(t.posOrdem());
				panelOcup.add(areaProcurar);

			}
		});
		Desocupacao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("test222");
			}
		});

		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.pack();*/

	}


}
