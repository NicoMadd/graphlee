package com.graphlee.Node.Restriction;

import java.util.function.Predicate;

import com.graphlee.Node.Node;

public abstract class Restriction<T> {

    public abstract boolean evaluate(Node<T> node);

    public static <T> PredicateRestriction<T> predicate(Predicate<Node<T>> node) {
        return new PredicateRestriction<>(node);
    }

}
