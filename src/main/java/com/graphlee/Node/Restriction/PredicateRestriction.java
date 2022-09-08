package com.graphlee.Node.Restriction;

import java.util.function.Predicate;

import com.graphlee.Node.Node;

public class PredicateRestriction<T> extends Restriction<T> {

    private Predicate<Node<T>> predicate;

    public PredicateRestriction(Predicate<Node<T>> predicate) {
        super();
        this.predicate = predicate;
    }

    public boolean evaluate(Node<T> node) {
        return predicate.test(node);
    }

}
