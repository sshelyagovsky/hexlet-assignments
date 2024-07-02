@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page
@param NamedRoutes path

@template.layout.page(
content = @`
<p>List of posts</p>
@if(page.getPost().isEmpty())
    <p>No posts found yet!</p>
@else
    @for(var post : page.getPost())
        <div>
            <h6><a href="${path.postPath(post.getId())}">${post.getName()}</a></h6>
            <p>${post.getBody()}</p>
        </div>
    @endfor

    @if(page.getPageNumber() == 1)
        <a href="${path.postsPath()}?page=${page.getPageNumber() + 1}">Next</a>
    @elseif(page.getPageNumber() == page.getLastPageNum())
        <a href="${path.postsPath()}?page=${page.getPageNumber() - 1}">Back</a>
    @else
        <a href="${path.postsPath()}?page=${page.getPageNumber() - 1}">Back</a>
        <a href="${path.postsPath()}?page=${page.getPageNumber() + 1}">Next</a>
    @endif
@endif
`
)