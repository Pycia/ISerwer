<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=windows-1250">
    <title></title>
</head>
<body>
<div id="loginPanel">
    <form action="/login" id="loginForm">
       <label>Login:</label>
       <input type="text" name="login" id="login"></input>
       <label>Password:</label>
       <input type="text" name="password" id="password"></input>
       <div id="loginLower">
           <input type="checkbox"></input><label memory="memory">Remember me</label>
           <input type="submit" value="Login"></input>
       </div>
    </form>
</div>
       <div id="alert">
       <%
           if ("true".equals(request.getParameter("error"))) {
               out.println("Your login or password is invalid");
           }
       %>
       </div>

       <script src="http://crypto-js.googlecode.com/svn/tags/3.0.2/build/rollups/md5.js"></script>
       <script>

       // Attach a submit handler to the form
       $( "#loginForm" ).submit(function( event ) {
         // Stop form from submitting normally
         event.preventDefault();

         // Get some values from elements on the page:
         var $form = $( this ),
           login = $form.find( "input[name='login']" ).val(),
           pass = $form.find( "input[name='password']" ).val(),
           passwordH = CryptoJS.MD5(pass).toString();
           url = $form.attr( "action" );
         $.ajax({ type: "POST",
                  url:  $form.attr( "action" ),
                  data: { login: login , passwordHash: passwordH },
                  success : function(text)
                  {
                     top.location.href=text;
                  }
             });

         });
       </script>
 </body>
 </html>
                                                                                                                                                