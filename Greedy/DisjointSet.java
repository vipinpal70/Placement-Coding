package Greedy;

// Java program to find the maximum profit job sequence
// from a given array of jobs with deadlines and profits
import java.util.*;

// A Simple Disjoint Set Data Structure
class DisjointSet
{
	int parent[];

	// Constructor
	DisjointSet(int n)
	{
		parent = new int[n + 1];

		// Every node is a parent of itself
		for (int i = 0; i <= n; i++)
			parent[i] = i;
	}

	// Path Compression
	int find(int s)
	{
		/* Make the parent of the nodes in the path
		from u--> parent[u] point to parent[u] */
		if (s == parent[s])
			return s;
		return parent[s] = find(parent[s]);
	}

	// Makes u as parent of v.
	void merge(int u, int v)
	{
		//update the greatest available
		//free slot to u
		parent[v] = u;
	}
}

class Job implements Comparator<Job>
{
	// Each job has a unique-id, profit and deadline
	char id;
	int deadline, profit;

	// Constructors
	public Job() { }
	public Job(char id,int deadline,int profit)
	{
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	// Returns the maximum deadline from the set of jobs
	public static int findMaxDeadline(ArrayList<Job> arr)
	{
		int ans = Integer.MIN_VALUE;
		for (Job temp : arr)
			ans = Math.max(temp.deadline, ans);
		return ans;
	}

	// Prints optimal job sequence
	public static void printJobScheduling(ArrayList<Job> arr)
	{
		Collections.sort(arr, new Job());
		int maxDeadline = findMaxDeadline(arr);
		DisjointSet dsu = new DisjointSet(maxDeadline);

		for (Job temp : arr)
		{
			int availableSlot = dsu.find(temp.deadline);

			if (availableSlot > 0)
			{
				dsu.merge(dsu.find(availableSlot - 1), availableSlot);
				System.out.print(temp.id + " ");
			}
		}
		System.out.println();
	}
	public int compare(Job j1, Job j2)
	{
		return j1.profit > j2.profit? -1: 1;
	}
}

class Main
{
	public static void main(String args[])
	{
		ArrayList<Job> arr=new ArrayList<Job>();
		arr.add(new Job('a',2,100));
		arr.add(new Job('b',1,19));
		arr.add(new Job('c',2,27));
		arr.add(new Job('d',1,25));
		arr.add(new Job('e',3,15));
		System.out.println("Following jobs need to be "+ "executed for maximum profit");
		Job.printJobScheduling(arr);
	}
}

