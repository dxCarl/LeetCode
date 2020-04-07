package com.xiao.deng.jz_offer.common;

public class BinaryTreeWithParentNode {
    private int val;
    private BinaryTreeWithParentNode left;
    private BinaryTreeWithParentNode right;
    private BinaryTreeWithParentNode parent;

    public BinaryTreeWithParentNode(int val) {
        this.val = val;
    }

    public BinaryTreeWithParentNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeWithParentNode left) {
        this.left = left;
    }

    public BinaryTreeWithParentNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeWithParentNode right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public BinaryTreeWithParentNode getParent() {
        return parent;
    }

    public void setParent(BinaryTreeWithParentNode parent) {
        this.parent = parent;
    }
}
