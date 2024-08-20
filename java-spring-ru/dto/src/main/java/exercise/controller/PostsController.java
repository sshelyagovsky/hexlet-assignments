package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        var result = posts.stream()
                .map(this::toPostDTO)
                .toList();
        return result;
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDTO show(@PathVariable Long id) {
        var postDto = postRepository.findById(id)
                .map(this::toPostDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        var comments = commentRepository.findByPostId(id)
                .stream().map(this::toCommentDTO)
                .toList();
        postDto.setComments(comments);

        return postDto;
    }

    public PostDTO toPostDTO(Post post) {
        var dtoPost = new PostDTO();

        dtoPost.setId(post.getId());
        dtoPost.setTitle(post.getTitle());
        dtoPost.setBody(post.getBody());

        return dtoPost;
    }

    public CommentDTO toCommentDTO(Comment comment) {
        var dtoComments = new CommentDTO();

        dtoComments.setId(comment.getId());
        dtoComments.setBody(comment.getBody());

        return dtoComments;
    }
}
// END
