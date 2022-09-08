package com.graphlee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.graphlee.Node.Node;

public class GraphTests {

    public List<Node<Object>> getSequentialNodes() {
        // Create 3 nodes and relate sequentially to each
        Node<Object> node1 = new Node<>();
        Node<Object> node2 = new Node<>();
        Node<Object> node3 = new Node<>();

        node1.addOutgoing(node2);
        node2.addOutgoing(node3);
        node3.addOutgoing(node1);

        return Arrays.asList(node1, node2, node3);
    }

    @Test
    public void nodeCanBeOfASpecificType() {

        String storedData = "And now for something completely different";

        // Create a typed node
        Node<String> node = new Node<>();

        // At first the data inside is null

        String data = node.getData();

        assertTrue(data == null);

        // Once set, it should have that value

        node.setData(storedData);

        data = node.getData();

        assertEquals(storedData, data);
    }

    @Test
    public void aNodeDifferencesBetweenOutgoingsAndIncomings() {
        Node<Integer> node = new Node<>();

        // add two nodes, one incoming and one outgoing

        Node<Integer> nodeOut = new Node<>();
        Node<Integer> nodeIn = new Node<>();

        node.addOutgoing(nodeOut);
        node.addIncoming(nodeIn);

        assertNotEquals(nodeOut, nodeIn);
        assertEquals(node.getIncomings().size(), 1);
        assertEquals(node.getOutgoings().size(), 1);
        assertEquals(node.getNeighbors().size(), 2);
        assertNotEquals(node.getIncomings().get(0), node.getOutgoings().get(0));
    }
}
