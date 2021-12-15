$(document).ready(()=>{
    Swal.fire({
        position: 'center',
            icon: 'success',
            title: "<h2 style='color:lightskyblue'>Yeni Şifre Belirlendi</h2>",
            showConfirmButton: false,
            background: 'navy',
            timer: 2500
          });
          
          setTimeout(()=>{
              window.location.href="login.jsp";
          }, 4000); 
});