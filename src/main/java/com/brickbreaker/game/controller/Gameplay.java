package com.brickbreaker.game.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;

	private boolean play = false;
	private int score = 0;

	private int totalBlocks = 21;

	private Timer timer;
	private int delay;

	private int playerX = 310;

	private int pongPosX = 120;
	private int pongPosY = 350;
	private int pongXdir = -1;
	private int pongYdir = -2;

	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void print(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.fillRect(1, 1, 692, 592);

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 3, 562);
		graphics.fillRect(0, 0, 692, 3);
		graphics.fillRect(691, 0, 3, 592);

		graphics.setColor(Color.gray);
		graphics.fillRect(playerX, 550, 100, 8);

		graphics.setColor(Color.green);
		graphics.fillOval(pongPosX, pongPosY, 20, 20);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
