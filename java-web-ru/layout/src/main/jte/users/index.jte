@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    @for(var user : page.getUsers())
        <div>
            <h6><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h6>
        </div>
    @endfor
`
)