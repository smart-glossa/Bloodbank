$(document).ready(function(){
	 // getAllstudent();
	$(document).on("click","#bsubmit",function(key){
		var name=$('#uName').val();
		var lname=$('#lname').val();
		var bgroup=$('#bgroup').val();
		var mno=$('#mno').val();
		var email=$('#email').val();
		
		if(name=="")
		{
		alert("Please Enter your Name");
		return;
		}
		if(lname=="")
		{
		alert("Please Enter your LastName");
		return;
		}
		if(bgroup=="")
		{
		alert("Please Enter your bgroup");
		return;
		}
		if(mno=="")
		{
		alert("Please Enter your MobileNo");
		return;
		}
		if(email=="")
		{
		alert("Please Enter your Email");
		return;
		}
		
	
		var url= "/bloodBank/blood?operation=userAdd&uName="+ name + "&lname="+ lname + "&bgroup=" + bgroup + "&mno=" + mno + "&email="+email;

        $.ajax({
        	url:url,
        	type:'POST'

        })
        
        .done(function(result) {
			result = JSON.parse(result);
		   if (result.status == 1) {
		   alert("SuccessFully Added");
		$('#uName').val("");
		$('#lname').val("");
		$('#bgroup').val("");
		$('#mno').val("");
	    $('#email').val("");
	    getAllorder()			
	} else if (result.status == 0) {
	alert("Error occurs");
}
}).fail(function(result) {
	alert("Please Check Details!..")
	});
})
	
	$(document).on("keyup", "#uName", function() {
		var sid =$("#sId").val();
		var url="/Library/lib?operation=getone&sId="+sid;
		$.ajax({
			url:url,
			type:'post'
				})
			
		.done(function(result){
			 result = JSON.parse(result);
             var Name = result.name;
             var gender=result.gender;
             var dep=result.dep;
             var year=result.year;
             var contact=result.contact;
             var email=result.email;
             var rdate=result.rdate;
             $("#Name").val(Name);
             $("#Gender").val(gender);
             $("#dep").val(dep);
             $("#Year").val(year);
             $("#Contact").val(contact);
             $("#Email").val(email);
             $("#rdate").val(rdate);
         })
		
		})
		.fail(function(result){
			
			alert("error:"+result);	
	})
	
	});
$(document).on('keypress','#sId',function(key){
	   if (key.which == 13){
		   $('#Name').focus();
	   }
	  
})  
$(document).on('keypress','#Name',function(key){
if (key.which == 13){
		$('#Gender').focus();	  
}
}) 
.on('keypress','#Gender',function(key){
if (key.which == 13){
$('#dep').focus();
}
}).on('keypress','#dep',function(key){
if (key.which == 13){
$('#Year').focus();
}
}).on('keypress','#Year',function(key){
if (key.which == 13){
$('#Contact').focus();
}
}).on('keypress','#Contact',function(key){
if (key.which == 13){
$('#Email').click();
}
}).on('keypress','#Email',function(key){
if (key.which == 13){
$('#rdate').click();
}
}).on('keypress','#submit',function(key){
if (key.which == 13){
$('#update').click();
}
}).on('keypress','#sId',function(e){
if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57) && e.which != 13) {
//display error message
$("#msg").html("Numbers Only").show().fadeOut(3000);
return false;
}
})

function getAllorder(){
						var url="/bloodBank/blood?operation=getAll";
					$.ajax({
						url:url,
						type:'POST'
					})
					.done(function(result){
						var array=JSON.parse(result);

						var table="<table border='2px  ' class='table'><tr><th>Name</th><th>LastName</th><th>BloodGroup</th><th>MobileNo</th><th>EmailId</th></tr>"

					    for(i=0;i<array.length;i++){
					    	table+="<tr>"
						 	    table+="<td>"+array[i].Name+"</td>"
						 		table+="<td>"+array[i].lName+"</td>"
						 		table+="<td>"+array[i].bgroup+"</td>"
						 		table+="<td>"+array[i].mno+"</td>"
						 		table+="<td>"+array[i].email+"</td>"
						 		
						 		
						 		table+="</tr>";
						 	}
						table+="</table>";
						 	$(".getorders")[0].innerHTML=table;	

						 })
						 .fail(function(result){
						 	alert("error");
						 })
						  
					}
$(document).on('click','#bsubmits',function(){
	var bgro = $('#bgroups').val();
	
		var url = "/bloodBank/blood?operation=getonly&bgroups="+ bgro;
		$.ajax({
			url:url,
			type:'POST'
		})
		.done(function(result){
			var array = JSON.parse(result);
	    	  var table = '<table>'
	    		  table += '<tr><th>Name</th><th>LastName</th><th>BloodGroup</th><th>MobileNo</th><th>Email</th></tr>';
	    	  for(i=0;i<array.length;i++){
			    	table+="<tr>"
			    		table+="<td>"+array[i].Name+"</td>"
				 		table+="<td>"+array[i].lName+"</td>"
				 		table+="<td>"+array[i].bg+"</td>"
				 		table+="<td>"+array[i].pno+"</td>"
				 		table+="<td>"+array[i].email+"</td>"
	    	    	  table+="</tr>";
			 	}
	                  table += '</table>';  
	                  $('.getStat')[0].innerHTML = table;
		 })
		 .fail(function(result){
		 	alert("error");
		 })
		  
	});
