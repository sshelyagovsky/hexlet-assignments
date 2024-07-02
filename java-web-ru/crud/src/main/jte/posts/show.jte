@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage

@param PostPage page
@param NamedRoutes path

@template.layout.page(
content = @`
    <a href="${path.postsPath()}">All posts</a>
    <div>
        <h2>${page.getPost().getName()}</h2>
        <p>${page.getPost().getBody()}</p>
    </div>
`
)