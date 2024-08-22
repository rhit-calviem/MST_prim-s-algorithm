package MST;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import MST.PrimsMST.Node;

public class Testing {

	@Test
	public void testBasic() {
		PrimsMST p = new PrimsMST();
		Node a = p.add("a");
		Node b = p.add("b");
		Node c = p.add("c");
		Node d = p.add("d");
		Node e = p.add("e");
		Node f = p.add("f");
		a.addEdge(b, 2);
		a.addEdge(c, 1);
		a.addEdge(f, 7);
		b.addEdge(c, 1);
		b.addEdge(e, 4);
		c.addEdge(f, 3);
		e.addEdge(f, 4);
		d.addEdge(c, 5);
		d.addEdge(f, 4);

		ArrayList<PrimsMST.Node> aL = new ArrayList<PrimsMST.Node>();
		aL.add(a);
		aL.add(c);
		aL.add(b);
		aL.add(f);
		aL.add(e);
		aL.add(d);

		assertEquals(aL, p.primAlg());
	}

	@Test
	public void test0() {
		PrimsMST p = new PrimsMST();
		Node a = p.add("a");
		Node b = p.add("b");
		Node c = p.add("c");
		Node d = p.add("d");
		Node e = p.add("e");
		Node f = p.add("f");
		Node g = p.add("g");
		Node h = p.add("h");
		Node i = p.add("i");
		Node j = p.add("j");
		Node k = p.add("k");
		Node l = p.add("l");

		a.addEdge(b, 3);
		a.addEdge(c, 5);
		a.addEdge(d, 4);
		b.addEdge(e, 3);
		b.addEdge(f, 6);
		c.addEdge(d, 2);
		c.addEdge(g, 4);
		d.addEdge(e, 1);
		d.addEdge(h, 5);
		e.addEdge(f, 2);
		e.addEdge(i, 4);
		f.addEdge(j, 5);
		g.addEdge(h, 3);
		g.addEdge(k, 6);
		h.addEdge(i, 6);
		h.addEdge(k, 7);
		i.addEdge(j, 3);
		i.addEdge(l, 5);
		j.addEdge(l, 9);
		k.addEdge(l, 8);

		ArrayList<PrimsMST.Node> aL = new ArrayList<PrimsMST.Node>();
		aL.add(a);
		aL.add(b);
		aL.add(e);
		aL.add(d);
		aL.add(f);
		aL.add(c);
		aL.add(g);
		aL.add(h);
		aL.add(i);
		aL.add(j);
		aL.add(l);
		aL.add(k);

		assertEquals(aL, p.primAlg());
	}

	@Test
	public void test1() {
		PrimsMST p = new PrimsMST();

		p.add("a");
		p.add("b");
		p.add("c");
		p.add("d");

		p.getNode(1).addEdge(p.getNode(2), 5);
		p.getNode(1).addEdge(p.getNode(3), 2);
		p.getNode(1).addEdge(p.getNode(4), 4);

		p.getNode(2).addEdge(p.getNode(3), 3);
		p.getNode(2).addEdge(p.getNode(4), 2);

		p.getNode(3).addEdge(p.getNode(4), 6);

		ArrayList<Node> result = new ArrayList<Node>();
		result.add(p.getNode(1));
		result.add(p.getNode(3));
		result.add(p.getNode(2));
		result.add(p.getNode(4));

		for (int j = 0; j < p.nodes.size(); j++) {
			assertEquals(result.toArray()[j], p.primAlg().toArray()[j]);
		}
	}

	@Test
	public void test2() {
		PrimsMST p = new PrimsMST();

		p.add("a");
		p.add("b");
		p.add("c");
		p.add("d");
		p.add("e");
		p.add("f");
		p.add("g");

		// edges for node 1
		p.getNode(1).addEdge(p.getNode(2), 2);

		// edges for node 2
		p.getNode(2).addEdge(p.getNode(3), 2);

		// edges for node 3
		p.getNode(3).addEdge(p.getNode(4), 2);

		// edges for node 4
		p.getNode(4).addEdge(p.getNode(5), 2);

		// edges for node 5
		p.getNode(5).addEdge(p.getNode(6), 2);

		// edges for node 6
		p.getNode(6).addEdge(p.getNode(7), 2);

		// edges for node 7
		// no edges

		ArrayList<Node> result = new ArrayList<Node>();
		result.add(p.getNode(1));
		result.add(p.getNode(2));
		result.add(p.getNode(3));
		result.add(p.getNode(4));
		result.add(p.getNode(5));
		result.add(p.getNode(6));
		result.add(p.getNode(7));

		assertEquals(result.toString(), p.primAlg().toString());

	}

