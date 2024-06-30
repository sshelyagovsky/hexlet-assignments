@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Search" />
    </form>
    @if(!page.getUsers().isEmpty())
        @for(var user : page.getUsers())
            <div>
                <h6><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h6>
            </div>
        @endfor
    @endif
`
)