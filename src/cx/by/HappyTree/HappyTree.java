package cx.by.HappyTree;

import sun.reflect.generics.tree.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HappyTree implements Serializable {
    private HappyTree parent=null;
    private List<HappyTree> children;
    private Object contain=null;
    private long length=1;
    public HappyTree(){ init(); }
    public HappyTree(Object o){
        init();
        this.contain=o;
    }
    private void init(){
        this.children=new ArrayList<>();
    }
    public int count(){
        return children.size();
    }
    public long length(){
        return length;
    }
    public boolean add(HappyTree o){
        if(children.size()==0){
            length++;
            if(null!=parent)
                parent.length();
        }
        o.setParent(this);
        return children.add(o);
    }
    public boolean remove(HappyTree o){
        return children.remove(o);
    }
    protected void fixLength(){

    }
    protected void incrLength(){
        length++;
        if(null!=parent){
            parent.incrLength();
        }
    }
    protected void reduceLength(){
        if(length>1){
            length--;
        }
        if(null!=parent){
            parent.reduceLength();
        }
    }
    protected void setParent(HappyTree parent){
        this.parent=parent;
    }
    public void insert(Object o){
        this.contain=o;
    }
    public Object contain(){
        return contain;
    }
}