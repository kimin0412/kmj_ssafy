package com.ssafy.graph;

public class GraphNode {
	int vertex;
	GraphNode link;
	public GraphNode(int vertex, GraphNode link) {
		this.vertex = vertex;
		this.link = link;
	}
	
//	public String toString() {
//		String linkStr = link==null?"":link.toString();
//	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GraphNode [vertex=").append(vertex).append(", link=").append(link).append("]");
		return builder.toString();
	}
	

}
