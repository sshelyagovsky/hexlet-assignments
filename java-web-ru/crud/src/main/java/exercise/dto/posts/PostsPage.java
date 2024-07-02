package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
// BEGIN
public class PostsPage {
    private List<Post> post;
    private int pageNumber;
    private int lastPageNum;
}
// END


