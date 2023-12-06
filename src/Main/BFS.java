/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	Integer[][] initialState = new Integer[3][3];
	Node root;
	Node currentNode;
	Integer[][] goalState = {{0,1,2},{3,4,5},{6,7,8}}; 
	Queue<Node> fringe = new LinkedList<>();
	List<Node> exploredNodes = new ArrayList<>();
	
	public BFS(String... state)
	{
		int index = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				
				if(state[index].equals("0")) {
					root = new Node(0, i, j,initialState,"",0);
				}
				initialState[i][j] = Integer.valueOf(state[index++]);
				
			}
		}
		root.setState(initialState);
	}
	
	public boolean solve()
	{
		boolean solved = false;
		fringe.add(root);
		
		while(!fringe.isEmpty())
		{
			
			currentNode = fringe.poll();
			exploredNodes.add(currentNode);
			if(gloalReached())
			{
				solved = true;
				printCurrentState();
				return solved;
			}
			else
			{
				printCurrentState();
			}
			
			
			for(Node neighbor : currentNode.getNeighbors())
			{
				
					fringe.add(neighbor);
					
				
			}
			currentNode.setNeighbors(null);
			
		}
		
		
		
		
		
		return solved;
	}

	private boolean gloalReached() {
		boolean success = true;
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(!currentNode.getState()[i][j].equals(goalState[i][j]))
				{
					success = false;
					break;
				}
						
			}
			if(success == true)
			{
				break;
			}
			
		}
		
		return success;
	}

	private void printCurrentState() {
		System.out.println("Current state after: " + currentNode.getPathToGoal());
		for(int i = 0;i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(currentNode.getState()[i][j]+"");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public Integer[][] getInitialState() {
		return initialState;
	}

	public void setInitialState(Integer[][] initialState) {
		this.initialState = initialState;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(Node currentNode) {
		this.currentNode = currentNode;
	}

	public Integer[][] getGoalState() {
		return goalState;
	}

	public void setGoalState(Integer[][] goalState) {
		this.goalState = goalState;
	}

	public Queue<Node> getFringe() {
		return fringe;
	}

	public void setFringe(Queue<Node> fringe) {
		this.fringe = fringe;
	}

	public List<Node> getExploredNodes() {
		return exploredNodes;
	}

	public void setExploredNodes(List<Node> exploredNodes) {
		this.exploredNodes = exploredNodes;
	}

	
	
	
}