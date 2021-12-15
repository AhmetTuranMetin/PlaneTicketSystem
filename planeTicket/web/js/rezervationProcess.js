$(document).ready(()=>{
    Swal.fire({
        position: 'center',
            icon: 'success',
            title: "<h2 style='color:lightskyblue'>Rezervasyon İşlemi Tamamlandı</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="index.jsp";
          }, 4000); 
});