package com.graphlee.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Node<T> {

    private T data = null;

    private List<Node<T>> outgoings;
    private List<Node<T>> incomings;

    public Node() {
        this.outgoings = new LinkedList<>();
        this.incomings = new LinkedList<>();
    }

    public Node(T data) {
        this.data = data;
        this.outgoings = new LinkedList<>();
        this.incomings = new LinkedList<>();
    }

    public Node(List<Node<T>> outcoming, List<Node<T>> incomings) {
        this.outgoings = outcoming;
        this.incomings = incomings;
    }

    public Node(List<Node<T>> outgoings, List<Node<T>> incomings, T data) {
        this.data = data;
        this.outgoings = outgoings;
        this.incomings = incomings;
    }

    public List<Node<T>> getNeighbors() {
        LinkedList<Node<T>> linkedList = new LinkedList<>();
        linkedList.addAll(outgoings);
        linkedList.addAll(incomings);
        return linkedList;
    }

    public List<Node<T>> getOutgoings() {
        return outgoings;
    }

    public List<Node<T>> getIncomings() {
        return incomings;
    }

    public void addIncoming(Node<T> incoming) {
        this.incomings.add(incoming);
    }

    public void addOutgoing(Node<T> outgoing) {
        this.outgoings.add(outgoing);
    }

    public boolean isNeighbor(Node<?> neighbor) {
        return this.incomings.contains(neighbor) || this.outgoings.contains(neighbor);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean canMoveTo(Node<T> node) {
        return true;
    }

    public List<Node<T>> getAllOutgoings() {
        if (outgoings == null || outgoings.isEmpty())
            return Arrays.asList(this);
        else {
            List<Node<T>> collect = outgoings.stream().map(n -> n.getAllOutgoings()).flatMap(n -> {
                return n.stream();
            }).collect(Collectors.toList());
            return collect;
        }
    }

}
