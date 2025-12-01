package project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//내 룸메가 박성현이라면 나는 앱컴 A를 맞을 수 있었을 텐데,
//if park castle string was my roomATE, i would graded A on ap com퓨터 ㅠㅠ.

public class project {
    public static void main(String[] args) {
        Frame1 frame1 = new Frame1();
    }
}

//opening
class Frame1 extends JFrame {
    Image background;

    //Frame1(오프닝 장면)
    public Frame1() {
        setTitle("King's Escape : 아관파천");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/project/controller.png");
        Dimension screenSize = toolkit.getScreenSize();
        setIconImage(image);

        // 배경화면 설정
        background = new ImageIcon("src/project/frame1_bg.png").getImage();
        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setLayout(null);

        //시작 버튼
        JButton startBtn = new JButton("게임 시작");
        startBtn.setContentAreaFilled(false);
        startBtn.setBorderPainted(false);
        startBtn.setFocusPainted(false);
        startBtn.setBounds(100, 470, 200, 40);
        panel.add(startBtn);

        //튜토리얼 버튼
        JButton tutorialBtn = new JButton("튜토리얼");
        tutorialBtn.setContentAreaFilled(false);
        tutorialBtn.setBorderPainted(false);
        tutorialBtn.setFocusPainted(false);
        tutorialBtn.setBounds(100, 650, 200, 40);
        panel.add(tutorialBtn);

        // 튜토리얼 -> Frame2로 이동
        tutorialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame2();
                dispose();
            }
        });

        // 게임 시작 -> Frame3로 이동
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame3();
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}
//tutorial
class Frame2 extends JFrame {
    Image background;

    public Frame2() {
        background = new ImageIcon("src/project/frame2_bg.png").getImage();
        setTitle("튜토리얼");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(null);
        JButton button2 = new JButton("고종 태우기 시작!!");
        button2.setBounds(350, 400, 200, 40);
        panel.add(button2);

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              new Frame3();
              dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}

//게임1: 고종이랑 무게 맞추기
//======================================================================================================================
class Frame3 extends JFrame {
    Image background;

    //고종 태우기 게임 시작
    public Frame3() {
        background = new ImageIcon("src/project/frame3_bg.png").getImage();
        JFrame frame3 = new JFrame("게임 시작! 고종 빼돌리기");
        setTitle("고종 가마 태우기 시작");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        setVisible(true);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            }
        };
        panel.setLayout(null);

        JButton button3 = new JButton("");
        button3.setContentAreaFilled(false);
        button3.setBorderPainted(false);
        button3.setFocusPainted(false);

        button3.setForeground(Color.WHITE);

        button3.setBounds(350, 400, 1500, 800);
        panel.add(button3);

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Frame3();
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}

class Frame4 extends JFrame {
    Image background;

    public Frame4() {
        background = new ImageIcon("src/project/frame4_bg.png").getImage();
        setTitle("고종 가마 태우기 게임 중");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            }
        };

        panel.setLayout(null);
        JButton button4 = new JButton("다음");
        button4.setBounds(100, 100, 200, 40);
        panel.add(button4);

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Frame5();
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}






//Ending=========================================================================================================================================Ending
class Frame12 extends JFrame {
    Image background;

    //고종 태우기 게임 시작
    public Frame12() {
        background = new ImageIcon("src/project/frame12_bg.png").getImage();
        JFrame frame12 = new JFrame("해피엔딩0: 무사통과");
        setTitle("일본 순사 통과");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        setVisible(true);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

            }
        };
        panel.setLayout(null);

        //다음 장면 이동 버튼 만들기
        JButton button12 = new JButton("");
        button12.setContentAreaFilled(false);
        button12.setBorderPainted(false);
        button12.setFocusPainted(false);
        button12.setForeground(Color.WHITE);
        button12.setBounds(350, 400, 1500, 800);
        panel.add(button12);
        //패널에 붙이기

        //해피엔딩 1로 이동
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame13();
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}



class Frame13 extends JFrame {
    Image background;

    //
    public Frame13() {
        background = new ImageIcon("src/project/frame13_bg.png").getImage();
        JFrame frame13 = new JFrame("해피엔딩1: 러시아 공사관 도착");
        setTitle("러시아 공사관 도착");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        setVisible(true);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

            }
        };
        panel.setLayout(null);

        //다음 장면 이동 버튼 만들기
        JButton button13 = new JButton("");
        button13.setContentAreaFilled(false);
        button13.setBorderPainted(false);
        button13.setFocusPainted(false);

        button13.setForeground(Color.WHITE);

        button13.setBounds(350, 400, 1500, 800);
        panel.add(button13);
        //패널에 붙이기

        //해피엔딩 2로 이동
        button13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame14();
                dispose();
            }
        });
        add(panel);
        setVisible(true);
    }
}

class Frame14 extends JFrame {
    Image background;

    //고종 태우기 게임 시작
    public Frame14() {
        background = new ImageIcon("src/project/frame14_bg.png").getImage();
        JFrame frame14 = new JFrame("해피엔딩2: 소개문구");
        setTitle("해피엔딩 소개문구");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        setVisible(true);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

            }
        };
        panel.setLayout(null);

        //다음 장면 이동 버튼 만들기
        JButton button14 = new JButton("");
        button14.setContentAreaFilled(false);
        button14.setBorderPainted(false);
        button14.setFocusPainted(false);
        button14.setForeground(Color.WHITE);
        button14.setBounds(350, 400, 1500, 800);
        panel.add(button14);//패널에 붙이기

        //해피엔딩 2로 이동
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame15();
                dispose();
            }
        });
        add(panel);
        setVisible(true);
    }
}

class Frame15 extends JFrame {
    Image background;

    //고종 태우기 게임 시작
    public Frame15() {
        background = new ImageIcon("src/project/frame15_bg.png").getImage();
        JFrame frame15 = new JFrame("해피엔딩1: 러시아 공사관 도착");
        setTitle("러시아 공사관 도착");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);
        setVisible(true);

        JPanel panel = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

            }
        };
        panel.setLayout(null);

        //다음 장면 이동 버튼 만들기
        JButton button15 = new JButton("");
        button15.setContentAreaFilled(false);
        button15.setBorderPainted(false);
        button15.setFocusPainted(false);
        button15.setForeground(Color.WHITE);
        button15.setBounds(350, 400, 1500, 800);
        panel.add(button15);
        //패널에 붙이기

        //해피엔딩 2로 이동
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Frame15();
                dispose();
            }
        });
        add(panel);
        setVisible(true);
    }
}