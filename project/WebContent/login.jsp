<style>
    div.login_parent
    {
        width:100%;
    }
    div.new_user
    {
        min-width: 49%;
        float:left;
        margin-top: 80px;
    }
    div.old_user
    {
        min-width: 49%;
        float:left;
        margin-top: 100px;
    }
    
</style>
<div class="login_parent">
    <div class="new_user" align="center">
        <table>
            <form action="Home?type=reg" method="post">
            <tr>
                <td>Username(display name):</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td><input type="password" name="cpassword"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td></td><td><input type="submit" value="Register"></td>
            </tr>
            </form>
        </table>
    </div>

    <div class="old_user" align="center">
        <table>
            <form action="Home?type=val" method="post">
            <tr>
                <td>Username:</td>
                <td><input type="input" name="username"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td></td><td><input type="submit" value="Sign In"></td>
            </tr>
            </form>
        </table>
        
    </div>
</div>