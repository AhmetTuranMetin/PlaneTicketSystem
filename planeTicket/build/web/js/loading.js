function loading(){
    $("#loading").html('<div class="loader"></div>');
    
    setTimeout(()=>{
        $("#loading").html('');
    }, 2500);
}