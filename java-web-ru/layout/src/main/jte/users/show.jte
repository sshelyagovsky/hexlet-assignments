@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <div>
        <h2>${page.getUser().getLastName()}</h2>
        <h3>${page.getUser().getFirstName()}</h3>
        <p>${page.getUser().getEmail()}</p>
    </div>
`
)