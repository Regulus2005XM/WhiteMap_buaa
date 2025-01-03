package com.whitemap.whitespringboot3.web.controller;
import java.util.List;
import com.whitemap.whitespringboot3.DB.mapper.CommentMapper;
import com.whitemap.whitespringboot3.DB.dao.CommentContentDAO;
import com.whitemap.whitespringboot3.web.controller.response.ResponseMessage;
import com.whitemap.whitespringboot3.DB.pojo.comments.CommentContentPOJO;
import com.whitemap.whitespringboot3.DB.pojo.comments.CommentIndexPOJO;
import com.whitemap.whitespringboot3.entity.Comment;
import com.whitemap.whitespringboot3.service.ICommentService;
import com.whitemap.whitespringboot3.service.ISubjectService;
import com.whitemap.whitespringboot3.web.dto.Comment.SendCommentDTO;
import java.util.ArrayList;

import org.apache.ibatis.javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/comment")
@RestController
public class CommentController {
    @Autowired
    ICommentService commentService;
    @Autowired
    ISubjectService subjectService;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentContentDAO commentContentDAO;
    @PostMapping("/send")
    public ResponseMessage<Comment> sendComment(@RequestBody SendCommentDTO dto) throws ObjectNotFoundException {
        // 格式校验
        if(dto.getContent() == null || dto.getContent().trim().equals(""))
            return ResponseMessage.info(null,"content is empty", HttpStatus.BAD_REQUEST);
        if(dto.getContent().length() > 300)
            return ResponseMessage.info(null,"content is too long", HttpStatus.BAD_REQUEST);
        // 数据库校验
        if(!subjectService.subjectExist(dto.getObjId(),dto.getObjType()))
            return ResponseMessage.info(null,"subject not found", HttpStatus.BAD_REQUEST);
        if(dto.getRoot()!=0 && !commentService.commentExist(dto.getObjId(),dto.getObjType(),dto.getRoot(),dto.getParent()))
            return ResponseMessage.info(null,"comment not found", HttpStatus.BAD_REQUEST);
        // 添加并返回
        Comment comment = commentService.add(dto);
        // Subject更新
        subjectService.updateCount(dto.getObjId(),dto.getRoot()==0);
        return ResponseMessage.success(comment);
    }

    @GetMapping("/{objId}/{objType}")
    public ResponseMessage<List<Comment>> getSubjectInfo(
            @PathVariable Integer objId,
            @PathVariable Integer objType) {
        try {
            // 获取主题相关的所有评论索引
            List<CommentIndexPOJO> indexList = commentMapper.getBySubject(objId, objType);
    
            // 构建返回对象列表
            List<Comment> comments = new ArrayList<>();
            for (CommentIndexPOJO index : indexList) {
                // 查询评论内容
                CommentContentPOJO content = commentContentDAO.findById(index.getID()).orElse(null);
                if (content == null) {
                    continue;
                }
    
                // 将索引和内容合并为完整评论对象
                Comment comment = new Comment();
                BeanUtils.copyProperties(index, comment);
                BeanUtils.copyProperties(content, comment);
    
                comments.add(comment);
            }
    
            // 返回成功的响应
            return ResponseMessage.success(comments);
    
        } catch (Exception e) {
            // 异常处理，返回服务器错误
            return ResponseMessage.info(null, "Error fetching comments: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
