package com.whitemap.whitespringboot3.web.controller;

import com.whitemap.whitespringboot3.web.controller.response.ResponseMessage;
import com.whitemap.whitespringboot3.entity.Comment;
import com.whitemap.whitespringboot3.service.ICommentService;
import com.whitemap.whitespringboot3.service.ISubjectService;
import com.whitemap.whitespringboot3.web.dto.Comment.SendCommentDTO;
import com.whitemap.whitespringboot3.web.dto.Comment.SubjectDTO;
import org.apache.ibatis.javassist.tools.rmi.ObjectNotFoundException;
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

    @GetMapping()
    public ResponseMessage<SubjectDTO> getSubjectInfo() {
        // TODO
        return null;
    }
}
