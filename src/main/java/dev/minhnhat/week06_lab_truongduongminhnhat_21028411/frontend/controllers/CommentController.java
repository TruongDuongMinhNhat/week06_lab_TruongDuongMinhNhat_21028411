package dev.minhnhat.week06_lab_truongduongminhnhat_21028411.frontend.controllers;

import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Comment;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.Post;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.models.User;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.CommentService;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.PostService;
import dev.minhnhat.week06_lab_truongduongminhnhat_21028411.backend.service.impl.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/view-detail-comment/{id}")
    public String viewDetailComment(@PathVariable long id, Model model) {
        Comment comment = commentService.findById(id).get();
        model.addAttribute("commentDetail", comment);
        model.addAttribute("subComments", commentService.findSubComments(comment));
        return "comment/comment_detail";
    }

    @PostMapping("/add-comment/{postId}")
    public String pushComment(@PathVariable("postId") String id,
                              @RequestParam String title,
                              @RequestParam String content,
                              @RequestParam String published,
                              HttpServletRequest request,
                              Model model) {
        Post post = postService.findById(Long.parseLong(id)).get();
        User user = (User) request.getServletContext().getAttribute("accountLogin");

        Comment comment = new Comment(post, null, user, title, published.equalsIgnoreCase("Yes") ? true : false
                , LocalDateTime.now(), LocalDateTime.now(), content);
        commentService.save(comment);

        model.addAttribute("postDetail", post);
        model.addAttribute("listComments", commentService.findListCommentByPostId(post));
        return "post/post_detail";
    }

    @GetMapping("/add-sub-comment")
    public String addSubComment(@RequestParam String postId,
                                @RequestParam String commentParentId,
                                Model model) {
        Post post = postService.findById(Long.parseLong(postId)).get();
        Comment comment = commentService.findById(Long.parseLong(commentParentId)).get();

        model.addAttribute("postDetail", post);
        model.addAttribute("commentDetail", comment);
        return "comment/sub-comment_add";
    }

    @PostMapping("/add-sub-comment")
    public String addSubComment(@RequestParam String postId,
                                @RequestParam String commentParentId,
                                @RequestParam String title,
                                @RequestParam String published,
                                @RequestParam String content,
                                HttpServletRequest request,
                                Model model) {

        Post post = postService.findById(Long.parseLong(postId)).get();
        Comment parrentComment = commentService.findById(Long.parseLong(commentParentId)).get();

        Comment comment = new Comment(post, parrentComment, (User) request.getServletContext().getAttribute("accountLogin"),
                "Report to " + title, published.equalsIgnoreCase("Yes"), LocalDateTime.now(), LocalDateTime.now(),
                content);
        commentService.save(comment);

        model.addAttribute("commentDetail", comment);
        model.addAttribute("subComments", commentService.findSubComments(comment));
        return "comment/comment_detail";
    }
}
