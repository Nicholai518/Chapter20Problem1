package sample;

public class Deque
{
    // Inner Node Class or maybe use already created doubly linked list as a field
    private class Node
    {
        // Might be considered Fields, maybe just variables. Not sure
        String value;       // Holds String Value
        Node next;          // Holds successor node
        Node previous;      // Holds Predecessor Node

        // Constructor
        public Node(String value, Node next, Node previous)
        {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    // Trying to add more inner classes to handle queue exceptions
    class QueueOverFlowException extends RuntimeException
    {

    }

    class EmptyQueueException extends RuntimeException
    {

    }

    // Fields for Deque class
    private Node front;
    private Node rear;

    // Constructor
    public Deque()
    {
        front = null;
        rear = null;
    }




    // Methods

//    /**
//     * Adds
//     */
//    public void enqueue()
//    {
//
//    }
    public void addFront(String string)
    {

        if(front != null)
        {
            Node newFrontNode = new Node(string, front, null);

            front.previous = newFrontNode;

            front = newFrontNode;

        }

        else
        {
            front = new Node(string, null, null);
            rear = front;
        }

//
    }

    public void removeFront() throws EmptyQueueException
    {
        if(empty())
        {
            throw new EmptyQueueException();

        }

        else
        {
            // There is only 1 Node
            if(front == rear)
            {
                front = null;
                rear = null;
            }
            else
            {
                front = front.next;
                //front.previous = null;
            }
        }
    }

    public void addRear(String string)
    {

        if(empty())
        {
            rear = new Node(string, null, null);
            front = rear;
        }
        else
        {
            // Store current rear
            //Node originalRear = rear;

            // Create new node to become rear
            Node newRearNode = new Node(string, null, rear);

            // update current rear.next
            rear.next = newRearNode;

            // update rear
            rear = newRearNode;

//            originalRear.next = newRearNode;
//
//            rear = newRearNode;
////
//            // Update rear to new node which referenced originalRear
//            rear = new Node(string, null, originalRear);
//
//            // Update the original rears successor node from null to new rear
//            originalRear.next = rear;
//

           // Node newRearNode = new Node(string, null, rear);

//
//
//            rear.next = newRearNode;
//
//            rear = newRearNode;
        }

    }

    public void removeRear()
    {

        if(empty())
        {
            throw new EmptyQueueException();

        }

        else
        {
            // There is only 1 Node, if you remove rear you technically also remove front
            if(front == rear)
            {
                front = null;
                rear = null;
            }
            else
            {
                if(rear.previous != null)
                {
                    // Update rear
                    rear = rear.previous;

                    // Remove successor node from new rear
                    rear.next = null;
                }


            }
        }

    }

    /**
     * Returns the size of the Deque
     * @return size of Deque
     */
    public int size()
    {
        // Accumulator
        int counter = 0;

        if(!empty())
        {
            Node currentNode = front;

            while(currentNode != null)
            {
                counter ++;
                currentNode = currentNode.next;
            }
        }

        return counter;
    }

    /**
     *  Returns boolean value based on if Deque is empty
     * @return true or false depending on if Deque is empty
     */
    public boolean empty()
    {
        return front == null;
    }


    @Override
    public String toString()
    {
        Node currentNode;
        String data ="";

        if(!empty())
        {
            currentNode = front;

            while(currentNode != null)
            {
                // Add to string accumulator
                data = data + currentNode.value + "\n";

                // update to view next node
                currentNode = currentNode.next;
            }
        }

        return data;
    }

}
