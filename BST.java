public class BST<T>
{
	class Node<T>
	{
		public T data;

		public Node<T> left, right;

		Node(Comparable data)
		{
			this.data = (T) data;
        	this.left = null;
			this.right = null;
		}
	}

	private Node<T> head;

	public BST()
	{
		head = null;
	}

    public boolean find(Comparable item)
	{
        return find(head, item);
    }

    private boolean find(Node<T> node, Comparable item)
	{
        if (node == null)
		{
            return false;
        }

        if(item.compareTo(node.data) == 0)
		{
            return true;
        }

        if (item.compareTo(node.data) < 0)
		{
			return find(node.left, item);
        }
		
		return find(node.right, item);

    }

    public void insert(Comparable data)
	{
        head = insert(this.head, data);
    }

    private Node<T> insert(Node<T> node, Comparable item)
	{
        if (node == null)
		{
            return new Node<T>(item);
        }
		
		if (item.compareTo(node.data) < 0)
		{
			node.left = insert(node.left, item);
        }
		
		else
		{
        	node.right = insert(node.right, item);
        }

        return node;
    }

    public void print()
	{
        print(this.head);
    }
	
    private void print(Node<T> node)
	{
        if (node != null)
		{
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        }
    }

    public void delete(Comparable item)
	{
        head = delete(this.head, item);
    }

    private Node<T> delete(Node<T> node, Comparable data)
	{
        if (node == null)
		{
            return node;
        }
		
		if(data.compareTo(node.data) < 0)
		{
            delete(node.left, data);
        }
		
		if(data.compareTo(node.data) > 0)
		{
            delete(node.right, data);
        }
		
		else
		{
            if (head.left == null && node.right == null)
			{
                head = null;
            }
			
			else if (head.left == null)
			{
                head = head.right;
            }
			
			else if (head.right == null)
			{
                head = head.left;
            }
			
			else
			{
                Node<T> smallest = findSmallest(head);

                head = smallest;
                head = delete(head.right, data);
            }
        }
		
        return head;
    }

    public Node<T> findSmallest(Node<T> node)
	{
        while(node.left != null)
		{
            node = node.left;
        }

        return node;
    }
}