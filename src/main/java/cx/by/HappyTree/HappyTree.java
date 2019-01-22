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

    public long length() {
        return length;
    }

    public HappyTree split(TreeNode node) {
        node.parent=null;
        return (HappyTree)node;
    }

    public void initChild() {
        children = new ArrayList<TreeNode>();
    }

    public boolean addChild(Object ... node) {
        for(Object item:node){
            if((item instanceof TreeNode||item instanceof HappyTree)){
                long maxLen=1;
                for (TreeNode tree:children) {
                    if(maxLen<tree.length())maxLen=tree.length();
                }
                for(int i = -1; i<(((HappyTree) item).length()-maxLen);i++){
                    incrLength();
                }

            }else {
                if(children.size()==0){
                    incrLength();
                }
            }
            ((HappyTree)item).setParent(this);

        }
        return true;
    }

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

    public boolean clear() {
        children.clear();
        while(length!=1){
            reduceLength();
        }
        return true;
    }

    public boolean insert(Object o){
        this.contain=o;
        return true;
    }

    public Object contain(){
        return contain;
    }

    public boolean setParent(Object node) {
        this.parent=node;
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(((TreeNode)obj).length()==length){
            if(null==((TreeNode)obj).contain()&&null==contain){
                return true;
            }
            return ((TreeNode)obj).contain().equals(contain);
        }
        return false;
    }
}