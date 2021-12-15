$(document).ready(()=>{
    Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: "<h2 style='color:goldenrod'>İşlem Başarılı</h2>",
            background: 'navy',
            showConfirmButton: false,
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="userList.jsp";
          }, 4000); 
});