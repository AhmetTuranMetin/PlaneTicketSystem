$(document).ready(()=>{
    Swal.fire({
            position: 'center',
            icon: 'success',
            title: "<h2 style='color:lightskyblue'>Hesap Oluşturuldu</h2>",
            background: 'navy',
            showConfirmButton: false,
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="login.jsp";
          }, 4000); 
});