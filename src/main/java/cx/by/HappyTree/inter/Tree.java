/*
 * Copyright (c) 2019. All rights reserved.
 * @Author: https://by.cx
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package cx.by.HappyTree.inter;

import cx.by.HappyTree.HappyTree;
import cx.by.HappyTree.TreeNode;

import java.util.List;

public interface Tree {
    boolean setParent(Object node);
    TreeNode parent();
    HappyTree split(TreeNode node);
    List<TreeNode> children();
    boolean addChild(Object ... node);
    boolean removeChild(Object node);
    boolean clear();
    boolean insert(Object o);
    Object contain();
    void incrLength();
    void reduceLength();
    long length();
    TreeNode[] findToRear(Object contain);
    TreeNode[] findToFrond(Object contain);
    TreeNode[] findAll(Object contain);
    TreeNode root();
}
