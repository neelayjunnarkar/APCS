Week16 RandP and Binary Search Tree
===================================
    by Neelay Junnarkar


Neelay Junnarkar APCS 2nd Period Mr. Kuszmaul


Note: I did not implement MathSet because while completing BST, Mr. Kuszmaul mentioned that those who complete
    the ACSL Contest#1 Coding portion are exempt from completing the projects portion of the homework

RandP
===
    A random number generator within a range [min, max] which never outputs a previously outputted value
        Accomplishes this by using an arraylist, and as it uses values, deleting them from the arraylist


Binary Search Tree (BST)
===
    class BST:
        Allows making a object of BST much easier
        Internally uses BSTNode
        Hosts the root of the binary search tree

    class BSTNode:
        Used for nodes on a binary search tree
        Each node has a left and right branching node--possibly null

        Implements the modifying functions of:
            insert(T datum): inserts a datum into it's sorted location in the tree
            delete(T datum): finds and deletes the datum in the bst and shifts the bst to make it sorted
            setLeft(T datum): sets the left branching node of the node
            setRight(T datum): sets the right branching node of the node

        Implements accessors of:
            getDatum(): retrieves the datum
            getLeft(): retrieves the left branching node
            getRight(): retrieves the right branching node
            depth(): calculates and returns the depth of the bst extending from the node
            isLeaf(): returns whether the node is a leaf or not

        Implements utility functions of:
            printTree(): prints the tree extending from the node as a sorted list of numbers
            toString(): enables system.out.println(node) and is also internally used in printTree.
                        Returns the tree in the form of a string

    Average Depth of a BST of 10 000 elements = 31.2244
        * Calculated by averaging the depth of 10 000 BSTs of 10 000 elements

    Algorithm Analysis (Big O times) for Binary Search Trees:

        Worst Search Time: O(N)
        Average Search Time: O(log N)

        Insertion Time: O(log N)

        Print Time: O(log N)

        Deletion Time: O(log N)



