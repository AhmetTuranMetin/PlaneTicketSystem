function validation(){
    var kalkis = document.getElementsByName("kalkis")[0].value;
    var varis = document.getElementsByName("varis")[0].value;

    if(kalkis === varis){
        var warning = `<div style="background-color:tomato;color:snow" class="alert alert-danger" role="alert">
                        Kalkis ve Varis yeri ayni olamaz !!
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