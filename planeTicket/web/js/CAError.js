$(document).ready(()=>{
    Swal.fire({
        position: 'center',
            icon: 'error',
            title: "<h2 style='color:lightskyblue'>Girdiğiniz Bilgilerde Kullanıcı Zaten Mevcut</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="createAccount.jsp";
          }, 4000); 
});