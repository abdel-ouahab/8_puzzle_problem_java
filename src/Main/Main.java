/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;


import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
	
	static final long MEGABYTE_FACTOR = 1024L * 1024L;
	
	public static void main(String[] args) {
		System.out.println("Starting bfs to solve 8-puzzle");
		System.out.println("Hello");
		//long start = System.currentTimeMillis();
		LocalDateTime startTime = LocalDateTime.now();
		BFS bfs = new BFS("0","2","5","3","4","1","6","7","8");
		boolean success = bfs.solve();
		LocalDateTime endTime = LocalDateTime.now();
		
		if(success)
		{
			System.out.println("\t\t\tStatistics:");
			System.out.println("Path to goal: " + bfs.getCurrentNode().getPathToGoal());
			System.out.println("Cost to goal: " + bfs.getCurrentNode().getCostOfPath());
			System.out.println("Nodes expanded: "+bfs.getExploredNodes().size());
			System.out.println("Search depth: " + bfs.getCurrentNode().getSearchDepth());
			System.out.println("Max Search depth: " + bfs.getCurrentNode().getMaxSearchDepth());
			
			
			//long hours = startTime.until( endTime, ChronoUnit.HOURS);
			long seconds = startTime.until( endTime, ChronoUnit.SECONDS);
			if(seconds == 0)
			{
				long milliSeconds = startTime.until( endTime, ChronoUnit.MILLIS);
				System.out.println("running time:  "+ milliSeconds+" MILLISECONDS");
			}
			else
			{
				System.out.println("running time:  "+ seconds+" SECONDS");
			}
			final long MEGABYTE_FACTOR = 1024L * 1024L;
			final DecimalFormat ROUNDED_DOUBLE_DECIMALFORMAT;
			DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
		    otherSymbols.setDecimalSeparator('.');
		    otherSymbols.setGroupingSeparator(',');
		    ROUNDED_DOUBLE_DECIMALFORMAT = new DecimalFormat("####0.00", otherSymbols);
		    ROUNDED_DOUBLE_DECIMALFORMAT.setGroupingUsed(false);
		    double totalMiB = bytesToMiB(getUsedMemory());
		    System.out.println(String.format("Max memory usage: %s Megabytes", totalMiB));
		}
		else
		{
			System.err.println("no solution found!");
		}
		

	}
	public static long getTotalMemory() {
	    return Runtime.getRuntime().totalMemory();
	}
	
	private static double bytesToMiB(long bytes) {
	    return ((double) bytes / MEGABYTE_FACTOR);
	}
	
	public static long getMaxMemory() {
	    return Runtime.getRuntime().maxMemory();
	}

	public static long getUsedMemory() {
	    return getTotalMemory() - getFreeMemory();
	}


	public static long getFreeMemory() {
	    return Runtime.getRuntime().freeMemory();
	}

}