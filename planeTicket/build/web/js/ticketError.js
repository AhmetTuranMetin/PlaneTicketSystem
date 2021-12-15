$(document).ready(()=>{
    Swal.fire({
            position: 'top-end',
            icon: 'error',
            title: "<h2 style='color:goldenrod'>Girdiğiniz Bilgilerde Koltuk Zaten Mevcut</h2>",
            background: 'navy',
            showConfirmButton: false,
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="ticketList.jsp";
          }, 4000); 
});