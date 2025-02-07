<#if PartyList?has_content>
<table class="table table-bordered table-striped table-hover">
    <thead>
        <tr>
            <th>${uiLabelMap.partyId}</th>
            <th>${uiLabelMap.partyName}</th>
        </tr>
    </thead>
    <tbody>
        <#list PartyList as party>
            <tr>
                <td>${party.partyId}</td>
                <td>${party.partyName?default("NA")}</td>
            </tr>
        </#list>
    </tbody>
</table>
</#if>
