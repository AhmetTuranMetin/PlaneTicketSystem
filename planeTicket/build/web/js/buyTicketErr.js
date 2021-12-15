$(document).ready(()=>{
    Swal.fire({
        position: 'center',
            icon: 'error',
            title: "<h2 style='color:lightskyblue'>Kart Bilgileri Yanlış</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="flightSearch.jsp";
          }, 4000); 
});