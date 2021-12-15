$(document).ready(()=>{
    Swal.fire({
        position: 'center',
            icon: 'error',
            title: "<h2 style='color:lightskyblue'>Zaten Bu Bilete Rezervasyon Yapılmıştır !!</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="index.jsp";
          }, 4000); 
});