<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring Security Example </title>
</head>
<body>


 <#if matches??>
     <#list matches as match>
         <form method="post" action="/makebet">
             <p> ${match.date}</p>
             <p> ${match.event1}</p>
             <p> ${match.event2}</p>
            <p> ${match.playerInfo.playername}</p>
             <p> ${match.playerInfo1.playername}</p>
             <select name="selected">
                 <option value="${match.event1}">${match.playerInfo.playername}</option>
                 <option value="${match.event2}">${match.playerInfo1.playername}</option>
             </select>
             <input name="mybet" placeholder="bet"/>
             <input type="hidden" name="tournamentId" value="${match.tournament.id}"/>
             <input type="hidden" name="matchId" value="${match.id}"/>


             <button type="submit"> submit </button>

         </form>

     </#list>
 </#if>



</body>
</html>
