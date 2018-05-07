import java.io.*;

class Main {
	
	static class No{
		int data;
		No left;
		No right;
		
		public No(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
	
	static class Tree{
		protected String posStr = "";
		protected static int preIndex = 0;
		
		//pre-in scheme to build the tree
		private No buildTree(String in[], String pre[], int start, int end) 
	    {
	        if (start > end) return null;
	        
	        int value = Integer.parseInt(pre[preIndex++]);
	        No nNo = new No(value);
	 
	        if (start == end) return nNo;
	  
	        int index = search(in, start, end, nNo.data);
	  
	        nNo.left = buildTree(in, pre, start, index - 1);
	        nNo.right = buildTree(in, pre, index + 1, end);
	  
	        return nNo;
	    }
		
		private int search(String array[], int start, int end, int data) 
	    {
	        int i;
	        for (i = start; i <= end; i++) 
	        {
	        	int aValue = Integer.parseInt(array[i]);
	            if ( aValue == data) return i;
	        }
	        return i;
	    }
		
		private void posOrderTree(No no) 
	    {
	        if (no == null) return;

	        posOrderTree(no.left);
	        posOrderTree(no.right);

	        posStr += no.data + " ";
	    }
		
		private String equalsStr() {
			return posStr;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		Tree tree = new Tree();
		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(input.readLine());

		String pre = input.readLine();
		String preOrder[] = pre.split(" ");
		
		String pos = input.readLine();
		
		String inOr = input.readLine();
		String inOrder[] = inOr.split(" ");
		
		No root = tree.buildTree(inOrder, preOrder, 0, size-1);
		
		tree.posOrderTree(root);
		
		String posTree = tree.equalsStr();

		String posStr = posTree.substring(0, posTree.length() - 1);
		
		if(pos.equals(posStr)) 
			System.out.println("yes");
		
		else System.out.println("no");

	}
	
}