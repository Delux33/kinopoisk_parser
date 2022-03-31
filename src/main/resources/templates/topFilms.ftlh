<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container-fluid h-100 bg-light">
        <div class="row justify-content-center">
            <a class="nav-link" href="/">Main</a>
            <h3>Top films from Kinopoisk</h3>
            <button type="button" data-toggle="dropdown" class="btn btn-outline-info dropdown-toggle ml-2 mb-2">
                Date
            </button>
            <ul class="dropdown-menu">
                <#list dates as date>
                    <li>
                        <a class="dropdown-item" href="/tops/${date}">${date}</a>
                    </li>
                </#list>
            </ul>
        </div>
        <div class="form-group">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Position</th>
                    <th scope="col">Name</th>
                    <th scope="col">Rating</th>
                    <th scope="col">Release Year</th>
                    <th scope="col">Number of votes</th>
                    <th scope="col">Date</th>
                </tr>
                <tbody>
                <#list topFilms as film>
                    <tr>
                        <td>${film.position}</td>
                        <td>${film.name}</td>
                        <td align="center">${film.rating}</td>
                        <td align="center">${film.releaseYear}</td>
                        <td align="center">${film.numberOfVotes}</td>
                        <td>${film.date}</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</@c.page>