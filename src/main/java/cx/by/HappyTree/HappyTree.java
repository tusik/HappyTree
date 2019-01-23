/*
 * Copyright (c) 2019. All rights reserved.
 * @Author: https://by.cx
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cx.by.HappyTree;

import cx.by.HappyTree.inter.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class HappyTree extends TreeNode {
    protected HashMap<TreeNode,ArrayList<Object>> innerList = new HashMap<>();
    public HappyTree(){
        super();
        root=this;
    }
    public HappyTree(Object contain){
        super(contain);
    }

    @Override
    public ArrayList<TreeNode> findAll(Object contain) {
        Iterator key = innerList.keySet().iterator();
        ArrayList<TreeNode> list = new ArrayList<>();
        while(key.hasNext()){
            TreeNode node = (TreeNode) key.next();
            for(Object o : innerList.get(node)){
                if(o==contain){
                    list.add(node);
                }
            }
        }
        return list;
    }

    @Override
    public boolean addChild(Object... node) {
        for(Object o:node){
            ((TreeNode)o).setRoot(this);
//            if(this.innerList.get(this)==null){
//                ArrayList<Object> list = new ArrayList<>();
//                list.add(((TreeNode) o).contain);
//                this.innerList.put(this,list);
//            }else {
//                this.innerList.get(this).add(((TreeNode) o).contain);
//            }
            listTreeToSetRoot((TreeNode) o);
        }
        return super.addChild(node);
    }
    private void listTreeToSetRoot(TreeNode node){
        for(TreeNode n:node.children()){
            n.setRoot(this);
            if(this.innerList.get(n.parent)==null){
                ArrayList<Object> list = new ArrayList<>();
                list.add(((TreeNode) n));
                this.innerList.put(node,list);

            }else {
                this.innerList.get(node).add(((TreeNode) n));
            }
            if(n.children().size()>0){
                listTreeToSetRoot(n);
            }
        }
    }

}