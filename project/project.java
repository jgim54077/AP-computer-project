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


// 오프닝 및 튜토리얼
//======================================================================================================================

// 오프닝
class Frame1 extends JFrame {
    Image background;

    // 화면 사이즈 및 제목 설정
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

        // 튜토리얼 -> Frame3로 이동
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

// 튜토리얼
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

        // frame3로 넘어가는 버튼
        panel.setLayout(null);
        JButton button2 = new JButton("고종 태우기 시작!!");
        button2.setBounds(600, 400, 200, 40);
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

// 게임1: 고종과 엄순헌 무게 맞추기
//======================================================================================================================

// 고종 태우기 게임 장면1(뒷배경)
class Frame3 extends JFrame {
    Image background;

    public Frame3() {
        background = new ImageIcon("src/project/frame3_bg.png").getImage();
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
        button3.setBounds(0, 0, 1500, 800);
        panel.add(button3);

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Frame4();
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}

// 고종 태우기 게임 장면2(가마 등장)
class Frame4 extends JFrame {
    Image background;

    public Frame4() {
        background = new ImageIcon("src/project/frame3_bg.png").getImage();
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
                new Frame5();
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
}

// 고종 태우기 게임 장면3(본게임)
class Frame5 extends JFrame {
    Image background;
    Image gojongImg;
    Image umImg;

    // 캐릭터 시작 위치
    int gojongX = 450;
    int gojongY = -100;
    int umX = 850;
    int umY = -100;

    // 캐릭터 크기
    int charWidth = 100;
    int charHeight = 150;

    // 떨어지는 속도
    int gravity = 3;

    // 가마 좌표
    int gamaTopY = 510; // 가마 윗라인

    // 아직 캐릭터가 공중에 있는 상태
    boolean gojongLand = false;
    boolean umLand = false;

    // 게임 중 타이머
    Timer timer;

    public Frame5() {
        background = new ImageIcon("src/project/frame5_bg.png").getImage();
        gojongImg = new ImageIcon("src/project/gojong.png").getImage();
        umImg = new ImageIcon("src/project/umsun.png").getImage();

        setTitle("고종 가마 균형 맞추기");
        setSize(1500, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(0, 0);

        GamePanel panel = new GamePanel();
        setContentPane(panel);
        setVisible(true);
    }

    // 게임 화면 전제(패널 내부 클래스)
    class GamePanel extends JPanel implements KeyListener {
        public GamePanel() {
            setFocusable(true);
            requestFocusInWindow();
            addKeyListener(this);

            // 떨어지는 타이머(0.02초마다 반복 실행-> 매 프레임마다 캐릭터 위치 업데이트)
            timer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!gojongLand) { // 고종이 멈추면
                        gojongY += gravity;
                        if (gojongY + charHeight >= gamaTopY) {
                            gojongY = gamaTopY - charHeight;
                            gojongLand = true;
                        }
                    }
                    if (!umLand) { // 엄순헌이 멈추면
                        umY += gravity;
                        if (umY + charHeight >= gamaTopY) {
                            umY = gamaTopY  - charHeight;
                            umLand = true;
                        }
                    }
                    repaint();
                }
            });

            timer.start();

            // 판정 버튼
            setLayout(null);
            JButton btn = new JButton("가자~!");
            btn.setBounds(700, 700, 120, 40);
            add(btn);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    check();
                }
            });
        }

        // 키보드 입력
        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();

            // 고종 이동
            if (code == KeyEvent.VK_A) gojongX -= 10;
            if (code == KeyEvent.VK_D) gojongX += 10;

            // 엄순헌 이동
            if (code == KeyEvent.VK_J) umX -= 10;
            if (code == KeyEvent.VK_L) umX += 10;

            repaint();
        }
        @Override
        public void keyReleased(KeyEvent e) {}
        @Override
        public void keyTyped(KeyEvent e) {}

        // 성공 or 실패 판정
        void check() {
            int gamaStart = 380; // 가마 좌측선
            int gamaEnd = 1100;
            boolean gojongOK = (gojongX >= gamaStart - 100 && gojongX + charWidth <= gamaEnd - 100);
            boolean umOK = (umX >= gamaStart - 200 && umX + charWidth <= gamaEnd - 200);

            if (gojongLand && umLand && gojongOK && umOK) new Frame6();
            else new Frame15();

            timer.stop();
            SwingUtilities.getWindowAncestor(this).dispose();
        }

        // 배경 및 캐릭터 그리기
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null); // 배경
            g.drawImage(gojongImg, gojongX, gojongY, charWidth, charHeight, null); // 고종
            g.drawImage(umImg, umX, umY, charWidth, charHeight, null); // 엄순헌
        }
    }

}


class Frame6 extends JFrame {
    Image background;

    public Frame6() {
        background = new ImageIcon("src/project/frame6_bg.png").getImage();
    }
}


//게임2 : 타이밍에 맞춰 엄순헌 얼굴 내밀기
//======================================================================================================================


//Ending=========================================================================================================================================Ending
// 해피엔딩 장면1(러시아인)
    class Frame12 extends JFrame {
        Image background;

        public Frame12() {
            background = new ImageIcon("src/project/frame12_bg.png").getImage();
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
            panel.add(button12); //패널에 붙이기

            // 해피엔딩 장면2(글)로 이동
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

    // 해피엔딩 장면2(글)
    class Frame13 extends JFrame {
        Image background;

        public Frame13() {
            background = new ImageIcon("src/project/frame13_bg.png").getImage();
            setTitle("해피엔딩 안내글");
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
            panel.add(button13); //패널에 붙이기

            //해피엔딩 장면3으로 이동
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

    // 해피엔딩 장면3(학생들)
    class Frame14 extends JFrame {
        Image background;

        public Frame14() {
            background = new ImageIcon("src/project/frame14_bg.png").getImage();
            setTitle("고종을 위한 감사표시 :)");
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
            add(panel);
            setVisible(true);
        }
    }

    // 배드엔딩
    class Frame15 extends JFrame {
        Image background;

        public Frame15() {
            background = new ImageIcon("src/project/frame15_bg.png").getImage();
            setTitle("러시아 공사관 도착 실패..");
            setSize(1500, 800);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(0, 0);

            JPanel panel = new JPanel() {
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(background, 0, 0, getWidth(), getHeight(), null);

                }
            };

            panel.setLayout(null);
            add(panel);
            setVisible(true);
        }
    }