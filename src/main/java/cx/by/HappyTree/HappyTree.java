/*
 * Copyright (c) 2019. All rights reserved.
 * @Author: https://by.cx
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cx.by.HappyTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HappyTree extends TreeNode {
    protected HashMap<TreeNode,ArrayList<Object>> innerList = new HashMap<>();
    public HappyTree(){
        super();
        root=this;
    }
    @Override
    public boolean addChild(Object... node) {
        for(Object o:node){
            ((TreeNode)o).setRoot(this);
            if(this.innerList.get(this)==null){
                ArrayList<Object> list = new ArrayList<>();
                list.add(((TreeNode) o).contain);
                this.innerList.put(this,list);
            }else {
                this.innerList.get(this).add(((TreeNode) o).contain);
            }
            listTreeToSetRoot((TreeNode) o);
        }
        return super.addChild(node);
    }
    private void listTreeToSetRoot(TreeNode node){
        for(TreeNode n:node.children()){
            n.setRoot(this);
            if(this.innerList.get(n.parent)==null){
                ArrayList<Object> list = new ArrayList<>();
                list.add(((TreeNode) n).contain);
                this.innerList.put(node,list);

            }else {
                this.innerList.get(node).add(((TreeNode) n).contain);
            }
            if(n.children().size()>0){
                listTreeToSetRoot(n);
            }
        }
    }

}