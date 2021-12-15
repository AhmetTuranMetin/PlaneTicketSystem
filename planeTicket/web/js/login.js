$(document).ready(()=>{
    var sifre = document.getElementById("sifre");
    $("#checkbox").click(function(){
        if (sifre.type === 'password') {
            sifre.type = 'text';
        } else {
            sifre.type = 'password';
        }
    });
});

function validation(){
    var kalkis = document.getElementsByName("yas")[0].value;
    
    if(parseInt(kalkis)<18){
        var warning = `<div style="background-color:goldenrod;color:navy" class="alert alert-danger" role="alert">
                        18 yasindan kucukler uye olamaz !!
                       </div>`
        
        $("#alert").html(warning);
        
        setTimeout(()=>{
            $("#alert").html("");
        }, 2500);
        return false;
    }
    else
        return true;
}