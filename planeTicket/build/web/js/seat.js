$(document).ready(()=>{
    let SEAT_NUMBER=180;
    var no=1;
    var order = ['A','B','C','D','E','F'];
    for (var i = 0; i < SEAT_NUMBER ;i++) {
        $(".seat-area").append("<div style='margin-top: 20px' id="+no+"></div>");
        for (var j = 0; j < order.length; j++) {
            if(order[j]==='D'){
                $("#"+no+"").append("<div style='float:left;background-color:green;color:navy;margin-left: 18%;width:50px;height:30px;text-align:center' id="+no+order[j]+">"+no+" "+order[j]+"</div>");
            }
            else{
                $("#"+no+"").append("<div style='float:left;background-color:green;color:navy;margin-left: 10px;width:50px;height:30px;text-align:center' id="+no+order[j]+">"+no+" "+order[j]+"</div>");
            }
            
        }
        $(".seat-area").append("<br>");
        no++;
    }
    
    var seats = $("#seats").text().split(";");
    
    for (var i = 0; i < seats.length; i++) {
        for (var j = 1; j <= SEAT_NUMBER; j++) {
            for (var k = 0; k < order.length; k++) {
                if($("#"+j+order[k]).text()===seats[i]){
                    $("#"+j+order[k]).css("background-color", "darkred");
                }  
            }
        }
    }
});

function validation(){
    var koltukNo = document.getElementsByName("koltukNo")[0].value;
    var sira = document.getElementsByName("koltukSira")[0].value;
    var seats = $("#seats").text().split(";");
    var check=0;
    
    for (var i = 0; i < seats.length; i++) {
        if((koltukNo+" "+sira)===seats[i]){
            check++;
        }
    }
    
    if(check===0)        
        return true;
    else{
         var warning = `<div style="background-color:goldenrod;color:navy" class="alert alert-danger" role="alert">
                        Seçtiğiniz koltuk dolu !!
                       </div>`
        
        $("#alert").html(warning);
        
        setTimeout(()=>{
            $("#alert").html("");
        }, 2500);
        return false;
    }
}