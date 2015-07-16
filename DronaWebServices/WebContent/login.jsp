<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
$(document).ready(function(){
    $('.textBox').each(function(){
         
        this.value = $(this).attr('title');
        $(this).addClass('text-label');
     
        $(this).focus(function(){
            if(this.value == $(this).attr('title')) {
                this.value = '';
                $(this).removeClass('text-label');
            }
        });
     
        $(this).blur(function(){
            if(this.value == '') {
                this.value = $(this).attr('title');
                $(this).addClass('text-label');
            }
        });
    });
});
    
</script>
<style type="text/css">
.myButton {
    -moz-box-shadow: inset 0px 1px 0px -50px #54a3f7;
    -webkit-box-shadow: inset 0px 1px 0px -50px #54a3f7;
    box-shadow: inset 0px 1px 0px -50px #54a3f7;
    background-color: #007dc1;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #124d77;
    display: inline-block;
    cursor: pointer;
    color: #ffffff;
    font-family: Times New Roman;
    font-size: 18px;
    font-weight: bold;
    padding: 6px 76px;
    text-decoration: none;
    text-shadow: 0px 1px 0px #154682;
    width: 194pt;
}

.myButton:hover {
    background-color: #0061a7;
}

.myButton:active {
    position: relative;
    top: 1px;
}
.text-label {
    color:  #757575;
    font-weight: bold;
}
.textBox {
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    width: 190pt;
    height: 25pt;
    font-family: Times New Roman;
    font-size: 18px;
    font-weight: normal;
    text-decoration: none;
    text-shadow: 0px 0px 0px #154682;
}
.textBox:focus { border: 2px solid #007dc1; }


</style>
</head>
<body style="background-color: #303030;">

    <center style="padding: 150pt">
        <table>
            <tr>
                <td style="padding-bottom: 13px"><input type="text" title="UserName"
                    name="username" class="textBox" /></td>
            </tr>
            <tr>
                <td style="padding-bottom: 18px"><input type="password" title="Password"
                    name="password" class="textBox" /></td>
            </tr>
            <tr>
                <td style="padding-bottom: 13px">
                    <button class="myButton">LOGIN</button>
                </td>
            </tr>
        </table>
    </center>
    
</body>
</html>