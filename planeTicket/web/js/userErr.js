$(document).ready(()=>{
    Swal.fire({
            position: 'top-end',
            icon: 'error',
            title: "<h2 style='color:goldenrod'>Girdiğiniz Bilgilerde Kullanıcı Zaten Mevcut</h2>",
            background: 'navy',
            showConfirmButton: false,
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="userList.jsp";
          }, 4000); 
});