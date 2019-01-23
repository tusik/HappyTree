/*
 * Copyright (c) 2019. All rights reserved.
 * @Author: https://by.cx
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cx.by.HappyTree;

import cx.by.HappyTree.inter.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode implements Tree {
    protected HappyTree root;
    protected Object parent;
    protected Object contain;
    protected long length;
    protected List<TreeNode> children;

    public TreeNode(){
        init();
    }
    public TreeNode(Object contain){
        init();
        this.contain = contain;
    }
    private void init(){
        parent   = null;
        length   = 1;
        contain  = null;
        children = new ArrayList<>();
    }
    public boolean setRoot(HappyTree tree){
        this.root = tree;
        return true;
    }

    @Override
    public boolean setParent(Object node) {
        if(node instanceof TreeNode){
            this.parent = node;
            Object tmp  = node;
            while (null != ((TreeNode) tmp).parent()){
                tmp = root.parent();
            }
            if(tmp instanceof HappyTree)
                root = (HappyTree) tmp;
        }
        return false;
    }

    @Override
    public TreeNode parent() {
        return (TreeNode) parent;
    }

    @Override
    public HappyTree split(TreeNode node) {
        if(children.indexOf(node)>=0){
            node.parent = null;
            removeChild(node);
        }
        return (HappyTree)node;
    }

    @Override
    public List<TreeNode> children() {
        return children;
    }

    @Override
    public boolean addChild(Object... node) {
        for(Object item:node){
            if((item instanceof TreeNode)){
                if(root==null){
                    Object tree = root();
                    if(tree instanceof HappyTree){
                        HappyTree t = (HappyTree) tree;
                        if(t.innerList.get(this)!=null){
                            t.innerList.get(this).add((TreeNode)item);
                        }
                    }
                }else {
                    if(root.innerList.get(this)!=null){
                        root.innerList.get(this).add((TreeNode)item);
                    }else {
                        root.innerList.put(this,new ArrayList<Object>());
                    }
                }
                long maxLen = 1;
                for (TreeNode tree:children) {
                    if(maxLen<tree.length())maxLen=tree.length();
                }
                for(int i = -1; i<(((TreeNode) item).length()-maxLen);i++){
                    incrLength();
                }
                children.add((TreeNode) item);
                ((TreeNode)item).setParent(this);
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeChild(Object node) {
        if(children.indexOf((TreeNode) node)>=0){
            if(((TreeNode)node).length()==length-1){
                for(int i =0;i<length-1;i++){
                    reduceLength();
                }
            }
            return children.remove(node);
        }
        return false;
    }

    @Override
    public boolean clear() {
        children.clear();
        while(length!=1){
            reduceLength();
        }
        return true;
    }

    @Override
    public boolean insert(Object o) {
        this.contain = o;
        return true;
    }

    @Override
    public Object contain() {
        return contain;
    }

    @Override
    public void incrLength() {
        length++;
        if(null!=parent){
            ((TreeNode)parent).incrLength();
        }
    }

    @Override
    public void reduceLength() {
        if(length>1){
            length--;
        }
        if(null!=parent){
            ((TreeNode)parent).reduceLength();
        }
    }

    @Override
    public long length() {
        return length;
    }

    @Override
    public TreeNode[] findToRear(Object contain) {
        return new TreeNode[0];
    }

    @Override
    public TreeNode[] findToFrond(Object contain) {
        return new TreeNode[0];
    }

    @Override
    public TreeNode[] findAll(Object contain) {
        return new TreeNode[0];
    }

    @Override
    public TreeNode root() {
        if(null != parent){
            TreeNode node = (TreeNode) parent;
            while(null!=node.parent){
                node = node.parent();
            }
            return node;
        }else {
            return this;
        }
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TreeNode){
            if(((TreeNode)obj).length()==length){
                if(null==((TreeNode)obj).contain()&&null==contain){
                    return true;
                }
                return ((TreeNode)obj).contain().equals(contain);
            }
        }
        return false;
    }
}
