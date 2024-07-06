@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page
@param NamedRoutes path

@template.layout.page(
content = @`
    <p>List of posts</p>
    @if(page.getPosts().isEmpty())
        <p>No posts found yet!</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <h6><a href="${path.postPath(post.getId())}">${post.getName()}</a></h6>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    @endif
`
)