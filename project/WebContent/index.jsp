<%-- 
    Document   : index
    Created on : 28 Apr, 2015, 11:13:51 AM
    Author     : Rishabh
--%>

<style>
    div.header
    {
        position: static;
        background-color: red;
        min-height: 15%;
        border-color: black;
    }
    div.body
    {
        position: relative;
        background-color: blueviolet;
        min-height: 70%;
        max-height: 1000%;
        border-color: black;
        overflow-y: auto;
        overflow-style: move;
    }
    div.footer
    {
        position: relative;
        background-color: red;       
        min-height: 15%;
    }

    div.item
    {
        float: left;
        mid-width: 100px;
        max-width: 100px;
        margin-left: 5px;
    }

</style>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>title--------</title>
    </head>
    <body>
        <div id ="header" class ="header" align="right"><a href="SignOut">Sign Out</a></div>
        <div id ="body" class="body">
            <% String pageName = (String)request.getParameter("body");%>
            <jsp:include page ="<%=pageName%>" flush="true" />
        </div>
        <div id ="footer" class="footer"></div>
    </body>
</html>
