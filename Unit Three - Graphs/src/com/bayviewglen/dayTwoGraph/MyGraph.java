package com.bayviewglen.dayTwoGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MyGraph {

	public static void main(String[] args) {
		// vertices are ints
		// links are edges

		final int vertices = 0;// getVertices();
		int numEdges = 0;// getEdges();
		LinkedList[] adjacencyList = getAdjList(vertices, numEdges);

	}

	private static LinkedList[] getAdjList(int vertices, int numEdges) {
		LinkedList[] adjacencyList = null;

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

			print(vertices, numEdges, adjacencyList);

		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			// e.printStackTrace();
		}
		return adjacencyList;
	}

	private static void print(int vertices, int numEdges, LinkedList[] adjacencyList) {
		System.out.println(vertices + " vertices, " + numEdges + " edges.");

		for (int i = 0; i < vertices; i++) {
			System.out.print(i + ": ");
			for (Object edges : adjacencyList[i]) {
				System.out.print(edges + " ");
			}
			System.out.println();
		}
	}
}
