package cx.by.HappyTree;

import cx.by.HappyTree.inter.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HappyTree implements Serializable, Tree {
    public Object parent=null;
    private List<TreeNode> children;
    private Object contain=null;
    private long length=1;
    public HappyTree(){
        initChild();
    }

    public HappyTree(Object o){
        initChild();
        this.contain=o;
    }

    protected void fixLength(){

    }

    public void incrLength(){
        length++;
        if(null!=parent){
            ((TreeNode)parent).incrLength();
        }
    }

    public void reduceLength(){
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
    public HappyTree split(TreeNode node) {
        node.parent=null;
        return (HappyTree)node;
    }

    @Override
    public void initChild() {
        children = new ArrayList<>();
    }

    @Override
    public boolean addChild(Object node) {

        if((node instanceof TreeNode||node instanceof HappyTree)){
            for(int i = 0; i<((TreeNode) node).length();i++){
                length++;
            }
            if(null==parent){

            }else {
                for(int i = 0; i<((TreeNode) node).length();i++){
                    ((TreeNode)parent).incrLength();
                }
            }

        }else {
            if(children.size()==0){
                length++;
                if(null!=parent)
                    ((TreeNode)parent).incrLength();
            }else {

            }
        }
        ((HappyTree)node).setParent(this);
        return children.add((TreeNode) node);
    }

    @Override
    public boolean removeChild(Object node) {
        return children.remove(node);
    }

    @Override
    public boolean clear() {
        children.clear();
        return true;
    }
    @Override
    public boolean insert(Object o){
        this.contain=o;
        return true;
    }
    @Override
    public Object contain(){
        return contain;
    }

    @Override
    public boolean setParent(Object node) {
        this.parent=node;
        return true;
    }
}