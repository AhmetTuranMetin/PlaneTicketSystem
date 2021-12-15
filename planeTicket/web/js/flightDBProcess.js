$(document).ready(()=>{
    Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: "<h2 style='color:goldenrod'>İşlem Başarılı</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="flightList.jsp";
          }, 4000); 
});

