package hackerrank;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.stream.IntStream;

enum Color {
	RED, GREEN
}

abstract class Tree {

	private int value;
	private Color color;
	private int depth;

	public Tree(int value, Color color, int depth) {
		this.value = value;
		this.color = color;
		this.depth = depth;
	}

	public int getValue() {
		return value;
	}

	public Color getColor() {
		return color;
	}

	public int getDepth() {
		return depth;
	}

	public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

	private ArrayList<Tree> children = new ArrayList<>();

	public TreeNode(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitNode(this);

		for (Tree child : children) {
			child.accept(visitor);
		}
	}

	public void addChild(Tree child) {
		children.add(child);
	}
}

class TreeLeaf extends Tree {

	public TreeLeaf(int value, Color color, int depth) {
		super(value, color, depth);
	}

	public void accept(TreeVis visitor) {
		visitor.visitLeaf(this);
	}
}

abstract class TreeVis {
	public abstract int getResult();

	public abstract void visitNode(TreeNode node);

	public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	private Integer result = 0;

	public int getResult() {
		return result;
	}

	public void visitNode(TreeNode node) {
		// implement this
	}

	public void visitLeaf(TreeLeaf leaf) {
		result += leaf.getValue();
	}
}

class ProductOfRedNodesVisitor extends TreeVis {
	private Long result = 1L;

	public int getResult() {
		return result.intValue();
	}

	public void visitNode(TreeNode node) {
		if (node.getColor() == Color.RED)
			result = result  * node.getValue() % 1000000007;
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.RED)
			result = result * leaf.getValue() % 1000000007;
	}
}

class FancyVisitor extends TreeVis {
	private Integer nonLeafNodesAtEvenDepth = 0;
	private Integer greenLeafNodes = 0;

	public int getResult() {
		return Math.abs(nonLeafNodesAtEvenDepth - greenLeafNodes);
	}

	public void visitNode(TreeNode node) {
		if ((node.getDepth() % 2) == 0) {
			nonLeafNodesAtEvenDepth += node.getValue();
		}
	}

	public void visitLeaf(TreeLeaf leaf) {
		if (leaf.getColor() == Color.GREEN) {
			greenLeafNodes += leaf.getValue();
		}
	}
}

public class VisitorSolution {

	public static Tree solve() {
		Scanner sc = new Scanner(System.in);
		int nodeCnt = sc.nextInt();
		Integer[] values = new Integer[nodeCnt];
		Color[] colors = new Color[nodeCnt];
		Tree[] nodes = new Tree[nodeCnt];
		Map<Integer, ArrayList<Integer>> struct = new TreeMap<>();

		for (int i = 0; i < nodeCnt; i++) {
			values[i] = sc.nextInt();
		}
		for (int i = 0; i < nodeCnt; i++) {
			colors[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
		}
		IntStream.range(0, nodeCnt).forEach(i -> struct.put(i, new ArrayList<>()));
		nodes[0] = new TreeNode(values[0], colors[0], 0);
		for (int i = 0; i < nodeCnt - 1; i++) {
			int v = sc.nextInt();
			int u = sc.nextInt();
			struct.get(v - 1).add(u - 1);
			struct.get(u - 1).add(v - 1);
		}
		sc.close();
		boolean[] visited = new boolean[nodeCnt];
		visited[0] = true;
		Stack<Integer> indexes = new Stack<>();
		indexes.push(0);
		while (indexes.iterator().hasNext()) {
			Integer index = indexes.pop();
			if (!struct.get(index).isEmpty()) {
				for (Integer nodeId : struct.get(index)) {
					if (!visited[nodeId]) {
						Tree newNode = null;
						visited[nodeId] = true;
						if (struct.get(nodeId).size()==1) {
							newNode = new TreeLeaf(values[nodeId], colors[nodeId], nodes[index].getDepth() + 1);
						} else {
							newNode = new TreeNode(values[nodeId], colors[nodeId], nodes[index].getDepth() + 1);
						}
						nodes[nodeId] = newNode;
						((TreeNode) nodes[index]).addChild(newNode);
						indexes.push(nodeId);
					}
				}
			}
		}
		return nodes[0];

	}

	public static void main(String[] args) {
		Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
		ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
		FancyVisitor vis3 = new FancyVisitor();

		root.accept(vis1);
		root.accept(vis2);
		root.accept(vis3);

		int res1 = vis1.getResult();
		int res2 = vis2.getResult();
		int res3 = vis3.getResult();

		System.out.println(res1);
		System.out.println(res2);
		System.out.println(res3);
	}
}