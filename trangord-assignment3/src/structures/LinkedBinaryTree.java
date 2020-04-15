/*
 * TCSS 342
 */

package structures;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedBinaryTree implements the BinaryTreeADT interface.
 * 
 * @author Lewis and Chase
 * @version 4.0
 * @author Alan Fowler - formatted for TCSS 342
 * @version Winter 2019
 * 
 * @param <T> the generic placeholder variable
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{
    /** The root of this Tree. */
    protected BinaryTreeNode<T> myRoot;
    
    /** The mod count for this Tree. */
    protected int myModCount;
    
    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() 
    {
        myRoot = null;
        myModCount = 0;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param theElement the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(final T theElement) 
    {
        myRoot = new BinaryTreeNode<T>(theElement);
        myModCount = 0;
    }
    
    /**
     * Creates a binary tree with the specified element as its root and the 
     * given trees as its left child and right child.
     *
     * @param theElement the element that will become the root of the binary tree
     * @param theLeft the left subtree of this tree
     * @param theRight the right subtree of this tree
     */
    public LinkedBinaryTree(final T theElement,
                            final LinkedBinaryTree<T> theLeft, 
                            final LinkedBinaryTree<T> theRight) 
    {
        myRoot = new BinaryTreeNode<T>(theElement);
        myRoot.setLeft(theLeft.myRoot);
        myRoot.setRight(theRight.myRoot);
        myModCount = 0;
    }
    
    /**
     * Returns a reference to the element at the root.
     *
     * @return a reference to the specified target
     * @throws EmptyCollectionException if the tree is empty
     */
    @Override
    public T getRootElement() throws EmptyCollectionException
    {
        // To be completed as a Programming Project
        return null; // temporary null return just to get the code to compile 
    }
    
    /**
     * Returns a reference to the node at the root.
     *
     * @return a reference to the specified node
     * @throws EmptyCollectionException if the tree is empty
     */
    protected BinaryTreeNode<T> getRootNode() throws EmptyCollectionException
    {
        // To be completed as a Programming Project
        return null; // temporary null return just to get the code to compile
    }
    
    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() 
    {
        return myRoot == null;
    }

    /**
     * Returns the integer size of this tree.
     *
     * @return the integer size of the tree
     */
    @Override
    public int size() 
    {
        // To be completed as a Programming Project
        return 0; // temporary return just to get the code to compile
    }
    
    /**
     * Returns the height of this tree.
     *
     * @return the height of the tree
     */
    public int getHeight()
    {
        // To be completed as a Programming Project
        return 0; // temporary return just to get the code to compile
    }
    
    /**
     * Returns true if this tree contains an element that matches the
     * specified target element and false otherwise.
     *
     * @param theTargetElement the element being sought in this tree
     * @return true if the element in is this tree, false otherwise
     */
    @Override
    public boolean contains(final T theTargetElement)
    {
        // To be completed as a Programming Project
        return false; // temporary return just to get the code to compile
    }
    
    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.  Throws a ElementNotFoundException if
     * the specified target element is not found in the binary tree.
     *
     * @param theTargetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if the element is not in the tree
     */
    @Override
    public T find(final T theTargetElement) throws ElementNotFoundException
    {
        final BinaryTreeNode<T> current = findNode(theTargetElement, myRoot);
        
        if (current == null)
        {
            throw new ElementNotFoundException("LinkedBinaryTree");
        }
        
        return current.getElement();
    }

    /**
     * Returns a reference to the Node containing the specified target element if it is
     * found in this binary tree.
     *
     * @param theTargetElement the element being sought in this tree
     * @param theNode the Node to begin searching from
     * @return a reference to the Node containing the target element if found; false otherwise
     */
    private BinaryTreeNode<T> findNode(final T theTargetElement,
                                       final BinaryTreeNode<T> theNode)
    {
        BinaryTreeNode<T> temp = null;
        if (theNode != null)
        {
            if (theNode.getElement().equals(theTargetElement))
            {
                temp = theNode;
            }
            else
            {
                temp = findNode(theTargetElement, theNode.getLeft());
                
                if (temp == null)
                {
                    temp = findNode(theTargetElement, theNode.getRight());
                }
            }
        }
        
        return temp;
    }
    
    /**
     * Returns a string representation of this binary tree showing
     * the nodes in an inorder fashion.
     *
     * @return an inorder string representation of this binary tree
     */
    @Override
    public String toString() 
    {
        // To be completed as a Programming Project
        return ""; // temporary return just to get the code to compile
    }

    /**
     * Returns an iterator over the elements in this tree using the 
     * iteratorInOrder method.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iterator()
    {
        return iteratorInOrder();
    }
    
    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    @Override
    public Iterator<T> iteratorInOrder()
    {
        final ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(myRoot, tempList);
        
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param theNode the node to be used as the root for this traversal
     * @param theTempList the temporary list for use in this traversal
     */
    protected void inOrder(final BinaryTreeNode<T> theNode, 
                           final ArrayUnorderedList<T> theTempList) 
    {
        if (theNode != null)
        {
            inOrder(theNode.getLeft(), theTempList);
            theTempList.addToRear(theNode.getElement());
            inOrder(theNode.getRight(), theTempList);
        }
    }

    /**
     * Performs an preorder traversal on this binary tree by calling 
     * an overloaded, recursive preorder method that starts with
     * the root.
     *
     * @return a pre order iterator over this tree
     */
    @Override
    public Iterator<T> iteratorPreOrder() 
    {
        // To be completed as a Programming Project
        return null; // temporary null return just to get the code to compile
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param theNode the node to be used as the root for this traversal
     * @param theTempList the temporary list for use in this traversal
     */
    protected void preOrder(final BinaryTreeNode<T> theNode, 
                            final ArrayUnorderedList<T> theTempList) 
    {
        // To be completed as a Programming Project
    }

    /**
     * Performs an postorder traversal on this binary tree by calling
     * an overloaded, recursive postorder method that starts
     * with the root.
     *
     * @return a post order iterator over this tree
     */
    @Override
    public Iterator<T> iteratorPostOrder() 
    {
        // To be completed as a Programming Project
        return null; // temporary null return just to get the code to compile
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param theNode the node to be used as the root for this traversal
     * @param theTempList the temporary list for use in this traversal
     */
    protected void postOrder(final BinaryTreeNode<T> theNode, 
                             final ArrayUnorderedList<T> theTempList) 
    {
        // To be completed as a Programming Project
    }

    /**
     * Performs a level order traversal on this binary tree, using a temporary list.
     *
     * @return a level order iterator over this binary tree
     */
    public Iterator<T> iteratorLevelOrder() 
    {
        final ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
                              new ArrayUnorderedList<BinaryTreeNode<T>>();
        final ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        BinaryTreeNode<T> current;

        nodes.addToRear(myRoot);
        
        while (!nodes.isEmpty()) 
        {
            current = nodes.removeFirst();
            
            if (current == null)
            {
                tempList.addToRear(null);
            }
            else
            {
                tempList.addToRear(current.getElement());
                if (current.getLeft() != null)
                {
                    nodes.addToRear(current.getLeft());
                }
                if (current.getRight() != null)
                {
                    nodes.addToRear(current.getRight());
                }
            }
        }
        
        return new TreeIterator(tempList.iterator());
    }
    
    
    
    
    
    // INNER CLASS ITERATOR
    
    /**
     * Inner class to represent an iterator over the elements of this tree.
     */
    private class TreeIterator implements Iterator<T>
    {
        /** The expected mod count which should match mod count of the associated Tree. */
        private final int myExpectedModCount;
        
        /** The backing Iterator. */
        private final Iterator<T> myIter;
        
        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param theIter the list iterator created by a tree traversal
         */
        TreeIterator(final Iterator<T> theIter)
        {
            this.myIter = theIter;
            myExpectedModCount = myModCount;
        }
        
        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        @Override
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(myModCount == myExpectedModCount))
            {
                throw new ConcurrentModificationException();
            }
            
            return myIter.hasNext();
        }
        
        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        @Override
        public T next() throws NoSuchElementException
        {
            if (hasNext())
            {
                return myIter.next();
            }
            else
            {
                throw new NoSuchElementException();
            }
        }
        
        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}

