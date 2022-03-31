<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="col-6 mx-auto">
    <h3>
        Choose a time frame
        <button type="button" data-toggle="dropdown" class="btn btn-outline-info dropdown-toggle ml-3 mb-2">
            click here
        </button>
        <ul class="dropdown-menu">
            <#list dates as date>
                <li>
                    <a class="dropdown-item" href="/tops/${date}">${date}</a>
                </li>
            </#list>
        </ul>
    </h3>
</@c.page>