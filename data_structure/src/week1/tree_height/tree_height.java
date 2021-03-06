import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
	StringTokenizer tok = new StringTokenizer("");
	BufferedReader in;

	FastScanner() {
	    in = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() throws IOException {
	    while (!tok.hasMoreElements())
		tok = new StringTokenizer(in.readLine());
	    return tok.nextToken();
	}
	int nextInt() throws IOException {
	    return Integer.parseInt(next());
	}
    }


    public class Node{
	public ArrayList<Node> children;
	public Node() { children = new ArrayList<Node>(); }
    }
    public class TreeHeight {
	int n;
	int parent[];
	Node root;
	Node[] nodeList;

	void read() throws IOException {
	    FastScanner in = new FastScanner();
	    n = in.nextInt();
	    parent = new int[n];
	    nodeList = new Node[n];
	    for (int i = 0; i < n; i++) {
		nodeList[i] = new Node();
	    }

	    for (int i = 0; i < n; i++) {
		int parentIdx = in.nextInt();
		if(parentIdx == -1) root = nodeList[i];
		else nodeList[parentIdx].children.add(nodeList[i]);
	    }
	    if(root == null) root = nodeList[0];
	}

	int computeHeight(Node root) {
	    int max = 0;
	    for(Node child: root.children) max = Math.max(max, computeHeight(child));
	    return max + 1;
	}
	int computeHeight() {
	    return computeHeight(root);
	}
    }

    static public void main(String[] args) throws IOException {
	new Thread(null, new Runnable() {
	    public void run() {
		try {
		    new tree_height().run();
		} catch (IOException e) {
		}
	    }
	}, "1", 1 << 26).start();
    }
    public void run() throws IOException {
	TreeHeight tree = new TreeHeight();
	tree.read();
	System.out.println(tree.computeHeight());
    }
}
