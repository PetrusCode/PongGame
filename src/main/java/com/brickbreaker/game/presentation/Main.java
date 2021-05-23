package com.brickbreaker.game.presentation;

import javax.swing.JFrame;

import com.brickbreaker.game.controller.Gameplay;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame();

		Gameplay game = new Gameplay();
		frame.setBounds(10, 10, 700, 600);
		frame.setTitle("The Pong Game");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
