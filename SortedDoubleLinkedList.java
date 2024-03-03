package linkedList;

import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	Comparator<T> comparator;
	
	
	public SortedDoubleLinkedList(Comparator<T> compareableObject) 
	{
		super();
		this.comparator= compareableObject;
		
	}
	public void add(T data)
	{
	    Node<T> newNode = new Node<>(data);
	    if(head==null) //the list is empty before the add
	    {
	    	head=newNode;
	    	tail=newNode;
	    }
	    else//the list is not empty
	    {
	       Node<T> temp=head;
	       while(comparator.compare(newNode.data, temp.data)>0&&temp.next!=null)//will iterate temp until the end of the list or until temp is larger than newNode
	       {
	    	   temp=temp.next;
	       }
	       if(comparator.compare(newNode.data, temp.data)<=0)//newNode is less than or equal to temp
	       {
	    	   if(temp==head) //temp is head
	    	   {
	    		   temp.prev=newNode;
	    		   newNode.next=temp;
	    		   head=newNode;
	    	   }
	    	   else
	    	   {
	    		   temp.prev.next=newNode;
	    		   newNode.prev=temp.prev;
	    		   newNode.next=temp;
	    		   temp.prev=newNode;
	    	   }
	    	   if(comparator.compare(newNode.data, temp.data)>0)//newNode is greater than temp
	    	   {
	    		   if(temp==tail)
	    		   {
	    			   temp.next=newNode;
	    			   newNode.prev=temp;
	    			   tail=newNode;
	    		   }
	    		   else
	    		   {
	    			   temp.next.prev=newNode;
	    			   newNode.next=temp.next;
	    			   newNode.prev=temp;
	    			   temp.next=newNode;
	    		   }
	    	   }
	    	
	       }
	    }
	size++;
	}
public Node<T> remove(T data,Comparator<T> comparator)
{
	Node<T> current=head;
	while(current!=null&&comparator.compare(data,current.data)!=0)
	{
		current=current.next;
	}
	if(current==null)
	{
		return null;
	}
	else//current is not null so there is a match
	{
		if(head.next==null)//only 1 node but its a match
		{
			head=null;
			tail=null;
		}
		else
		{
			if(current==head)//if the match is head
			{
				current.next.prev=null;
				head=current.next;
				
			}
			else
			{
				if(tail==current)//if the match is tail
				{
					current.prev.next=null;
					tail=current.prev;
					
				}
				else//other cases
				{
					current.prev.next=current.next;
					current.next.prev=current.prev;
				
				}
			}
		}
		
		size--;
		return current;
	}
	
	
}

	public ListIterator<T> iterator()
	{
		return new DoubleLinkedListIterator();
	}
	
	public void addtoFront()
	{
		throw new UnsupportedOperationException("Cannot add directly to the front of a sorted list.");
	}
	public void addtoEnd()
	{
		throw new UnsupportedOperationException("Cannot add directly to the front of a sorted list.");
	}

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    Node<T> current = head;

    // Start the list representation
    sb.append("[");

    // Traverse the list
    while (current != null) {
        sb.append(current.data.toString());
        if (current.next != null) {
            sb.append(", "); // Add a comma separator between elements
        }
        current = current.next; // Move to the next node
    }

    // Close the list representation
    sb.append("]");
    System.out.print(sb.toString());
    return sb.toString();
}
}
