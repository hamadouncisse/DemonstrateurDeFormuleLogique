package tpfinalMDC;

import javax.swing.*;

import tpfinalMDC.deduction.JetonDeduction;
import tpfinalMDC.deduction.Node;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;



/*
 * A Viewer for Binary Trees.
 */
class BinaryTreeView<T> extends JPanel {

    /* The tree currently being display */
    protected Node<T> tree;

    /* The max. height of any tree drawn so far.  This
       is used to avoid the tree jumping around when nodes
       are removed from the tree. */
    protected int maxHeight;

    /* The font for the tree nodes. */
    protected Font font = new Font("Roman", 0, 14);
    protected Font font1 = new Font("Roman", 0, 12);
    
    /* 
     * Create a new window with the given width and height 
     * that is showing the given tree.
     */
    public BinaryTreeView(Node<T> tree) {

        //Initialize drawing colors, border, opacity.
        setBackground(Color.white);
        setForeground(Color.black);

        // Create window and make it so hitting the close icon
        // will terminate the program
     /*   JFrame f = new JFrame("BinaryTree View");
        
        
        f.getContentPane().add(this, BorderLayout.CENTER);
        f.setSize(new Dimension(width, height));
        f.setVisible(true);
        
        // install initial tree.*/
        setTree(tree);
    }

    /*
     * Set the display to show the given tree.
     */ 
    public void setTree(Node<T> t) {
        tree = t;
        maxHeight = this.getHeight(tree);
    }
    private static <T> void printTree(Node<T> node, String appender) {
 	   System.out.println(appender + ((JetonDeduction) node.getData()).getval());
 	   node.getChildren().forEach(each ->  printTree(each, appender + appender));
 	 }
    
    private <T> int getHeight(Node<T> root){

 	    if (root.getChildren().size()==0) {
 	        return 1;
 	    }

 	    int height=0;
 	    //Iterate every child
 	    for (Node<T> childNode  : root.getChildren()) {

 	        //Get the height again
 	        int childHeight = getHeight(childNode);

 	        //Update if new high result
 	        if (childHeight>height) {
 	            height = childHeight;
 	        }
 	    }

 	    //Return highest point
 	    return height + 1;
 	}
    /*
     * Invoke this method whenever you would like the window
     * to be refreshed, such as after updating the tree in some
     * way.
     */
    public void refresh() {
        paintImmediately(0,0, getWidth(), getHeight());
    }


    /*
     * Draw the contents of the tree into the given Graphics
     * context.
     * It will place all info between minX and maxX in the x-direction,
     * starting at location y in the y-direction.  Levels of the tree
     * will be separated by yStep pixels.
     */
    protected void drawTree(Graphics g, int x, int y, 
                            int barre,  Node<T> tree,int p) {

        String s = ((JetonDeduction) tree.getData()).getval();
        String op=tree.getOp();
        String h=tree.hypo();
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();
        int width = fm.stringWidth(s);
        int height = fm.getHeight();
        int nb=tree.getChildren().size();
        g.drawString(s, x-(width/2), y);
        if(p==2) {
        	barre=barre/2;
        }else if(p==3) {
        	barre=barre/3;
        }
        
        if(nb==0) {
        	 g.setFont(font1);
        		g.setColor( Color.red );
        	 g.drawString(tree.hypo(), x-(width/2), y-10);	
        	 g.setFont(font);
        	 g.setColor( Color.black );
        }
        if(nb!=0) {
        g.drawString(op, x+(barre/2)-20, y-10);
        g.drawLine(x-(barre/2)+20, y-15, x+(barre/2)-20, y-15);
           if(nb==1) {
        	   drawTree(g,x,y-16,barre,tree.getChildren().get(0),1);
           }else if(nb==2) {
        	   List<Node<T>> children = tree.getChildren();
        	   int x1=x-(barre/4); int y1=y-16;
        	   
        	   
        	   for(int i=0;i<children.size();i++) {
        		   drawTree(g,x1,y1,(barre),tree.getChildren().get(i),2);
        		   x1=x1+((x-x1)*2);
        	   }
           }else if(nb==3) {
        	   //(a∧b)⇒(b∧c)
        	   List<Node<T>> children = tree.getChildren();
        	   int x1=x-(barre/3); int y1=y-16;
        	   int pas=x1;
        	   
        	   
        	   for(int i=0;i<children.size();i++) {
        		   drawTree(g,x1,y1,(barre),tree.getChildren().get(i),3);
        		   x1=x1+(pas*2);
        		   
        	   }
           }
        }
        
    }


    /*
     * paint method unherited from the Swing library.  Just
     * calls drawTree whenever the window needs to be repainted.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);      //clears the background
       
        maxHeight = getHeight(tree);
     
              int v=1;
        drawTree(g, (maxHeight*200)/2,maxHeight*24,maxHeight*200, tree,v);

    } 

    /* 
     * Test code.
     */
   
}