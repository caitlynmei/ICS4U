package com.bayviewglen.dayTwoGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Graph {

	public static void main(String[] args) {
		// vertices are ints
		// links are edges

		LinkedList[] adjacencyList = null;
		LinkedList<Integer> edges = new LinkedList<Integer>();

		final int vertices = 0;
		int numEdges = 0;

		getAdjList(vertices, numEdges, adjacencyList);

	}

	private static void getAdjList(int vertices, int numEdges, LinkedList[] adjacencyList) {
		try {
			Scanner input = new Scanner(new File("testData/tinyGraph.dat"));

			while (input.hasNext()) {
				vertices = Integer.parseInt(input.nextLine());
				numEdges = Integer.parseInt(input.nextLine());

				adjacencyList = new LinkedList[vertices];

				// instantiate the LinkedLists inside of adjacency list
				for (int i = 0; i < vertices; i++) {
					adjacencyList[i] = new LinkedList<Integer>();
				}

				// sort which vertices are connected to each other
				for (int i = 0; i < numEdges; i++) {
					int temp1 = Integer.parseInt(input.next());
					int temp2 = Integer.parseInt(input.next());
					adjacencyList[temp1].add(temp2);
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			// e.printStackTrace();
		}

	}
}
