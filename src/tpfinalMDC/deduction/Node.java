package tpfinalMDC.deduction;


import java.util.ArrayList;
import java.util.List;

/**
* 
* @amar
*
*/
public class Node<T> {

private T data = null;
private String operation; 
private String hypo; 

private List<Node<T>> children = new ArrayList<>();

private Node<T> parent = null;

public Node(T data,String s) {
this.data = data;
this.operation=s;
}
public Node(T data,String s,int j) {
this.data = data;
this.operation=s;
this.hypo="H"+j;
}

public Node<T> addChild(Node<T> child) {
child.setParent(this);
this.children.add(child);
return child;
}

public void addChildren(List<Node<T>> children) {
children.forEach(each -> each.setParent(this));
this.children.addAll(children);
}

public List<Node<T>> getChildren() {
return children;
}

public T getData() {
return data;
}
public String getOp() {
return operation;
}

public String hypo() {
return this.hypo;
}

public void setOp(String s) {
 this.operation=s;;
}
public void setHypo(String s) {
	 this.hypo=s;;
	}

public void setData(T data) {
this.data = data;
}

private void setParent(Node<T> parent) {
this.parent = parent;
}

public Node<T> getParent() {
return parent;
}

}