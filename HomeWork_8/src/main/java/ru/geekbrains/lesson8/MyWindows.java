package ru.geekbrains.lesson8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyWindows extends JFrame {

    private int winHeigth = 720;
    private int winWigth = 960;
    private int winPosX = 200;
    private int winPosY = 100;
    private int maxMap = 10;
    private int minMap = 3;

    private JButton btnStart;
    private JButton btnExit;
    private JButton btnClearLog;

    private JPanel panelSetting;
    private JPanel panelControl;

    private JTextArea panelLog;
    private JScrollPane scrollLog;

    private JPanel panelSlider;
    private JSlider sliderMap;
    private JSlider sliderWin;

    private String mapSizePrefix = "Map is size ";
    private JLabel labelMapSize;

    private String maxWinLengthPrefix = "Winner length ";
    private JLabel labelWinLength;

    private GameMap gameMap;

    MyWindows () {

        beginSettingWindows();
        prepareButton();
        prepareControl();
        scrollLogPanel();
        prepareSlider();
        prepareSetting();

        gameMap = new GameMap(this);

        add(gameMap);

        setVisible(true);

    }

    private void prepareSlider() {
        panelSlider = new JPanel();
        panelSlider.setLayout(new GridLayout(10,1));

        labelWinLength = new JLabel(maxWinLengthPrefix + minMap);
        labelMapSize = new JLabel(mapSizePrefix + minMap);

        sliderMap = new JSlider(minMap, maxMap, minMap);
        sliderMap.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentPos = sliderMap.getValue();
                labelMapSize.setText(mapSizePrefix + sliderMap.getValue());
                sliderWin.setMaximum(currentPos);
            }
        });

        sliderWin = new JSlider(3,minMap,minMap);
        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(maxWinLengthPrefix + sliderWin.getValue());
            }
        });


        panelSlider.add(labelMapSize);
        panelSlider.add(sliderMap);
        panelSlider.add(labelWinLength);
        panelSlider.add(sliderWin);
    }


    private void prepareSetting() {
        panelSetting = new JPanel(); // Создаем панель
        panelSetting.setLayout(new GridLayout(2, 1)); //Переопределяем расположение
        panelSetting.add(panelSlider);
        panelSetting.add(scrollLog);
        add(panelSetting, BorderLayout.EAST); //Добавляем в окно справо
    }

    private void prepareControl() {
        panelControl = new JPanel();
        panelControl.setLayout(new GridLayout(1,3));
        panelControl.add(btnStart); //Добавляем кнопки
        panelControl.add(btnExit);
        panelControl.add(btnClearLog);
        add(panelControl, BorderLayout.SOUTH);
    }

    private void scrollLogPanel() {
        panelLog = new JTextArea();
        scrollLog = new JScrollPane(panelLog);
        panelLog.setEditable(false);
        panelLog.setLineWrap(true);
    }

    private void prepareButton() {
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                putLog("Start Game" );
                putLog(mapSizePrefix + "" + sliderMap.getValue());
                putLog(maxWinLengthPrefix + "" + sliderWin.getValue());
            }
        });
        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnClearLog = new JButton("Clear log");
        btnClearLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelLog.setText("");
            }
        });
    }

    private void beginSettingWindows() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(winPosX, winPosY, winWigth, winHeigth);
        setTitle(" Game ");
        setResizable(false);
    }

    void putLog (String msg) {
        panelLog.append(msg + "\n");
    }


}
