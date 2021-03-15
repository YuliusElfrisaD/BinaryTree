package bianrytree;
public class treeNode {

    private treeNode leftChild, rightChild, parent;
    private int data;

    public treeNode getParent() {
        return parent;
    }

    public void setParent(treeNode parent) {
        this.parent = parent;
    }

    public treeNode() {
    }

    public treeNode(int elemen, treeNode parent) {
        this.data = elemen;
        this.parent = parent;
    }

    public int getElemen() {
        return data;    }
    public void setElemen(int elemen) {
        this.data = elemen;    }

    public treeNode getLeft() {
        return leftChild;    }
    public void setLeft(treeNode left) {
        this.leftChild = left;    }

    public treeNode getRight() {
        return rightChild;    }
    public void setRight(treeNode right) {
        this.rightChild = right;    }   
    
    public void insert(int x){
        if (x < data){
            if (this.leftChild==null){
                leftChild = new treeNode(x, this);                
            } else {
                leftChild.insert(x);
            }
        } else {
            if (this.rightChild==null){
                rightChild = new treeNode(x, this);                
            } else {
                rightChild.insert(x);
            }
        }
    }
}
