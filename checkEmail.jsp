<%-- 
    Document   : newjsp
    Created on : 13-feb-2018, 8.54.46
    Author     : sala.stefano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head><title>Email Validation</title>
    <script language = "Javascript">

        function emailcheck(str) {

            var at="@"
            var dot="."
            var lat=str.indexOf(at)
            var lstr=str.length
            var ldot=str.indexOf(dot)
            if (str.indexOf(at)==-1){
                alert("Invalid E-mail ID")
                return false
            }

            if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr){
                document.write("Invalid E-mail ID");
                return false
            }

            if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr){
                document.write("Invalid E-mail ID");
                return false
            }

            if (str.indexOf(at,(lat+1))!=-1){
                document.write("Invalid E-mail ID");
                return false
            }

            if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot){
                document.write("Invalid E-mail ID");
                return false
            }

            if (str.indexOf(dot,(lat+2))==-1){
                document.write("Invalid E-mail ID");
                return false
            }

            if (str.indexOf(" ")!=-1){
                document.write("Invalid E-mail ID");
                return false
            }
            document.write("valid E-mail ID");
            return true 
        }

        function ValidateEmail(){
            var emailID=document.frm.txtEmail

            if ((emailID.value==null)||(emailID.value=="")){
                document.write("Please Enter your Email Address");
                emailID.focus()
                return false
            }
            
            if (emailcheck(emailID.value)==false){
                emailID.value=""
                emailID.focus()
                return false
            }
            return true
        }
    </script>
    </head>
        <body>
            <form name="frm" method="post" action="#" onSubmit="return ValidateEmail()">
            <p>Enter an Email Address : 
            <input type="text" name="txtEmail">
            </p>
            <p> 
            <input type="submit" name="Submit" value="Submit">
            </p>
            </form>
        </body>
</html>