	@Test
	public void test3() {
		PrimsMST p = new PrimsMST();

		p.add("a");
		p.add("b");
		p.add("c");
		p.add("d");
		p.add("e");
		p.add("f");
		p.add("g");
		p.add("h");
		p.add("i");
		p.add("j");

		// edges for node 1
		p.getNode(1).addEdge(p.getNode(2), 10);

		// edges for node 2
		p.getNode(2).addEdge(p.getNode(3), 9);
		p.getNode(2).addEdge(p.getNode(4), 8);

		// edges for node 3
		// no edges

		// edges for node 4
		p.getNode(4).addEdge(p.getNode(5), 7);
		p.getNode(4).addEdge(p.getNode(6), 6);

		// edges for node 5
		// no edges
		
		// edges for node 6
		p.getNode(6).addEdge(p.getNode(7), 5);
		p.getNode(6).addEdge(p.getNode(8), 4);

		// edges for node 7
		// no edges

		// edges for node 8
		p.getNode(8).addEdge(p.getNode(9), 3);
		p.getNode(8).addEdge(p.getNode(10), 2);

		// edges for node 9
		// no edges

		// edges for node 10
		// no edges

		ArrayList<Node> result = new ArrayList<Node>();
		result.add(p.getNode(1));
		result.add(p.getNode(2));
		result.add(p.getNode(4));
		result.add(p.getNode(6));
		result.add(p.getNode(8));
		result.add(p.getNode(10));
		result.add(p.getNode(9));
		result.add(p.getNode(7));
		result.add(p.getNode(5));
		result.add(p.getNode(3));

		assertEquals(result.toString(), p.primAlg().toString());

	}

	@Test
	public void testAllNodesInLine() {
		int n = 5000;
		PrimsMST p = new PrimsMST();
		for (int i = 1; i <= n; i++) {
			p.add(i);
		}
		for (int i = 1; i < n; i++) {
			p.getNode(i).addEdge(p.getNode(i + 1), 2);
		}
		ArrayList<Node> result = new ArrayList<Node>();
		for (int i = 1; i <= n; i++) {
			result.add(p.getNode(i));
		}
		assertEquals(p.primAlg(), result);
	}

	@Test
	public void test5() {
		PrimsMST p = new PrimsMST();
		Node a = p.add("a");
		Node b = p.add("b");
		Node c = p.add("c");
		Node d = p.add("d");
		Node e = p.add("e");
		Node f = p.add("f");
		Node g = p.add("g");
		Node h = p.add("h");
		Node i = p.add("i");
		a.addEdge(b, 8);
		a.addEdge(c, 12);
		b.addEdge(c, 13);
		b.addEdge(e, 9);
		b.addEdge(d, 25);
		c.addEdge(d, 14);
		c.addEdge(g, 21);
		d.addEdge(g, 12);
		d.addEdge(i, 16);
		d.addEdge(h, 12);
		d.addEdge(f, 8);
		d.addEdge(e, 20);
		e.addEdge(f, 19);
		f.addEdge(h, 11);
		h.addEdge(i, 9);
		i.addEdge(g, 11);

		ArrayList<Node> aL = new ArrayList<Node>();
		aL.add(a);
		aL.add(b);
		aL.add(e);
		aL.add(c);
		aL.add(d);
		aL.add(f);
		aL.add(h);
		aL.add(i);
		aL.add(g);

		assertEquals(aL, p.primAlg());
	}
	
	@Test
	public void test6() {
		PrimsMST p = new PrimsMST();
		Node a = p.add("a");
		Node b = p.add("b");
		Node c = p.add("c");
		Node d = p.add("d");
		Node e = p.add("e");
		Node f = p.add("f");
		
		a.addEdge(b, 1);
		a.addEdge(e, 3);
		a.addEdge(d, 4);
		b.addEdge(d, 4);
		b.addEdge(e, 2);
		d.addEdge(e, 4);
		e.addEdge(c, 4);
		e.addEdge(f, 7);
		c.addEdge(f, 5);

		ArrayList<Node> aL = new ArrayList<Node>();
		aL.add(a);
		aL.add(b);
		aL.add(e);
		aL.add(d);
		aL.add(c);		
		aL.add(f);
		
		assertEquals(aL, p.primAlg());

	}
	@Test
	public void testAllNodesConnected() {
        PrimsMST<Integer> primsMST = new PrimsMST<>();
        int number = 200;

        for (int i = 1; i <= number; i++) {
            primsMST.add(i);
        }


        for (int i = 1; i < number; i++) {
            Node node = primsMST.getNode(i);

            for (int j = i + 1; j <= number; j++) {
                Node otherNode = primsMST.getNode(j);
                node.addEdge(otherNode, j - i); 
            }
        }

        ArrayList<Node> result = new ArrayList<Node>();
        for(int i = 1; i <= number; i++) {
        	result.add(primsMST.getNode(i));
        }

        assertEquals(result, primsMST.primAlg());
	}
	
}
