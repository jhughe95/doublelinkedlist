package linkedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{
	int size;
	 Node<T> head;
	 Node<T> tail;
	public class DoubleLinkedListIterator implements ListIterator<T>
	{
	Node<T> temp;
	
	
	public DoubleLinkedListIterator()
	{
		temp = head;
	}


		@Override
		public boolean hasNext() {
			if(temp.next==null)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		@Override
		public T next() {
			if(hasNext()||temp==tail)//will iterate if temp has a .next and if temp is at the end of the list
			{
				T dataOfTemp=temp.data;
				temp=temp.next;
				return dataOfTemp;
			}
			else 
			{
				throw new NoSuchElementException();
			}
		
		}

		@Override
		public boolean hasPrevious() {
	if(temp.prev==null)
	{
		return false;
	}
	else
	{
		return true;
	}
		}

		@Override
		public T previous() {
			if(hasPrevious()) 
			{
			T dataOfNode=temp.data;
			temp=temp.prev;
			return dataOfNode; 
			}
			else
			{
			throw new NoSuchElementException();
			}
							}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	
	
public class Node<T>
{
	T data;
	Node<T> next;
	Node<T> prev;
	Node (T data)
	{
		this.data=data;
	}
}
	public int getSize()
	{
		return size;
	}

	BasicDoubleLinkedList()
	{
		head=null;
		tail=null;
		size=0;
	}
	public void addToEnd(T data)
	{
		Node<T> newNode= new Node<T>(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
			size++;
		}
		else
		{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			size++;
		}
	}
	
	public void addToFront(T data) 
	{
		Node<T> newNode= new Node<T>(data);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
			size++;
		}
		else 
		{
			newNode.next=head;
			head.prev=newNode;
			head=newNode;
			size++;
		}
	}
	
	public T getFirst() 
	{
		return head.data;
	}
	public T getLast() 
	{
		return tail.data;
	}
	
	public ListIterator<T> iterator()
	{
	return new DoubleLinkedListIterator();
	}

	public T retrieveFirstElement() 
	{T dataOfFirst=head.data;
		if(head==null)//list is empty
		{
			return dataOfFirst;
		}
		else if(head==tail)//list has 1 node
		{
			head=null;
			return dataOfFirst;
		}else//any other case which means 2 or more
		{
			
			head.next.prev=null;
			head=head.next;
			return dataOfFirst;
		}
	}
	public T retrieveLastElement() 
	{T dataOfLast=tail.data;
		if (tail==null) //list is empty
		{
			return null;
		}
		else if(tail==head)//list has 1 node
		{
			tail=null;
			return dataOfLast;
			
		}
		else//2 or more nodes
		{
			
			tail.prev.next=null;
			tail=tail.prev;
			return dataOfLast;
		}
	}
	public ArrayList<T> toArrayList()
	{
		ArrayList<T> list=new ArrayList<T>();
		Node<T> temp=head;
		while(temp!=null)
		{
			list.add(temp.data);
			temp=temp.next;
		}
		return list;
	}
	public Node<T> remove(T data, Comparator<T> comparator) {
	    Node<T> current=head;
	    while(comparator.compare(data,current.data)!=0 && current!=null)
	    {
	        current = current.next;
	    }

	    if(current==null)//if list does not have a match
	    {
	        return null; 
	    }
	    else{//list does have a match

	    if (current==head)//if head is the match
	    {
	    	if(head.next==null) //if head is the only node in the list
	    	{
	    		head=null;
	    		size--;
	    		return current;
	    	}
	    	else//if head is the match and head.next is not null
	    	{
	    		head.next.prev=null;
	    		head=head.next;
	    		size--;
	    		return current;
	    	}
	       
	    } 
	    else//if there is a match that is not head
	    {
	    if(current==tail)//if the match is the tail
	    {
	    	tail.prev.next=null;
	    	tail=tail.prev;
	    	size--;
	    	return current;
	    }
	    else//if the match is not the tail
	    {
	        current.prev.next=null;
	        current.next.prev=null;
	        size--;
	        return current;
	    }

	    }}}
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
	    return sb.toString();
	}
	





}
