package com.brickbreaker.game.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {

	public int[][] map;
	public int objectsWidth;
	public int objectsHeight;

	public MapGenerator(int row, int col) {
		map = new int[row][col];

		for (int indice = 0; indice < map.length; indice++) {

			for (int index = 0; index < map[0].length; index++) {
				map[indice][index] = 1;
			}
		}

		objectsWidth = 500 / col;
		objectsHeight = 150 / row;

	}

	public void draw(Graphics2D graphics2D) {
		for (int indice = 0; indice < map.length; indice++) {

			for (int index = 0; index < map[0].length; index++) {
				if (map[indice][index] > 0) {
					graphics2D.setColor(Color.ORANGE);
					graphics2D.fillRect(index * objectsWidth + 80,
							indice * objectsHeight + 50, objectsWidth,
							objectsHeight);

					graphics2D.setStroke(new BasicStroke(3));
					graphics2D.setColor(Color.white);
					graphics2D.drawRect(index * objectsWidth + 80,
							indice * objectsHeight + 50, objectsWidth,
							objectsHeight);
				}
			}
		}
	}

	public void setObjectsValue(int value, int row, int col) {
		map[row][col] = value;
	}
}
