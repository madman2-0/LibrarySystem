<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.menu {
	height: 30px;
    width: 990px;
    border-radius: 25px;
    background: #d3d3d3 ;
}
.side {
	height: 370px;
    width: 120px;
    border-radius: 25px;
    background:  #B0E0E6  ;
    }
.body {
	height: 370px;
    width: 870px;
    border-radius: 25px;
    background: #FFd3d3 ;
}
.footer{
    border-radius: 25px;
    background: #FFFFd3 ;
}

</style>
<tiles:insertAttribute name="header" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<title><tiles:insertAttribute name="title" ignore="true" /></title> </head> 
<body> <div align="center" class="menu"><tiles:insertAttribute name="menu" /> </div><hr>
<table><tr><td><div align="left" class="side"> <tiles:insertAttribute name="side" /> </div> </td>
<td><div align="center" class="body"> <tiles:insertAttribute name="body" /> </div></td> </tr>
</table>
<div align="center" class="footer"><tiles:insertAttribute name="footer" /> </div> </body> </html>
