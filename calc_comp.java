package new_03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calc_comp {
	public static void main(String[] args) {
		okno nf = new okno();
	}

}

class okno extends JFrame {
	private JTextArea text;
	private double p1=0,p2=0;
	private int oper=0;
	
	private void btnClick(JButton btn) {
		String str = btn.getText();
		System.out.println(str);
		if (str == "Exit") System.exit(0);
		else if (str == "C") {
			System.out.println("p1:" + p1 + "p2:" + p2);
			text.setText("");
			p1 = p2 = 0;
			System.out.println("p1:" + p1 + "p2:" + p2);
		}else if (str == "=") {
			if (p2 == 0) p2 = Integer.parseInt(text.getText());
			if (oper == 1) text.setText("" + (p1+p2));
			if (oper == 2) text.setText("" + (p1-p2));
			if (oper == 3) text.setText("" + (p1*p2));
			if (oper == 4) text.setText("" + (p1/p2));
		}
		else if (str == "+") {
			oper = 1;
			p1 = Double.parseDouble(text.getText());
			text.setText("");
		}
		else if (str == "-") {
			oper = 2;
			p1 = Double.parseDouble(text.getText());
			text.setText("");
		}
		else if (str == "*") {
			oper = 3;
			p1 = Double.parseDouble(text.getText());
			text.setText("");
	   }
		else if (str == "/") {
			oper = 4;
			p1 = Double.parseDouble(text.getText());
			text.setText("");
	   }
		else {
			text.setText("" + text.getText() + str);
		}
}
	
public okno() {
		
		JPanel pan=new JPanel();
		Container con=getContentPane();
		pan.setLayout(null);
		
		Font btnFont=new Font("serif",0,20);
		Font labFont=new Font("arial",1,20);
		Font textFont=new Font("arial",2,30);
		
		
		JButton btn[]=new JButton[17];
		for(int i=0;i<17;i++) {
			btn[i]=new JButton();
			btn[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btnClick((JButton)e.getSource());
				}
			});
			btn[i].setSize(100,25);
			btn[i].setFont(btnFont);
			btn[i].setLocation(30,50+i*30);
			btn[i].setBackground(Color.CYAN);
			pan.add(btn[i]);
		}
		for(int i=0;i<10;i++) btn[i].setText(""+i);
		btn[10].setText("+");
		btn[11].setText("-");
		btn[12].setText("/");
		btn[13].setText("*");
		btn[14].setText("=");
		btn[15].setText("C");
		btn[16].setText("Exit");
		
		JLabel lab=new JLabel("Result");
		lab.setFont(labFont);
		lab.setBounds(130,0,300,50);
		pan.add(lab);
		
		text=new JTextArea();
		text.setFont(textFont);
		text.setBounds(300,10,300,35);
		text.setForeground(new Color(0,0,100));
		text.setBackground(Color.WHITE);
		pan.add(text);
		con.add(pan);
		pan.setBackground(Color.BLACK);
		setBounds(200,75,800,600);
		setTitle("Calc");
		setVisible(true);
	}
}

	
	
	
	
	


