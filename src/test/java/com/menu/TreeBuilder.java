/*package com.menu;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder<T> {

	List<T> nodes = new ArrayList<T>();

	public TreeBuilder(List<T> nodes) {
		super();
		this.nodes = nodes;
	}

	*//**
	 * 构建树形结构
	 * 
	 * @return
	 *//*
	public List<T> buildTree() {
		List<T> treeNodes = new ArrayList<T>();
		List<T> rootNodes = getRootNodes();
		for (T rootNode : rootNodes) {
			buildChildNodes(rootNode);
			treeNodes.add(rootNode);
		}
		return treeNodes;
	}

	*//**
	 * 递归子节点
	 * 
	 * @param node
	 *//*
	public void buildChildNodes(T node) {
		List<T> children = getChildNodes(node);
		if (!children.isEmpty()) {
			for (T child : children) {
				buildChildNodes(child);
			}
			node.setChildren(children);
		}
	}

	*//**
	 * 获取父节点下所有的子节点
	 * 
	 * @param nodes
	 * @param pnode
	 * @return
	 *//*
	public List<T> getChildNodes(T pnode) {
		List<T> childNodes = new ArrayList<T>();
		for (T n : nodes) {
			if (pnode.getwTId().equals(n.getwTFatherId()) && !n.getwTFatherId().equals(n.getwTId())) {
				childNodes.add(n);
			}
		}
		return childNodes;
	}

	*//**
	 * 判断是否为根节点
	 * 
	 * @param nodes
	 * @param inNode
	 * @return
	 *//*
	public boolean rootNode(T node) {
		boolean isRootNode = false;
		if (node.getFatherId().equals(node.getId())) {
			isRootNode = true;
		}
		return isRootNode;
	}

	*//**
	 * 获取集合中所有的根节点
	 * 
	 * @param nodes
	 * @return
	 *//*
	public List<T> getRootNodes() {
		List<T> rootNodes = new ArrayList<T>();
		for (T n : nodes) {
			if (rootNode(n)) {
				rootNodes.add(n);
			}
		}
		return rootNodes;
	}
}
*/