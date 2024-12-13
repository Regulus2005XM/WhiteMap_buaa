package com.whitemap.whitespringboot3.entities.Comments;

import java.util.ArrayList;
import java.util.List;


public class CommentManager {
    private int offset = 0;
    private List<Comment> roots;

    public CommentManager() {
        roots = new ArrayList<Comment>();
    }

    public List<Comment> getMore(int limit) {
        if(limit <=0)
            throw new IllegalArgumentException("limit must be greater than 0");
        return null;
    }
    public List<Comment> getAll() {
        return roots;
    }
}
