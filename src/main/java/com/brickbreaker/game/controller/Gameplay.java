package com.brickbreaker.game.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.brickbreaker.game.model.MapGenerator;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;

	private boolean play = false;
	private int score = 0;

	private int totalObjects = 21;

	private Timer timer;
	private int delay = 8;

	private int playerX = 310;

	private int pongPosX = 120;
	private int pongPosY = 350;
	private int pongXdir = -1;
	private int pongYdir = -2;

	private MapGenerator map;

	public Gameplay() {
		map = new MapGenerator(3, 7);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.fillRect(1, 1, 692, 592);

		map.draw((Graphics2D) graphics);

		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, 3, 592);
		graphics.fillRect(0, 0, 692, 3);
		graphics.fillRect(691, 0, 3, 592);

		graphics.setColor(Color.gray);
		graphics.fillRect(playerX, 550, 100, 8);

		graphics.setColor(Color.green);
		graphics.fillOval(pongPosX, pongPosY, 20, 20);

		graphics.setColor(Color.black);
		graphics.setFont(new Font("serif", Font.BOLD, 25));
		graphics.drawString(" " + score, 590, 30);
		if (totalObjects <= 0) {
			play = false;
			pongXdir = 0;
			pongYdir = 0;

			graphics.setColor(Color.green);
			graphics.setFont(new Font("serif", Font.BOLD, 30));
			graphics.drawString("You Won, Score: " + score, 190, 300);

			graphics.setFont(new Font("serif", Font.BOLD, 20));
			graphics.drawString("Press Enter to Restart!", 230, 350);
		}
		if (pongPosY > 570) {
			play = false;
			pongXdir = 0;
			pongYdir = 0;

			graphics.setColor(Color.RED);
			graphics.setFont(new Font("serif", Font.BOLD, 30));
			graphics.drawString("Game Over, Score: " + score, 190, 300);

			graphics.setFont(new Font("serif", Font.BOLD, 20));
			graphics.drawString("Press Enter to Restart.", 230, 350);
		}
		graphics.dispose();

	}

	public void actionPerformed(ActionEvent e) {
		timer.start();

		if (play) {

			// Ball and floor interaction
			if (new Rectangle(pongPosX, pongPosY, 20, 30)
					.intersects(new Rectangle(playerX, 550, 100, 8))) {
				pongYdir = -pongYdir;
			}

			// We create a loops to acces the mapgenerator and to make imaginary
			// rectangle over our rectangles
			for (int indice = 0; indice < map.map.length; indice++) {

				for (int index = 0; index < map.map[0].length; index++) {

					if (map.map[indice][index] > 0) {
						int objectsX = index * map.objectsWidth + 80;
						int objectsY = indice * map.objectsHeight + 50;
						int objectsWidth = map.objectsWidth;
						int objectsHeigt = map.objectsHeight;

						Rectangle rectangle = new Rectangle(objectsX, objectsY,
								objectsWidth, objectsHeigt);

						Rectangle pongRectangle = new Rectangle(pongPosX,
								pongPosY, 20, 30);

						Rectangle objectsRectangle = rectangle;

						// To make the ball bounce when interact with the
						// objects
						if (pongRectangle.intersects(objectsRectangle)) {
							// here we turn the value of the objects back to
							// zero when the ball interact with them also we
							// make totalObjec decrement and plus score
							map.setObjectsValue(0, indice, index);

							totalObjects--;
							score += 5;

							if (pongPosX + 19 <= objectsRectangle.x
									|| pongPosX + 1 >= objectsRectangle.x
											+ objectsRectangle.width) {
								// Here we make the bounce effect
								pongXdir = -pongXdir;
							} else {
								pongYdir = -pongYdir;
							}
						}
					}
				}
			}
			// Using conditionals to change value of the ball in +- to make an
			// effect of bounce
			pongPosX += pongXdir;
			pongPosY += pongYdir;

			if (pongPosX < 0) {
				pongXdir = -pongXdir;
			}
			if (pongPosY < 0) {
				pongYdir = -pongYdir;
			}

			if (pongPosX > 670) {

				pongXdir = -pongXdir;
			}
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {

		// TODO Auto-generated method stub
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_D) {
			if (playerX >= 600) {
				playerX = 600;
			} else {
				moveRight();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			if (playerX <= 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play == true) {
				play = true;
				pongPosX = 120;
				pongPosY = 350;
				pongXdir = -1;
				pongYdir = -2;
				score = 0;
				totalObjects = 21;
				map = new MapGenerator(3, 7);
				repaint();
			}
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void moveRight() {
		play = true;
		playerX += 20;
	}

	public void moveLeft() {
		play = true;
		playerX -= 20;
	}

}
