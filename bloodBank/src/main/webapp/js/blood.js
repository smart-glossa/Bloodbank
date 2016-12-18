function bloods(){
	var bloodVar="";
	bloodVar += "		<center>";
	bloodVar += "<div class=\"blo\">";
	bloodVar += "";
	bloodVar += "	<div>";
	bloodVar += "	<h2>Search BloodGroup<\/h2>";
	bloodVar += "	<\/div>";
	bloodVar += "	<div>";
	bloodVar += "	<label>BloodGroup*:<\/label>";
	bloodVar += "	<input type=text id=\"bgroups\" placeholder=\"Name..\">";
	bloodVar += "	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	bloodVar += "	<button id=\"bsubmits\" >Submit</button>";
	bloodVar += "	<\/div>";
	bloodVar += "";
	bloodVar += "	<\/div>";
	bloodVar += "	</center>";
$('.dts')[0].innerHTML = bloodVar;
}

function blood(){
	var bloodVar="";
	bloodVar += "		<center>";
	bloodVar += "<div class=\"std\">";
	bloodVar += "";
	bloodVar += "	<div>";
	bloodVar += "	<h2>Blood Detail<\/h2>";
	bloodVar += "	<\/div>";
	bloodVar += "	<div>";
	bloodVar += "	<label>FirstName*:<\/label>";
	bloodVar += "	<input type=text id=\"uName\" placeholder=\"Name..\">";
	bloodVar += "	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	bloodVar += "	<label>LastName*:<\/label>";
	bloodVar += "	&nbsp;";
	bloodVar += "	<input type=text id=\"lname\" placeholder=\"LastName..\">";
	bloodVar += "	<\/div>";
	bloodVar += "	&nbsp;&nbsp;";
	bloodVar += "	<div>";
	bloodVar += "	<label>BloodGroup*:<\/label>";
	
	bloodVar += "	<input type=text id=\"bgroup\" placeholder=\"Your BloodGroup..!\">";
	bloodVar += "	&nbsp;";
	bloodVar += "	<label>MobileNumber*:<\/label>";
	bloodVar += "	&nbsp;";
	bloodVar += " <input type=text id=\"mno\" placeholder=\"MObileNumber..\">";
	bloodVar += " <\/div>";
	bloodVar += "	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
	bloodVar += "	<div>";
	
	bloodVar += "	&nbsp;&nbsp;&nbsp;&nbsp;";
	bloodVar += "	<label>Email*:<\/label>";
	bloodVar += "	&nbsp;";
	bloodVar += "	<input type=text id=\"email\" placeholder=\"email..\">";
	bloodVar += "	&nbsp;";
	bloodVar += "	<\/div>";
	bloodVar += "	&nbsp;&nbsp;&nbsp;";
	bloodVar += "	<div>";
	bloodVar += "	&nbsp;&nbsp;&nbsp;";
	bloodVar += "	<button id=\"bsubmit\" >Submit</button>";
	bloodVar += "	&nbsp;";
	bloodVar += "	<button id=\"update\">GetAll</button>";
	bloodVar += "	<\/div>";
	bloodVar += "";
	bloodVar += "	<\/div>";
	bloodVar += "	</center>";
$('.blod')[0].innerHTML = bloodVar;
}

